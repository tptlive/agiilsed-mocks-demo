package ee.tptlive.agiilsed.mocksdemo.rest.controller;

import ee.tptlive.agiilsed.mocksdemo.rest.model.Person;
import ee.tptlive.agiilsed.mocksdemo.rest.service.PersonService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.stream.Collectors;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/person")
public class PersonController {

    @Inject
    private PersonService personService;

    @GET
    @Path("/children")
    @Produces(APPLICATION_JSON)
    public List<Person> getChildren() {
        return personService.getAllChildren();
    }

    @GET
    @Path("/{name}")
    @Produces(APPLICATION_JSON)
    public List<Person> getChildren(@PathParam("name") String name) {
        return personService.getAll().stream()
                .filter(person -> person.getName().equals(name))
                .collect(Collectors.toList());
    }

}
