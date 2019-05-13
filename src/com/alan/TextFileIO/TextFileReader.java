package com.alan.TextFileIO;

import com.alan.data.model.Movie;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TextFileReader {

    public List<Movie> readFile(String fileName) {

        // constructing Movie based on data model
        // putting movie into array list of movies
        Movie movie = new Movie();
        List<Movie> myMovies = new ArrayList<>();

        try {
            // Reading file line by line using FileReader, and bufferReader
            Scanner s = new Scanner(new BufferedReader(new FileReader(fileName)));
            String line;

            while(s.hasNextLine()){
                line = s.nextLine();
                if(!line.isEmpty()) {
                    if (line.equalsIgnoreCase("rated:")) {
                        // reading the rate, and putting it into movie model
                        movie.setRated(s.nextLine());
                    } else if (line.equalsIgnoreCase("times:")){
                        // reading the times, and organizing them into movie model array of times
                        String[] timesNoTrim = s.nextLine().split(",");
                        String[] times = new String[timesNoTrim.length];
                        for (int i = 0;  i < timesNoTrim.length ; i++){
                            times[i] = timesNoTrim[i].trim();
                        }

                        movie.setTimes(times);
                    } else if (line.equalsIgnoreCase("release date:")){
                        // reading date, and putting it into movie model

                        movie.setReleaseTime(s.nextLine());
                    } else if (line.equalsIgnoreCase("run time:")){
                        // reading time, and putting it into movie model

                        movie.setRunTime(s.nextLine());
                    } else if (line.equalsIgnoreCase("genre:")){
                        // reading genre, and putting it into movie model

                        movie.setGenre(s.nextLine());
                    } else if (line.equalsIgnoreCase("starring:")){
                        // this part would be hell
                        // reading stars, and putting them into movie model array of stars

                        String[] starline = s.nextLine().split("With starring of");
                        String[] starsNoTrim = starline[0].split(",");
                        String[] stars = new String[starsNoTrim.length];

                        for (int i = 0; i < stars.length; i++){
                            stars[i] = starsNoTrim[i].trim();
                        }

                        movie.setStars(stars);
                    } else if (line.equalsIgnoreCase("director(s):")){
                        // reading directors, and putting them into movie model array of directors
                        String[] directorsNoTrim = s.nextLine().split(",");
                        String[] directors = new String[directorsNoTrim.length];
                        for (int i = 0;  i < directorsNoTrim.length ; i++){
                            directors[i] = directorsNoTrim[i].trim();
                        }

                        movie.setDirectors(directors);
                    } else if (line.equalsIgnoreCase("PRODUCER(S):")){
                        // reading producers, and putting them into movie model array of producers
                        String[] producersNoTrim = s.nextLine().split(",");
                        String[] producers = new String[producersNoTrim.length];
                        for (int i = 0;  i < producersNoTrim.length ; i++){
                            producers[i] = producersNoTrim[i].trim();
                        }

                        movie.setProduces(producers);
                    } else if (line.equalsIgnoreCase("writer(s):")){
                        // reading writers, and putting them into movie model array of writers
                        String[] writersNoTrim = s.nextLine().split(",");
                        String[] writers = new String[writersNoTrim.length];

                        for (int i = 0; i < writersNoTrim.length; i++) {
                            writers[i] = writersNoTrim[0].trim();
                        }

                        movie.setWriters(writers);
                    } else if (line.equalsIgnoreCase("studio:")){
                        // reading the rate, and putting it into movie model

                        movie.setStudio(s.nextLine());
                    } else if (movie.getName() == null) {
                        movie.setName(line);
                    }
                } else {
                    // when the length of line is not zero
                    // pushing its information for the list, and assigning it to null
                    myMovies.add(movie);
                    movie = new Movie();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return myMovies;
    }

}
