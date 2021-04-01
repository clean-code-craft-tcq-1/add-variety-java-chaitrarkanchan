package TypewiseAlert;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TypewiseAlertTest 
{
   @Test
    public void infersBreachAsPerLimits()
    {
      assertTrue(TypewiseAlert.inferBreach(12, 20, 30) ==BreachType.TOO_LOW);
    }
	
	@Test
    public void checkAndAlertAsPerCoolingType()
    {
        BatteryCharacter batteryCharacter = new BatteryCharacter(CoolingType.PASSIVE_COOLING,"Bosch");
		TypewiseAlert.checkAndAlert(AlertTarget.TO_Email,batteryCharacter , 36);
    }
	@Test
    public void classifyTemperatureBreachAsPerCooling()
    {
        assertTrue((TypewiseAlert.classifyTemperatureBreach(CoolingType.MED_ACTIVE_COOLING,45) == BreachType.TOO_HIGH));
    }
}
