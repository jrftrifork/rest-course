package com.trifork.hr.representation;

import com.trifork.hr.model.Employee;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="employees")
public class EmployeeListRepresentation {
    @XmlElement
    List<Employee> employees;

    @SuppressWarnings("unused")
    public EmployeeListRepresentation() {
        // For JAXB
    }

    public EmployeeListRepresentation(List<Employee> employees) {
        this.employees = employees;
    }
}
