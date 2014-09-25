/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package astro.planetarysystemsimulator;

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

    public ForceCalculator() {
        this.G = 0.000667;       //in simulation units
    }
    
    public double getG() {
        return this.G;
    }
    
    public void setG(double newG) {
        this.G = newG;
    }
    
    public double[] force(Body body1, Body body2) {
        double[] distances = this.distances(body1.getPosition(), body2.getPosition());
        double force = G * body1.getMass() * body2.getMass() / Math.pow(distances[3],2);
        double[] forces = {0,0,0};
        forces[0] = force * distances[0] / distances[3];
        forces[1] = force * distances[1] / distances[3];
        forces[2] = force * distances[2] / distances[3];
        return forces;      
    }
    
    public double[] distances(double[] pos1, double[] pos2) {
        double distances[] = {0,0,0,0};
        distances[0] = pos1[0]-pos2[0];
        distances[1] = pos1[1]-pos2[1];
        distances[2] = pos1[2]-pos2[2];
        distances[3] = Math.sqrt(Math.pow(distances[0],2) + Math.pow(distances[1],2) + Math.pow(distances[2],2));
        return distances;
    }
    
}
