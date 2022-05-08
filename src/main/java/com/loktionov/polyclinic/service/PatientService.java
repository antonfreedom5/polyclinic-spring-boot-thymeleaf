package com.loktionov.polyclinic.service;

import com.loktionov.polyclinic.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    public void create(Patient patient);

    public List<Patient> getAll();

    public Optional<Patient> getById(Long id);

    public void deleteById(Long id);
}
