package com.ejercicioexamen.app;
import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ejercicioexamen.app.DBUtil.DBUtil;
import com.ejercicioexamen.app.business.service.RepositoryMoviesService;
import com.ejercicioexamen.app.business.service.impl.RepositoryMoviesServiceImpl;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
		/*try {
			Connection connection = DBUtil.getConnection();
			RepositoryService repositoryService=new RepositoryServiceImpl();
			
			System.out.println(repositoryService.findAllMovies(connection));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}*/
		
		
	}

}
