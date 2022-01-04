package com.cjss.Employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {
    private Integer id;
    private String name;
    private String dept;
    private Double salary;
    private String location;
    private  String phoneNumber;
    private  String designation;

}
