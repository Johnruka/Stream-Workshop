package se.lexicon.service;

import org.junit.Test;
import se.lexicon.model.Person;

import java.time.LocalDate;
import java.time.Year;
import java.util.*;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

public class StreamExercises {

    private static List<Person> people = People.INSTANCE.getPeople();

    /**
     * Turn integers into a stream then use forEach as a terminal operation to print out the numbers
     */
    @Test
    public void task1() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        integers.stream().forEach(num -> System.out.println(num));

        /*
        integers.forEach(integer -> System.out.println(integer));  //Using lambda
         */

    }




    /**
     * Create a calendar using Stream.iterate() of year 2020. Extract to a LocalDate array
     */
    @Test
    public void task14() {
        LocalDate[] _2020_dates = null;

        _2020_dates = Stream.iterate(LocalDate.parse("2020-01-01"), (localDate -> localDate.plusDays(1)))
                .limit(Year.of(2020).isLeap() ? 366 : 365)
//                .peek(System.out::println)
                .toArray(LocalDate[]::new);

        assertNotNull(_2020_dates);
        assertEquals(366, _2020_dates.length);
        assertEquals(LocalDate.parse("2020-01-01"), _2020_dates[0]);
        assertEquals(LocalDate.parse("2020-12-31"), _2020_dates[_2020_dates.length - 1]);
    }

}
