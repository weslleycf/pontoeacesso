package com.dio.projeto.pontoeacesso.pontoeacesso.service;


import com.dio.projeto.pontoeacesso.pontoeacesso.model.JornadaTrabalho;
import com.dio.projeto.pontoeacesso.pontoeacesso.repository.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JornadaService {

    final JornadaRepository jornadaRepository;

    @Autowired
    public JornadaService(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }

    public JornadaTrabalho save(JornadaTrabalho jornadaTrabalho){
        return jornadaRepository.save(jornadaTrabalho);
    }



    public ResponseEntity<JornadaTrabalho> update(Long idJornada, JornadaTrabalho newJornadaTrabalho){

        Optional<JornadaTrabalho> oldJornada = jornadaRepository.findById(idJornada);

        if(oldJornada.isPresent()){
            oldJornada.get().setDescricao(newJornadaTrabalho.getDescricao());
            return new ResponseEntity<JornadaTrabalho>(jornadaRepository.save(oldJornada.get()), HttpStatus.OK);
        }

        else

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<JornadaTrabalho> getById(Long idJornada){
        Optional<JornadaTrabalho> jornada = jornadaRepository.findById(idJornada);
        return jornada.map(jornadaTrabalho -> new ResponseEntity<>(jornadaTrabalho, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }


    public ResponseEntity<Void> delete(JornadaTrabalho jornadaTrabalho){
        if(jornadaRepository.existsById(jornadaTrabalho.getId())){
            jornadaRepository.deleteById(jornadaTrabalho.getId());
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        else
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<Void> deleteById(Long idJornada){
        if(jornadaRepository.existsById(idJornada)){
            jornadaRepository.deleteById(idJornada);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        else
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }


    public List<JornadaTrabalho> findAll() {
        return jornadaRepository.findAll();
    }
}
