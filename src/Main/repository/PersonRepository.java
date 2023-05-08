package Main.repository;

import Main.exception.EntityNotFoundException;
import Main.interator.SimpleIterator;
import Main.object.Person;
import Main.Enum.Role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonRepository implements PersonInterface {

    private RepositoryService<Person> personRepositoryService;
    private SimpleIterator<Person> iterator;

    private List<Person> personList;

    public PersonRepository() {
        personRepositoryService = new RepositoryService<>();
        personList = new ArrayList<>();
        personList.add(new Person(Role.TEACHER, "Miroslav", "Bykov", "miroslav@gmail.com", "+3809912345678", 1));
        personList.add(new Person(Role.TEACHER, "Mykola", "Petrov", "Mykola@gmail.com", "+3809812345678", 2));
        personList.add(new Person(Role.STUDENT, "Taras", "Repitor", "Taras@Gmail.com", "+3809712345678", 1));
        personList.add(new Person(Role.STUDENT, "Andrii", "Charlz", "Andrii@gmail.com", "+3805012345678", 2));
        iterator = new SimpleIterator<>(personList.toArray(new Person[0]));
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public SimpleIterator<Person> getAll() {
        return new SimpleIterator<>(personList.toArray(new Person[0]));
    }

    public void addPerson(Person person) {
        personRepositoryService.add(person);
        personList.add(person);
        iterator = new SimpleIterator<>(personList.toArray(new Person[0]));
    }


    public void remove(int index) {
        personRepositoryService.remove(index);
        personList = new ArrayList<>(List.of(personRepositoryService.getArray()));
        iterator = new SimpleIterator<>(personList.toArray(new Person[0]));
    }

    public Iterable<? extends Person> getPersons() {
        return personList;
    }

    public void setPersons(Iterable<? extends Person> persons) {
        personList = new ArrayList<>((Collection) persons);
        personRepositoryService.setArray((Person[]) personList.toArray());
        iterator = new SimpleIterator<>(personList.toArray(new Person[0]));
    }

    public Person getPersonById(int id) throws EntityNotFoundException {
        for (Person person : personList) {
            if (person != null && person.getId() == id) {
                return person;
            }
        }
        throw new EntityNotFoundException("Person with ID " + id + " not found");
    }

}
