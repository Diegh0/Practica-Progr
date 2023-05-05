package com.ejercicioexamen.app.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ejercicioexamen.app.DBUtil.DBUtil;
import com.ejercicioexamen.app.business.entity.Actor;
import com.ejercicioexamen.app.business.entity.Director;
import com.ejercicioexamen.app.business.entity.Movies;
import com.ejercicioexamen.app.excepcion.NotFound;
import com.ejercicioexamen.app.persistence.RepositoryMovies;

public class RepositoryMoviesImpl implements RepositoryMovies {

    
    @Override
    public List<Movies> findAllMovies(Connection connection) throws SQLException {
        String sql = "SELECT * FROM movies";
        ResultSet resultSet = DBUtil.select(connection, sql, null);
        List<Movies> movies = new ArrayList<>();
        while (resultSet.next()) {
        movies.add(new Movies(
        resultSet.getInt("id"),
        resultSet.getString("imdb_id"),
        resultSet.getInt("year"),
        resultSet.getInt("runtime"),
        resultSet.getString("title"),
        resultSet.getString("image"),
        resultSet.getString("description")));
        }
        return movies;
        }
        
    @Override
    public Movies findMovieById( int id) throws SQLException {
        try {
        
        Connection conn=DBUtil.getConnection();//ABRO CONEXIÓN

        String sql="SELECT * FROM directors join movies on directors.imdb_id=movies.director_id  WHERE movies.id=?;";           
        List<Object> params = List.of(id);
     
        ResultSet resultSet=DBUtil.select(conn, sql,params);
     
        if (resultSet.next()) { 
            Movies movie = new Movies(
            resultSet.getInt("id"),
            resultSet.getString("imdb_id"),
            resultSet.getInt("year"),
            resultSet.getInt("runtime"), 
            resultSet.getString("title"),
            resultSet.getString("image"),
            resultSet.getString("description"));

            Director director =new Director(   
            resultSet.getInt("id"),
            resultSet.getInt("birthYear"), 
            resultSet.getInt("deathYear"),
            resultSet.getString("name") 
        
        );
        movie.setDirector_id(director);
        DBUtil.closeConnection(conn);//CIERRO CONEXIÓN
        return movie;
       
    } else {
       throw new NotFound("No Funsiona");
    }
       
} catch (Exception e) {
    throw new RuntimeException(e);
}    
   

}

    @Override
    public boolean insertMovies(Connection connection, String title, int year, int runtime, Director director_id){
        String sql = """
            INSERT INTO movies (title, year,runtime, director_id) 
            VALUES (?, ?, ?, ?)                    
        """;
        List<Object> params = List.of(title,year,runtime,director_id); 
     
        return DBUtil.insert(connection, sql, params); //Esta funcion solo devuelve true or false si se ha insertado correctamente el dato
    }
    

   

 
}
   


