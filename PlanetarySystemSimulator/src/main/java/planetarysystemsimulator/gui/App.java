/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetarysystemsimulator.gui;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import planetarysystemsimulator.astro.Body;
import planetarysystemsimulator.astro.VerletIntegrator;

/**
 * This is the main class of the project.
 * Creates the Solar System including the Sun
 * and the eight planets. Initializes the Verlet
 * integrator and the Drawing board. Sets the
 * simulation running.
 * 
 * @author jussi
 */

public class App {
    public static void main( String[] args ) {
        ArrayList<Body> bodies = new ArrayList<Body>();
        
        Body body1 = new Body("Sun", 2000000);
        body1.setPosition(new double[]{0.0, 0.0, 0.0});
        body1.setVelocity(new double[]{0.0, 0.0, 0.0});
        body1.setColor(Color.yellow);
        body1.setSize(7);
        bodies.add(body1);

        Body body2 = new Body("Mercury", 0.3);
        body2.setPosition(new double[]{5.8, 0.0, 0.0});
        body2.setVelocity(new double[]{0.0, 0.47, 0.0});
        body2.setColor(Color.DARK_GRAY);
        body2.setSize(4);
        bodies.add(body2);

        Body body3 = new Body("Venus", 4.9);
        body3.setPosition(new double[]{10.8, 0.0, 0.0});
        body3.setVelocity(new double[]{0.0, 0.35, 0.0});
        body3.setColor(Color.ORANGE);
        body3.setSize(4);
        bodies.add(body3);

        Body body4 = new Body("Earth", 6);
        body4.setPosition(new double[]{15.0, 0.0, 0.0});
        body4.setVelocity(new double[]{0.0, 0.3, 0.0});
        body4.setColor(Color.blue);
        body4.setSize(4);
        bodies.add(body4);
        
        Body body5 = new Body("Mars", 0.6);
        body5.setPosition(new double[]{0.0, -23.0, 0.0});
        body5.setVelocity(new double[]{0.24, 0.0, 0.0});
        body5.setColor(Color.red);
        body5.setSize(4);
        bodies.add(body5);
        
        Body body6 = new Body("Jupiter", 1900);
        body6.setPosition(new double[]{0.0, -78.0, 0.0});
        body6.setVelocity(new double[]{0.13, 0.0, 0.0});
        body6.setColor(Color.PINK);
        bodies.add(body6);

        Body body7 = new Body("Saturn", 600);
        body7.setPosition(new double[]{0.0, -143.0, 0.0});
        body7.setVelocity(new double[]{0.097, 0.0, 0.0});
        body7.setColor(Color.white);
        bodies.add(body7);

        Body body8 = new Body("Uranus", 87);
        body8.setPosition(new double[]{287.0, 0.0, 0.0});        
        body8.setVelocity(new double[]{0.0, 0.068, 0.0});
        body8.setColor(Color.lightGray);
        bodies.add(body8);

        Body body9 = new Body("Neptune", 100);
        body9.setPosition(new double[]{450.0, 0.0, 0.0});        
        body9.setVelocity(new double[]{0.0, 0.054, 0.0});
        body9.setColor(Color.blue);
        bodies.add(body9);

        DrawingBoard board = new DrawingBoard(bodies);
        VerletIntegrator verlet = new VerletIntegrator(bodies, board);
        GUI gui = new GUI(bodies, board, verlet);
        
        SwingUtilities.invokeLater(gui);
        
        verlet.accelerate();  //calculate the beginning velocities
        int i = 0;
        while (true) {
            i++;
            while (verlet.getRunning()) {
                verlet.run();
                try {
                Thread.sleep(50);
                } catch ( InterruptedException e ){}
            }
        }
    }
}