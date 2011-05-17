package com.trifork.hr.representation;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;

@XmlRootElement
public class Link {
    public static final String REL_SELF="self";

    @XmlAttribute
    String rel;

    @XmlAttribute
    URI href;

    @XmlAttribute
    String method = "GET";

    @SuppressWarnings("unused")
    public Link() {
        // for JAXB
    }

    public Link(String rel, URI href) {
        this.rel = rel;
        this.href = href;
    }

    public Link(String rel, URI href, String method) {
        this(rel, href);
        this.method = method; 
    }
}
