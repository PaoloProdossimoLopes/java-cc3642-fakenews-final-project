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
public class Infected extends People {
    public Infected(String contact, List<String> contacts, int x, int y) {
        super(6, contact, contacts);
        this.x = x;
        this.y = y;
    }
}
