package TypewiseAlert;

public class ControllerAlert implements IAlerter {

	@Override
	public void sendAlert(BreachType breachType) {
		// TODO Auto-generated method stub
		  int header = 0xfeed;
		  System.out.printf("%i : %i%n", header, breachType);
	}

}
