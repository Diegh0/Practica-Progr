package com.ejercicioexamen.app.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ejercicioexamen.app.business.entity.Actor;

public interface RepositoryActors  {
    
    List<Actor> findAllActors(Connection connection) throws SQLException;
    
    List<Actor> findActorsById(int id) throws SQLException;

}
