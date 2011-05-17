package com.trifork.hr.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Status")
@XmlEnum
public enum EmployeeStatus {
    ACTIVE, SICK, ON_LEAVE, INACTIVE
}
