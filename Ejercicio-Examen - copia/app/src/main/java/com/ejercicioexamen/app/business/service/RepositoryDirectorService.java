package com.ejercicioexamen.app.business.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ejercicioexamen.app.business.entity.Director;

public interface RepositoryDirectorService {
    public List<Director> findAllDirectors(Connection connection) throws SQLException;
}
