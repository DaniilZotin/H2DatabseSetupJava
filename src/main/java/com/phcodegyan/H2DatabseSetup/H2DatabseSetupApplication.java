package com.phcodegyan.H2DatabseSetup;

import com.phcodegyan.H2DatabseSetup.controllers.Controller;
import com.phcodegyan.H2DatabseSetup.db.Person;
import com.phcodegyan.H2DatabseSetup.repositories.PersonRep;
import com.phcodegyan.H2DatabseSetup.servises.Servise;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationAotProcessor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;


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
