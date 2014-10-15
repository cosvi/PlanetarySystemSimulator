/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetarysystemsimulator.gui;


import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import planetarysystemsimulator.astro.Body;

/**
 * This class provides the basis for drawing
 * the objects onto the screen.
 * 
 * @author jussi
 */

public class DrawingBoard extends JPanel {
    
    private ArrayList<Body> bodies;

    public DrawingBoard(ArrayList<Body> bodies) {
        super.setBackground(Color.black);
        this.bodies = bodies;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Body x : this.bodies) {
            x.draw(g);
        }
    }
}
