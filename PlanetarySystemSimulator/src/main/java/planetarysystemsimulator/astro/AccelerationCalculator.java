/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planetarysystemsimulator.astro;

/**
 * This class handles the calculation of the 
 * acceleration caused by the force between
 * two objects. 
 * 
 * @author jussi
 * 
 * 
 */

public class AccelerationCalculator {
    protected ForceCalculator forcecalc;
    
    /**
     * Creates a new AccelerationCalculator
     * with it's associated ForceCalculator.
     */
    public AccelerationCalculator() {
        this.forcecalc = new ForceCalculator();
    }
    
    /**
     * Calculates the acceleration caused by two
     * bodies on each other. Returns the accelerations
     * as two acceleration vectors, one for each body.
     * @param body1 the first body
     * @param body2 the second body
     * @return the acceleration vectors of the bodies
     */
    public double[][] acceleration(Body body1, Body body2) {
        double[] acc1 = new double[]{0,0,0}, acc2 = new double[]{0,0,0};
        double[] force = this.forcecalc.force(body1, body2);
        for (int i = 0; i < 3; i++) {
            acc1[i] = -force[i] / body1.getMass();
            acc2[i] = force[i] / body2.getMass();
        }
        double[][] accelerations = new double[][]{acc1, acc2};
        return accelerations;
    }
}

