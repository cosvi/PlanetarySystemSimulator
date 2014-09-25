/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planetarysystemsimulator.astro;

import java.awt.Component;

/**
 * This class handles the movement of the objects
 * according to the Velocity Verlet integration
 * algorithm.
 * 
 * @author jussi
 */

public class VerletIntegrator {
    private AccelerationCalculator accCalc;
    private VelocityCalculator velCalc;
    private PositionCalculator posCalc;
    private Body[] bodies;
    private int t;  //timestep used in integration
    private Component comp;
    
    public VerletIntegrator(Body[] bodies, Component comp)  {
        this.accCalc = new AccelerationCalculator();
        this.velCalc = new VelocityCalculator();
        this.posCalc = new PositionCalculator();
        this.bodies = bodies;
        this.comp = comp;
        this.t = 1;
    }
    
    //Calculates the accelerations for each pair of objects
    public void accelerate() {
        this.saveAccelerations();
        double[][] accelerations;
        for (int i = 0; i < this.bodies.length; i++) {
            for (int j = i+1;j < this.bodies.length; j++) {
                accelerations = this.accCalc.acceleration(this.bodies[i], this.bodies[j]);
                this.bodies[i].accelerate(accelerations[0]);
                this.bodies[j].accelerate(accelerations[1]);
                
            }
        }
    }
    
    public void saveAccelerations() {
        for(Body x : this.bodies) {
            x.saveAcceleration();
        }
    }
    
    public void newVelocities() {
        for(Body x : this.bodies) {
            x.setVelocity(this.velCalc.newVelocity(x, t));
        }
    }
    
    public void newPositions() {
        for(Body x : this.bodies) {
            x.setPosition(this.posCalc.newPosition(x,t));
        }
    }
    
    public void integrate() {
        this.newPositions();
        this.accelerate();
        this.newVelocities();
    }
    
    public void run() {
        this.accelerate();
        for (int i = 0; i < 100; i++) {
            this.integrate();
            if (i % 10 == 0) {
                System.out.println(i);
                System.out.println(this.bodies[2].getPosition()[0]);
                System.out.println(this.bodies[1].getPosition()[0]);
                this.comp.repaint();
            }
        }
    }
}


