/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fakenewsapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 *
 * @author pprod
 */
public class People {
    protected int x;
    protected int y;
    private int code;
    private final String contact;
    private final List<String> contacts;
    
    public People(int code) {
        this.code = code;
        this.contact = UUID.randomUUID().toString();
        this.contacts = new ArrayList<>();
        
        setRandomPosition();
    }
    
    public void moveRandom() {
        final Random random = new Random();
        
        final boolean isVerticalMoviment = random.nextBoolean();
        final boolean isPositiveMoviment = random.nextBoolean();
        
        if (isVerticalMoviment) {
           final int upperBound = 59;
           final int newYPosition = isPositiveMoviment
                ? checkEdges(y + 1, upperBound)
                : checkEdges(y - 1, upperBound);
           this.y = newYPosition;
        } else {
            final int upperBound = 29;
            final int newXPosition = isPositiveMoviment
                ? checkEdges(x + 1, upperBound)
                : checkEdges(x - 1, upperBound);
            this.x = newXPosition;
        }
    }
    
    public void setRandomPosition() {
        final Random random = new Random();
        
        this.x = random.nextInt(30);
        this.y = random.nextInt(60);
    }
    
    private int checkEdges(int newPosition, int upperBound) {
        int lowerBound = 0;
        if (newPosition >= upperBound - 1) {
            return lowerBound;
        } else if (newPosition < lowerBound) {
            return upperBound;
        } else {
            return newPosition;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCode() {
        return code;
    }

    public String getContact() {
        return contact;
    }
}
