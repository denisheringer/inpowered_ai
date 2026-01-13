package ai.inpowered.addressbook.application.service;

import ai.inpowered.addressbook.application.reader.AddressBookReader;
import ai.inpowered.addressbook.domain.Person;

import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;

public class DefaultAddressBookService implements AddressBookService {

    private final AddressBookReader reader;

    public DefaultAddressBookService(AddressBookReader reader) {
        this.reader = reader;
    }

    @Override
    public long countMales() {
        return reader.read().stream()
                .filter(Person::isMale)
                .count();
    }

    @Override
    public Person findOldestPerson() {
        return reader.read().stream()
                .min(Comparator.comparing(Person::getBirthDate))
                .orElseThrow(() ->
                        new IllegalStateException("Address book is empty"));
    }

    @Override
    public long daysOlder(String firstPersonName, String secondPersonName) {
        List<Person> people = reader.read();

        Person firstPerson = findByFullName(people, firstPersonName);
        Person secondPerson = findByFullName(people, secondPersonName);

        return ChronoUnit.DAYS.between(
                firstPerson.getBirthDate(),
                secondPerson.getBirthDate()
        );
    }

    private Person findByFullName(List<Person> people, String fullName) {
        return people.stream()
                .filter(p -> p.getName().equals(fullName))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Person not found: " + fullName));
    }

}
