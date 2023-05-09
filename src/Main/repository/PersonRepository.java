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
        personList.add(new Person(Role.STUDENT, "StudentFirstname1", "StudentLastname1", "Student1@Gmail.com", "StudentPhoneNumber1", 1));
        personList.add(new Person(Role.STUDENT, "StudentFirstname2", "StudentLastname2", "Student2@Gmail.com", "StudentPhoneNumber2", 2));
        personList.add(new Person(Role.STUDENT, "StudentFirstname3", "StudentLastname3", "Student3@Gmail.com", "StudentPhoneNumber3", 1));
        personList.add(new Person(Role.STUDENT, "StudentFirstname4", "StudentLastname4", "Student4@Gmail.com", "StudentPhoneNumber4", 2));
        personList.add(new Person(Role.STUDENT, "StudentFirstname5", "StudentLastname5", "Student5@Gmail.com", "StudentPhoneNumber5", 1));
        personList.add(new Person(Role.STUDENT, "StudentFirstname6", "StudentLastname6", "Student6@Gmail.com", "StudentPhoneNumber6", 2));
        personList.add(new Person(Role.STUDENT, "StudentFirstname7", "StudentLastname7", "Student7@Gmail.com", "StudentPhoneNumber7", 1));
        personList.add(new Person(Role.STUDENT, "StudentFirstname8", "StudentLastname8", "Student8@Gmail.com", "StudentPhoneNumber8", 2));
        personList.add(new Person(Role.STUDENT, "StudentFirstname9", "StudentLastname9", "Student9@Gmail.com", "StudentPhoneNumber9", 1));
        personList.add(new Person(Role.STUDENT, "StudentFirstname10", "StudentLastname10", "Student10@Gmail.com", "StudentPhoneNumber10", 2));

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
