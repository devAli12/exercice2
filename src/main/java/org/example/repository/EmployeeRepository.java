package org.example.repository;

import lombok.AllArgsConstructor;
import org.example.entity.Departement;
import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

@AllArgsConstructor
public class EmployeeRepository {

    private final SessionFactory sessionFactory;

    public List<Employee> getEmployeesByDepartmentId(int departmentId) {
        try (Session session = sessionFactory.openSession()) {
            // Use HQL to select employees of a specific department
            String hql = "FROM Employee e WHERE e.departement.id = :departmentId";
            Query<Employee> query = session.createQuery(hql, Employee.class);
            query.setParameter("departmentId", departmentId);

            return query.list();
        }
    }


    public void addEmployeeToDepartment(Employee employee, int departmentId) {
        try (Session session = sessionFactory.openSession()) {
            // Begin transaction
            session.beginTransaction();

            // Retrieve the department entity by ID
            Departement department = session.get(Departement.class, departmentId);

            // Set the department for the new employee
            employee.setDepartement(department);

            // Save the employee
            session.save(employee);

            // Commit transaction
            session.getTransaction().commit();
        }
    }


    public List<Departement> getDepartmentsByEmployeeId(int employeeId) {
        try (Session session = sessionFactory.openSession()) {
            // Use HQL to select departments by employee ID
            String hql = "SELECT e.departement FROM Employee e WHERE e.id = :employeeId";
            Query<Departement> query = session.createQuery(hql, Departement.class);
            query.setParameter("employeeId", employeeId);

            return query.list();
        }
    }

    public void deleteEmployee(int employeeId) {
        try (Session session = sessionFactory.openSession()) {
            // Begin transaction
            session.beginTransaction();
            // Retrieve the employee entity by ID
            Employee employee = session.get(Employee.class, employeeId);

            if (employee != null) {
                // Delete the employee
                session.delete(employee);
            }
            // Commit transaction
            session.getTransaction().commit();
        }
    }

}
