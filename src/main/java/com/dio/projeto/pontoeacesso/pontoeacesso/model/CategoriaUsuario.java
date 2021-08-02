package com.dio.projeto.pontoeacesso.pontoeacesso.model;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CategoriaUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String descricao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CategoriaUsuario that = (CategoriaUsuario) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 2059934939;
    }
}
