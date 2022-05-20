package com.example.controller;

import com.example.model.Smartphone;
import com.example.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/smartphones")
public class SmartphoneRestController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

//    @GetMapping
//    public ResponseEntity<Iterable<Smartphone>> allPhones() {
//        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
//    }

    @GetMapping("/list1")
    public ResponseEntity<List<Smartphone>> allPhones() {
        return new ResponseEntity(smartphoneService.findAllSmarts(), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones", smartphoneService.findAll());
        return modelAndView;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable int id) {
//        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        Optional<Smartphone> smartphoneOptional = Optional.ofNullable(smartphoneService.findById(id));
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "getById")
    public ResponseEntity<Smartphone> getById(@RequestParam int id) {
        Smartphone smartphone = smartphoneService.findById(id);
        return new ResponseEntity<>(smartphone, HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Void> edit(@RequestBody Smartphone smartphone) {
        smartphoneService.save(smartphone);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
