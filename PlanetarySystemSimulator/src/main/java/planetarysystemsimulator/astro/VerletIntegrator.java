/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planetarysystemsimulator.astro;

import java.awt.Component;
import java.util.ArrayList;

/**
 * This VerletIntegrator handles the movement of the objects
 * according to the Velocity Verlet integration
 * algorithm.
 * 
 * @author jussi
 */

public class VerletIntegrator {
    protected AccelerationCalculator accCalc;
    protected VelocityCalculator velCalc;
    protected PositionCalculator posCalc;
    private ArrayList<Body> bodies;
    private int t;  //timestep used in integration, units of 10^5 s
    private Component comp;
    private boolean running;  //Is integrator running
    
    /**
     * Creates a new VerletIntegrator with its
     * necessary calculators. It sets the timestep
     * of integration to 1 simulation unit (10^5 s) and the
     * running value to true, so the simulation starts
     * running straight away.
     * @param bodies the bodies in the planetary system
     * @param comp the component that handles the drawing
     * of the bodies
     */
    public VerletIntegrator(ArrayList<Body> bodies, Component comp)  {
        this.accCalc = new AccelerationCalculator();
        this.velCalc = new VelocityCalculator();
        this.posCalc = new PositionCalculator();
        this.bodies = bodies;
        this.comp = comp;
        this.t = 1;
        this.running = true;
    }
    
    /**
     * Returns an ArrayList with the bodies in the system.
     * @return ArrayList of bodies
     */
    public ArrayList<Body> getBodies() {
        return this.bodies;
    }
    
    /**
     * Switches the value of the running attribute
     * between true and false. This enables the
     * simulation to be paused and continued.
     */
    public void toggleRunning() {
        this.running = !this.running;
    }
    
    /**
     * Returns the value of the running attribute which
     * determines whether the simulation is running or paused.
     * @return value of the running attribute
     */
    public boolean getRunning() {
        return this.running;
    }
    
    /**
     * Doubles the value of the gravitational constant.
     */
    public void doubleG() {
        this.accCalc.forcecalc.setG(this.accCalc.forcecalc.getG() * 2);
    }
    
    /**
     * Halves the value of the gravitational constant.
     */
    public void halveG() {
        this.accCalc.forcecalc.setG(this.accCalc.forcecalc.getG() / 2.0);
    }

    /**
     * Calculates the accelerations for each pair of objects
     * in the simulation. It first saves the old values of
     * acceleration for each object, since these are needed
     * in the integration. It then calculates the new values
     * for all objects, taking into account the gravitational
     * influence of each of the other objects.
     */
    public void accelerate() {
        this.saveAccelerations();
        double[][] accelerations;
        for (int i = 0; i < this.bodies.size(); i++) {
            for (int j = i+1;j < this.bodies.size(); j++) {
                accelerations = this.accCalc.acceleration(this.bodies.get(i), this.bodies.get(j));
                this.bodies.get(i).accelerate(accelerations[0]);
                this.bodies.get(j).accelerate(accelerations[1]);
                
            }
        }
    }
    
    /**
     * Saves the current acceleration of
     * each body in the system. It does this by
     * calling the saveAcceleration() method of
     * each body.
     *  
     */
    public void saveAccelerations() {
        for(Body x : this.bodies) {
            x.saveAcceleration();
        }
    }
    
    /**
     * Calculates the new velocities for each body
     * in the system. It does this by telling each
     * body to call the newVelocity() method of the
     * VelocityCalculator and call it's own setVelocity()
     * method using the return value from the calculator
     * as it's input.
     */
    public void newVelocities() {
        for(Body x : this.bodies) {
            x.setVelocity(this.velCalc.newVelocity(x, t));
        }
    }

    /**
     * Calculates the new positions for each body
     * in the system. It does this by telling each
     * body to call the newPostion() method of the
     * PositionCalculator and call it's own setPosition()
     * method using the return value from the calculator
     * as it's input.
     */

    public void newPositions() {
        for(Body x : this.bodies) {
            x.setPosition(this.posCalc.newPosition(x,t));
        }
    }

    /**
     * Performs one round of the Velocity Verlet algorithm.
     * It calls the newPositions(), accelerate() and newVelocities()
     * methods once each.
     */
    public void integrate() {
        this.newPositions();
        this.accelerate();
        this.newVelocities();
    }
    
    /**
     * Runs one step of the whole simulation process.
     * It first performs on step of the integration algorithm
     * by calling integrate() and then calls the GUI to repaint
     * the system.
     */
    public void run() {
            this.integrate();
            this.comp.repaint();
    }
}


