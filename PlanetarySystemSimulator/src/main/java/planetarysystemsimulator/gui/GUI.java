/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planetarysystemsimulator.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import planetarysystemsimulator.astro.Body;
import planetarysystemsimulator.astro.VerletIntegrator;

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
    private DrawingBoard board;
    
    public GUI(Body[] bodies, DrawingBoard board, VerletIntegrator verlet) {
        this.bodies = bodies;
        this.board = board;
        this.verlet = verlet;
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
        container.setLayout(new BorderLayout());
        container.add(this.board);
        
        JButton pause = new JButton("Pause");
        pause.addActionListener(new PauseListener(this.verlet));
        container.add(pause, BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return frame;
    }
}
