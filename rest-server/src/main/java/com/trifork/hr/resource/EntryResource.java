package com.trifork.hr.resource;

import com.trifork.hr.representation.EntryPointRepresentation;
import com.trifork.hr.representation.Link;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.Arrays;

@Path("/")
public class EntryResource {
    private static final Logger logger = Logger.getLogger(EntryResource.class);

    @Context
    UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public EntryPointRepresentation makeEntryPoint() {
        logger.debug("entryPoint GET");
        final Link allEmployeesLink = new Link("http://com.trifork/hr/allemployees", uriInfo.getRequestUriBuilder().path(EmployeeResource.class).build());
        final Link createEmployeeLink = new Link("http://com.trifork/hr/createemployee", uriInfo.getRequestUriBuilder().path(EmployeeResource.class).build(), "POST");

        return new EntryPointRepresentation(Arrays.asList(allEmployeesLink, createEmployeeLink));
    }
}
