/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author samuelfarias
 */
public class Padle {
    private int x,y,width,heigth,up,down;
    
    public Padle(int x, int y, int  width, int height, int up, int down){
        this.x = x;
        this.y  = y;
        this.width = width;
        this.heigth = height;
        this.up = up;
        this.down = down;
    }
    
    public void move(ArrayList<Integer> input, int height){
        if(input.contains(this.up) && this.y > 0){
            y -=  10;
        }
        if(input.contains(this.down) && this.y+this.heigth < height){
            y += 10;
        }
    }
    
    public boolean collision(Ball b){
        if(b.x < this.x + this.width && b.x + b.ratio > this.x){
            if(b.y < this.y + this.heigth && b.y + b.ratio > this.y){
                return true;
            }
        }
        return false;
    }
    
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(this.x, this.y, this.width, this.heigth);
    }
}
