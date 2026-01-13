package ai.inpowered.addressbook.infrastructure.reader;

import ai.inpowered.addressbook.domain.Gender;
import ai.inpowered.addressbook.domain.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class PersonLineParser {

    private static final DateTimeFormatter DATE_FORMATTER =
            new DateTimeFormatterBuilder()
                    .appendPattern("dd/MM/")
                    .appendValueReduced(
                            ChronoField.YEAR,
                            2, 2, 1900
                    )
                    .toFormatter();

    public Person parse(String line) {
        String[] parts = line.split(",");

        String name = parts[0].trim();
        Gender gender = parseGender(parts[1].trim());
        LocalDate birthDate =
                LocalDate.parse(parts[2].trim(), DATE_FORMATTER);

        return new Person(name, gender, birthDate);
    }

    private Gender parseGender(String value) {
        return switch (value.toLowerCase()) {
            case "male" -> Gender.MALE;
            case "female" -> Gender.FEMALE;
            default -> throw new IllegalArgumentException(
                    "Unknown gender: " + value);
        };
    }

}
