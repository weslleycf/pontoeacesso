package com.dio.projeto.pontoeacesso.pontoeacesso.model;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class BancoHoras{

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class BancoHorasId implements Serializable{
        private long idBancoHoras;
        private long idMovimentacao;
        private long idUsuario;
    }
    @Id
    @EmbeddedId
    private BancoHorasId id;

    private LocalDateTime dataTrabalhada;
    private BigDecimal quantidadeHoras;
    private BigDecimal saldoHoras;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BancoHoras that = (BancoHoras) o;

        if (!Objects.equals(id, that.id)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
