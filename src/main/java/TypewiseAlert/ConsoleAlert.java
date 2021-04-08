package TypewiseAlert;

public class ConsoleAlert implements IAlerter{
@Override
public void sendAlert(BreachType breachType) {
	// TODO Auto-generated method stub
	  System.out.println("The temperature is "+breachType.getDisplayName()+"\n");
}
}
