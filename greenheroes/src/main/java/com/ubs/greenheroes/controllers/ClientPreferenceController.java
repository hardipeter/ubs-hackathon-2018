package com.ubs.greenheroes.controllers;

import com.ubs.greenheroes.data.MockedDatabase;
import com.ubs.greenheroes.data.Client;
import com.ubs.greenheroes.data.ClientPreference;
import com.ubs.greenheroes.data.InterestLevel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientPreferenceController {

    private static final String ACCEPTED_ORIGINS = "http://localhost:3000";

    @CrossOrigin(origins = ACCEPTED_ORIGINS)
    @RequestMapping("/preferences")
    public Client getClient() {
        return MockedDatabase.CLIENT;
    }

    @RequestMapping("/preferences/{id}")
    public void setClientPreference(@PathVariable(name = "id") int id,
                                    @RequestBody InterestLevel interest) {
        final ClientPreference clientPreference = MockedDatabase.CLIENT.getClientPreference(id);
        if (clientPreference != null) {
            clientPreference.setLevelOfInterest(interest);
        }
    }

}
