package com.ejercicioexamen.app.persistence.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ejercicioexamen.app.DBUtil.DBUtil;
import com.ejercicioexamen.app.business.entity.Actor;
import com.ejercicioexamen.app.persistence.RepositoryActors;

public class RepositoryActorsImpl implements RepositoryActors {

    @Override
    public List<Actor> findAllActors(Connection connection) throws SQLException {
     
        String sql="select * from actors";
        ResultSet resultSet=DBUtil.select(connection, sql, null);
        List<Actor> actorsList=new ArrayList<>();
        while(resultSet.next()){
            actorsList.add(new Actor(
                resultSet.getInt("id"),
                resultSet.getInt("birthYear"),
                resultSet.getInt("deathYear"),
                resultSet.getString("name")));
        }
        return actorsList;
    }

    @Override
    public List<Actor> findActorsById(int id) throws SQLException {
        Connection conn=DBUtil.getConnection();
    String  sql="select * from actors join actors_movies on actors.imdb_id=actors_movies.actor_id where actors_movies.movie_id=?";
    ResultSet resultSet=DBUtil.select(conn, sql, List.of(id));
    List<Actor> actorsList = new ArrayList<>();
    while(resultSet.next()){
        actorsList.add(new Actor(
            resultSet.getInt("id"),
            resultSet.getInt("birthYear"),
            resultSet.getInt("deathYear"),
            resultSet.getString("name")));
    }
    return actorsList;

    }
    
    
}
