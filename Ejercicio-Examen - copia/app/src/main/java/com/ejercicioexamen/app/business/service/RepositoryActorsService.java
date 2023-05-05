package com.ejercicioexamen.app.business.service;

import java.sql.SQLException;
import java.util.List;

import org.mariadb.jdbc.Connection;

import com.ejercicioexamen.app.business.entity.Actor;

public interface RepositoryActorsService {
    
    List<Actor> findAllActors(Connection connection) throws SQLException;
   
    List<Actor> findActorsById(int id) throws SQLException;
   
}
