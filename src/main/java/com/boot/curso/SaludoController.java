package com.boot.curso;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @GetMapping(value = "saludo", produces = MediaType.TEXT_PLAIN_VALUE)
    public String saludo(){
        return "Microservicio Spring boot";
    }

    @GetMapping(value = "saludo/{nombre}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String saludo(@PathVariable("nombre") String n){
        return "Bienvenido %s".formatted(n);
    }
}
