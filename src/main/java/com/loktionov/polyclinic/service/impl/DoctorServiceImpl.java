package com.loktionov.polyclinic.service.impl;

import com.loktionov.polyclinic.entity.Doctor;
import com.loktionov.polyclinic.repository.DoctorRepository;
import com.loktionov.polyclinic.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public void create(Doctor doctor) {
        System.out.println(doctor.getBirthday());
        this.doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAll() {
        return this.doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> getById(Long id) {
        return this.doctorRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.doctorRepository.deleteById(id);
    }
}
