package com.loktionov.polyclinic.service;

import com.loktionov.polyclinic.entity.Specialization;

import java.util.List;
import java.util.Optional;

public interface SpecializationService {
    public void create(Specialization specialization);

    public List<Specialization> getAll();

    public Optional<Specialization> getById(Long id);

    public void deleteById(Long id);
}
