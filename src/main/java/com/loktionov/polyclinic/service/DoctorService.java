package com.loktionov.polyclinic.service;

import com.loktionov.polyclinic.entity.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    void create(Doctor doctor);

    List<Doctor> getAll();

    Optional<Doctor> getById(Long id);

    void deleteById(Long id);
}
