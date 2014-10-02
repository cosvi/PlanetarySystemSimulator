/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planetarysystemsimulator.astro;

/**
 * This class handles the calculation of the
 * gravitational force between two objects.
 * 
 * @author jussi
 * 
 * 
 */

//Might be combined with AccelerationCalculator.
public class ForceCalculator {
    private double G;       //gravitational constant

    /**
     * Creates a new ForceCalculator, setting
     * the gravitational constant to the equivalent
     * of the actual G in simulation units.
     */
    public ForceCalculator() {
        this.G = 6.67E-7;       //in simulation units
    }
    
    /**
     * Returns the current value of the gravitational constant
     * in simulation units.
     * @return Current value of G.
     */
    public double getG() {
        return this.G;
    }
    
    /**
     * Sets a new value for the gravitational constant in
     * simulation units.
     * @param newG New value for G.
     */
    public void setG(double newG) {
        this.G = newG;
    }
    
    /**
     * Calculates the gravitational force between
     * two bodies. It returns the force vector of
     * body2, so the force vector for body1 is the
     * negative of the return vector.
     * 
     * @param body1 the first body
     * @param body2 the second body
     * @return the force vector for the second body
     */
    public double[] force(Body body1, Body body2) {
        double[] distances = this.distances(body1.getPosition(), body2.getPosition());
        double force = this.G * body1.getMass() * body2.getMass() / Math.pow(distances[3],2);
        double[] forces = {0,0,0};
        forces[0] = force * distances[0] / distances[3];
        forces[1] = force * distances[1] / distances[3];
        forces[2] = force * distances[2] / distances[3];
        return forces;      
    }
    
    /**
     * Calculates the position vector between
     * two bodies. Returns the position of the
     * first body in relation to the second body.
     * 
     * @param pos1 position of the first body
     * @param pos2 position of the second body
     * @return the position vector from body2 to body1
     */
    public double[] distances(double[] pos1, double[] pos2) {
        double distances[] = {0,0,0,0};
        distances[0] = pos1[0]-pos2[0];
        distances[1] = pos1[1]-pos2[1];
        distances[2] = pos1[2]-pos2[2];
        distances[3] = Math.sqrt(Math.pow(distances[0],2) + Math.pow(distances[1],2) + Math.pow(distances[2],2));
        return distances;
    }
    
}
