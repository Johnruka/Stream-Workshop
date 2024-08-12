package se.lexicon.data;


import jdk.internal.org.objectweb.asm.TypeReference;
import se.lexicon.model.Person;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {

    private static final JsonReader INSTANCE;

    static {
        INSTANCE = new JsonReader();
    }

    public static JsonReader getInstance() {
        return INSTANCE;
    }

    private JsonReader(){}

    public List<Person> read(){
        List<Person> people = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        File file = new File("resources/people.json");
        try{
            people = objectMapper.readValue(file, new TypeReference<List<Person>>() {});
        }catch (IOException ex){
            System.out.println(ex + " " + ex.getMessage());
        }
        return people;
    }


    }

