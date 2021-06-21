package TypewiseAlert;

public class ConsoleAlert implements IAlerter{
	
@Override
public  String sendAlert(BreachType breachType) {
	// TODO Auto-generated method stub
	  System.out.println("The temperature is "+breachType.getDisplayName()+"\n");
	  return breachType.getDisplayName();
}

}
