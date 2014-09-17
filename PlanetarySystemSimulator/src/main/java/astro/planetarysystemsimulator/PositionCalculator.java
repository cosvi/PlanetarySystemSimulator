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

//This class calculates the new positions of objects
//based on their velocities and accelerations.

//Does it need to be a separate class???
public class PositionCalculator {
    
    public PositionCalculator() {
        
    }
    
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
