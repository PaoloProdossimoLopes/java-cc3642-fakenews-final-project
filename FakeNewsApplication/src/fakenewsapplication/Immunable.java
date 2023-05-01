/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fakenewsapplication;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author pprod
 */
public class Immunable extends Transformable {
    
    private final Timer timer;

    public Immunable(Timer timer, WorldMap map, List<People> peoples) {
        super(map, peoples);
        this.timer = timer;
    }

    @Override
    public void transform(People people, int index) {
        if (map.isImmunable(people) == false) return;
                
        Immunized immunized = new Immunized(people.getX(), people.getY());
        tranformTo(immunized, index);
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (map.isImmunable(immunized)) return;
                Unfected unfected = new Unfected(immunized.getX(), immunized.getY());
                tranformTo(unfected, index);
            }
         }, 0, 30000);
    }
}