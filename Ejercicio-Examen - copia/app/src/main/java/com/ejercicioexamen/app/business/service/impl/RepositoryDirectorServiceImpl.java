package com.ejercicioexamen.app.business.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ejercicioexamen.app.business.entity.Director;
import com.ejercicioexamen.app.business.service.RepositoryDirectorService;
import com.ejercicioexamen.app.persistence.RepositoryDirector;
import com.ejercicioexamen.app.persistence.impl.RepositoryDirectoryImpl;

public class RepositoryDirectorServiceImpl implements RepositoryDirectorService{

    RepositoryDirector repositoryDirector=new RepositoryDirectoryImpl();
    @Override
    public List<Director> findAllDirectors(Connection connection) throws SQLException {
       return repositoryDirector.findAllDirectors(connection);
    }
    
}
