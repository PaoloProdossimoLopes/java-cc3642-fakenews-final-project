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
public class Unfectable extends Transformable {

    public Unfectable(WorldMap map, List<People> peoples) {
        super(map, peoples);
    }

    @Override
    public void transform(People people, int index) {
        if (map.isUnfectable(people) == false) return;
        
        Unfected unfectable = new Unfected(people.getContact(), people.getContacts(), people.getX(), people.getY());
        tranformTo(unfectable, index);
    }
}
