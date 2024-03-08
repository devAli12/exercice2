package org.example.repository;

import lombok.AllArgsConstructor;
import org.example.entity.Departement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@AllArgsConstructor
public class DepartementRepository {

    private final SessionFactory sessionFactory;

    public void deleteDepartment(int departmentId) {
        try (Session session = sessionFactory.openSession()) {
            // Begin transaction
            session.beginTransaction();

            // Retrieve the department entity by ID
            Departement department = session.get(Departement.class, departmentId);

            if (department != null) {
                // Delete the department along with its associated employees
                session.delete(department);
            }
            // Commit transaction
            session.getTransaction().commit();
        }
    }
}
