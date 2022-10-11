package br.org.serratec.model;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.org.serratec.enums.Espaco;

@Embeddable
public class Loja {
    @Enumerated(EnumType.STRING)
    private Espaco espaco;

    private String nomeLoja;

    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }
}
