package com.dio.projeto.pontoeacesso.pontoeacesso.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Empresa {

    private long id;
    private String descricao;
    private String cnpj;
    private String endereço;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone;




}
