using Microsoft.Maps.MapControl.WPF;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace ZtmMaps
{
    class VehicleMarker
    {
        public async Task MarkVehicles(IList<Vehicle> vehicles, Map map)
        {
            foreach(Vehicle v in vehicles)
            {
                MarkOne(v, map);
            }
        }

        private async Task MarkOne(Vehicle vehicle, Map map)
        {
            Pushpin pin = new Pushpin();
            pin.Location = new Location(vehicle.Lat, vehicle.Lon);
            pin.ToolTip = "Linia: " + vehicle.Lines + "\nBrygada: " + vehicle.Brigade + "\nCzas aktualizacji: " + vehicle.Time;
            map.Children.Add(pin);
        }
    }
}
