package TypewiseAlert;
public class AlertFactory {

	public IAlerter GetInstanceOfAlertType(String result) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class<?> cls =Class.forName("TypewiseAlert."+result+"Alert");
		return (IAlerter) cls.newInstance();
		
	}
	
}
