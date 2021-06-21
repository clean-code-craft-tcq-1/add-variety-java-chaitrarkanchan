package TypewiseAlert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TypewiseAlertTest 
{
	
	double tempval;
	BreachType expectedResult;
	CoolingType coolingtype;
	String alertTarget;
	BatteryCharacter batteryCharacter;
	
	
	@Before
    public void initialiseBatteryCharacters() { 		
		batteryCharacter = new BatteryCharacter(coolingtype,"Bosch");
	}
	
	@Parameterized.Parameters
	public static Collection inputData() {
	      return Arrays.asList(new Object[][]{
	        
	         { CoolingType.HI_ACTIVE_COOLING,32, BreachType.NORMAL,"Controller"},
	         { CoolingType.PASSIVE_COOLING, -1,BreachType.TOO_LOW,"Console"},
	         { CoolingType.MED_ACTIVE_COOLING,60,BreachType.TOO_HIGH,"Email"}
	      });
	}
	
	public TypewiseAlertTest(CoolingType coolingtype, double tempval,BreachType expectedResult,String alertTarget) {
	      this.coolingtype = coolingtype;
	      this.tempval = tempval;
	      this.expectedResult = expectedResult;
	      this.alertTarget = alertTarget;
	   }
	
   
   @Test(expected = ClassNotFoundException.class)
   public void checkAndAlertAsWithMissingClass() throws ClassNotFoundException {
   	//when
   	try {    	
   		BatteryCharacter batteryCharacter = new BatteryCharacter(CoolingType.PASSIVE_COOLING,"Bosch");
   		TypewiseAlert.checkAndAlert("Notification",batteryCharacter , 36);// when class implementation not found
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
   }
	
	
	@Test
    public void classifyTemperatureBreachAsPerCooling()
    {
		assertEquals(TypewiseAlert.classifyTemperatureBreach(coolingtype,tempval),expectedResult);
    }
	

	 @Test
	    public void infersBreachAsPerLimits()
	    {
	      assertTrue(TypewiseAlert.inferBreach(12, 20, 30) ==BreachType.TOO_LOW);
	    }
	 
	 @Test
	    public  void checkAndAlertAsPerAlertTarget() {
	    	
			try {
				assertEquals(expectedResult.getDisplayName(),TypewiseAlert.checkAndAlert(alertTarget,batteryCharacter,tempval));
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
	    }
}
