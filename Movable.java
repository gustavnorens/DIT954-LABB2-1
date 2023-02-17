/** Interface to implement the methods required by a movable object*/
public interface Movable {
    /** asserts that all subtypes of Datamodules.Movable must implement move */
    void move();
    /** asserts that all subtypes of Datamodules.Movable must implement turnLeft */
    void turnLeft();
    /** asserts that all subtypes of Datamodules.Movable must implement turnRight */
    void turnRight();
}
