package com.sat.tmf.productrest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prodapi")
public class TestController {
	
	@GetMapping("/testprod")
    public String testProd() {
        return "Test Prod!";
    }

}
