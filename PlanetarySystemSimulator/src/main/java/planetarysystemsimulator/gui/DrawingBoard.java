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
    private double scale;

    public DrawingBoard(ArrayList<Body> bodies) {
        super.setBackground(Color.black);
        this.bodies = bodies;
        this.scale = 1;
    }
    
    public void setScale(double newScale) {
        this.scale = newScale;
    }
    
    public double getScale() {
        return this.scale;
    }
    
    public int[] scalePosition(Body body) {
         int[] pos = new int[]{0,0,0};
         pos[0] = 400 + (int)(this.scale * 13.0/18.0 * body.getPosition()[0]);
         pos[1] = 370 - (int)(this.scale * 13.0/18.0 * body.getPosition()[1]);
         pos[2] = (int)(body.getPosition()[2]);
         return pos;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Body x : this.bodies) {
            g.setColor(x.getColor());
            int[] pos = this.scalePosition(x);
            g.fillOval(pos[0], pos[1], x.getSize(), x.getSize());
//            x.draw(g);
        }
    }
}
