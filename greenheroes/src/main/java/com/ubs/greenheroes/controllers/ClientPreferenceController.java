package com.ubs.greenheroes.controllers;

import com.ubs.greenheroes.data.Client;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientPreferenceController {

    @RequestMapping("/clientPreferences")
    public Client getClient(@RequestParam(value="name") String name){
        return new Client(name);
    }

}
