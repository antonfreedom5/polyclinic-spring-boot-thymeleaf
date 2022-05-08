package com.loktionov.polyclinic.controller;

import com.loktionov.polyclinic.entity.Doctor;
import com.loktionov.polyclinic.service.DoctorService;
import com.loktionov.polyclinic.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;
    private final SpecializationService specializationService;

    @Autowired
    public DoctorController(DoctorService doctorService, SpecializationService specializationService) {
        this.doctorService = doctorService;
        this.specializationService = specializationService;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("doctors", doctorService.getAll());
        return "doctor/doctor-list";
    }

    @GetMapping("/add")
    public String addEndpoint(@ModelAttribute Doctor doctor, Model model) {
        model.addAttribute("doctor", doctor);
        model.addAttribute("specializations", this.specializationService.getAll());
        return "doctor/add-doctor";
    }

    @PostMapping("/add-item")
    public String add(@ModelAttribute Doctor doctor, BindingResult bindingResult, Model model) {
        doctorService.create(doctor);
        return "redirect:/doctor";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        Doctor doctor = doctorService.getById(id).orElseThrow(() -> new IllegalArgumentException("Invalid doctor Id:" + id));
        model.addAttribute("doctor", doctor);
        model.addAttribute("specializations", this.specializationService.getAll());

        return "doctor/edit-doctor";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Doctor doctor, BindingResult result, Model model) {
        doctorService.create(doctor);
        return "redirect:/doctor";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        doctorService.deleteById(id);
        return "redirect:/doctor";
    }
}
