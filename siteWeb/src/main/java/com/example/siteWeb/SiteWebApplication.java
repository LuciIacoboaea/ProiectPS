package com.example.siteWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@SpringBootApplication
@EntityScan("com.example.siteWeb.Tabele")
public class SiteWebApplication {
	public static void main(String[] args) {

		 SpringApplication.run(SiteWebApplication.class, args);
		 hello();
	}
	@GetMapping
	public static String hello(){
		return"Hello World!";
	}
	/*@PostConstruct
	public void checkDatabaseConnection() {
		try {
			Connection connection = dataSource.getConnection();
			System.out.println("Conexiunea la baza de date s-a realizat cu succes!");
			connection.close();
		} catch (SQLException e) {
			System.out.println("Eroare la conectarea la baza de date: " + e.getMessage());
		}
	}*/

}
