using System;
using System.Threading;
using System.Threading.Tasks;
using System.Windows;

namespace ZtmMaps
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private ZtmService ztmService;
        private VehicleMarker vehicleMarker;
        private Thread watcher;

        public MainWindow()
        {
            InitializeComponent();
            ztmService = new ZtmService();
            vehicleMarker = new VehicleMarker();
            watcher = new Thread(EmptyMethod);
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            if (watcher.IsAlive)
            {
                watcher.Interrupt();
            }
            watcher = new Thread(StartWatching);
            watcher.IsBackground = true;
            watcher.Start();
        }

        private void StartWatching()
        {
            try
            {
                while (true)
                {
                    Dispatcher.Invoke(() =>
                    {
                        myMap.Children.Clear();
                        GetVehiclesAndMarkThem();
                    });
                    Thread.Sleep(5000);
                }
            } catch (Exception tie)
            {
                Console.WriteLine("Line changed");
            }
        }

        private async Task GetVehiclesAndMarkThem()
        {
            var vehicleType = busRadioButton.IsChecked.Value ? "1" : "2";
            var vehicles = await ztmService.GetAllVehiclesAsync(vehicleType, vehicleNumber.Text);
            if(vehicles.Count == 0)
            {
                ShowError();
                watcher.Interrupt();
            }
            vehicleMarker.MarkVehicles(vehicles, myMap);
        }

        private void EmptyMethod()
        {

        }

        private void ShowError()
        {
            Thread thr = new Thread(() => MessageBox.Show("Nie znaleziono żadnych połączeń o podanych parametrach.", "Błąd", MessageBoxButton.OK, MessageBoxImage.Error));
            thr.Start();
        }
    }
}
