/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package astro.planetarysystemsimulator;

/**
 *
 * @author jussi
 */
public class Body {
    private String name;
    private double mass;             //in units of ???
    private double[] position;       //in units of ???
    private double[] velocity;       //in units of ???
    private double[] acceleration;   //in units of ???
    
    public Body(String name, double mass) {
        this.name = name;
        this.mass = mass;
        this.acceleration = new double[]{0, 0, 0};
    }
    
    public void setPosition(double[] position) {
        this.position = position;
    }
    
    public double[] getPosition() {
        return this.position;
    }
    
    public void setVelocity(double[] velocity) {
        this.velocity = velocity;
    }
    
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
}
