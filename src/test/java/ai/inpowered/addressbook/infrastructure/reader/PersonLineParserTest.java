package ai.inpowered.addressbook.infrastructure.reader;

import ai.inpowered.addressbook.domain.Gender;
import ai.inpowered.addressbook.domain.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonLineParserTest {

    @Test
    void shouldParseValidLine() {
        PersonLineParser parser = new PersonLineParser();

        Person person = parser.parse("Bill McKnight, Male, 16/03/77");

        assertEquals("Bill McKnight", person.getName());
        assertEquals(Gender.MALE, person.getGender());
        assertEquals(LocalDate.of(1977, 3, 16), person.getBirthDate());
    }

    @Test
    void shouldFailWhenGenderIsUnknown() {
        PersonLineParser parser = new PersonLineParser();

        assertThrows(IllegalArgumentException.class, () ->
                parser.parse("John Doe, AnInvalidGender, 01/01/90"));
    }

}
