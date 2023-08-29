/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pong;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author samuelfarias
 */
public class PongGame extends  JPanel{
    private int width;
    private int heigth;
    private int scoreR,scoreL;
    private Ball b;
    private Padle r1;
    private Padle r2;
    
    public PongGame(){
        this.width= 600;
        this.heigth= 600;
        this.b =  new Ball(25,300,300);
        this.r1 = new Padle(50,300,25,100,38,40);
        this.r2 = new Padle(500,300,25,100,87,83);
        this.scoreR++;
        this.scoreL++;
    }
    
    @Override
    public void paint(Graphics g){
        g.fillRect(0, 0, 600, 600);
        b.paint(g);
        r1.paint(g);
        r2.paint(g);
        g.drawString("ScoreL:"+ this.scoreL +" | ScoreR:" + this.scoreR, 300, 20);
    }
    
    public void gamelLogic(ArrayList<Integer>input){
        b.move();
        b.edgeColission(600,600);
        r1.move(input,this.heigth);
        r2.move(input,this.heigth);
        if(r1.collision(b)){
            b.reverseX();
        }
        if(r2.collision(b)){
            b.reverseX();
        }
        if(b.x + b.ratio > this.width ){
           scoreR++;
           restart();
       }else if(b.x < 0){
           scoreL++;
           restart();
       }
    }
    
    public void restart(){
        b.x = 300;
        b.y = 300;
    }
}
