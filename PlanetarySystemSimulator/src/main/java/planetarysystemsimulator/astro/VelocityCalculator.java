/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planetarysystemsimulator.astro;

/**
 * This class handles the calculation of the new
 * velocities of objects based on their acceleration.
 * 
 * @author jussi
 */

//Might be combined with PositionCalculator
public class VelocityCalculator {
    
    /**
     * Creates a new VelocityCalculator.
     */
    public VelocityCalculator() {
        
    }
    
    /**
     * Calculates the new velocity vector for
     * a body based on its current velocity and
     * current and previous accelerations.
     * @param body the body whose velocity to calculate
     * @param timestep the timestep of integration
     * @return the new velocity vector of the body
     */
    public double[] newVelocity(Body body, int timestep) {
        double[] velocity = new double[]{0,0,0};
        double[] oldVelocity = body.getVelocity();
        double[] acceleration = body.getAcceleration();
        double[] accelerationOld = body.getAccelerationOld();
        
        for (int i = 0; i < 3; i++) {
            velocity[i] = oldVelocity[i] + 0.5 * (acceleration[i] + accelerationOld[i]) * timestep;
        }
        
        return velocity;
    }
    
}
