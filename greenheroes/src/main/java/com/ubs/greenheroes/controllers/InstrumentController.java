package com.ubs.greenheroes.controllers;

import com.ubs.greenheroes.data.MockedDatabase;
import com.ubs.greenheroes.data.Instrument;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstrumentController {

    @RequestMapping("/instruments")
    public List<Instrument> getInstruments() {
        return MockedDatabase.INSTRUMENTS;
    }
}
