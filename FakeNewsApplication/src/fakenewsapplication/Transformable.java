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
                int mainPeopleX = people.getX();
                int mainPeopleY = people.getY();
                
                int possiblePeopleCloserX = p.getX();
                int possiblePeopleCloserY = p.getY();
                
                boolean isSamePosition = (
                    mainPeopleX == possiblePeopleCloserX &&
                    mainPeopleY == possiblePeopleCloserY
                );
                boolean isUpper = (
                    mainPeopleX == possiblePeopleCloserX &&
                    mainPeopleY + 1 == possiblePeopleCloserY
                );
                boolean isBellow = (
                    mainPeopleX == possiblePeopleCloserX &&
                    mainPeopleY - 1 == possiblePeopleCloserY
                );
                boolean isRight = (
                    mainPeopleX + 1 == possiblePeopleCloserX &&
                    mainPeopleY == possiblePeopleCloserY
                );
                boolean isLeft = (
                    mainPeopleX - 1 == possiblePeopleCloserX &&
                    mainPeopleY == possiblePeopleCloserY
                );
                
                
                if (isSamePosition) return true;
                else if (isUpper) return true;
                else if (isBellow) return true;
                else if (isRight) return true;
                else if (isLeft) return true;
                else return false;
                
            })
            .toList()
        ;
    }
    
    protected void tranformTo(People people, int index) {
        
        peoples.set(index, people);
        map.setMap(people.getCode(), people.getX(), people.getY());
    } 
}
