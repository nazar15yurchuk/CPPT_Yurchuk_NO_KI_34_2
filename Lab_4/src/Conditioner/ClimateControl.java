package Conditioner;
import java.io.*;
/**
 * Class ClimateControl
 * @version 1.0
 */

interface IClimateControl{
    void changeHumidity(int humidity, int sec);
}

public class ClimateControl extends Conditioner implements IClimateControl{
    Display humidityDisplay = new Display();

    int currentHumidity = 0;

    /**
     * Constructor
     * @param temp
     * @param humidity
     * @throws FileNotFoundException
     */
    public ClimateControl(int temp, int humidity) throws FileNotFoundException
    {
        super(temp);
        this.currentHumidity = humidity;
        humidityDisplay.setTemp(humidity);
    }
    /**
     * Constructor
     * @param temp
     * @throws FileNotFoundException
     */
    public ClimateControl(int temp) throws FileNotFoundException
    {
        super(temp);
        this.currentHumidity = 70;
        humidityDisplay.setTemp(70);
    }
    /**
     * Method changes humidity
     * @param humidity
     * @param sec
     */
    public void changeHumidity(int humidity, int sec) {
        try{
            sendMessage("Changing humidity started... " + "(" + sec + " seconds)");
            for(int i = 0; i < sec; i++)
            {
                if(currentHumidity < humidity)
                {
                    currentHumidity += 1;
                }
                else if(currentHumidity > humidity)
                {
                    currentHumidity -= 1;
                }
                System.out.println("Humidity: " + currentHumidity);
                Thread.sleep(1000);
            }
            sendMessage("Changing humidity stopped... \n Humidity: " + currentHumidity);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
