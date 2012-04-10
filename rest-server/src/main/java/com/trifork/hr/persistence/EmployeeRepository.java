package com.trifork.hr.persistence;

import com.trifork.hr.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Simple repository for Employees.
 * Use simply by calling <code>new EmployeeRepository()</code>.
 */
public class EmployeeRepository {
    private static EntityManager em = Persistence.createEntityManagerFactory("hr").createEntityManager();

    static {
        em.merge(new Employee("Test 1"));
        em.merge(new Employee("Test 2"));
    }

    public Employee save(Employee empl) {
        return em.merge(empl);
    }

    /**
     * @throw EntitytNotFoundException if the Employee indicated by parameter <code>id</code> does not exist
     */
    public Employee get(long id) {
        final Employee employee = em.find(Employee.class, id);
        if (employee == null) throw new EntityNotFoundException("" + id);
        return employee;
    }

	@SuppressWarnings({"unchecked", "UnusedDeclaration"})
	public void remove(long id) {
        em.remove(get(id));
    }

    @SuppressWarnings({"unchecked", "UnusedDeclaration"})
    public List<Employee> listAll() {
        return em.createQuery("SELECT e from Employee e").getResultList();
    }
}

