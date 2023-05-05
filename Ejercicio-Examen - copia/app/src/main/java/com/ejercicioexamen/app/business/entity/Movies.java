package com.ejercicioexamen.app.business.entity;

import java.util.List;

public class Movies {
    int id,year,runtime;
  
    String title,image,description,imdb_id;
    
    Director director_id; //getters y setters

    List<Actor> actorsList;

    public Director getDirector_id() {
        return director_id;
    }

    public void setDirector_id(Director director_id) {
        this.director_id = director_id;
    }

    public Movies(){}

    public Movies(int id, String imdb_id, int year, int runtime, String title, String image, String description) {
        this.id = id;
        this.year = year;
        this.runtime = runtime;
        this.title = title;
        this.image = image;
        this.description = description;
        this.imdb_id = imdb_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    @Override
    public String toString() {
        return "Movies [id=" + id + ", year=" + year + ", runtime=" + runtime + ", director_id=" + director_id
                + ", title=" + title + ", image=" + image + ", description=" + description + ", imdb_id=" + imdb_id
                + "]";
    }

    public void setActorsList(List<Actor> actorsList) {
        this.actorsList = actorsList;
    }

    
    

    
    
  
}
