package com.loktionov.polyclinic.service;

import com.loktionov.polyclinic.entity.PatientOrder;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public void create(PatientOrder patientOrder);

    public List<PatientOrder> getAll();

    public Optional<PatientOrder> getById(Long id);

    public void deleteById(Long id);
}
