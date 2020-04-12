package com.finra.test.controllers;

import com.finra.test.models.PageAttributes;
import com.finra.test.models.PageItems;
import com.finra.test.services.FinraServices;
import com.finra.test.validators.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@Validated
public class FinraRestController {

    @Autowired
    public FinraServices finraServices;

    @GetMapping(value = "/generateCombinations/{phoneNumber}",produces = "application/json")
    public PageAttributes generateCombinations(@PathVariable("phoneNumber") @PhoneNumber Integer phoneNumber) {
        return finraServices.generateCombinations(phoneNumber);
    }

    @GetMapping(value = "/getCombinations/{page}",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public PageItems getCombinations(@PathVariable(name = "page") Integer pageNumber) {
        return finraServices.getItems(pageNumber);
    }
}
