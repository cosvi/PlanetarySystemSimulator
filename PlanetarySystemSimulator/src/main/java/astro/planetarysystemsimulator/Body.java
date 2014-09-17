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

//This class depicts all the planetary system objects.
//If necessary subclasses can be added to handle different
//objects, such as stars, planets, asteroids, etc.
public class Body {
    private String name;
    private double mass;             //in units of ???
    private double[] position;       //in units of ???      x(t)
    private double[] velocity;       //in units of ???      v(t)
    private double[] acceleration;   //in units of ???,     a(t)
    private double[] accelerationOld;   //in units of ???,    a(t-1)

    public Body(String name, double mass) {
        this.name = name;
        if (mass > 0.0) {
            this.mass = mass;
        } else {
            this.mass = 1.0;
            System.out.println("Mass has to be positive. It has been set to 1.0");
        }
        this.acceleration = new double[]{0, 0, 0};
        this.accelerationOld = new double[]{0, 0, 0};
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
    
    public void accelerate(double[] acceleration) {
        for (int i = 0; i < 3; i++) {
            this.acceleration[i] += acceleration[i];
        }
    }
    
    public void saveAcceleration() {
        this.accelerationOld = this.acceleration;
        for (double x : this.acceleration) {
            x = 0.0;
        }
    }
}
