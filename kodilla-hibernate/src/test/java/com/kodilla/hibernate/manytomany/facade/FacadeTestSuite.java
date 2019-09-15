package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacadeTestSuite {

    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    Facade facade;

    private Employee johnSmith;
    private Employee stephanieClarckson;
    private Employee lindaKovalsky;

    private Company softwareMachine;
    private Company dataMaesters;
    private Company greyMatter;

    @Before
    public void prepare(){

        johnSmith = new Employee("John", "Smith");
        stephanieClarckson = new Employee("Stephanie", "Clarckson");
        lindaKovalsky = new Employee("Linda", "Kovalsky");

        softwareMachine = new Company("Software Machine");
        dataMaesters = new Company("Data Maesters");
        greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);
    }

    @After
    public void cleanUp(){

        companyDao.deleteById(softwareMachine.getId());
    }

    @Test
    public void testSearchForCompany() {
        //Given
        final String ARG1 = "ma";
        final String ARG2 = "soft";

        List<Company> foundThreeCompanies = new ArrayList<>();
        List<Company> foundOneCompany = new ArrayList<>();
        List<Company> foundZeroCompanies = new ArrayList<>();

        //When
        try {
            foundThreeCompanies = facade.searchForCompany(ARG1);
            foundOneCompany = facade.searchForCompany(ARG2);
            foundZeroCompanies = facade.searchForCompany("ome");
        } catch (NotFoundException e) {
            System.out.println(NotFoundException.ERR_COMPANY_NOT_FOUND + e);
        }

        //Then
        assertEquals(foundThreeCompanies.size(), 3);
        assertTrue(foundThreeCompanies.contains(softwareMachine));
        assertTrue(foundThreeCompanies.contains(greyMatter));
        assertTrue(foundThreeCompanies.contains(dataMaesters));
        assertEquals(foundOneCompany.size(), 1);
        assertTrue(foundOneCompany.contains(softwareMachine));
        assertTrue(foundZeroCompanies.isEmpty());
    }

    @Test
    public void testSearchForEmployee() {
        //Given
        final String ARG1 = "ova";
        final String ARG2 = "smit";

        List<Employee> foundLinda = new ArrayList<>();
        List<Employee> foundJohn = new ArrayList<>();
        List<Employee> foundZero = new ArrayList<>();

        //When
        try {
            foundLinda = facade.searchForEmployee(ARG1);
            foundJohn = facade.searchForEmployee(ARG2);
            foundZero = facade.searchForEmployee("maj");
        } catch (NotFoundException e) {
            System.out.println(NotFoundException.ERR_COMPANY_NOT_FOUND + e);
        }

        //Then
        assertEquals(foundLinda.size(), 1);
        assertTrue(foundLinda.contains(lindaKovalsky));
        assertEquals(foundJohn.size(), 1);
        assertTrue(foundJohn.contains(johnSmith));
        assertTrue(foundZero.isEmpty());
    }

}