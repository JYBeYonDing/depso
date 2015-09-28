/**
 * Description: GoldsteinPrice(GP) function
 *
 * @ Author        Create/Modi     Note
 * Xiaofeng Xie    Apr 20, 2003
 * Xiaofeng Xie    May 11, 2004
 *
 * @Principles: 
 *   1) each constrained problem instance is extended from problem.UnconstrainedProblemEncoder, which 
 *      is a minimization function.	
 *   2) In the constructor function (i.e., the function with the class name), two
 *      parts should be implemented: 
 *      a) call super(NX), in which NX is the number of variables (or parameters); 
 *      b) set range for each parameter by using the function setDefaultXAt(i, LB_P, UB_P), 
 *         in which i means the i-th parameter, LB_P and UB_P are the lower and upper bounds;
 *   3) Realize the function: "double calcTargetAt(double[] VX)",
 *       in which "VX" is an array of parameter values.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * Please acknowledge the author(s) if you use this code in any way.
 *
 * @version 1.0
 * @Since MAOS1.0
 *
 * @References:
 * [1] Serra P, Stanton A F, Kais S. Comparison study of pivot methods for global
 *  optimization. J. Chem. Phys, 1997, 106(17): 7170-7177
 */

package problem.unconstrained;

import problem.*;

//Principle #1: each constrained problem instance is extended from problem.UnconstrainedProblemEncoder,  
//              which is a minimization function.
public class GoldsteinPrice extends UnconstrainedProblemEncoder {
  public GoldsteinPrice() throws Exception {
    //Principle #2a: call super(NX), in which NX is the number of variables (or parameters); 
    super(2);
    //Principle #2b: set range for each parameter by using the function setDefaultXAt(i, LB_P, UB_P), 
    //in which i means the i-th parameter, LB_P and UB_P are the lower and upper bounds;
    setDefaultXAt(0, -2, 2);
    setDefaultXAt(1, -2, 2);
  }

 //Principle #3: realize the function "double calcTargetAt(double[] VX)", in which "VX" is an array of parameter values.
  protected double calcTarget(double[] VX) {
    return (1+Math.pow(VX[0]+VX[1]+1, 2)*(19-14*VX[0]+3*VX[0]*VX[0]-14*VX[1]+6*VX[0]*VX[1]+3*VX[1]*VX[1]))*(30+(Math.pow(2*VX[0]-3*VX[1], 2)*(18-32*VX[0]+12*VX[0]*VX[0]+48*VX[1]-36*VX[0]*VX[1]+27*VX[1]*VX[1])));
  }
}
