package TypewiseAlert;

public class TypewiseAlert 
{
    
    public static BreachType inferBreach(double value, double lowerLimit, double upperLimit) {
      if(value < lowerLimit) {
        return BreachType.TOO_LOW;
      }
      if(value > upperLimit) {
        return BreachType.TOO_HIGH;
      }
      return BreachType.NORMAL;
    }
    
    public static BreachType classifyTemperatureBreach(CoolingType coolingType, double temperatureInC) {
      return inferBreach(temperatureInC, coolingType.getLowerLimit(), coolingType.getUpperLimit());
    }
   
    public static void checkAndAlert(
        AlertTarget alertTarget, BatteryCharacter batteryChar, double temperatureInC) {

      BreachType breachType = classifyTemperatureBreach(batteryChar._coolingType, temperatureInC);
      
      AlertFactory alertFactory = new AlertFactory();
      String alertType=alertTarget.toString();
      alertType = alertType.split("_")[1];  
		
			IAlerter alert;
			try {
				alert = alertFactory.GetInstanceOfAlertType(alertType);
				alert.sendAlert(breachType);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
				}
    }
   
}

 
