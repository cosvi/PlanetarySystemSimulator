/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetarysystemsimulator.gui;

import javax.swing.SwingUtilities;
import planetarysystemsimulator.astro.Body;
import planetarysystemsimulator.astro.VerletIntegrator;

/**
 * This is the main class of the project.
 * It sets the whole thing going.
 * 
 * @author jussi
 */

public class App {
    public static void main( String[] args ) {
        Body body1 = new Body("Sun", 2000000);
        body1.setPosition(new double[]{350.0, 350.0, 0.0});
        body1.setVelocity(new double[]{0.0, 0.0, 0.0});
        
        Body body2 = new Body("Earth", 6);
        body2.setPosition(new double[]{500.1, 352.2, 1.0});
        body2.setVelocity(new double[]{0.0, -3.0, 0.0});
        
        Body body3 = new Body("Mars", 0.6);
        body3.setPosition(new double[]{350.0, 600.0, -1.0});
        body3.setVelocity(new double[]{2.4, 0.0, 0.0});
        
        Body[] bodies = new Body[]{body1, body2, body3};
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