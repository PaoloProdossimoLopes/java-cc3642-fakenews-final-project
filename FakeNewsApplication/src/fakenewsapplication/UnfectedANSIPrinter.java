/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fakenewsapplication;

/**
 *
 * @author pprod
 */
public class UnfectedANSIPrinter implements ANSIPrinterProvider {
    
    public static final int IDENTIFIER_MAP = 5;
    
    @Override
    public String block() {
        return "\033[42m \033[0m";
    }
}