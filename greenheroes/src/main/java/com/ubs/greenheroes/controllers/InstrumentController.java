package com.ubs.greenheroes.controllers;

import static com.ubs.greenheroes.controllers.ClientPreferenceController.ACCEPTED_ORIGINS;
import com.ubs.greenheroes.data.Instrument;
import com.ubs.greenheroes.data.MockedDatabase;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstrumentController {

    @CrossOrigin(origins = ACCEPTED_ORIGINS)
    @RequestMapping("/instruments")
    public List<Instrument> getInstruments() {
        return MockedDatabase.INSTRUMENTS;
    }
}
