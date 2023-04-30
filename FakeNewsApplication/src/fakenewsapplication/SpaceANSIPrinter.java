/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fakenewsapplication;

/**
 *
 * @author pprod
 */
public class SpaceANSIPrinter implements ANSIPrinterProvider {
    
    static final int IDENTIFIER_MAP = 0;
    
    @Override
    public String block() {
       return " ";
    }
}