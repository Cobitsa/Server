package com.cobitsa.server.bus;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BusService {

    private final BusFlagRepository busFlagRepository;
    @Transactional
    public BusFlag getBusFlag(String busId) {
        BusFlag busFlag = this.busFlagRepository.findByBusId(busId).orElseGet(BusFlag::new);
        return busFlag;
    }

    @Transactional
    public void setBusRide(String busId) {
        BusFlag busFlag = this.busFlagRepository.findByBusId(busId).orElseGet(BusFlag::new);
        busFlag.setBusId(busId);
        busFlag.setWillRide(true);
        this.busFlagRepository.save(busFlag);
    }

    @Transactional
    public void setBusOff(String busId) {
        BusFlag busFlag = this.busFlagRepository.findByBusId(busId).orElseGet(BusFlag::new);
        busFlag.setBusId(busId);
        busFlag.setWillGetOff(true);
        this.busFlagRepository.save(busFlag);
    }

    @Transactional
    public void deleteFlag(String busId) {
        BusFlag busFlag = this.busFlagRepository.findByBusId(busId).get();
        this.busFlagRepository.delete(busFlag);
    }
}
