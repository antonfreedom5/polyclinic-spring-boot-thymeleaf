package com.loktionov.polyclinic.controller;

import com.loktionov.polyclinic.entity.Specialization;
import com.loktionov.polyclinic.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/specialization")
public class SpecializationController {
    private final SpecializationService specializationService;

    @Autowired
    public SpecializationController(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("specializations", specializationService.getAll());
        return "specialization/specialization-list";
    }

    @GetMapping("/add")
    public String addEndpoint(@ModelAttribute Specialization specialization, Model model) {
        model.addAttribute("specialization", specialization);
        return "specialization/add-specialization";
    }

    @PostMapping("/add-item")
    public String add(@ModelAttribute Specialization specialization, BindingResult bindingResult, Model model) {
        specializationService.create(specialization);
        return "redirect:/specialization";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        Specialization specialization = specializationService.getById(id).orElseThrow(() -> new IllegalArgumentException("Invalid specialization Id:" + id));
        model.addAttribute("specialization", specialization);

        return "specialization/edit-specialization";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Specialization specialization, BindingResult result, Model model) {
        specializationService.create(specialization);
        return "redirect:/specialization";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        specializationService.deleteById(id);
        return "redirect:/specialization";
    }
}
