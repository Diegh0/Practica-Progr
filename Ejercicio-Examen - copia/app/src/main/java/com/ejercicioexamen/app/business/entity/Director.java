package com.ejercicioexamen.app.business.entity;

public class Director {
    
    int id,birthYear,deathYear;
    String name;
    
    public Director(int id, int birthYear, int deathYear, String name) {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Director [id=" + id + ", birthYear=" + birthYear + ", deathYear=" + deathYear + ", name=" + name + "]";
    }

    


}
