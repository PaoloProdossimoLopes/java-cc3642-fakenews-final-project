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
public class ContactsUnfectable extends Transformable {

    public ContactsUnfectable(WorldMap map, List<People> peoples) {
        super(map, peoples);
    }

    @Override
    public void transform(People people, int index) {
        if (map.isInfectable(people) == false && people instanceof Infected) return ;
        
        List<People> contacts = findPeopleClosers(people);
        
        for (People contact : contacts) {
            boolean isNotFound = peoples.contains(contact) == false;
            boolean isInfectable = map.isInfectable(contact);
            boolean isNotInfected = (contact instanceof Infected) == false;
            if (isNotFound || isInfectable || isNotInfected) continue;

            int contactIndex = peoples.indexOf(contact);
            Unfected unfected = new Unfected(contact.getContact(), contact.getContacts(), contact.getX(), contact.getY());
            tranformTo(unfected, contactIndex);
        }
    }
}