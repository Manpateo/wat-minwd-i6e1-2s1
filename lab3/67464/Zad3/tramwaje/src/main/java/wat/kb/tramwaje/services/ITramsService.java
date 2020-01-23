package wat.kb.tramwaje.services;
import wat.kb.tramwaje.models.Tram;

import java.io.IOException;
import java.util.ArrayList;

public interface ITramsService {
    public ArrayList<Tram> getAll() throws IOException;
    public ArrayList<Tram> getByLine(int line) throws IOException;
}
