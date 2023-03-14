package com.phcodegyan.H2DatabseSetup;


import com.phcodegyan.H2DatabseSetup.db.Person;
import com.phcodegyan.H2DatabseSetup.repositories.PersonRep;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;



@SpringBootApplication
public class H2DatabseSetupApplication {

	@Autowired
	public PersonRep personRep;


	public static void main(String[] args) {
		SpringApplication.run(H2DatabseSetupApplication.class, args);

	}

	@Bean
	InitializingBean initDataBase(){
		return () -> {personRep.save(new Person("Daniil",LocalDate.of(2003,7,2) ));
					personRep.save(new Person("Alex",LocalDate.of(2002,8,20)));
					personRep.save(new Person("Sergo",LocalDate.of(2002,2,14)));};
	}



}
