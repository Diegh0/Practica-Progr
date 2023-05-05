package com.ejercicioexamen.app.persistence.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.ejercicioexamen.app.DBUtil.DBUtil;
import com.ejercicioexamen.app.business.entity.Director;
import com.ejercicioexamen.app.persistence.RepositoryDirector;

public class RepositoryDirectoryImpl implements RepositoryDirector  {

    @Override
    public List<Director> findAllDirectors(Connection connection) throws SQLException {
        String sql = "SELECT * FROM directors";
        ResultSet resultSet = DBUtil.select(connection, sql, null);
        List<Director>directors=new ArrayList<>();
        while (resultSet.next()){
            directors.add(new Director(
            resultSet.getInt("id"),
            resultSet.getInt("birthYear"),
            resultSet.getInt("deathYear"),
            resultSet.getString("name")));
        }
        return directors;
    }

   

   
    
}
