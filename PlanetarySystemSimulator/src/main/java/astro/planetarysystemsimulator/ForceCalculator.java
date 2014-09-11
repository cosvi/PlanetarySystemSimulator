/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package astro.planetarysystemsimulator;
//import java.lang.Math;

/**
 *
 * @author jussi
 */
public class ForceCalculator {
    private double G;       //gravitational constant

    public ForceCalculator() {
        this.G = 10.0;       //in m/s
    }
    
    public double getG() {
        return this.G;
    }
    
    public void setG(double newG) {
        this.G = newG;
    }
    
    public double[] Force(Body body1, Body body2) {
        double[] distances = this.Distances(body1.getPosition(), body2.getPosition());
        double force = G * body1.getMass() * body2.getMass() / distances[3];
        double[] forces = {0,0,0};
        forces[0] = Math.signum(distances[0]) * force * distances[0] / distances[3];
        forces[1] = Math.signum(distances[1]) * force * distances[0] / distances[3];
        forces[2] = Math.signum(distances[2]) * force * distances[0] / distances[3];
        return forces;      
    }
    
    public double[] Distances(double[] pos1, double[] pos2) {
        double distances[] = {0,0,0,0};
        distances[0] = pos1[0]-pos2[0];
        distances[1] = pos1[1]-pos2[1];
        distances[2] = pos1[2]-pos2[2];
        distances[3] = Math.sqrt(Math.pow(distances[0],2) + Math.pow(distances[1],2) + Math.pow(distances[2],2));
        return distances;
    }
    
}
