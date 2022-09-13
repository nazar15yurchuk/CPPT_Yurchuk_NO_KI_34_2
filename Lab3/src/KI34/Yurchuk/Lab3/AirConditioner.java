package KI34.Yurchuk.Lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Class <code>AirConditioner</code> implements air conditioner
 *
 * @author Nazar Yurchuk
 * @version 1.0
 */
public class AirConditioner {
    private PrintWriter fout;
    private SwitchButton switchButton;
    private Temperature temperature;
    private Fan fan;
    private Mode mode;
    // AirConditioner brand name value
    private String brand;



    /**
     * Constructor
     *
     * @param
     * <code>brand</code> AirConditioner brand name value
     * @throws FileNotFoundException
     */
    public AirConditioner(String brandN)throws FileNotFoundException {
        fout = new PrintWriter("Log.txt");
        switchButton=new SwitchButton();
        fan= new Fan();
        temperature=new Temperature();
        mode=Mode.DEFAULT;
        brand=brandN;
    }
    /**
     * Constructor
     *
     * @param
     * <code>temperatureValue</code> Temperature value
     * @throws FileNotFoundException
     */
    public AirConditioner(int initialTempValue)throws FileNotFoundException{
        fout = new PrintWriter("Log.txt");
        switchButton=new SwitchButton();
        fan= new Fan();
        temperature=new Temperature(initialTempValue);
        mode=Mode.DEFAULT;
    }
    /**
     * Method simulates turning on air conditioner
     */
    public void turnOn(){
        switchButton.pressOnButton();
        fan.startFan();
        System.out.println("Air conditioner starts working!\n");
        fout.printf("Initial temperature: "+temperature.getTemperatureV()+" C"+"\n");
        fout.print("Fan start's spinning! Status: " + fan.isSpinned() + " with "+fan.getSpeedMode().name()+" mode"+"\n");
        fout.print("Button "+switchButton.getButtonMode().name()+" is pressed"+"\n");
        fout.flush();
    }
    /**
     * Method simulates turning off air conditioner
     */
    public void turnOff(){
        switchButton.pressOffButton();
        fan.finishFan();
        System.out.println("Air conditioner finished working!\n");
        fout.print("Fan finished spinning! Status: " + fan.isSpinned() +"\n");
        fout.print("Button "+switchButton.getButtonMode().name()+" is pressed"+"\n");
        fout.flush();
    }

    /**
     * Method simulates changing fan speed mode
     */
    public void changeFanSpeedMode(SpeedMode speedMode){
        fan.changeFan(speedMode);
        fout.printf("Fan speed mode changed to "+fan.getSpeedMode()+"\n");
    }
    /**
     * Method simulates increasing temperature value
     */
    public void increaseTemperature(int increaseV){
        temperature.increaseTemperature(increaseV);
        fout.printf("Temperature value increased  to "+temperature.getTemperatureV()+"\n");
    }
    /**
     * Method simulates reduction temperature value
     */
    public void reductTemperature(int reductV){
        temperature.reductTemperature(reductV);
        fout.printf("Temperature value reducted  to "+temperature.getTemperatureV()+"\n");
    }

    /**
     * Method returns info about Temperature value
     *
     * @return Temperature value
     */
    public int getTemperatureV() {
        return temperature.getTemperatureV();
    }

    /**
     * Method returns SwitchButton mode value
     *
     * @return SwitchButton mode value
     */
    public String getButtonModeV() {
        return switchButton.getButtonMode().name();
    }

    /**
     * Method simulates choosing mode of air conditioner
     */
    public void chooseMode(Mode modeV){
        mode=modeV;
        fout.printf("Air conditioner stars working in "+mode.name()+" mode!"+"\n");
    }
    /**
     * Method sets air conditioner brand name
     */
    public void setBrandName(String brandN){
        brand=brandN;
    }

    /**
     * Method returns AirConditioner brand name
     *
     * @return AirConditioner brand name
     */
    public String getBrandName() {
        return brand;
    }


    /**
     * Method releases used recourses
     */
    public void dispose() {
        fout.close();
    }
}
