/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fakenewsapplication;

import java.util.List;

/**
 *
 * @author pprod
 */
public class Unfected extends People {
    
    public Unfected(String contact, List<String> contacts) {
        super(5, contact, contacts);
    }
    
    public Unfected(String contact, List<String> contacts, int x, int y) {
        this(contact, contacts);
        this.x = x;
        this.y = y;
    }
}
