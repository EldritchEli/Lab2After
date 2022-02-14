import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    private CarGroup carGroup;

    public CarController(String name, CarGroup carGroup){
        this.drawPanel = new DrawPanel(800, 800 -240, carGroup);
        this.carGroup = carGroup;
        frame = new CarView(name, this.carGroup);


    }

    public void addToCarGroup(Car car) {
        carGroup.add(car);
    }
    public CarGroup getCarGroup() {
        return carGroup;
    }


    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController("CarSim 1.0", new CarGroup());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : frame.drawPanel.getCarGroup().getCars()) {
                car.move();
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                if (car.getX() > 700) {
                    car.stopEngine();
                    car.setAngle(180);
                    car.startEngine();
                }
                else if (car.getX() < 0) {
                    car.stopEngine();
                    car.setAngle(0);
                    car.startEngine();
                }
            }
        }
    }
}
