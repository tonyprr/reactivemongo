package com.biellcon.demos.reactive.controller;

import com.biellcon.demos.reactive.model.BusinessArea;
import com.biellcon.demos.reactive.repository.BusinessAreaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/business-area")
public class BusinessAreaController {

    private BusinessAreaRepository businessAreaRepository;

    public BusinessAreaController(BusinessAreaRepository businessAreaRepository) {
        this.businessAreaRepository = businessAreaRepository;
    }

    @PostMapping
    public @ResponseBody
    Mono<BusinessArea> save(@Valid @RequestBody BusinessArea businessArea) {
        return businessAreaRepository.save(businessArea);
    }

    @GetMapping
    public @ResponseBody
    Flux<BusinessArea> getAll() {
        return businessAreaRepository.findAll();
    }

}
