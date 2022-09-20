package Conditioner;
import java.io.*;
/**
 * Class Conditioner
 * @version 1.0
 */
public abstract class Conditioner {
    Ventilator ventilator = new Ventilator();
    Filter filter = new Filter();
    Display display = new Display();

    int currentTemp;
    private PrintWriter fout;
    /**
     * Constructor
     * @param currentTemp
     * @throws FileNotFoundException
     */
    public Conditioner(int currentTemp) throws FileNotFoundException
    {
        this.currentTemp = currentTemp;
        fout = new PrintWriter(new File("Log.txt"));
    }
    /**
     * Constructor
     * @throws FileNotFoundException
     */
    public Conditioner() throws FileNotFoundException
    {
        currentTemp = 10;
        fout = new PrintWriter(new File("Log.txt"));
    }
    /**
     * Method
     * @param temp
     * @param sec
     */
    public void turnOn(int temp, int sec) {
        try {
            ventilator.setRotation(getRevolutionByTemp(temp));
            sendMessage("Air conditioning started... " + "(" + sec + " seconds)");
            for(int i = 0; i < sec; i++)
            {
                try{
                    if(currentTemp < temp)
                    {
                        currentTemp += 1;
                    }else if(currentTemp > temp){
                        currentTemp -= 1;
                    }
                    filter.tick();
                    display.setTemp(currentTemp);
                    System.out.println("Temperature: " + display.getTemp());
                }
                catch (Exception e){
                    System.out.println(e);
                }
                finally {
                    Thread.sleep(1000);
                }
            }
            turnOff();
            sendMessage("Air conditioning stopped... \n Temperature: " + currentTemp);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    /**
     * Method returns current temp
     */
    public int getTemp()
    {
        return display.getTemp();
    }
    /**
     * Method cleans filter
     */
    public void cleanFilter()
    {
        filter.clean();
        sendMessage("Filter cleaned!");
    }
    /**
     * Method returns filter pollution
     */
    public int getFilterPollution()
    {
        return filter.pollutionStatus;
    }
    /**
     * Method returns ventilator revolution
     */
    public int getVentilatorRevolution()
    {
        return ventilator.revolutionsPerSecond;
    }
    /**
     * Method returns changes filter
     */
    public void changeFilter()
    {
        filter = new Filter();
    }
    /**
     * Method for setting a new temperature
     */
    public void changeCurrentTemp(int temp)
    {
        currentTemp = temp;
    }
    /**
     * Method turnoff the conditioner
     */
    private void turnOff()
    {
        ventilator.turnOff();
    }

    public void dispose()
    {
        fout.close();
    }

    protected void sendMessage(String message)
    {
        System.out.println(message);
        fout.println(message);
    }

    private int getRevolutionByTemp(int temp)
    {
        return Math.abs(temp) * 10;
    }

}
