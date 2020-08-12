package com.ikasalo.springchat.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Obavijest {
    private int idObavijest;
    private String radnik;
    private String opis;
    /*  private LocalDateTime datum;*/
    private boolean uPosljednjihSatVremena;
    private String prijeKolikoMinuta;
    private boolean procitano;
}
