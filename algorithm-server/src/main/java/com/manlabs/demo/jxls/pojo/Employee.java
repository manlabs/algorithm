package com.manlabs.demo.jxls.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class Employee {

    private String name;
    private Date birthDate;
    private int payment;
    private double bonus;

    private int mergeNum;

    private List<Employee> children;

}
