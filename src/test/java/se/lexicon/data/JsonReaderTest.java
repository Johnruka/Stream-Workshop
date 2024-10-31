package se.lexicon.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import se.lexicon.model.Person;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JsonReaderTest {

    private static final JsonReader INSTANCE;

    static {
        INSTANCE = new JsonReader();
    }

    public static JsonReader getInstance() {
        return INSTANCE;
    }

    private void JsonReader(){}

    public List<Person> read(){
        List<Person> people = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("resources/people.json");
        try{
            people = objectMapper.readValue(file, new TypeReference<List<Person>>() {});


        }catch (IOException ex){
            System.out.println(ex + " " + ex.getMessage());
        }
        return people;
    }


}
