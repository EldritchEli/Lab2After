import java.awt.*;

public class Scania extends FlatbedCar{
    /**
     * Constructor for Scania.
     */
    public Scania () {
        super(2,150, Color.magenta,"Scania",4,70,1, "Pics/Scania.jpg");
    }

    /**
     * Calculates the speed factor of Scania.
     * @return The unique speed factor of Scania.
     */
    public double speedFactor(){
        return getEnginePower() * 0.01;
    }
}
