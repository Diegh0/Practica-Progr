package com.ejercicioexamen.app.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ejercicioexamen.app.business.entity.Actor;
import com.ejercicioexamen.app.business.entity.Director;
import com.ejercicioexamen.app.business.entity.Movies;

public interface RepositoryMovies {
    List<Movies> findAllMovies(Connection connection) throws SQLException;

    Movies findMovieById(int id) throws SQLException;
    
    boolean insertMovies(Connection connection,String title,int year,int runtime,Director director_id) throws SQLException;
}