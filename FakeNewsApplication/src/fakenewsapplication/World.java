/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fakenewsapplication;

import java.util.List;
import java.util.Map;

/**
 *
 * @author pprod
 */
public class World {
    private WorldMap map;
    private final List<People> peoples;
    private final Map<Integer, ANSIPrinterProvider> ansiProviders;
    
    public World(WorldMap map, List<People> peoples, Map<Integer, ANSIPrinterProvider> ansiProviders) {
        this.map = map;
        this.peoples = peoples;
        this.ansiProviders = ansiProviders;
    }
    
    public void refreshWorld() {
        map.refreshWorld();
    }
    
    public void movePeoples() {
        for (int index = 0; index < peoples.size(); index++) {
            People people = peoples.get(index);
            people.moveRandom();
             
            if (map.isImmunable(people)) {
                Immunized immunized = new Immunized(people.getX(), people.getY());
                changePeopleState(immunized, index);
            } else if (map.isInfectable(people)) {
                Infected infected = new Infected(people.getX(), people.getY());
                changePeopleState(infected, index);
            } else if (map.isUnfectable(people)) {
                Unfected unfected = new Unfected(people.getX(), people.getY());
                changePeopleState(unfected, index);
            } else {
                map.setMap(people.getCode(), people.getX(), people.getY());
            }
        }
    }
    
    private void changePeopleState(People people, int index) {
        peoples.set(index, people);
        map.setMap(people.getCode(), people.getX(), people.getY());
    }
    
    public void drawWorld() {
        for (int colounmIndex = 0; colounmIndex < map.getMap().length; colounmIndex++) {
            for (int rowIndex = 0; rowIndex < map.getMap()[colounmIndex].length; rowIndex++) {
                int code = map.getMap()[colounmIndex][rowIndex];
                
                String block = ansiProviders.get(code).block();
                System.out.print(block);
            } 
            
            System.out.println();
        }
    }
}