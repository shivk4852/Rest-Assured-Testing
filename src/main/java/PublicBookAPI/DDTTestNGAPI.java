package PublicBookAPI;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DDTTestNGAPI
{
	String id;
   @Test(dataProvider = "TestData", priority = 1)
   public void AddBookAPI(String isbn, String aisle)
   {
	   
	   RestAssured.baseURI ="http://216.10.245.166";
		
		String Response	=given().log().all().header("Content-Type",  "application/json").body(PayloadJson.PostRequest(isbn, aisle)).
	         when().post("/Library/Addbook.php").then().log().all().assertThat().statusCode(200).extract().asString();	
		System.out.println(Response);
		
		JsonPath js= new JsonPath(Response);
	       id=	js.get("ID");
	       System.out.println(id);
   }
   
   @Test(priority = 3)
   public void DeleteBook()
   {
   	
   	
   	String Response2 =given().log().all().header("Content-Type", "application/json").body(PayloadJson.DeleteRequest(""+id+""))
   	.when().post("/Library/DeleteBook.php").then().log().all().assertThat().statusCode(200).extract().asString();
   	
   	System.out.println(Response2);
   }
   @Test(priority = 2)
    public void GetBookAPI()
    {
   	 
   	 given().queryParam("ID", ""+id+"").when().get("/Library/GetBook.php").
   	 then().log().all().statusCode(200).extract().asString();
    }

   @DataProvider(name="TestData")
   public Object[][] TestData()
   {
	   
	   return new Object [][] { {"Divya", "1234"} , {"Vijay", "26899"}, {"Shiva", "22889"} };
	   
			   
	                                          }
  
}
