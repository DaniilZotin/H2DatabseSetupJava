package com.phcodegyan.H2DatabseSetup.servises;

import com.phcodegyan.H2DatabseSetup.db.Age;
import com.phcodegyan.H2DatabseSetup.db.Person;
import com.phcodegyan.H2DatabseSetup.repositories.PersonRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class Servise {

    @Autowired
    private PersonRep personRep;

    LocalDate birthday;
    LocalDate now = LocalDate.now();


    public List<Age> baseAge(Long id){
        List<Person> peopleService = personRep.findAllById(id);
        List<Age> resultList = new ArrayList<>();
        peopleService.forEach(person -> {
           birthday = person.getBirth();
           long yearsOld = ChronoUnit.YEARS.between(birthday, now);
           resultList.add(new Age(person.getName(),yearsOld,person.getId()));

        });
        return resultList;
    }



}


//return people.stream().filter(person -> person.getName().equals("Alex")).findAny().orElse(null);
