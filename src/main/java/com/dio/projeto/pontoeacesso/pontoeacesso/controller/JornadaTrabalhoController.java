package com.dio.projeto.pontoeacesso.pontoeacesso.controller;


import com.dio.projeto.pontoeacesso.pontoeacesso.model.JornadaTrabalho;
import com.dio.projeto.pontoeacesso.pontoeacesso.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.save(jornadaTrabalho);

    }
    @PutMapping
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.update(jornadaTrabalho);
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> getById(@RequestParam("idJornada" ) Long idJornada) throws Exception {
        return ResponseEntity.ok(jornadaService.getById(idJornada).orElseThrow(() ->
                        new NoSuchElementException("Not found!")
                ));
    }

    @DeleteMapping
    public void deleteJornada(JornadaTrabalho jornadaTrabalho){
        jornadaService.delete(jornadaTrabalho);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable  Long id) throws Exception {
        jornadaService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}///public ResponseEntity<Void> methodName() {
// your business logic
   /// return ResponseEntity.noContent().build();
   //        }
