package com.loktionov.polyclinic.controller;

import com.loktionov.polyclinic.entity.Patient;
import com.loktionov.polyclinic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("patients", patientService.getAll());
        return "patient/patient-list";
    }

    @GetMapping("/add")
    public String addEndpoint(@ModelAttribute Patient patient, Model model) {
        model.addAttribute("patient", patient);
        return "patient/add-patient";
    }

    @PostMapping("/add-item")
    public String add(@ModelAttribute Patient patient, BindingResult bindingResult, Model model) {
        patientService.create(patient);
        return "redirect:/patient";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        Patient patient = patientService.getById(id).orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));
        model.addAttribute("patient", patient);

        return "patient/edit-patient";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Patient patient, BindingResult result, Model model) {
        patientService.create(patient);
        return "redirect:/patient";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        patientService.deleteById(id);
        return "redirect:/patient";
    }
}
