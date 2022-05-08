package com.loktionov.polyclinic.controller;

import com.loktionov.polyclinic.entity.Status;
import com.loktionov.polyclinic.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/status")
public class StatusController {
    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("statuses", statusService.getAll());
        return "status/status-list";
    }

    @GetMapping("/add")
    public String addEndpoint(@ModelAttribute Status status, Model model) {
        model.addAttribute("status", status);
        return "status/add-status";
    }

    @PostMapping("/add-item")
    public String add(@ModelAttribute Status status, BindingResult bindingResult, Model model) {
        statusService.create(status);
        return "redirect:/status";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        Status status = statusService.getById(id).orElseThrow(() -> new IllegalArgumentException("Invalid status Id:" + id));
        model.addAttribute("status", status);

        return "status/edit-status";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Status status, BindingResult result, Model model) {
        statusService.create(status);
        return "redirect:/status";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        statusService.deleteById(id);
        return "redirect:/status";
    }
}
