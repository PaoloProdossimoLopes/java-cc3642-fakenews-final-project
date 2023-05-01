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
    
    public List<People> findPeopleClosers(People people) {
       return peoples.stream()
            .filter(p -> (p.getContact().equals(people.getContact()) == false))
            .filter(p -> {
                if ((people instanceof Unfected) == false) return false;
                
                int infectedX = people.getX();
                int indectdeY = people.getY();
                
                int peopleX = p.getX();
                int peopleY = p.getY();
                
                boolean stayInSamePosition = peopleX == infectedX && peopleY == indectdeY;
                if (stayInSamePosition) return true;
                
                boolean stayInUpperPosition = peopleX == infectedX && peopleY == indectdeY + 1;
                if (stayInUpperPosition) return true;
                
                boolean stayInLowerPosition = peopleX == infectedX && peopleY == indectdeY - 1;
                if (stayInLowerPosition) return true;
                
                boolean stayRightPosition = peopleX == infectedX + 1 && peopleY == indectdeY;
                if (stayRightPosition) return true;
                
                boolean stayLeftPosition = peopleX == infectedX - 1 && peopleY == indectdeY;
                if (stayLeftPosition) return true;
                
                return false;
            })
            .toList()
        ;
    }
    
    protected void tranformTo(People people, int index) {
        
        peoples.set(index, people);
        map.setMap(people.getCode(), people.getX(), people.getY());
    } 
}
