package main.repository;

import main.object.Person;


public class PersonRepository {

    private int CAPACITY = 10;
    private Person[] personArrays = new Person[CAPACITY];

    public Person[] getPersonArrays() {
        return personArrays;
    }

    public void addPerson(Person person) {

        for (int i = 0; i < personArrays.length; i++) {
            if (personArrays[i] == null) {
                personArrays[i] = person;
                break;
            } else if (i == personArrays.length - 1) {
                increasingArray();
            }

        }

    }


    private void increasingArray() {
        int tempCapacity = CAPACITY;
        CAPACITY = (CAPACITY * 3) / 2 + 1;
        Person[] tempPersonArrays = new Person[CAPACITY];
        System.arraycopy(personArrays, 0, tempPersonArrays, 0, tempCapacity);
        personArrays = tempPersonArrays;

    }


}
