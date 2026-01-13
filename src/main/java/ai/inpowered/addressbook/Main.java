package ai.inpowered.addressbook;

import ai.inpowered.addressbook.application.reader.AddressBookReader;
import ai.inpowered.addressbook.application.service.AddressBookService;
import ai.inpowered.addressbook.application.service.DefaultAddressBookService;
import ai.inpowered.addressbook.infrastructure.reader.AddressBookFileReader;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Usage: java -jar addressbook.jar <path-to-addressbook-file>");
            System.exit(1);
        }

        Path filePath = Path.of(args[0]);

        AddressBookReader reader = new AddressBookFileReader(filePath);
        AddressBookService service = new DefaultAddressBookService(reader);

        System.out.println("Number of males: " + service.countMales());
        System.out.println("Oldest person: " + service.findOldestPerson().getName());
        System.out.println(
                "Bill McKnight is " +
                service.daysOlder("Bill McKnight", "Paul Robinson") +
                " days older than Paul Robinson"
        );
    }

}
