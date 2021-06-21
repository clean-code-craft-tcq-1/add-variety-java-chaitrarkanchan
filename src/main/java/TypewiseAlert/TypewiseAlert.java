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
   
    public static String checkAndAlert(
        String alertTarget, BatteryCharacter batteryChar, double temperatureInC)throws InstantiationException, IllegalAccessException, ClassNotFoundException {

      BreachType breachType = classifyTemperatureBreach(batteryChar._coolingType, temperatureInC);
      
      AlertFactory alertFactory = new AlertFactory();
      
			IAlerter alert;
			
				alert = alertFactory.GetInstanceOfAlertType(alertTarget);
				return alert.sendAlert(breachType);
			
    }
   
}

 
