/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package fakenewsapplication;

/**
 *
 * @author pprod
 */
public class WallANSIPrinter implements ANSIPrinterProvider {
    
    static final int IDENTIFIER_MAP = 1;

    @Override
    public String block() {
       return "\033[47m \033[0m";
    }
}