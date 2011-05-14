package com.trifork.hr.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "EmployeeStatus")
@XmlEnum
public enum EmployeeStatus {
    ACTIVE, SICK, ON_LEAVE, INACTIVE
}
