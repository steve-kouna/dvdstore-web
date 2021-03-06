package com.koona.dvdstore.web.controller;

import com.koona.dvdstore.entity.Movie;
import com.koona.dvdstore.service.MovieServiceInterface;
import com.koona.dvdstore.web.form.MovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dvd")
public class HomeController {

    @Autowired
    private MovieServiceInterface movieService;

    public HomeController(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/home")
    public String displayHome(Model model) {
        System.out.println("La methode display home a ete invoquee !");
//        model.addAttribute("movies", movieService.getMovieList());

        return "dvdstore-home";
    }

    @GetMapping("/add-movie-form")
    public String displayMovieForm(@ModelAttribute MovieForm movieForm) {
        return "add-movie-form";
    }
}
