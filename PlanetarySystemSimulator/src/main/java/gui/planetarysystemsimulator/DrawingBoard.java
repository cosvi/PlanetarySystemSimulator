/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.planetarysystemsimulator;


import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import astro.planetarysystemsimulator.Body;

/**
 * This class provides the basis for drawing
 * the objects onto the screen.
 * 
 * @author jussi
 */

public class DrawingBoard extends JPanel {
    
    private Body[] bodies;

    public DrawingBoard(Body[] bodies) {
        super.setBackground(Color.WHITE);
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
