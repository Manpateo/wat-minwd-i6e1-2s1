package wat.kb.tramwaje.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tram {
    private int Lines;
    private double Lon;
    private String VehicleNumber;
    private String Time;
    private double Lat;
    private String Brigade;

    public Tram() {
    }

    public void setLines(int lines) {
        Lines = lines;
    }
    @JsonProperty("Lines")
    public int getLines() { return Lines; }

    public void setLon(double lon) {
        Lon = lon;
    }
    @JsonProperty("Lon")
    public double getLon() { return Lon; }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }
    @JsonProperty("VehicleNumber")
    public String getVehicleNumber() { return VehicleNumber; }

    public void setTime(String time) {
        Time = time;
    }
    @JsonProperty("Time")
    public String getTime() { return Time; }

    public void setLat(double lat) {
        Lat = lat;
    }
    @JsonProperty("Lat")
    public double getLat() { return Lat; }

    public void setBrigade(String brigade) {
        Brigade = brigade;
    }
    @JsonProperty("Brigade")
    public String getBrigade() { return Brigade; }
}
