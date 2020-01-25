using System.Collections.Generic;
using System.Threading.Tasks;
using System.Net.Http;
using Newtonsoft.Json.Linq;

namespace ZtmMaps
{
    class ZtmService
    {
        private HttpClient client;
        private readonly string ztmApiUrl = $"https://api.um.warszawa.pl/api/action/busestrams_get/?resource_id={ZtmProperties.resourceId}&apikey={ZtmProperties.apiKey}";

        public ZtmService()
        {
            client = new HttpClient();
        }

        public async Task<IList<Vehicle>> GetAllVehiclesAsync(string vehicleType, string vehicleNumber)
        {
            var response = await client.GetAsync(ztmApiUrl + $"&type={vehicleType}&line={vehicleNumber}");
            if (response.IsSuccessStatusCode)
            {
                var tmpJsonObj = JObject.Parse(await response.Content.ReadAsStringAsync());
                var tmpJsonArray = (JArray)tmpJsonObj["result"];
                var vehicles = tmpJsonArray.ToObject<IList<Vehicle>>();
                return vehicles;
            }
            else
            {
                return null;
            }
        }
    }
}
