package wat.kb.tramwaje.services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import wat.kb.tramwaje.models.Tram;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;

@Service
public class TramsService implements ITramsService {

    String pageUrl = "https://api.um.warszawa.pl/api/action/busestrams_get/?resource_id=f2e5503e-927d-4ad3-9500-4ab9e55deb59&apikey=52367340-0396-41ad-b022-84d9e2b9b4fd&type=2";

    public ArrayList<Tram> getAll() throws IOException {

        URL ztmAll = new URL(pageUrl);
        BufferedReader in = new BufferedReader(new InputStreamReader(ztmAll.openStream()));
        String jsonString = in.readLine();
        in.close();

        ArrayList<Tram> input = getArray(jsonString);
        ArrayList<Tram> lines = new ArrayList<Tram>();
        for(int i=0; i < input.size(); i++) {
            boolean isAssigned = false;
            for(int j =0; j < lines.size(); j++)
            {
                if(lines.get(j).getLines() == input.get(i).getLines())
                {
                    isAssigned = true;
                    break;
                }
            }
            if (!isAssigned) lines.add(input.get(i));
        }
        lines.sort(Comparator.comparing(Tram::getLines));
        return lines;
    }

    public ArrayList<Tram> getByLine(int line) throws IOException {

        URL ztmLine = new URL(pageUrl + "&line=" + line);
        BufferedReader in = new BufferedReader(new InputStreamReader(ztmLine.openStream()));
        String jsonString = in.readLine();
        in.close();

        return getArray(jsonString);
    }

    private ArrayList<Tram> getArray(String jsonString) {
        JSONObject json = new JSONObject(jsonString);
        JSONArray jsonArray = json.getJSONArray("result");

        ArrayList<Tram> trams = new ArrayList<Tram>();

        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject element = jsonArray.getJSONObject(i);

            Tram tram = new Tram();
            tram.setLines(element.getInt("Lines"));
            tram.setLon(element.getDouble("Lon"));
            tram.setVehicleNumber(element.getString("VehicleNumber"));
            tram.setTime(element.getString("Time"));
            tram.setLat(element.getDouble("Lat"));
            tram.setBrigade(element.getString("Brigade"));

            trams.add(tram);
        }
        return trams;
    }
}
