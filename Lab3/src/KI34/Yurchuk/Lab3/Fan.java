package KI34.Yurchuk.Lab3;

/**
 * Class <code>Fan</code> implements fan
 *
 * @author Nazar Yurchuk
 * @version 1.0
 */
public class Fan {
    // Fan mode value
    private SpeedMode speedMode;
    // Fan mode
    private boolean isSpinned;

    /**
     * Constructor
     */
    public Fan() {
        isSpinned = false;
        speedMode = SpeedMode.INITIAL;
    }
    /**
     * Method simulates Fan start's working
     */
    public void startFan(){
        isSpinned=true;
    }

    /**
     * Method simulates Fan finishes working
     */
    public void finishFan(){
        isSpinned=false;
    }
    /**
     * Method returns Fan speed mode value
     * @return Fan speed mode value
     * <code>Fan.SpeedMode</code>
     */
    public SpeedMode getSpeedMode(){
        return speedMode;
    }

    /**
     * Method simulates changing Fan speed mode value
     */
    public void changeFan(SpeedMode speedModeValue){
        speedMode=speedModeValue;
    }

    /**
     * Method returns Fan  mode value
     * @return The Fan mode
     */
    public boolean isSpinned() {
        return isSpinned;
    }

}
