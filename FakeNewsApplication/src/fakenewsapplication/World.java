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
    
    public World(List<People> peoples, Map<Integer, ANSIPrinterProvider> ansiProviders) {
        this.peoples = peoples;
        this.ansiProviders = ansiProviders;
        this.map = new WorldMap();
    }
    
    public void refreshWorld() {
        map.refreshWorld();
    }
    
    public void movePeoples() {
        for (int index = 0; index < peoples.size(); index++) {
            People people = peoples.get(index);
            people.moveRandom();
            
            map.setMap(4, people.getX(), people.getY());
            
            if (map.isImmunable(people)) {
                //TODO: Implement process to became immune
            } else if (map.isInfectable(people)) {
                //TODO: Implement process to became infected (if not immune)
            } else if (map.isUnfectable(people)) {
                //TODO: Became people unfected
            }
        }
    }
    
    public void drawWorld() {
        for (int colounmIndex = 0; colounmIndex < map.getMap().length; colounmIndex++) {
            for (int rowIndex = 0; rowIndex < map.getMap()[colounmIndex].length; rowIndex++) {
                int identifier = map.getMap()[colounmIndex][rowIndex];
                
                String block = ansiProviders.get(identifier).block();
                
                System.out.print(block);
            } 
            
            System.out.println();
        }
    }
}