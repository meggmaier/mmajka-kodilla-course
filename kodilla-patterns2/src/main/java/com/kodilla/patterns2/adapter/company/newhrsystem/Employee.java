package com.kodilla.patterns2.adapter.company.newhrsystem;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Objects;

@AllArgsConstructor
@Getter
public class Employee {

    final private String peselId;
    final private String firstname;
    final private String lastname;
    final private BigDecimal baseSalary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return peselId.equals(employee.peselId) &&
                firstname.equals(employee.firstname) &&
                lastname.equals(employee.lastname) &&
                baseSalary.equals(employee.baseSalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peselId, firstname, lastname, baseSalary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "peselId='" + peselId + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", baseSalary=" + baseSalary +
                '}';
    }
}

