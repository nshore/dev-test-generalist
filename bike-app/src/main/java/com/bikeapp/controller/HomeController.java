package com.bikeapp.controller;

import com.bikeapp.Database.DatabaseHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/getAllBikes")
    public String allBikesAPICall(){

        DatabaseHandler bikeQuery = new DatabaseHandler();
        return bikeQuery.getAllBikes();
        //return "this is the bike page";
    }

    @RequestMapping("/getBikeById")
    public String bikeByIdAPICall(@RequestParam("bikeId") int bikeId) {

        DatabaseHandler bikeQuery = new DatabaseHandler();
        return bikeQuery.getBikeById(bikeId);
    }

}
