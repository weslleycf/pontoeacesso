package com.dio.projeto.pontoeacesso.pontoeacesso.controller;


import com.dio.projeto.pontoeacesso.pontoeacesso.model.JornadaTrabalho;
import com.dio.projeto.pontoeacesso.pontoeacesso.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaService jornadaService;

    @GetMapping
    public List<JornadaTrabalho> getJornadas(){
        return jornadaService.findAll();
    }

    @PostMapping
    public JornadaTrabalho createJornada(@Valid @RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.save(jornadaTrabalho);

    }


    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> getById(@PathVariable("idJornada") Long idJornada) throws Exception {
        return jornadaService.getById(idJornada);
    }

    @PutMapping
    public ResponseEntity<JornadaTrabalho> updateJornada( @Valid @RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.update(jornadaTrabalho.getId(), jornadaTrabalho);
    }

    @PutMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> updateJornada(@PathVariable("idJornada") Long idJornada,
                                                         @Valid @RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.update(idJornada, jornadaTrabalho);
    }


    @DeleteMapping
    public ResponseEntity<Void> deleteJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.delete(jornadaTrabalho);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable  Long id) {
        return jornadaService.deleteById(id);
    }



    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}