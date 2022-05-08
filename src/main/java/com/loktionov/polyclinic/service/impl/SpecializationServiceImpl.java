package com.loktionov.polyclinic.service.impl;

import com.loktionov.polyclinic.entity.Specialization;
import com.loktionov.polyclinic.repository.SpecializationRepository;
import com.loktionov.polyclinic.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecializationServiceImpl implements SpecializationService {
    private final SpecializationRepository specializationRepository;

    @Autowired
    public SpecializationServiceImpl(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    @Override
    public void create(Specialization specialization) {
        this.specializationRepository.save(specialization);
    }

    @Override
    public List<Specialization> getAll() {
        return this.specializationRepository.findAll();
    }

    @Override
    public Optional<Specialization> getById(Long id) {
        return this.specializationRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.specializationRepository.deleteById(id);
    }
}
