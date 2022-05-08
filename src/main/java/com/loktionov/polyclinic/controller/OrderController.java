package com.loktionov.polyclinic.controller;

import com.loktionov.polyclinic.entity.PatientOrder;
import com.loktionov.polyclinic.service.DoctorService;
import com.loktionov.polyclinic.service.OrderService;
import com.loktionov.polyclinic.service.PatientService;
import com.loktionov.polyclinic.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final StatusService statusService;

    @Autowired
    public OrderController(OrderService orderService, DoctorService doctorService, PatientService patientService, StatusService statusService) {
        this.orderService = orderService;
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.statusService = statusService;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("orders", orderService.getAll());
        return "order/order-list";
    }

    @GetMapping("/add")
    public String addEndpoint(@ModelAttribute PatientOrder patientOrder, Model model) {
        model.addAttribute("order", patientOrder);
        model.addAttribute("doctors", this.doctorService.getAll());
        model.addAttribute("patients", this.patientService.getAll());
        model.addAttribute("statuses", this.statusService.getAll());
        return "order/add-order";
    }

    @PostMapping("/add-item")
    public String add(@ModelAttribute PatientOrder patientOrder, BindingResult bindingResult, Model model) {
        orderService.create(patientOrder);
        return "redirect:/order";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        PatientOrder patientOrder = orderService.getById(id).orElseThrow(() -> new IllegalArgumentException("Invalid order Id:" + id));
        model.addAttribute("order", patientOrder);
        model.addAttribute("doctors", this.doctorService.getAll());
        model.addAttribute("patients", this.patientService.getAll());
        model.addAttribute("statuses", this.statusService.getAll());

        return "order/edit-order";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") long id, PatientOrder patientOrder, BindingResult result, Model model) {
        orderService.create(patientOrder);
        return "redirect:/order";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        orderService.deleteById(id);
        return "redirect:/order";
    }
}
