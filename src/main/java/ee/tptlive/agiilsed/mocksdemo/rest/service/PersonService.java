package ee.tptlive.agiilsed.mocksdemo.rest.service;

import ee.tptlive.agiilsed.mocksdemo.rest.dao.PersonDao;
import ee.tptlive.agiilsed.mocksdemo.rest.model.Person;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class PersonService {

    @Inject
    private PersonDao personDao;

    public List<Person> getAllChildren() {
        return personDao.getAll().stream()
                .filter(person -> person.getAge() < 18)
                .collect(Collectors.toList());
    }
    public List<Person> getAll() {
        return personDao.getAll();
    }

}
