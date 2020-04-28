package com.cobitsa.server.bus;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusFlagRepository extends JpaRepository<BusFlag,Long> {
    Optional<BusFlag> findByBusId(String busId);
}
