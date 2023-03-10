import java.awt.*;

public class Scania extends Vehicle{
    private double trailerTilt;

    /** constructor for Scania */   /** Constructor */
    Scania(){
        nrDoors = 2;
        color = Color.white;
        enginePower = 100;
        modelName = "Scania";
        posX = 400;
        posY = 0;
        dir = Dir.NORTH;
        trailerTilt = 0;
        stopEngine();
        length = 2100;
        width = 250;
        height = 300;
    }

    /** Increases the trailer tilt by a chosen amount of degrees */     /** Increases the trailer tilt a given amount of degrees */
    public void increaseTrailerTilt(double deg){
       if (currentSpeed == 0 && deg >= 0) {
           if (deg + trailerTilt > 70) {
               trailerTilt = 70;
               return;
           }
           trailerTilt += deg;
       }
    }

     /** decreases the trailer tilt a chosen amount of degrees */
    public void decreaseTrailerTilt(double deg){
        if (currentSpeed == 0 && deg >= 0) {
            if (trailerTilt - deg < 0) {
                trailerTilt = 0;
                return;
            }
            trailerTilt -= deg;
        }
    }

    /** Returns the current trailer tilt */     /** returns the current trailer tilt */
    public double getTrailerTilt(){
        return trailerTilt;
    }

    private boolean canDrive() {
        if (trailerTilt > 0) {
            return false;
        }
        return true;
    }
    public void gas(double amount){
        if (canDrive()){
            super.gas(amount);
        }
    }
    public void startEngine(){
        if (canDrive()){
            super.startEngine();
        }
    }
}
