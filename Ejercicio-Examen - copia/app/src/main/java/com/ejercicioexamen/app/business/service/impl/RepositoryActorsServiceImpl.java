package com.ejercicioexamen.app.business.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.mariadb.jdbc.Connection;

import com.ejercicioexamen.app.business.entity.Actor;
import com.ejercicioexamen.app.business.service.RepositoryActorsService;
import com.ejercicioexamen.app.persistence.RepositoryActors;
import com.ejercicioexamen.app.persistence.impl.RepositoryActorsImpl;

public class RepositoryActorsServiceImpl implements RepositoryActorsService {
    
    RepositoryActors repositoryActors=new RepositoryActorsImpl();

    @Override

    public List<Actor> findAllActors(Connection connection) throws SQLException {
        return repositoryActors.findAllActors(connection);
    }

    @Override
    public List<Actor> findActorsById(int id) throws SQLException {
       return repositoryActors.findActorsById(id);
    }

   

    
    
}
