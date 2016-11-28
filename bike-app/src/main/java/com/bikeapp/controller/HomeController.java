package com.bikeapp.controller;

import com.bikeapp.Database.DBQueryHandler;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @RequestMapping("/getAllBikes")
    public String allBikesAPICall(){

        DBQueryHandler bikeQuery = new DBQueryHandler();
        return bikeQuery.getAllBikes();
        //return "this is the bike page";
    }

    @RequestMapping("/getBikeById/{bikeId}")
    public String bikeByIdAPICall(@PathVariable("bikeId") int bikeId, HttpServletRequest request) {

        DBQueryHandler bikeQuery = new DBQueryHandler();
        return bikeQuery.getBikeById(bikeId);
    }

    @RequestMapping(value = "/createBike", method = RequestMethod.POST)
    public String createBikedAPICall(@RequestParam("bikeName") String bikeName,
                                     @RequestParam("bikeDescription") String bikeDescription,
                                     @RequestParam("bikePrice") String bikePrice) {

        DBQueryHandler bikeQuery = new DBQueryHandler();
        return bikeQuery.createBike(bikeName, bikeDescription, bikePrice);
    }

}
