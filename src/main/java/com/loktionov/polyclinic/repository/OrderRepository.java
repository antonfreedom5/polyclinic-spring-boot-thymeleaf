package com.loktionov.polyclinic.repository;

import com.loktionov.polyclinic.entity.PatientOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<PatientOrder, Long> {
}
