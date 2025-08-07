package org.lessons.java.spring.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.List;

import org.lessons.java.spring.best_of_the_year.classes.Movie;
import org.lessons.java.spring.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("name", "Andrea");

        return "home";
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        List<Movie> movies = getBestMovies();

        String movieTitles = "";
        for (int i = 0; i < movies.size(); i++) {
            movieTitles += movies.get(i).getTitle();
            if (i < movies.size() - 1) {
                movieTitles += ", ";
            }
        }
        model.addAttribute("movieList", movieTitles);
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        List<Song> songs = getBestSongs();

        String songTitles = "";
        for (int i = 0; i < songs.size(); i++) {
            songTitles += songs.get(i).getTitle();
            if (i < songs.size() - 1) {
                songTitles += ", ";
            }
        }
        model.addAttribute("songList", songTitles);

        return "songs";
    }

    private List<Movie> getBestMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Il Signore Degli anelli"));
        movies.add(new Movie(2, "The Witcher"));
        movies.add(new Movie(3, "Matrix"));
        movies.add(new Movie(4, "Apocalipse now"));
        movies.add(new Movie(5, "Io sono Leggenda"));

        return movies;
    }

    private List<Song> getBestSongs() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "Non Crollo"));
        songs.add(new Song(2, "Plesantville"));
        songs.add(new Song(3, "Rap in vena"));
        songs.add(new Song(4, "Bugiardo"));
        songs.add(new Song(5, "La Soluzione"));

        return songs;
    }
}
