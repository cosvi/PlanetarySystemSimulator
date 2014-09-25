/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.planetarysystemsimulator;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import astro.planetarysystemsimulator.Body;
import astro.planetarysystemsimulator.VerletIntegrator;

/**
 * This class creates the graphical
 * user interface.
 * 
 * @author jussi
 */

public class GUI implements Runnable {

    private JFrame frame;
    private Body[] bodies;
    private VerletIntegrator verlet;
    
    public GUI(Body[] bodies) {
        this.bodies = bodies;
    }

    @Override
    public void run() {
        frame = new JFrame("PlanetarySystemSimulator");
        frame.setPreferredSize(new Dimension(700, 700));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        DrawingBoard board = new DrawingBoard(this.bodies);
        this.verlet = new VerletIntegrator(this.bodies, board);
        container.add(board);
        this.verlet.run();
    }

    public JFrame getFrame() {
        return frame;
    }
}
