/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koona.dvdstore.web.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author Steve KOUNA
 */
public class MovieForm {

    @NotBlank(message = "Veuillez entrer un titre")
    @Size(max = 20, message = "Entrez un titre de 20 caractères au plus")
    private String title;

    @NotBlank(message = "Veuillez choisir un genre")
    private String genre;
    private Long id;

    @Size(max = 255, message = "Entrez une description de 255 caractères au plus")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
