package com.dio.projeto.pontoeacesso.pontoeacesso.controller;


import com.dio.projeto.pontoeacesso.pontoeacesso.model.JornadaTrabalho;
import com.dio.projeto.pontoeacesso.pontoeacesso.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaService jornadaService;

    @PostMapping()
    public JornadaTrabalho create(@RequestBody JornadaTrabalho jornadaTrabalho){
        jornadaService.save(jornadaTrabalho);
        return null;
    }


}
