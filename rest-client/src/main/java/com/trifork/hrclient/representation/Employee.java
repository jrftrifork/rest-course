package com.trifork.hrclient.representation;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
    @XmlElement
    public String name;

    @XmlElement
    long id;

    @XmlElement
    String status;

    @SuppressWarnings("unused")
    public Employee() {
        // For JAXB
    }

    public Employee(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Employee[" +
                "name='" + name + "\', " +
                "status='" + status + "\', " +
                "id='" + id + '\'' +
                ']';
    }
}
