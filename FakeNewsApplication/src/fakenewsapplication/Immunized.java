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
public class Immunized extends People {
    public Immunized(String contact, List<String> contacts, int x, int y) {
        super(7, contact, contacts);
        this.x = x;
        this.y = y;
    }
}
