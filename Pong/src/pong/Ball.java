/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pong;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author samuelfarias
 */
public class Ball {
    int  ratio,x,y,cx,cy;
    
    public Ball(int ratio, int x, int y){
        this.x = x;
        this.y  = y;
        this.ratio = ratio;
        this.cx = 5;
        this.cy = 5;
    }
    
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x, y, ratio, ratio);
    }
    
    void move(){
        x +=  cx;
        y += cy;
    }
    
    void reverseY(){
        cy *= -1;
    }
    void reverseX(){
        cx *= -1;
    }
      
    void edgeColission(int width, int height){
       
       if(y + ratio > height){
           reverseY();
       }else if(y < 0){
           reverseY();
       }
    }
}
