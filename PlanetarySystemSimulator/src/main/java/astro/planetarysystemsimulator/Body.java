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
    private float mass;             //in units of ???
    private float[] position;       //in units of ???
    private float[] velocity;       //in units of ???
    private float[] acceleration;   //in units of ???
    
    public Body(String name, float mass) {
        this.name = name;
        this.mass = mass;
        this.acceleration = new float[]{0, 0, 0};
    }
    
    public void setPosition(float[] position) {
        this.position = position;
    }
    
    public float[] getPosition() {
        return this.position;
    }
    
    public void setVelocity(float[] velocity) {
        this.velocity = velocity;
    }
    
    public float[] getVelocity() {
        return this.velocity;
    }
    
    public void setMass(float mass) {
        this.mass = mass;
    }
    
    public float getMass() {
        return this.mass;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
}
