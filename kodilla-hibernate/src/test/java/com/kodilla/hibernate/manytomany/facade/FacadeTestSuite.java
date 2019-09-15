package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class FacadeTestSuite {

    @Mock
    CompanyDao companyDao;

    @Autowired
    Facade facade;

    @Test
    public void testSearchForCompany() {
        //Given
        List<Company> companiesThree = asList(new Company("alfa"),
                                        new Company("beta"),
                                        new Company("gamma"));
        List<Company> companiesOne = asList(new Company("gamma"));

        Mockito.when(companyDao.retrieveCompanyNameGivenArg("a")).thenReturn(companiesThree);
        Mockito.when(companyDao.retrieveCompanyNameGivenArg("mm")).thenReturn(companiesOne);
        Mockito.when(companyDao.retrieveCompanyNameGivenArg("ome")).thenReturn(new ArrayList<>());

        List<Company> foundThreeCompanies = new ArrayList<>();
        List<Company> foundOneCompany = new ArrayList<>();
        List<Company> foundZeroCompanies = new ArrayList<>();
        //When
        try {
            foundThreeCompanies = facade.searchForCompany("a");
            foundOneCompany = facade.searchForCompany("mm");
            foundZeroCompanies = facade.searchForCompany("ome");
        } catch (NotFoundException e) {
            System.out.println(NotFoundException.ERR_COMPANY_NOT_FOUND + e);
        }

        //Then
        Assert.assertEquals(companiesThree, foundThreeCompanies);
        Assert.assertEquals(companiesOne, foundOneCompany);
        Assert.assertEquals(foundZeroCompanies.size(), 0);
    }

    @Test
    public void testSearchForEmployee() {
        //Given

        //When

        //Then
    }
}