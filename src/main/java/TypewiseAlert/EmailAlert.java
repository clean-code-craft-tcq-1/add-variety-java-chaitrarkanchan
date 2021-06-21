package TypewiseAlert;

public class EmailAlert implements IAlerter{
	@Override
	public String sendAlert(BreachType breachType) {
		String recepient = "a.b@c.com";
	    	  System.out.printf("To: %s%n", recepient);
	    	  if(!breachType.getDisplayName().equalsIgnoreCase("normal")) {
	          System.out.println("Hi, the temperature is "+breachType.getDisplayName()+"\n");
	    	  }
	    	return breachType.getDisplayName();
	}

}
