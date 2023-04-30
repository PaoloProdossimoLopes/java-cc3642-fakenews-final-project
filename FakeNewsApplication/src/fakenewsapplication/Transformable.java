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
public class Transformable {
    protected final WorldMap map;
    protected final List<People> peoples;
    
    public Transformable(WorldMap map, List<People> peoples) {
        this.map = map;
        this.peoples = peoples;
    }
    
    public void transform(People people, int index) { /*Overload*/ }
    
    protected void tranformTo(People people, int index) {
        
        peoples.set(index, people);
        map.setMap(people.getCode(), people.getX(), people.getY());
    } 
}
