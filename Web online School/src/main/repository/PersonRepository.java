package Main.repository;

import Main.exception.EntityNotFoundException;
import Main.interator.SimpleIterator;
import Main.object.Person;
import Main.Enum.Role;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

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
        personList.add(new Person(Role.STUDENT, "StudentFirstname2", "StudentLastname2", "Student1@Gmail.com", "StudentPhoneNumber2", 2));
        personList.add(new Person(Role.STUDENT, "StudentFirstname3", "StudentLastname3", "Student3@Gmail.com", "StudentPhoneNumber3", 1));
        personList.add(new Person(Role.STUDENT, "StudentFirstname4", "StudentLastname4", "Student4@Gmail.com", "StudentPhoneNumber4", 2));


        iterator = new SimpleIterator<>(personList.toArray(new Person[0]));
    }
    public void printPersonMap() {
        Map<String, String> personMap = new HashMap<>();
        for (Person person : personList) {
            personMap.put(person.getEmail(), person.getLastname() + " " + person.getFirstname());
        }
        System.out.println(personMap);
    }
    public List<Person> getPersonList() {
        return personList;
    }
    public boolean isEmailAlreadyExist(String email) {
        for (Person person : personList) {
            if (person.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    public SimpleIterator<Person> getAll() {
        return new SimpleIterator<>(personList.toArray(new Person[0]));
    }

    public void addPerson(Person person) {
        if (!isEmailAlreadyExist(person.getEmail())) {
            personRepositoryService.add(person);
            personList.add(person);
            iterator = new SimpleIterator<>(personList.toArray(new Person[0]));
        } else {
            System.out.println("Person with email " + person.getEmail() + " already exists");
        }
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
    public void writeStudentEmailsToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            List<Person> students = new ArrayList<>();
            for (Person person : personList) {
                if (person.getRole() == Role.STUDENT) {
                    students.add(person);
                }
            }
            students.sort(Comparator.comparing(Person::getEmail));
            for (Person student : students) {
                writer.println(student.getEmail());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
