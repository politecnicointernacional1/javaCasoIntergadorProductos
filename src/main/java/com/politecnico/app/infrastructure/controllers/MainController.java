package com.politecnico.app.infrastructure.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
  @GetMapping("/")
  public String hello(){
    return "hola java";
  }
}
