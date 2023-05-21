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
public class Infectable extends Transformable {

    public Infectable(WorldMap map, List<People> peoples) {
        super(map, peoples);
    }

    @Override
    public void transform(People people, int index) {
        if (map.isInfectable(people) == false || people instanceof Immunized) return;
        
        Infected infectable = new Infected(people.getContact(), people.getContacts(), people.getX(), people.getY());
        tranformTo(infectable, index);
        
        List<String> contactsNumber = infectable.getContacts();
        for (int contactIndex = 0; contactIndex < contactsNumber.size(); contactIndex++) {
            for (int peopleIndex = 0; peopleIndex < peoples.size(); peopleIndex++) {
                People p = peoples.get(peopleIndex);
                final boolean isContact = p.getContact().equals(contactsNumber.get(contactIndex));
                final boolean isNotInInfectedArea = map.isUnfectable(p) == false;
                final boolean isNotInImmunableArea = map.isImmunable(p) == false;
                final boolean isNotImmunable = (p instanceof Immunized) == false;
                        
                if (isContact && isNotInInfectedArea && isNotInImmunableArea && isNotImmunable) {
                    Infected contactUnfeted = new Infected(p.getContact(), p.getContacts(), p.getX(), p.getY());
                    tranformTo(contactUnfeted, peopleIndex);
                }
            }
        }
    }
}