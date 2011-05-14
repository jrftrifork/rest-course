package com.trifork.hr.resource;

import com.trifork.hr.model.Employee;
import com.trifork.hr.persistence.EmployeeRepository;
import org.apache.log4j.Logger;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/employee")
public class EmployeeResource {
    private static final Logger logger = Logger.getLogger(EmployeeResource.class);

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response get(@PathParam("id") long id) {
        logger.debug("get id=" + id);
        Employee employee;
        try {
            employee = new EmployeeRepository().get(id);
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok().entity(employee).build();
    }
}
