package ai.inpowered.addressbook.infrastructure.reader;

import ai.inpowered.addressbook.application.reader.AddressBookReader;
import ai.inpowered.addressbook.domain.Person;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressBookFileReaderTest {

    @Test
    void shouldReadPeopleFromFile() throws IOException {
        Path tempFile = Files.createTempFile("addressbook", ".txt");

        Files.writeString(tempFile, """
                Bill McKnight, Male, 16/03/77
                Paul Robinson, Male, 15/01/85
                Gemma Lane, Female, 20/11/91
                """);

        AddressBookReader reader = new AddressBookFileReader(tempFile);

        List<Person> people = reader.read();

        assertEquals(3, people.size());
        assertEquals("Bill McKnight", people.get(0).getName());
        assertEquals("Paul Robinson", people.get(1).getName());
        assertEquals("Gemma Lane", people.get(2).getName());
    }

}
