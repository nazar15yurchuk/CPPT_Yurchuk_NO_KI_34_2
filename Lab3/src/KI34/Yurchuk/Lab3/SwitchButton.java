package KI34.Yurchuk.Lab3;
/**
 * Class <code>SwitchButton</code> implements switch button
 *
 * @author Nazar Yurchuk
 * @version 1.0
 */
public class SwitchButton {
    // Switch button mode
    private boolean isPressed;
    // Switch button mode value
    private ButtonMode buttonMode;
    /**
     * Constructor
     */
    public SwitchButton(){
        isPressed=false;
        buttonMode=ButtonMode.OFF;
    }
    /**
     * Method simulates pressing button to on mode
     */
    public void pressOnButton(){
        isPressed=true;
        buttonMode=ButtonMode.ON;
    }
    /**
     * Method simulates pressing button to off mode
     */
    public void pressOffButton(){
        isPressed=true;
        buttonMode=ButtonMode.OFF;
    }
    /**
     * Method returns the SwitchButton mode
     * @return The SwitchButton mode
     */
    public ButtonMode getButtonMode() {
        return buttonMode;
    }
}
