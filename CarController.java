import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController implements ActionListener, ChangeListener {

    // member fields:

    // The frame that represents this instance View of the MVC pattern
    private CarView frame;
    private DrawPanel drawPanel;
    // A list of cars, modify if needed
    private CarGroup carGroup;




    public CarController(String name){
        this.carGroup = new CarGroup(this);
        this.drawPanel = new DrawPanel(800, 800 -240, carGroup);

        frame = new CarView(name, this);
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
        CarController cc = new CarController("CarSim 1.0");

        Car saab95 = new Saab95();
        Car saabtwo = new Saab95();
        saabtwo.setY(300);
        saab95.setY(100);
        Car scania = new Scania();
        scania.setY(200);
        cc.addToCarGroup(new Volvo240());
        cc.addToCarGroup(saab95);
        cc.addToCarGroup(scania);
        cc.addToCarGroup(saabtwo);



        // Start a new view and send a reference of self
        //cc.frame = new CarView("CarSim 1.0", cc.getCarGroup());

        // Start the timer
        //cc.timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
             if (e.getSource() == frame.startButton)     {carGroup.startEngine();         }
        else if (e.getSource() == frame.stopButton)      {carGroup.stopEngine();          }
        else if (e.getSource() == frame.turboOnButton)   {carGroup.turboOn();             }
        else if (e.getSource() == frame.turboOffButton)  {carGroup.turboOff();            }
        else if (e.getSource() == frame.gasButton)       {carGroup.gas();                 } // flytta gasAmount till carGroup}
        else if (e.getSource() == frame.brakeButton)     {carGroup.brake(20);     }
        else if (e.getSource() == frame.liftBedButton)   {carGroup.liftBed();             }
        else if (e.getSource() == frame.lowerBedButton)  {carGroup.lowerBed();            }}

    @Override
    public void stateChanged(ChangeEvent e) {carGroup.setGasAmount((int)((JSpinner)e.getSource()).getValue());
    }



    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    public DrawPanel getDrawPanel() {return drawPanel;}

    public void repaint() {
        drawPanel.repaint();
    }


}
