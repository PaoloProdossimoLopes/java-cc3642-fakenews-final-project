/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fakenewsapplication;

/**
 *
 * @author pprod
 */
public class InfectableANSIPrinter implements ANSIPrinterProvider {
    
    static final int IDENTIFIER_MAP = 3;

    @Override
    public String block() {
        return "\033[41m \033[0m";
    }
}
