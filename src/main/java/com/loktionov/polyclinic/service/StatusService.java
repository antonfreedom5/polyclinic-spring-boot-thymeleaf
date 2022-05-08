package com.loktionov.polyclinic.service;

import com.loktionov.polyclinic.entity.Status;

import java.util.List;
import java.util.Optional;

public interface StatusService {
    public void create(Status status);

    public List<Status> getAll();

    public Optional<Status> getById(Long id);

    public void deleteById(Long id);
}
