package com.dio.projeto.pontoeacesso.pontoeacesso.controller;


import com.dio.projeto.pontoeacesso.pontoeacesso.model.JornadaTrabalho;
import com.dio.projeto.pontoeacesso.pontoeacesso.service.JornadaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/jornada")
@Api(value = "API REST Jornada de Trabalho")
@CrossOrigin(origins = "*")
public class JornadaTrabalhoController {

    @Autowired
    JornadaService jornadaService;

    @GetMapping
    @ApiOperation("Retorna uma lista de jornadas de trabalho")
    public List<JornadaTrabalho> getJornadas() {
        return jornadaService.findAll();
    }

    @GetMapping("/{idJornada}")
    @ApiOperation("Retorna uma uma jornada de trabalho pela sua id")
    public ResponseEntity<JornadaTrabalho> getById(@PathVariable("idJornada") Long idJornada) {
        return jornadaService.getById(idJornada);
    }

    @PostMapping
    @ApiOperation("Cria uma jornada de trabalho")
    public JornadaTrabalho createJornada(@Valid @RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaService.save(jornadaTrabalho);

    }


    @PutMapping
    @ApiOperation("Atualiza uma jornada de trabalho")
    public ResponseEntity<JornadaTrabalho> updateJornada(@Valid @RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaService.update(jornadaTrabalho.getId(), jornadaTrabalho);
    }

    @PutMapping("/{idJornada}")
    @ApiOperation("Atualiza uma jornada de trabalho pelo seu id")
    public ResponseEntity<JornadaTrabalho> updateJornada(@PathVariable("idJornada") Long idJornada,
                                                         @Valid @RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaService.update(idJornada, jornadaTrabalho);
    }


    @DeleteMapping
    @ApiOperation("Apaga uma jornada de trabalho")
    public ResponseEntity<Void> deleteJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaService.delete(jornadaTrabalho);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Apaga uma jornada de trabalho pelo seu id")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return jornadaService.deleteById(id);
    }



   /* @ResponseStatus(HttpStatus.BAD_REQUEST)
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
    }*/

}