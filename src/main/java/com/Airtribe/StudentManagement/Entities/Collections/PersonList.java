package main.java.com.Airtribe.StudentManagement.Entities.Collections;

import main.java.com.Airtribe.StudentManagement.Entities.Person.Person;
import main.java.com.Airtribe.StudentManagement.Interfaces.SearchableWithID;

import java.util.ArrayList;
import java.util.List;

import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayMessage;

public class PersonList implements SearchableWithID {

    private final List<Person> personList;

    public PersonList(){
        this.personList = new ArrayList<>();
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void addToPersonList(Person person){
        this.personList.add(person);
    }

    public void removePerson(int personID){
        boolean flag = this.personList.removeIf(person -> person.getId() == personID);
        if(flag){
            DisplayMessage("Operation performed Successfully");
        }else{
            DisplayMessage("No such value found to Delete");
        }
    }

    @Override
    public boolean doesExist(int id) {
        for(Person person : personList){
            if(person.getId() == id){
                DisplayMessage("Person has been found!");
                return true;
            }
        }
        DisplayMessage("Person with given id has not been found");
        return false;
    }

    public void Display(){
        for(Person person : this.personList){
            person.Display();
        }
    }

}
