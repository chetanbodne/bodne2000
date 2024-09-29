package com.example.controller;

import com.example.entity.Bus;
import com.example.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {
    @Autowired
    private BusService busService;
    @PostMapping
    public ResponseEntity<Bus>createBus(@RequestBody Bus bus){
        Bus bus1 = busService.createBus(bus);
        return new ResponseEntity<>(bus1, HttpStatus.CREATED);

    }
    @DeleteMapping
    public ResponseEntity<String>deleteBus(@RequestParam long id){
        busService.deleteBus(id);
       return new ResponseEntity<>("Registration is deleted",HttpStatus.OK);
    }
    @PutMapping
public ResponseEntity<Bus>updateBus(@RequestParam long id,@RequestBody Bus bus){
    Bus bus1 = busService.updateBus(id, bus);
    return new ResponseEntity<>(bus1,HttpStatus.OK);

}
@GetMapping
public ResponseEntity<List<Bus>>getAllBus(){
    List<Bus> allBus = busService.getAllBus();
    return new ResponseEntity<>(allBus,HttpStatus.OK);

}


}
