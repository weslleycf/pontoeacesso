package com.dio.projeto.pontoeacesso.pontoeacesso.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Audited
public class JornadaTrabalho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "O campo 'descricao' é obrigatório!")
    private String descricao;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JornadaTrabalho that = (JornadaTrabalho) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 1072517713;
    }
}
