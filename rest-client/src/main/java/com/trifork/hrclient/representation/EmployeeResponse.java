package com.trifork.hrclient.representation;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class EmployeeResponse {
    @XmlElement
    public Employee employee;
}
