import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ftmk.rmi.sensor.TemperatureSensor;

/**
 * This class represent the client-side of RMI application
 * 
 * @author emalianakasmuri
 *
 */
public class TemperatureClientRMIApp {

	public static void main(String[] args) {
		
		
		try {
			
			// Get registry
			Registry rmiRegistry = LocateRegistry.getRegistry();
			
			// Look-up for the remote object
			TemperatureSensor remoteSensorJasin = (TemperatureSensor) rmiRegistry.lookup("SensorJasin");
			TemperatureSensor remoteSensorAyerKeroh = (TemperatureSensor) rmiRegistry.lookup("SensorAyerKeroh");
			
			// Invoke method from the remote object
			int currentTemperature = remoteSensorJasin.getTemperature();
			int currentTemperature1 = remoteSensorAyerKeroh.getTemperature();
			
			System.out.println("Current temperature in Jasin is " + currentTemperature1 + " Celcius");
			System.out.println("Current temperature in Ayer Keroh is " + currentTemperature1 + " Celcius");
			
			// Invoke new method from remote object for specific day temperature
			String day = "Monday";
			int temperature = remoteSensorAyerKeroh.getTemperatureDay(day);
			
			System.out.println("Current temperature in Ayer Keroh on " + day + " is " + temperature + " Celcius");
			
			// Print average of temperature in a week
			float averageTemperature = remoteSensorAyerKeroh.getAverageTemperature();
			
			System.out.println("Average temperature in Ayer Keroh in a week is " + averageTemperature + " Celcius");
			
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
