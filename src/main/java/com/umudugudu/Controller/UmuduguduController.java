package com.umudugudu.Controller;


import com.umudugudu.Model.Umudugudu;
import com.umudugudu.Repository.UmuduguduRepository;
import com.umudugudu.Service.UmuduguduService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
    public class UmuduguduController {


    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private UmuduguduRepository umuduguduRepository;

    @Autowired
    UmuduguduService umuduguduService;


    @PostMapping("/registration")
    public String registerCitizen(@RequestParam("firstname") String firstName,
                                  @RequestParam("lastname") String lastName,
                                  @RequestParam("national") Integer national,
                                  @RequestParam("district") String district,
                                  @RequestParam("country") String country,
                                  @RequestParam("gender") String gender,
                                  @RequestParam("age") Integer age) {

        Umudugudu citizen = new Umudugudu(firstName, lastName, national, district, country, gender, age);
        umuduguduRepository.save(citizen);

        return "user/saved-success";
    }


    @GetMapping("/viewCitizen")
    public String viewCitizen(Model model) {
        List<Umudugudu> citizen = umuduguduRepository.findAll();
        model.addAttribute("citizen", citizen);
        return "view-client";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") long id, Model model) {
        Umudugudu citizen = umuduguduRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid booking Id:" + id));
        model.addAttribute("citizen", citizen);
        return "admin/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(value = "id") long id, @Valid Umudugudu citizen, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            citizen.setId(id);
            return "admin/dashboard";
        }
            umuduguduRepository.save(citizen);
            return "redirect:/viewCitizen";
        }



    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") Long id) {
        Umudugudu client = umuduguduService.findClientById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));

        umuduguduRepository.delete(client);

        return "redirect:/viewCitizen";
    }

}


