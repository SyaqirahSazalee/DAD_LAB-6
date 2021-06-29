package ftmk.rmi.sensor.manager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import ftmk.rmi.sensor.TemperatureSensor;

/**
 * This class manage the value of temperature from the sensor.
 * 
 * @author emalianakasmuri
 *
 */
public class TemperatureSensorManager extends UnicastRemoteObject implements TemperatureSensor {

	public TemperatureSensorManager() throws RemoteException {
		super();
	}

	@Override
	public int getTemperature() throws RemoteException {
		
		return 35;
	}

	
	private HashMap <String, Integer> loadTemperature()
	{
		HashMap <String, Integer> temperature = new HashMap<>();
		
		temperature.put("Monday", 32);
		temperature.put("Tuesday", 31);
		temperature.put("Wednesday", 33);
		temperature.put("Thursday", 35);
		temperature.put("Friday", 36);
		temperature.put("Saturday", 33);
		temperature.put("Sunday", 33);
		
		return temperature;
	}

	@Override
	public int getTemperatureDay(String Day) throws RemoteException 
	{
		HashMap <String, Integer> temp = loadTemperature();
		int temperature = temp.get(Day);
		
		return temperature;
		
	}

	@Override
	public float getAverageTemperature() throws RemoteException 
	{
		HashMap <String, Integer> temp = loadTemperature();
		
		int totalTemperature = 0;
		
		for (int temperature : temp.values())
		{
			totalTemperature = totalTemperature + temperature;
		}
		
		float averageTemperature = (float)totalTemperature/temp.size();
		return averageTemperature;
	}
	
	

}
