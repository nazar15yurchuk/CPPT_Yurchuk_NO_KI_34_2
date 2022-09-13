package KI34.Yurchuk.Lab3;

import java.io.FileNotFoundException;

/**
 * AirConditionerApp class implements main method for AirConditioner
 * class possibilities demonstration
 *
 * @author Nazar Yurchuk
 * @version 1.0
 */
public class AirConditionerApp {
    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        AirConditioner airConditioner = new AirConditioner("Phillips");
        AirConditioner airConditioner1 = new AirConditioner(8);
        airConditioner.turnOn();
        airConditioner.chooseMode(Mode.DRY);
        airConditioner.changeFanSpeedMode(SpeedMode.MAX);
        airConditioner.increaseTemperature(12);
        airConditioner.reductTemperature(5);
        System.out.println("Current temperature: "+airConditioner.getTemperatureV()+" C");
        System.out.println("Brand name of air conditioner : "+airConditioner.getBrandName());
        airConditioner.turnOff();
        airConditioner.dispose();
        airConditioner1.turnOn();
        airConditioner1.chooseMode(Mode.HEAT);
        airConditioner1.changeFanSpeedMode(SpeedMode.LOW);
        airConditioner.increaseTemperature(6);
        airConditioner.reductTemperature(10);
        System.out.println("Current temperature: "+airConditioner1.getTemperatureV()+" C");
        airConditioner1.setBrandName("Samsung");
        System.out.println("Brand name of air conditioner : "+airConditioner1.getBrandName());
        airConditioner.turnOff();
        airConditioner1.dispose();
    }
}
