/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author samuelfarias
 */
public class Pong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame janela = new  JFrame("Pong");
        janela.setSize(600, 600);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        PongGame pong = new PongGame();
        janela.add(pong);   
        ArrayList<Integer> input = new ArrayList();     
        janela.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e) {
                int keycode = e.getExtendedKeyCode();
                if(!input.contains(keycode))
                    input.add(keycode);
            }
            public void keyReleased(KeyEvent e) {
                int keycode = e.getExtendedKeyCode();
                int ind = input.indexOf(keycode);
                input.remove (ind);
            }
        });
        
        Timer timer = new Timer(66, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pong.gamelLogic(input);
                pong.repaint();
                input.forEach((x)->System.out.print(x));
                System.out.println();
            }
        });

        timer.start();
        
    }
    
}
