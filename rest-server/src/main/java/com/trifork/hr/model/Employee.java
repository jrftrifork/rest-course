package com.trifork.hr.model;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("UnusedDeclaration")
@XmlRootElement
public class Employee {
    private long id;
    String name;
    EmployeeStatus status = EmployeeStatus.ACTIVE;

	public Employee() {
		// used by JAXB
	}

	public Employee(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Employee[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ']';
    }
}
