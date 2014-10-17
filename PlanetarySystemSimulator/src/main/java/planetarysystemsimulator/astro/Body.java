/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planetarysystemsimulator.astro;


import java.awt.Color;
import java.awt.Color.*;
import java.awt.Graphics;

/**
 * Instances of this class represent the
 * different planetary system bodies. This
 * class provides methods to manipulate those
 * objects.
 * 
 * @author jussi
 * 
 */

public class Body {
    private String name;
    private double mass;                //in units of 10^24 kg
    private double[] position;          //in units of 10^10 m
    private double[] velocity;          //in units of 10^5 m/s
    private double[] acceleration;      //in units of m/s^2
    private double[] accelerationOld;   //in units of m/s^2
    private Color color;
    private int size;                   //size of body on screen in pixels
    
    /**
     * The constructor sets the initial 
     * acceleration values to 0. The default color
     * of an object is black and default size is
     * 5 pixels.
     * @param name the name of the body
     * @param mass the mass of the body
     */   
    public Body(String name, double mass) {
        this.name = name;
        this.mass = mass;
        this.acceleration = new double[]{0, 0, 0};
        this.accelerationOld = new double[]{0, 0, 0};
        this.color = Color.black;       //default color of body
        this.size = 5;                  //default size of body on screen
    }
    
    /**
     * Sets the on screen size (given in pixels)
     * of the body.
     * @param size new size of image of body (in pixels) 
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * Returns the on screen size (in pixels) of the body.
     * @return current size of the image of the body (in pixels)
     */
    public int getSize() {
        return this.size;
    }
    
    /**
     * Sets the on screen color of the body.
     * @param color new color of body
     */
    public void setColor(Color color) {
        this.color = color;
    }
    
    /**
     * Returns the on screen color of the body.
     * @return current color of body
     */
    public Color getColor() {
        return this.color;
    }
    
    /**
     * Sets the position of the body using
     * simulation units. The position is set
     * relative to the center of the screen,
     * given as an array with x, y and z
     * components. The units used are 10^10m.
     * @param position the position vector of the body
     */
    
    public void setPosition(double[] position) {
        this.position = position;
    }
    
    /**
     * Returns the position of the body in
     * simulation units. The position is 
     * relative to the center of the screen,
     * given as an array with x, y and z
     * components. The units used are 10^10m.
     * @return the position vector of the body
     */
    public double[] getPosition() {
        return this.position;
    }
    
    /**
     * Sets the velocity of the body using
     * simulation units. The velocity is given
     * as an array with x, y, and z components.
     * The units used are 10^5 m/s.
     * @param velocity the velocity vector of the body
     */
    public void setVelocity(double[] velocity) {
        this.velocity = velocity;
    }
    
    /**
     * Returns the velocity of the body in
     * simulation units. The velocity is given
     * as an array with x, y, and z components.
     * The units used are 10^5 m/s.
     * @return the velocity vector of the body
     */
    
    public double[] getVelocity() {
        return this.velocity;
    }
    
    /**
     * Sets the mass of the body in units
     * of 10^24 kg. e.g. Earth's mass is 6 units.
     * @param mass new mass of the body
     */
    public void setMass(double mass) {
        this.mass = mass;
    }
    
    /**
     * Returns the mass of the body in units
     * of 10^24 kg. e.g. The Sun's mass is
     * 2000000 units.
     * @return current mass of body
     */
    public double getMass() {
        return this.mass;
    }
    
    /**
     * Sets the name of the object.
     * @param name new name of the object
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Returns the name of the object.
     * @return current name of the object
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Sets the acceleration of the body
     * in simulation units. The acceleration
     * is given as an array with x, y and z
     * components in units of 1 m/s^2.
     * @param acc new acceleration vector of body
     */
    public void setAcceleration(double[] acc) {
        this.acceleration = acc;
    } 
    
    /**
     * Returns the acceleration of the body
     * in simulation units. The acceleration
     * is given as an array with x, y and z
     * components in units of 1 m/s^2.
     * @return current acceleration vector of the body
     */
    public double[] getAcceleration() {
        return this.acceleration;
    }
    
    /**
     * Sets the acceleration at time step t-1
     * of the body in simulation units. The
     * acceleration is given as an array with
     * x, y and z components in units of 1 m/s^2.
     * @param acc new acceleration vector (at t-1) of body
     */
    public void setAccelerationOld(double[] acc) {
        this.accelerationOld = acc;
    } 
    
    /**
     * Returns the acceleration (at t-1)of the body
     * in simulation units. The acceleration
     * is given as an array with x, y and z
     * components in units of 1 m/s^2.
     * @return current acceleration vector (at t-1) of the body
     */
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
}
