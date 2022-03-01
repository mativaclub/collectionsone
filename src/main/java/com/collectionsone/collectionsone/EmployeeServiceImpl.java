package com.collectionsone.collectionsone;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employeeList;

    public EmployeeServiceImpl() {
        employeeList = new ArrayList<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return add(newEmployee);
    }

    @Override
    public Employee add(Employee employee) {
        if (employeeList.contains(employee)) {
            throw new EmployeeExistsException();
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return add(newEmployee);
    }

    @Override
    public Employee remove(Employee employee) {

        if (!employeeList.remove(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }


    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.remove(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }


    @Override
    public Collection <Employee> getAll() {
        return (employeeList);
    }

}
