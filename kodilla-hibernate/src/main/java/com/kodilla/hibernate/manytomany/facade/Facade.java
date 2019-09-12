package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Facade {

    private CompanyDao companyDao;
    private EmployeeDao employeeDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(Facade.class);

    public Facade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> searchForCompany(String arg) throws NotFoundException{

        List<Company> foundCompanies = companyDao.retrieveCompanyNameGivenArg(arg);

        if (foundCompanies.size() == 0){
            LOGGER.error(NotFoundException.ERR_COMPANY_NOT_FOUND);
            throw new NotFoundException(NotFoundException.ERR_COMPANY_NOT_FOUND);
        }
        return foundCompanies;
    }

    public List<Employee> searchForEmployee(String arg) throws NotFoundException{

        List<Employee> foundEmployees = employeeDao.retrieveEmployeesWithGivenArg(arg);

        if (foundEmployees.size() == 0){
            LOGGER.error(NotFoundException.ERR_EMPLOYEE_NOT_FOUND);
            throw new NotFoundException(NotFoundException.ERR_EMPLOYEE_NOT_FOUND);
        }
        return foundEmployees;
    }
}
