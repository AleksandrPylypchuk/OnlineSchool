package Main.repository;

import Main.exception.EntityNotFoundException;
import Main.interator.SimpleIterator;
import Main.object.Person;


import java.util.Arrays;

public class PersonRepository implements PersonInterface {

    private RepositoryService<Person> personRepositoryService;
    private SimpleIterator<Person> iterator;

    private int CAPACITY = 10;

    private Person[] personArrays = new Person[CAPACITY];
    private Iterable<? extends Person> persons;

    public PersonRepository() {
        personRepositoryService = new RepositoryService<>();
    }

    public Person[] getPersonArrays() {
        Object[] objects = personRepositoryService.getArray();
        Person[] persons = new Person[objects.length];
        int i = 0;
        for (Object obj : objects) {
            if (obj instanceof Person) {
                persons[i++] = (Person) obj;
            }
        }
        return Arrays.copyOf(persons, i);
    }
    public SimpleIterator<Person> getAll() {
        Person[] persons = Arrays.copyOf(personArrays, personRepositoryService.size());
        return new SimpleIterator<>(persons);
    }

    public void addPerson(Person person) {
        personRepositoryService.add(person);
        Object[] objects = personRepositoryService.getArray();
        Person[] persons = new Person[objects.length];
        int i = 0;
        for (Object obj : objects) {
            if (obj instanceof Person) {
                persons[i++] = (Person) obj;
            }
        }
        personArrays = Arrays.copyOf(persons, i);
        iterator = new SimpleIterator<>(personArrays);
    }

    public void remove(int index) {
        personRepositoryService.remove(index);
        iterator = new SimpleIterator<>(personRepositoryService.getArray());
    }

    public Iterable<? extends Person> getPersons() {
        return persons;
    }

    public void setPersons(Iterable<? extends Person> persons) {
        this.persons = persons;
    }

    public Person getPersonById(int id) throws EntityNotFoundException {
        for (Person person : getPersonArrays()) {
            if (person != null && person.getId() == id) {
                return person;
            }
        }
        throw new EntityNotFoundException("Person with ID " + id + " not found");
    }

}
