package com.ubs.greenheroes.data;

import com.ubs.greenheroes.data.Client;
import com.ubs.greenheroes.data.Instrument;
import java.util.ArrayList;
import java.util.List;

public class MockedDatabase {

    public static final List<Instrument> INSTRUMENTS = new ArrayList<>();
    public static Client CLIENT;

    private MockedDatabase() {
    }
}
