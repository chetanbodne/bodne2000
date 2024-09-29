package com.example.service;

import com.example.entity.Bus;
import com.example.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;
    public Bus createBus(Bus bus){
        Bus saved = busRepository.save(bus);
        return saved;

    }
    public void deleteBus(long id){
        busRepository.deleteById(id);

    }
    public Bus updateBus(long id,Bus bus){
        Optional<Bus> byId = busRepository.findById(id);
        Bus bus1 = byId.get();
        bus1.setName(bus.getName());
        bus1.setEmail(bus.getEmail());
        bus1.setMobile(bus.getMobile());
        busRepository.save(bus1);
        return bus1;
    }
    public List<Bus>getAllBus(){
        List<Bus> all = busRepository.findAll();
        return all;

    }


}
