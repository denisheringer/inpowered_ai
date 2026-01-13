package ai.inpowered.addressbook.application.service;

import ai.inpowered.addressbook.application.reader.AddressBookReader;
import ai.inpowered.addressbook.domain.Gender;
import ai.inpowered.addressbook.domain.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultAddressBookServiceTest {

    private final AddressBookReader fakeReader = () -> List.of(
            new Person("Bill McKnight", Gender.MALE, LocalDate.of(1977, 3, 16)),
            new Person("Paul Robinson", Gender.MALE, LocalDate.of(1985, 1, 15)),
            new Person("Gemma Lane", Gender.FEMALE, LocalDate.of(1991, 11, 20))
    );

    private final AddressBookService service =
            new DefaultAddressBookService(fakeReader);

    @Test
    void shouldCountOnlyMales() {
        assertEquals(2, service.countMales());
    }

    @Test
    void shouldReturnOldestPerson() {
        assertEquals("Bill McKnight",
                service.findOldestPerson().getName());
    }

    @Test
    void shouldCalculateHowManyDaysOnePersonIsOlderThanTheOther() {
        long days =
                service.daysOlder(
                        "Bill McKnight",
                        "Paul Robinson");

        assertEquals(2862, days);
    }

}
