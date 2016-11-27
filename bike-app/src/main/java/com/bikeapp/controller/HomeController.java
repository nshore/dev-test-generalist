package com.bikeapp.controller;

import com.bikeapp.Database.DBQueryHandler;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
