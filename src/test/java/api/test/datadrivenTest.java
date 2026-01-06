package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoint.user_endpoints;
import api.payload.User;
import io.restassured.response.Response;

public class datadrivenTest {
	User u=new User();
	
	@Test(priority=0, dataProvider="Data", dataProviderClass=api.utility.DataProviders.class)
	public void createUser(String iD, String UName, String fName, String lName, String Email, String pwd,String Ph) 
	{
		u.setId(Integer.parseInt(iD));
		u.setUsername(UName);
		u.setFirstName(fName);
		u.setLastName(lName);
		u.setEmail(Email);
		u.setPassword(pwd);
		u.setPhone(Ph);
		u.setUserStatus(0);
		Response res=user_endpoints.createUser(u);
		res.then().log().body();
		Assert.assertEquals(res.getStatusCode(), 200);
		//Response res1=user_endpoints.readUser(this.u.getUsername());
	}
	
	@Test(priority=1, dataProvider="UserNames", dataProviderClass=api.utility.DataProviders.class)
	public void deleteUser(String uname) {
		Response res=user_endpoints.deleteUser(uname);
		Assert.assertEquals(res.getStatusCode(),200);
	} 
	
}
