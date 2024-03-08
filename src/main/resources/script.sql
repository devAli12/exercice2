-- Insert Sample Departments
INSERT INTO Departement (id, nom) VALUES
                                      (1, 'Human Resources'),
                                      (2, 'IT Department');

-- Insert Sample Employees
INSERT INTO Employee (id, nom, prenom, email, departement_id) VALUES
                                                                  (1, 'John', 'Doe', 'john.doe@example.com', 1),
                                                                  (2, 'Jane', 'Smith', 'jane.smith@example.com', 1),
                                                                  (3, 'Bob', 'Johnson', 'bob.johnson@example.com', 2),
                                                                  (4, 'Alice', 'Williams', 'alice.williams@example.com', 2);