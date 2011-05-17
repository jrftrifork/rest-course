package com.trifork.hrclient;

import com.trifork.hrclient.representation.Link;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;

public class XmlUtil {
    public static String xmlToString(Node node) {
        try {
            Source source = new DOMSource(node);
            StringWriter stringWriter = new StringWriter();
            Result result = new StreamResult(stringWriter);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            transformer.transform(source, result);
            return stringWriter.getBuffer().toString();
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    public static Link findLink(Document respEntity, String relToFind) {
        System.out.println("Trying to find link with rel " + relToFind + " in " + xmlToString(respEntity));
        final NodeList links = respEntity.getElementsByTagName("link");
        for (int i = 0; i < links.getLength(); i++) {
            final Node link = links.item(i);
            final String rel = link.getAttributes().getNamedItem("rel") != null ? link.getAttributes().getNamedItem("rel").getTextContent() : "";
            if (relToFind.equals(rel)) {
                final String href = link.getAttributes().getNamedItem("href") != null ? link.getAttributes().getNamedItem("href").getTextContent() : "";
                try {
                    return new Link(new URI(href), rel);
                } catch (URISyntaxException e) {
                    throw new IllegalArgumentException("href attribute " + href + " retrieved from server is not a welformed URI");
                }
            }
        }

        return null;
    }
}
