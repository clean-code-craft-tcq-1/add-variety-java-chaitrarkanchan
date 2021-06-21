package TypewiseAlert;

public class ControllerAlert implements IAlerter {

	@Override
	public String sendAlert(BreachType breachType) {
		// TODO Auto-generated method stub
		  int header = 0xfeed;
		 // System.out.printf("%i : %i%n", header, breachType);
		  return breachType.getDisplayName();
	}


}
