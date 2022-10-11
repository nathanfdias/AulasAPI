package br.org.serratec.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.org.serratec.exception.EnumValidationException;

public enum Espaco {
    ONLINE, FÍSICO, ENCOMENDA;

    @JsonCreator
    public static Espaco verifica(String valor) throws EnumValidationException {
        for (Espaco espaco : Espaco.values()) {
            if (valor.equals(espaco.name())) {
                return espaco;
            }
        }
        throw new EnumValidationException("Preencha o espaço corretamente");
    }
}
