package com.loktionov.polyclinic.service.impl;

import com.loktionov.polyclinic.entity.Status;
import com.loktionov.polyclinic.repository.StatusRepository;
import com.loktionov.polyclinic.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {
    private final StatusRepository statusRepository;

    @Autowired
    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public void create(Status status) {
        this.statusRepository.save(status);
    }

    @Override
    public List<Status> getAll() {
        return this.statusRepository.findAll();
    }

    @Override
    public Optional<Status> getById(Long id) {
        return this.statusRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.statusRepository.deleteById(id);
    }
}
