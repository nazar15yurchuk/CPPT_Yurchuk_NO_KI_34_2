package KI34.Yurchuk.Lab3;
/**
 * Class <code>Temperature</code> implements temperature
 *
 * @author Nazar Yurchuk
 * @version 1.0
 */
public class Temperature {
    // Temperature  value
    private int temperatureValue;
    /**
     * Constructor
     */
    public Temperature(){
        temperatureValue=(int)(Math.random() * 25 + 5);
    }

    /**
     * Constructor
     * @param
     * <code>tValue</code> Temperature  temperature value
     */
    public Temperature(int tValue){
        temperatureValue=tValue;
    }

    /**
     * Method simulates increasing Temperature value
     */
    public void increaseTemperature(int increasedValue){
        temperatureValue+=increasedValue;
    }

    /**
     * Method simulates reduction Temperature value
     */
    public void reductTemperature(int reductedValue){
        temperatureValue-=reductedValue;
    }


    /**
     * Method returns the Temperature  value
     * @return The Temperature  value
     */
    public int getTemperatureV() {
        return temperatureValue;
    }
}
