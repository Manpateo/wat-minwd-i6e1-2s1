package wat.kb.tramwaje.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wat.kb.tramwaje.models.Tram;
import wat.kb.tramwaje.services.ITramsService;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/trams")
@CrossOrigin
public class TramsController {

    private ITramsService _service;

    @Autowired
    public TramsController(ITramsService service) {
        _service = service;
    }

    @GetMapping("/all")
    public ArrayList<Tram> getAll() throws IOException {
        return _service.getAll();
    }

    @GetMapping("line/{line}")
    public ArrayList<Tram> getByLine(@PathVariable(value = "line") int line) throws IOException {
        return _service.getByLine(line);
    }
}
