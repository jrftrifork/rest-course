package com.trifork.hr.representation;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="hrEntryPoint")
public class EntryPointRepresentation {
    @XmlElementWrapper(name = "links")
    @XmlElement(name = "link")
    List<Link> link;

    @SuppressWarnings("unused")
    public EntryPointRepresentation() {
    // for JAXB
    }

    public EntryPointRepresentation(List<Link> link) {
        this.link = link;
    }
}
