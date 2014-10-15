/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planetarysystemsimulator.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
    private ArrayList<Body> bodies;
    private VerletIntegrator verlet;
    private DrawingBoard board;
    
    public GUI(ArrayList<Body> bodies, DrawingBoard board, VerletIntegrator verlet) {
        this.bodies = bodies;
        this.board = board;
        this.verlet = verlet;
    }

    @Override
    public void run() {
        frame = new JFrame("PlanetarySystemSimulator");
        frame.setPreferredSize(new Dimension(1000, 700));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

     }

    private void createComponents(Container container) {
        container.setLayout(new BorderLayout());
        container.add(this.board);
        
        JButton pause = new JButton("Pause");
        pause.addActionListener(new PauseListener(this.verlet));
        container.add(pause, BorderLayout.SOUTH);
        container.add(createMenu(), BorderLayout.WEST);
    }
    
    private JPanel createMenu() {
        JPanel panel = new JPanel(new GridLayout(this.bodies.size() + 2 ,1));
        
        JButton doubleG = new JButton("Double G");
        doubleG.addActionListener(new GDoubleListener(this.verlet));
        panel.add(doubleG);
        
        JButton halveG = new JButton("Halve G");
        halveG.addActionListener(new GHalveListener(this.verlet));
        panel.add(halveG);
        
        for (Body x : this.bodies) {
            JButton but = new JButton(x.getName());
            but.addActionListener(new BodyListener(this, this.frame.getContentPane(), x));
            panel.add(but);
        }
//        JButton sun = new JButton("The Sun");
//        sun.addActionListener(new BodyListener(this, this.frame.getContentPane(), this.bodies.get(0)));
//        panel.add(sun);
        
        return panel;
    }

    public JPanel bodyDialog(final Body body) {
        final JPanel pane = new JPanel(new BorderLayout());

        
        int numOfButtons = 3;
        JRadioButton[] buttons = new JRadioButton[numOfButtons];
        final ButtonGroup group = new ButtonGroup();
        
        final String mass = "mass";
        final String velX = "velocityX";
        final String velY = "velocityY";
        
        String[] coms = new String[]{mass, velX, velY};
        
        buttons[0] = new JRadioButton("Change mass");
        buttons[0].setActionCommand(mass);
        
        buttons[1] = new JRadioButton("Change x-velocity");
        buttons[1].setActionCommand(velX);
        
        buttons[2] = new JRadioButton("Change y-velocity");
        buttons[2].setActionCommand(velY);
        
        for (int i = 0; i < numOfButtons; i++) {
            group.add(buttons[i]);
        }
        
        JButton changeButton = new JButton("Change");
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String com = group.getSelection().getActionCommand();
                
                if (com == mass) {
                    String s = (String)JOptionPane.showInputDialog(
                    frame, "Give new mass:",
                    "Mass", JOptionPane.PLAIN_MESSAGE);
                    body.setMass(Double.parseDouble(s));
                    pane.setVisible(false);
                } else if (com == velX) {
                    String s = (String)JOptionPane.showInputDialog(
                    frame, "Give horizontal velocity change:",
                    "Horizontal kick", JOptionPane.PLAIN_MESSAGE);
                    double[] vel = body.getVelocity();
                    vel[0] += Double.parseDouble(s);
                    body.setVelocity(vel);
                    pane.setVisible(false);
                } else if (com == velY) {
                    String s = (String)JOptionPane.showInputDialog(
                    frame, "Give vertical velocity change:",
                    "Vertical kick", JOptionPane.PLAIN_MESSAGE);
                    double[] vel = body.getVelocity();
                    vel[1] += Double.parseDouble(s);
                    body.setVelocity(vel);                    
                    pane.setVisible(false);
                }
                return;
            }
        });
        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
        
        for (int i = 0; i < numOfButtons; i++) {
            box.add(buttons[i]);
        }
        
//        JPanel pane = new JPanel(new BorderLayout());
        pane.add(box, BorderLayout.PAGE_START);
        pane.add(changeButton, BorderLayout.PAGE_END);
        return pane;
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
