import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarGroup {


    public double gasAmount;

    public CarGroup(CarController cc) {
        this.cc = cc;
        timer.start();
    }
    private final int delay = 50;
    Timer timer = new Timer(delay, new TimerListener());

    CarController cc;

    ArrayList<Car> cars = new ArrayList<>();

    void add (Car car) {
        cars.add(car);
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(brake);
        }
    }

    void gas() {
        double gas = gasAmount / 100;
        for (Car car : cars
        ) {
            car.gas(gas);
        }
    }
    void startEngine(){
        for (Car car : cars
        ) {
            car.startEngine();
        }
    }

    void turboOn() {
        for (Car car : cars
        ) {
            if (car instanceof Saab95) {((Saab95) car).setTurboOn();
            System.out.println("Turbo on");
        }}

    }

    void turboOff() {
        for (Car car : cars
        ) {
            if (car instanceof Saab95) ((Saab95) car).setTurboOff();
        }
    }

    void liftBed() {
        for (Car car : cars) {
            if (car instanceof FlatbedCar) {
                ((FlatbedCar) car).incrementFlatbed();}}}

    void lowerBed() {
        for (Car car : cars) {
            if(car instanceof FlatbedCar) {
                ((FlatbedCar) car).decrementFlatbed();
            }}}

    void stopEngine() {
        for (Car car : cars
        ) {
            car.stopEngine();
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
                // repaint() calls the paintComponent method of the panel
                cc.repaint();
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

    public double getGasAmount() {
        return gasAmount;
    }

    public void setGasAmount(double gasAmount) {
        this.gasAmount = gasAmount;
    }
}
