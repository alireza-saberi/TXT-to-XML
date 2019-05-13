package com.alan.data.model;

import java.util.Arrays;
import java.util.Objects;

public class Movie {
    private String name;
    private String rated;
    private String[] times;
    private String releaseTime;
    private String runTime;
    private String genre;
    private String[] stars;
    private String[] directors;
    private String[] produces;
    private String[] writers;
    private String studio;

    public Movie() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String[] getTimes() {
        return times;
    }

    public void setTimes(String[] times) {
        this.times = times;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String[] getStars() {
        return stars;
    }

    public void setStars(String[] stars) {
        this.stars = stars;
    }

    public String[] getDirectors() {
        return directors;
    }

    public void setDirectors(String[] directors) {
        this.directors = directors;
    }

    public String[] getProduces() {
        return produces;
    }

    public void setProduces(String[] produces) {
        this.produces = produces;
    }

    public String[] getWriters() {
        return writers;
    }

    public void setWriters(String[] writers) {
        this.writers = writers;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(getName(), movie.getName()) &&
                Objects.equals(getRated(), movie.getRated()) &&
                Arrays.equals(getTimes(), movie.getTimes()) &&
                Objects.equals(getReleaseTime(), movie.getReleaseTime()) &&
                Objects.equals(getRunTime(), movie.getRunTime()) &&
                Objects.equals(getGenre(), movie.getGenre()) &&
                Arrays.equals(getStars(), movie.getStars()) &&
                Arrays.equals(getDirectors(), movie.getDirectors()) &&
                Arrays.equals(getProduces(), movie.getProduces()) &&
                Arrays.equals(getWriters(), movie.getWriters()) &&
                Objects.equals(getStudio(), movie.getStudio());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getName(), getRated(), getReleaseTime(), getRunTime(), getGenre(), getStudio());
        result = 31 * result + Arrays.hashCode(getTimes());
        result = 31 * result + Arrays.hashCode(getStars());
        result = 31 * result + Arrays.hashCode(getDirectors());
        result = 31 * result + Arrays.hashCode(getProduces());
        result = 31 * result + Arrays.hashCode(getWriters());
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", rated='" + rated + '\'' +
                ", times=" + Arrays.toString(times) +
                ", releaseTime='" + releaseTime + '\'' +
                ", runTime='" + runTime + '\'' +
                ", genre='" + genre + '\'' +
                ", stars=" + Arrays.toString(stars) +
                ", directors=" + Arrays.toString(directors) +
                ", produces=" + Arrays.toString(produces) +
                ", writers=" + Arrays.toString(writers) +
                ", studio='" + studio + '\'' +
                '}';
    }
}
