package Conditioner;
/**
 * Class Ventilator
 * @version 1.0
 */
public class Ventilator {

    int revolutionsPerSecond = 0;

    int MAX_REVOLUTIONS = 1000;
    /**
     * Method for setting ventilator revolution
     * @param rotation
     */
    public void setRotation(int rotation) throws Exception
    {
        if(rotation > MAX_REVOLUTIONS || rotation < 0)
        {
            throw new Exception("Invalid revolution");
        }

        revolutionsPerSecond = rotation;
    }
    /**
     * Method turn off the ventilator
     */
    public void turnOff()
    {
        revolutionsPerSecond = 0;
    }

}
