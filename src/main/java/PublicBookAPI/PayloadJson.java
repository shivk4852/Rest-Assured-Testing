package PublicBookAPI;

public class PayloadJson {

	
	public static String PostRequest(String isbn, String aisle)
	{
		
		String inputJson = "{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}\r\n"
				+ "";
		return inputJson;
	}
	
	public static String DeleteRequest(String id)
	{
		
          String Dinput="{\r\n"
          		+ " \r\n"
          		+ "\"ID\" : \""+id+"\"\r\n"
          		+ " \r\n"
          		+ "} ";
		return Dinput;
	}
}
