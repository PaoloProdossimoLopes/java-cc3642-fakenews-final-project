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
    private final List<Transformable> transformables;
    
    public World(WorldMap map, List<People> peoples, List<Transformable> transformables, Map<Integer, ANSIPrinterProvider> ansiProviders) {
        this.map = map;
        this.peoples = peoples;
        this.transformables = transformables;
        this.ansiProviders = ansiProviders;
    }
    
    public void refreshWorld() {
        map.refreshWorld();
    }
    
    public void move() {
        for (int index = 0; index < peoples.size(); index++) {
            People people = peoples.get(index);
            people.moveRandom();
            
            System.out.println("Toal de contatos para " + people.getContact() + "tem " + people.getContacts().size() + " contatos");
            
            for (Transformable transformable: transformables) {
                transformable.transform(people, index);
            }
        }
    }
    
    public void drawWorld() {
        for (int[] rows : map.getMap()) {
            for (int code: rows) {
                String block = ansiProviders.get(code).block();
                System.out.print(block);
            }
            
            System.out.println();
        }
    }
}