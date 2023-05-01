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
    }
}