import java.awt.*;

/***
 * Subclass to car, has a unique value turbo that is used in speedFactor function.
 * @author Eli Uhlin, Alexander Lisborg
 * @version 1.6 21 january 2022
 */
public class Saab95 extends Car {

    /***
     * The turbo amount of the car.
     */
    private double turbo = 1;

    /***
     * True if turbo is on, false if turbo is on.
     */
    private boolean turboOn;

    /***
     * Constructor for car Saab95.
     * turboOn is set to false by default.
     */
    public Saab95(){
        super(2,125,Color.red,"Saab95", 2, "pics/Saab95.jpg");
	    turboOn = false;
        //stopEngine();
    }

    /***
     * Sets turboOn to true
     * (see function speedFactor for turbo usage)
     */
    public void setTurboOn(){
	    turboOn = true;
        turbo = 9000;
    }
    /***
     * Sets turboOn to false
     * (see function speedFactor for turbo usage)
     */
    public void setTurboOff(){
	    turboOn = false;
        turbo = 1.0;
    }

    /***
    * Returns the Turbo value of the car.
    */
    public double getTurbo() {
    return this.turbo;
    }
    /***
     * Calculates the speedFactor for the car.
     * @return speedFactor a unique value used to determine the
     * acceleration of the car in increment and decrement speed
     */
    public double speedFactor(){
        return getEnginePower() * 0.01 * turbo;
    }
//test
}
