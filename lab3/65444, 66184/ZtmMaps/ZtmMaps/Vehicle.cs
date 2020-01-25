using Newtonsoft.Json;
using System;

namespace ZtmMaps
{
    class Vehicle
    {
        [JsonProperty("Lat")]
        public double Lat { get; set; }
        [JsonProperty("Lon")]
        public double Lon { get; set; }
        [JsonProperty("Time")]
        public DateTime Time { get; set; }
        [JsonProperty("Lines")]
        public int Lines { get; set; }
        [JsonProperty("Brigade")]
        public string Brigade { get; set; }
    }
}
