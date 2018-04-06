package ee.tptlive.agiilsed.mocksdemo.rest.dao;

import ee.tptlive.agiilsed.mocksdemo.rest.model.Person;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

import static java.util.Arrays.asList;

public class PersonDao {

    public List<Person> getAll() {
        Person john = new Person(UUID.randomUUID(), "John", 35, LocalDate.of(1990, Month.APRIL, 11));
        Person sander = new Person(UUID.randomUUID(), "Sander", 22, LocalDate.of(1990, Month.APRIL, 11));
        Person william = new Person(UUID.randomUUID(), "William", 11, LocalDate.of(1990, Month.APRIL, 11));
        Person dolores = new Person(UUID.randomUUID(), "Dolores", 53, LocalDate.of(1990, Month.APRIL, 11));

        return asList(john, sander, william, dolores);
    }

}
