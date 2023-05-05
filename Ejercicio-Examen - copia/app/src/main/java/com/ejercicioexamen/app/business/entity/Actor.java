package com.ejercicioexamen.app.business.entity;

public class Actor {
    int id,birthYear,deathYear;
    String name;
    
    public Actor(int id, int birthYear, int deathYear, String name) {
        this.id = id;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.name = name;
    }
    
    public int getId() {
        return id;
    }
    public int getBirthYear() {
        return birthYear;
    }
    public int getDeathYear() {
        return deathYear;
    }
    public String getName() {
        return name;
    }
}
