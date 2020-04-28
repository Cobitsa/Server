package com.cobitsa.server.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/bus/{busId}")
public class BusController {
    @Autowired
    BusService busService;

    @GetMapping
    public ResponseEntity getBusFlag(@PathVariable String busId){
        BusFlag busFlag = this.busService.getBusFlag(busId);
        return ResponseEntity.ok(busFlag);
    }

    @PostMapping
    public ResponseEntity setBusRide(@PathVariable String busId){
        this.busService.setBusRide(busId);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity setBusOff(@PathVariable String busId){
        this.busService.setBusOff(busId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteFlag(@PathVariable String busId){
        this.busService.deleteFlag(busId);
        return ResponseEntity.ok().build();
    }
}
