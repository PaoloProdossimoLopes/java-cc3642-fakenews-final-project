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
        World world = new World(makePeoples(), makeANSIProviders());
        
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
    
    private static Map<Integer, ANSIPrinterProvider> makeANSIProviders() {
        Map<Integer, ANSIPrinterProvider> printers = new HashMap<>();
        printers.put(SpaceANSIPrinter.IDENTIFIER_MAP, new SpaceANSIPrinter());
        printers.put(WallANSIPrinter.IDENTIFIER_MAP, new WallANSIPrinter());
        printers.put(UnfectedANSIPrinter.IDENTIFIER_MAP, new UnfectedANSIPrinter());
        printers.put(InfectedANSIPrinter.IDENTIFIER_MAP, new InfectedANSIPrinter());
        printers.put(ImmuneANSIPrinter.IDENTIFIER_MAP, new ImmuneANSIPrinter());
        return printers;
    }
    
    private static List<People> makePeoples() {
        List<People> peoples = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            peoples.add(new People(" "));
        }
        return peoples;
    }
}
