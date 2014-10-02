/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planetarysystemsimulator.astro;


import java.awt.Graphics;

/**
 * Instances of this class represent the
 * different planetary system bodies. This
 * class provides methods to manipulate those
 * objects and to draw them to the screen.
 * 
 * @author jussi
 * 
 */

//
//If necessary subclasses can be added to handle different
//objects, such as stars, planets, asteroids, etc.
public class Body {
    private String name;
    private double mass;             //in units of ???
    private double[] position;       //in units of ???      x(t)
    private double[] velocity;       //in units of ???      v(t)
    private double[] acceleration;   //in units of ???,     a(t)
    private double[] accelerationOld;   //in units of ???,    a(t-1)

    /**
     * The constructor sets the initial 
     * acceleration values to 0. If the mass is
     * non-positive, it is set to 1.
     * @param name the name of the body
     * @param mass the mass of the body
     */   
    public Body(String name, double mass) {
        this.name = name;
        if (mass > 0.0) {
            this.mass = mass;
        } else {
            this.mass = 1.0;
        }
        this.acceleration = new double[]{0, 0, 0};
        this.accelerationOld = new double[]{0, 0, 0};
    }
    
    /**
     * Sets the position of the body using
     * simulation units.
     * @param position the position vector of the body
     */
    
    public void setPosition(double[] position) {
        this.position = position;
    }
    
    /**
     * Returns the position of the body.
     * @return the position vector of the body
     */
    public double[] getPosition() {
        return this.position;
    }
    
    /**
     * Sets the velocity of the body using
     * simulation units.
     * @param velocity the velocity vector of the body
     */
    public void setVelocity(double[] velocity) {
        this.velocity = velocity;
    }
    
    /**
     * Returns the velocity of the body in
     * simulation units.
     * @return the velocity vector of the body
     */
    
    public double[] getVelocity() {
        return this.velocity;
    }
    
    public void setMass(double mass) {
        this.mass = mass;
    }
    
    public double getMass() {
        return this.mass;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setAcceleration(double[] acc) {
        this.acceleration = acc;
    } 
        
    public double[] getAcceleration() {
        return this.acceleration;
    }
    
    public void setAccelerationOld(double[] acc) {
        this.accelerationOld = acc;
    } 
        
    public double[] getAccelerationOld() {
        return this.accelerationOld;
    }
    
    /**
     * Adds the input acceleration vector to
     * the current acceleration vector.
     * @param acceleration the acceleration vector which is to be added
     */
    
    public void accelerate(double[] acceleration) {
        for (int i = 0; i < 3; i++) {
            this.acceleration[i] += acceleration[i];
        }
    }
    
    /**
     * Saves the current value of acceleration
     * to the accelerationOld attribute.
     */
     public void saveAcceleration() {
        this.accelerationOld = this.getAcceleration();
        this.setAcceleration(new double[]{0, 0, 0});
    }
    
    /**
     * Draws the body to the drawing
     * board in it's current position.
     * @param g the graphics object that controls the output
     */
     
    public void draw(Graphics g) {
        g.fillOval((int)this.position[0], (int)this.position[1], 7, 7);
    }
}
