/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fakenewsapplication;

import java.util.List;

/**
 *
 * @author pprod
 */
public class ChangeContact extends Transformable {

    public ChangeContact(WorldMap map, List<People> peoples) {
        super(map, peoples);
    }

    @Override
    public void transform(People people, int index) {
        List<People> peopleClosers = findPeopleClosers(people);
        for (People peopleCloser: peopleClosers) {
            if (people.getContacts().contains(peopleCloser.getContact())) continue;
            
            people.addContact(peopleCloser.getContact());
            peopleCloser.addContact(people.getContact());
        }
    }
}