package com.phcodegyan.H2DatabseSetup.controllers;

import com.phcodegyan.H2DatabseSetup.db.Age;

import com.phcodegyan.H2DatabseSetup.servises.Servise;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class Controller implements ErrorController {



    @Autowired
    private Servise servise;


    @GetMapping("/find/{id}")
    public List<Age> findById(@PathVariable(value = "id", required = false) Long id){
        return servise.baseAge(id);
    }

    @RequestMapping("/error")
    public String error(HttpServletRequest request){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "Error-404 not found this page ";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "Error-500 hm... something wrong with server check your code";
            }
        }
        return "Error try again";
    }

    @GetMapping("/")
    public String forTest(){
        return "Hello World from Spring Boot";
    }




}

