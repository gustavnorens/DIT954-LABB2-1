import java.awt.*;
/** Subclass of car, represents the Saab 95 */
public class Saab95 extends Vehicle {

    /** turbo of the car */
    private boolean turboOn;

    /** constructor */
    Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        posX = 200;
        posY = 0;
        dir = Dir.NORTH;
        stopEngine();
        height = 147;
        width = 185;
        length = 501;
    }

    /** turns on the cars turbo */
    public void setTurboOn(){
        turboOn = true;
    }

    /** turns off the cars turbo */
    public void setTurboOff(){
        turboOn = false;
    }

    public boolean getTurbo() {
        return turboOn;
    }

    /** returns the cars speedfactor */
    @Override
    double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
