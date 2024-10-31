package se.lexicon.service;

import se.lexicon.model.Person;

import java.util.List;

public interface PeopleTest {

    People INSTANCE = PeopleImpl.getInstance();

    List<Person> getPeople();
}
