import java.util.ArrayList;

public class CarGroup {




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

    void gas(int amount) {
        double gas = ((double) amount) / 100;
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
            if (car instanceof Saab95) ((Saab95) car).setTurboOn();
        }
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


}
