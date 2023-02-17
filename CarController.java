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
    ArrayList<Vehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

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
            for (Vehicle car : cars) {
                car.move();
                int x = (int) Math.round(car.getPosX());
                int y = (int) Math.round(car.getPosY());
                frame.drawPanel.moveit(x, y, car.getModelName());
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                if (y > 500 || y < 0 || x < 0 || x > 700) {
                    for (int i = 0; i < 2; i++) {
                        car.turnRight();
                    }
                }
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars
                ) {
            car.gas(gas);
        }
    }

    public void brake (int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) { car.brake(brake);}
    }

    public void setTurboOn () {
        for (Vehicle car : cars) {
            if (car.getModelName().equals("Saab95")) {
                Saab95 saab = (Saab95) car;
                saab.setTurboOn();
            }
        }
    }

    public void stopEngine(){
        for (Vehicle car : cars){
            car.stopEngine();
        }
    }

    public void startEngine(){
        for (Vehicle car : cars){
            car.startEngine();
        }
    }

    public void setTurboOff() {
        for (Vehicle car : cars) {
            if (car.getModelName().equals("Saab95")) {
                Saab95 saab = (Saab95) car;
                saab.setTurboOff();
            }
        }
    }

    public void increaseTrailerTilt(int amount){
        for (Vehicle car : cars) {
            if (car.getModelName().equals("Scania")) {
                Scania scania = (Scania) car;
                scania.increaseTrailerTilt(amount);
            }
        }
    }

    public void decreaseTrailerTilt(int amount){
        for (Vehicle car : cars) {
            if (car.getModelName().equals("Scania")) {
                Scania scania = (Scania) car;
                scania.decreaseTrailerTilt(amount);
            }
        }
    }
}
