package ai.inpowered.addressbook.application.reader;

import ai.inpowered.addressbook.domain.Person;

import java.util.List;

public interface AddressBookReader {

    /**
     * Reads all people from the address book.
     *
     * @return a list of Person entries
     */
    public List<Person> read();

}
