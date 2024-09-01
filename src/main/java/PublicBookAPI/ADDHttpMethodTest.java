package PublicBookAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured. *;

import org.testng.annotations.Test;
public class ADDHttpMethodTest 



{
	String id;
    @Test(priority = 1)
	public void CreateBookAPI() {
		
		RestAssured.baseURI ="http://216.10.245.166";
		
	String Response	=given().log().all().header("Content-Type",  "application/json").body(PayloadJson.PostRequest("Shiv", "35567")).
         when().post("/Library/Addbook.php").then().log().all().assertThat().statusCode(200).extract().asString();		
	
	System.out.println(Response);
	
	
	JsonPath js= new JsonPath(Response);
       id=	js.get("ID");
       System.out.println(id);
		
	}
    @Test(priority = 3)
    public void DeleteBook()
    {
    	
    	RestAssured.baseURI ="http://216.10.245.166";
    	
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
}
