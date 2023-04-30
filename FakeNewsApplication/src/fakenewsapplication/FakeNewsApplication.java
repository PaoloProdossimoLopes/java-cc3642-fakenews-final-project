/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fakenewsapplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pprod
 */
public class FakeNewsApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        WorldMap map = new WorldMap();
        
        List<People> peoples = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Unfected people = new Unfected();
            peoples.add(people);
        }
        
        Map<Integer, ANSIPrinterProvider> printers = new HashMap();
        printers.put(SpaceANSIPrinter.IDENTIFIER_MAP, new SpaceANSIPrinter());
        printers.put(WallANSIPrinter.IDENTIFIER_MAP, new WallANSIPrinter());
        printers.put(UnfectableANSIPrinter.IDENTIFIER_MAP, new UnfectableANSIPrinter());
        printers.put(InfectableANSIPrinter.IDENTIFIER_MAP, new InfectableANSIPrinter());
        printers.put(ImmunableANSIPrinter.IDENTIFIER_MAP, new ImmunableANSIPrinter());
        printers.put(UnfectedANSIPrinter.IDENTIFIER_MAP, new UnfectedANSIPrinter());
        printers.put(InfectedANSIPrinter.IDENTIFIER_MAP, new InfectedANSIPrinter());
        printers.put(ImmunizedANSIPrinter.IDENTIFIER_MAP, new ImmunizedANSIPrinter());
        
        List<Transformable> transformables = new ArrayList();
        transformables.add(new Mantainable(map, peoples));
        transformables.add(new Immunable(map, peoples));
        transformables.add(new Infectable(map, peoples));
        transformables.add(new Unfectable(map, peoples));
        
        World world = new World(map, peoples, transformables, printers);
        
        Date worldCreationTimestamp = new Date();

        while (true) {
            Date now = new Date();
            Long timeSpend = (now.getTime() - worldCreationTimestamp.getTime()) / 1000;
            printHeader(timeSpend, peoples);
            
            world.refreshWorld();
            world.move();
            world.drawWorld();
            
            System.out.print("\n\n\n\n\n");
            
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private static void printHeader(Long timeSpend, List<People> peoples) {
        
        Long total_infected = countPeoplesEqual(Infected.class, peoples);
        Long total_unfected = countPeoplesEqual(Unfected.class, peoples);
        Long total_immuned = countPeoplesEqual(Immunized.class, peoples);
        
        System.out.println(":::::::::::::::::::::::::");
        System.out.println(":: Tempo da simulacao: " + (timeSpend));
        System.out.println(":: Imunes: " + (total_immuned));
        System.out.println(":: Infectados: " + (total_infected));
        System.out.println(":: Nao Infectados: " + (total_unfected));
        System.out.println(":::::::::::::::::::::::::");
        System.out.println();
    }
    
    private static <T extends People> Long countPeoplesEqual(Class<T> type, List<People> peoples) {
        return peoples.stream().filter(people -> {
            return people.getClass() == type;
        }).count();
    }
}
