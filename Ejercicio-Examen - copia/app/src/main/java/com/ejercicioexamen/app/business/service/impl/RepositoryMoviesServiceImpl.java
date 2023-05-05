package com.ejercicioexamen.app.business.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ejercicioexamen.app.DBUtil.DBUtil;
import com.ejercicioexamen.app.business.entity.Actor;
import com.ejercicioexamen.app.business.entity.Director;
import com.ejercicioexamen.app.business.entity.Movies;
import com.ejercicioexamen.app.business.service.RepositoryActorsService;
import com.ejercicioexamen.app.business.service.RepositoryMoviesService;
import com.ejercicioexamen.app.persistence.RepositoryMovies;
import com.ejercicioexamen.app.persistence.impl.RepositoryMoviesImpl;

public class RepositoryMoviesServiceImpl implements RepositoryMoviesService{
    
    RepositoryMovies repository=new RepositoryMoviesImpl();
    RepositoryActorsService repositoryActorsService=new RepositoryActorsServiceImpl();
    

    @Override
    public List<Movies> findAllMovies(Connection connection) throws SQLException {  
        
        
          return  repository.findAllMovies(connection);
    }

    @Override
    public Movies findMovieById(int id) throws SQLException {
        Movies movies=repository.findMovieById(id);
        List<Actor>actorsList=repositoryActorsService.findActorsById(id);
        movies.setActorsList(actorsList);
        
        return movies;
    }

    @Override
    public boolean insertMovies(Connection connection, String title, int year, int runtime, Director director_id) throws SQLException {
        return repository.insertMovies(connection, title, year, runtime, director_id);
    }

    
}
