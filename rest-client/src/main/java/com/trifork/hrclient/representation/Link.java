package com.trifork.hrclient.representation;

import java.net.URI;

public class Link {
    public String rel;
    public URI href;

    public Link(URI href, String rel) {
        this.href = href;

        this.rel = rel;
    }


    @Override
    public String toString() {
        return "Link[" +
                "rel='" + rel + '\'' +
                ", href=" + href +
                ']';
    }
}
