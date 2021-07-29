package com.dio.projeto.pontoeacesso.pontoeacesso.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Empresa {
    @Id
    private long id;
    private String descricao;
    private String cnpj;
    private String endereço;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone;




}
