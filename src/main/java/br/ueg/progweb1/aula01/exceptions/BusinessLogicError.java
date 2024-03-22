package br.ueg.progweb1.aula01.exceptions;

import lombok.Getter;

@Getter
public enum BusinessLogicError {
    GENERAL(0L, "Erro desconhecido!"),
    REGISTER_NUMBER_DUPLICATED(100L, "Número de matricula duplicado"),
    NOT_FOUND(404L, "Registro não encontrado!"),
    MANDATORY_FIELD_NOT_FOUND(1L, "Campo Obrigatório não preenchido");
    private Long id;
    private String message;

    BusinessLogicError(Long id, String message){
        this.id = id;
        this.message = message;
    }
}
