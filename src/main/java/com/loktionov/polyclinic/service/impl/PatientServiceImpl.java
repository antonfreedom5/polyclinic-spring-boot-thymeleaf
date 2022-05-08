package com.loktionov.polyclinic.service.impl;

import com.loktionov.polyclinic.entity.Patient;
import com.loktionov.polyclinic.repository.PatientRepository;
import com.loktionov.polyclinic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void create(Patient patient) {
        this.patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAll() {
        return this.patientRepository.findAll();
    }

    @Override
    public Optional<Patient> getById(Long id) {
        return this.patientRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.patientRepository.deleteById(id);
    }
}
