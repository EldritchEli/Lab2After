import java.awt.*;

public abstract class FlatbedCar extends Car {
    private Flatbed flatbed;

    /***
     * Constructor for FlatbedCar
     * @param nrDoors the number of doors.
     * @param enginePower
     * @param color
     * @param modelName
     * @param anglelimit the maximum angle of the the cars flatbed measured in degrees
     * @param incDecSpeed the angle changing speed measured in degrees
     */
    public FlatbedCar(int nrDoors, double enginePower, Color color, String modelName, double size, double anglelimit, double incDecSpeed, String texture) {
        super(nrDoors, enginePower, color, modelName, size, texture);
        flatbed = new Flatbed(anglelimit, incDecSpeed, this);
    }
    public void startEngine() {
        if (getFlatbedAngle()== 0) {super.startEngine();}
    }

    /***
     * Increases angle of the Flatbed by incDecSpeed.
     */
    public void incrementFlatbed () {
        flatbed.incrementAngle();
    }

    /***
     * Decreases the angle of the Flatbed by incDecSpeed.
     */
    public void decrementFlatbed () {
        flatbed.decrementAngle();
    }

    /***
     * returns the Flatbeds current Angle.
     */
    public double getFlatbedAngle () {return flatbed.getAngle();}

    public void setFlatbedAngle(double angle) {flatbed.setAngle(angle);}

    /***
     * returns the Angle of the Car, not to be confused with getFlatbedAngle.
     */
    public double getAngleLimit() {
        return flatbed.getAngleLimit();
    }



    public double speedFactor(){
        return getEnginePower() * 0.01;
    }
}