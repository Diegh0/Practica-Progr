package com.ejercicioexamen.app.business.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.ejercicioexamen.app.business.entity.Director;
import com.ejercicioexamen.app.business.entity.Movies;



public interface RepositoryMoviesService {
    List<Movies> findAllMovies(Connection connection) throws SQLException;
    
    public Movies findMovieById(int id) throws SQLException;

    public boolean insertMovies(Connection connection, String title, int year, int runtime, Director director_id) throws SQLException;

   

}
