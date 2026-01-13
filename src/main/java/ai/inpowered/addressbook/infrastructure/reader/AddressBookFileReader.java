package ai.inpowered.addressbook.infrastructure.reader;

import ai.inpowered.addressbook.application.reader.AddressBookReader;
import ai.inpowered.addressbook.domain.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AddressBookFileReader implements AddressBookReader {

    private final Path filePath;
    private final PersonLineParser parser = new PersonLineParser();

    public AddressBookFileReader(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Person> read() {
        try {
            return Files.lines(filePath)
                    .map(parser::parse)
                    .toList();
        } catch (IOException e) {
            throw new IllegalStateException(
                    "Failed to read address book file: " + filePath, e);
        }
    }

}
