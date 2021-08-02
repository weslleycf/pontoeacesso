package com.dio.projeto.pontoeacesso.pontoeacesso.model;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Calendario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private TipoData tipoData;
    private String descricao;
    private LocalDateTime dataEspecial;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Calendario that = (Calendario) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 223886055;
    }
}
