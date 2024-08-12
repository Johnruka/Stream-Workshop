package se.lexicon.service;

import se.lexicon.JsonReader;
import se.lexicon.model.Person;

import java.util.List;

public class PeopleImpl implements People {

    private static final PeopleImpl INSTANCE;

    static {
        INSTANCE = new PeopleImpl();
    }

    static PeopleImpl getInstance() {
        return INSTANCE;
    }

    private List<Person> people;

    private void PeopleImpl() {
        people = JsonReader.getInstance().read();
    }

    @Override
    public List<Person> getPeople() {
        return people;
    }
}
