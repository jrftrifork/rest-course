package com.trifork.hr.representation;

import com.trifork.hr.model.Employee;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name="response")
public class EmployeeRepresentation {
    @XmlElement
    Employee employee;
    @XmlElementWrapper(name="links")
    @XmlElement(name="links")
    List<Link> links;

    @SuppressWarnings("unused")
    public EmployeeRepresentation() {
        // for JAXB
    }

    public EmployeeRepresentation(Employee employee, Link... links) {
        this.employee = employee;
        this.links = Arrays.asList(links);
    }
}
