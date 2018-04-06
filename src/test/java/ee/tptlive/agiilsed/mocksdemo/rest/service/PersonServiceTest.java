package ee.tptlive.agiilsed.mocksdemo.rest.service;

import ee.tptlive.agiilsed.mocksdemo.rest.dao.PersonDao;
import ee.tptlive.agiilsed.mocksdemo.rest.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @Mock
    private PersonDao personDao;

    @InjectMocks
    private PersonService personService;

    @Test
    public void getAllChildren_EmptyList_IfDaoHasNoPersons() {
        // when
        List<Person> result = personService.getAllChildren();

        // then
        assertEquals(emptyList(), result);
    }

    @Test
    public void getAllChildren_ListWithOnePerson_IfDaoHasPersonsWhereOnChild() {
        // given
        Person john = new Person(UUID.randomUUID(), "John", 35, LocalDate.of(1990, Month.APRIL, 11));
        Person sander = new Person(UUID.randomUUID(), "Sander", 22, LocalDate.of(1990, Month.APRIL, 11));
        Person william = new Person(UUID.randomUUID(), "William", 11, LocalDate.of(1990, Month.APRIL, 11));
        Person dolores = new Person(UUID.randomUUID(), "Dolores", 53, LocalDate.of(1990, Month.APRIL, 11));

        when(personDao.getAll()).thenReturn(asList(john, sander, william, dolores));

        // when
        List<Person> result = personService.getAllChildren();

        // then
        assertEquals(1, result.size());
        assertEquals(william, result.get(0));
    }

}