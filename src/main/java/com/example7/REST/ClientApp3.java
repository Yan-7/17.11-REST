package com.example7.REST;

import com.example7.REST.entity.Employee;
import org.springframework.web.client.RestTemplate;

public class ClientApp3 {
    public static void main(String[] args) {

        Employee person =new Employee(0,"Yoel", Employee.Department.CUSTOMERS,17000);

        RestTemplate rt = new RestTemplate();

        Employee emp = rt.postForObject("http://localhost:8080/api/employees",person,Employee.class);
        System.out.println(emp);

    }
}
