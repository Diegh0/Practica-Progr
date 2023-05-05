package com.ejercicioexamen.app.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ejercicioexamen.app.business.entity.Actor;
import com.ejercicioexamen.app.business.entity.Movies;

public class DBUtil {

    final static String DRIVER = "jdbc:mysql";
    final static String URL = "localhost:3306";
    final static String DB = "imdb";
    final static String USER = "root";
    final static String PASSWORD = "diego";

    static String connectionString = String.format("%s://%s/%s?user=%s&password=%s", DRIVER, URL, DB, USER, PASSWORD);
//ABRIR FLUJOS
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(connectionString);
        } catch (Exception e) {
            throw new RuntimeException("Error al conectar con la bbdd");
        }
    }
 //CERRAR FLUJOS
    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error al cerrar la conexción con la bbdd");
        }
    }

 //SELECT
 public static ResultSet select(Connection connection, String sql, List<Object> values) {
    try {
        PreparedStatement preparedStatement = setParameters(connection, sql, values);
        return preparedStatement.executeQuery();
    } catch (SQLException e) {
        throw new RuntimeException();
             
    }
}
    
    // /* MÉTODO PARA SETEAR PARAMETROS */ METODO PARA HACER QUERYS
    private static PreparedStatement setParameters(Connection connection, String sql, List<Object> values) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            if (values != null) {
                for (int i = 0; i < values.size(); i++) {
                    Object value = values.get(i);
                    preparedStatement.setObject(i + 1, value);
                }
            }
            return preparedStatement;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /* MÉTODOS CRUD */
    public static boolean insert(Connection connection, String sql, List<Object> values) {
        try {
            PreparedStatement preparedStatement = setParameters(connection, sql, values);
            return (preparedStatement.executeUpdate() > 0) ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int update(Connection connection, String sql, List<Object> values) {
        try {
            PreparedStatement preparedStatement = setParameters(connection, sql, values);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int delete(Connection connection, String sql, List<Object> values) {
        try {
            PreparedStatement preparedStatement = setParameters(connection, sql, values);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
