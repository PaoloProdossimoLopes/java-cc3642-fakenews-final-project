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
import java.util.Timer;

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
        Timer timer = new Timer();
        
        List<People> peoples = makePeoples();
        List<Transformable> transformables = makeTransformables(timer, map, peoples);
        Map<Integer, ANSIPrinterProvider> ansiProviders = makeANSIProviders();
        
        World world = new World(map, peoples, transformables, ansiProviders);
        
        Date worldCreationTimestamp = new Date();

        while (true) {
            Date now = new Date();
            Long timeSpend = (now.getTime() - worldCreationTimestamp.getTime()) / 1000;
            printHeader(timeSpend, peoples);
            
            world.refreshWorld();
            world.move();
            world.drawWorld();
            
            System.out.print("\n\n");
            
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private static List<People> makePeoples() {
        List<People> peoples = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Unfected people = new Unfected();
            peoples.add(people);
        }
        return peoples;
    }
    
    private static Map<Integer, ANSIPrinterProvider> makeANSIProviders() {
        Map<Integer, ANSIPrinterProvider> providers = new HashMap();
        providers.put(SpaceANSIPrinter.IDENTIFIER_MAP, new SpaceANSIPrinter());
        providers.put(WallANSIPrinter.IDENTIFIER_MAP, new WallANSIPrinter());
        providers.put(UnfectableANSIPrinter.IDENTIFIER_MAP, new UnfectableANSIPrinter());
        providers.put(InfectableANSIPrinter.IDENTIFIER_MAP, new InfectableANSIPrinter());
        providers.put(ImmunableANSIPrinter.IDENTIFIER_MAP, new ImmunableANSIPrinter());
        providers.put(UnfectedANSIPrinter.IDENTIFIER_MAP, new UnfectedANSIPrinter());
        providers.put(InfectedANSIPrinter.IDENTIFIER_MAP, new InfectedANSIPrinter());
        providers.put(ImmunizedANSIPrinter.IDENTIFIER_MAP, new ImmunizedANSIPrinter());
        return providers;
    }
    
    private static List<Transformable> makeTransformables(Timer timer, WorldMap map, List<People> peoples) {
        List<Transformable> transformables = new ArrayList();
        transformables.add(new Mantainable(map, peoples));
        transformables.add(new Immunable(timer, map, peoples));
        transformables.add(new Infectable(map, peoples));
        transformables.add(new Unfectable(map, peoples));
        return transformables;
    }
    
    private static void printHeader(Long timeSpend, List<People> peoples) {
        Long total_infected = countPeoplesEqual(Infected.class, peoples);
        Long total_unfected = countPeoplesEqual(Unfected.class, peoples);
        Long total_immuned = countPeoplesEqual(Immunized.class, peoples);
        
        System.out.println(":::::::::::::::::::::::::");
        System.out.println(":: Tempo da simulacao: " + (timeSpend) + " s");
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