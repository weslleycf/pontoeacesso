package com.dio.projeto.pontoeacesso.pontoeacesso.service;


import com.dio.projeto.pontoeacesso.pontoeacesso.model.JornadaTrabalho;
import com.dio.projeto.pontoeacesso.pontoeacesso.repository.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JornadaService {

    JornadaRepository jornadaRepository;

    @Autowired
    public JornadaService(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }

    public JornadaTrabalho save(JornadaTrabalho jornadaTrabalho){
        return jornadaRepository.save(jornadaTrabalho);
    }


}
