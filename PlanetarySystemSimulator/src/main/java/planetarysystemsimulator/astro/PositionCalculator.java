/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planetarysystemsimulator.astro;

/**
 * This PositionCalculator calculates the new 
 * positions of objects based on their 
 * velocities and accelerations.
 * 
 * @author jussi
 */

public class PositionCalculator {
    
    /**
     * Creates a new PositionCalculator.
     */
    public PositionCalculator() {
        
    }

    /**
     * Sets the new position vector of the given body
     * based on it's current position, velocity
     * and acceleration. The timestep of the integration
     * is given in units of 10^5 s.
     * @param body the body in question
     * @param t the timestep of integration
     * @return the new position vector of the body
     */
    public double[] newPosition(Body body, int t) {
        double[] position = new double[]{0,0,0};
        double[] oldPosition = body.getPosition();
        double[] acceleration = body.getAcceleration();
        double[] velocity = body.getVelocity();
        
        for (int i = 0; i < 3; i++) {
            position[i] = oldPosition[i] + velocity[i] * t + 0.5 * acceleration[i] * t * t;
        }
        
        return position;

    }
}
