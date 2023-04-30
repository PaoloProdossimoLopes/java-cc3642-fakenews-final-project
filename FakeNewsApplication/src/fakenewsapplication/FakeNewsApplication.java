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
        
        WorldMap map = new WorldMap();
        World world = new World(map, peoples, printers);
        
        Date worldCreationTimestamp = new Date();

        while (true) {
            Date now = new Date();
            Long timeSpend = (now.getTime() - worldCreationTimestamp.getTime()) / 1000;
            printHeader(timeSpend);
            
            world.refreshWorld();
            world.movePeoples();
            world.drawWorld();
            
            System.out.print("\n\n\n\n");
            
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private static void printHeader(Long timeSpend) {
        System.out.println(":::::::::::::::::::::::::");
        System.out.println("Tempo da simulacao: " + (timeSpend) + "s");
        System.out.println(":::::::::::::::::::::::::");
        System.out.println();
    }
}
