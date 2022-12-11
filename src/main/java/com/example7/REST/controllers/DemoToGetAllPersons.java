package com.example7.REST.controllers;

import com.example7.REST.entity.Person;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

// TODO: 08/12/2022 need a person controller 
public class DemoToGetAllPersons {
    public static void main(String[] args) {

        RestTemplate rt = new RestTemplate();
        URI baseUri = URI.create("http://localhost:8080/api/persons");

        Person person = new Person();

        RequestEntity<Void> req = RequestEntity.get(baseUri).build();

        try {
            ResponseEntity<Person[]> resp = rt.exchange(req, Person[].class);
            System.out.println(resp.getStatusCode());
            Person[] arr = resp.getBody();
            List<Person> list = Arrays.asList(arr);
            System.out.println(list);
        } catch (RestClientException e) {
            System.out.println("error " + e.getMessage());
        }
    }
}
