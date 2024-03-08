package org.example;

import org.example.entity.Departement;
import org.example.repository.DepartementRepository;
import org.example.repository.EmployeeRepository;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory =new Configuration().configure().buildSessionFactory();
        DepartementRepository departmentDAO = new DepartementRepository(sessionFactory);
        EmployeeRepository employeeRepository = new EmployeeRepository(sessionFactory);
        //int departmentIdToDelete = 2;
        //departmentDAO.deleteDepartment(departmentIdToDelete);
        //int employeeIdToDelete = 1; // Replace with the actual employee ID
        //employeeRepository.deleteEmployee(employeeIdToDelete);
        //Employee newEmployee = new Employee();
        //newEmployee.setNom("hsh");
        //newEmployee.setPrenom("hosin");
        //newEmployee.setEmail("hosin.doe@example.com");

        //int departmentId = 1; // Replace with the actual department ID
        //employeeRepository.addEmployeeToDepartment(newEmployee, departmentId);

        //int departmentId = 1; // Replace with the actual department ID
        //List<Employee> employees = employeeRepository.getEmployeesByDepartmentId(departmentId);
        //for(Employee employee:employees) System.out.println(employee.getNom());

        int employeeIdToQuery = 1; // Replace with the actual employee ID
        List<Departement> departments = employeeRepository.getDepartmentsByEmployeeId(employeeIdToQuery);
        for (Departement departement : departments) System.out.println(departement.getNom());

    }
}