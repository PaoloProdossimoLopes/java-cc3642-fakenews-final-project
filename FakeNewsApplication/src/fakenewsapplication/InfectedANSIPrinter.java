/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fakenewsapplication;

/**
 *
 * @author pprod
 */
public class InfectedANSIPrinter implements ANSIPrinterProvider {
    
    public static final int IDENTIFIER_MAP = 6;
    
    @Override
    public String block() {
        return "\033[41m \033[0m";
    }
}