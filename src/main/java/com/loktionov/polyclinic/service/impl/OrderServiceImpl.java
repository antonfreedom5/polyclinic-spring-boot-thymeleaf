package com.loktionov.polyclinic.service.impl;

import com.loktionov.polyclinic.entity.PatientOrder;
import com.loktionov.polyclinic.repository.OrderRepository;
import com.loktionov.polyclinic.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void create(PatientOrder patientOrder) {
        this.orderRepository.save(patientOrder);
    }

    @Override
    public List<PatientOrder> getAll() {
        return this.orderRepository.findAll();
    }

    @Override
    public Optional<PatientOrder> getById(Long id) {
        return this.orderRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.orderRepository.deleteById(id);
    }
}
