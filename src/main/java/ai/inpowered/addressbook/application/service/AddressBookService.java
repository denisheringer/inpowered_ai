package ai.inpowered.addressbook.application.service;

import ai.inpowered.addressbook.domain.Person;

public interface AddressBookService {
    
    /**
     * @return the number of male people in the address book
     */
    public long countMales();


    /**
     * @return the oldest person in the address book
     */
    public Person findOldestPerson();


    /**
     * Calculates the number of days one person is older than another.
     *
     * @param firstPersonName full name of the first person
     * @param secondPersonName full name of the second person
     * @return number of days the first person is older than the second
     */
    public long daysOlder(String firstPersonName, String secondPersonName);

}
