/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koona.dvdstore.web.controller;

import com.koona.dvdstore.entity.Movie;
import com.koona.dvdstore.service.MovieServiceInterface;
import java.util.Scanner;

import com.koona.dvdstore.web.form.MovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Steve KOUNA
 */
@Controller
@RequestMapping("/movie")
public class MovieController {
    
    @Autowired
    private MovieServiceInterface movieService;

    
    public void addUsingConsole() {
        Movie movie = new Movie();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println( "What is the title of the movie : " );
        String title = scanner.nextLine();
        System.out.println( "What is the genre of the movie : " );
        String genre = scanner.nextLine();
        
        movie.setGenre(genre);
        movie.setTitle(title);
        
        movieService.registerMovie(movie);
    }
    
    public void goLiveMovie() {
        Movie movie = new Movie();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println( "What is the title of the movie : " );
        String title = scanner.nextLine();
        System.out.println( "What is the genre of the movie : " );
        String genre = scanner.nextLine();
        
        movie.setGenre(genre);
        movie.setTitle(title);
        
        movieService.goLiveMovie(movie);
    }

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public String displayMovieCard(@PathVariable("id") Long id, Model model) {
        System.out.println("la methode display movie card invoquee");
        model.addAttribute("movie", movieService.getMovieId(id));
        return "movie-details";
    }

    @PostMapping("")
    public String addMovie(@Validated @ModelAttribute MovieForm movieForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()){
            return "add-movie-form";
        }

        Movie movie = new Movie();
        movie.setGenre(movieForm.getGenre());
        movie.setDescription(movieForm.getDescription());
        movie.setTitle(movieForm.getTitle());

        movieService.registerMovie(movie);
        return "movie-added";
    }

}
