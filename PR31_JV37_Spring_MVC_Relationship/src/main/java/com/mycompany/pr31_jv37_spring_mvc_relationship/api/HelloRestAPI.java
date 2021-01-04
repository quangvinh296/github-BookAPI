/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pr31_jv37_spring_mvc_relationship.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api")
public class HelloRestAPI {

    @RequestMapping("/hello-api")
    public Object helloWorld() {
        return "Hello world";
    }

    @RequestMapping("/request-param")
    public Object sendValue(
            @RequestParam(name = "country") String country) {
        return "Hello " + country;
    }

    @RequestMapping("/path-variable/{country}")
    public Object sendPathVariable(
            @PathVariable("country") String country) {
        return "Hello " + country;
    }
}
