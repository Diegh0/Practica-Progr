package com.ejercicioexamen.app.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ejercicioexamen.app.business.entity.Director;
import com.ejercicioexamen.app.business.entity.Movies;

public interface RepositoryDirector {
    
    public List<Director> findAllDirectors(Connection connection) throws SQLException;
}
