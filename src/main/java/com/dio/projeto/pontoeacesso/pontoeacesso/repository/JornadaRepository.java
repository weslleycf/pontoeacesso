package com.dio.projeto.pontoeacesso.pontoeacesso.repository;

import com.dio.projeto.pontoeacesso.pontoeacesso.model.JornadaTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JornadaRepository extends JpaRepository<JornadaTrabalho, Long> {

}
