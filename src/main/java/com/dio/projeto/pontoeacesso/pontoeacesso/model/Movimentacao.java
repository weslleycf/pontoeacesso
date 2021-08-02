package com.dio.projeto.pontoeacesso.pontoeacesso.model;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Movimentacao {


    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class MovimentacaoId implements Serializable{
        private long idMovimento;
        private long idUsuario;
    }
    @Id
    @EmbeddedId
    private MovimentacaoId id;
    private LocalDateTime dataEntrada;
    private LocalDateTime datasaida;
    private BigDecimal permanencia;
    @ManyToOne
    private Ocorrencia ocorrencia;
    @ManyToOne
    private Calendario calendario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Movimentacao that = (Movimentacao) o;

        if (!Objects.equals(id, that.id)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
