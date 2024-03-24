package com.example.siteWeb;
import Service.ClientiService;
import Tabele.Clienti;
import com.sun.tools.javac.Main;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
@ComponentScan(basePackages = {"Controller","Service","Repo"})
@RestController
public class SiteWebApplication {
	@Autowired
	private DataSource dataSource;
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
