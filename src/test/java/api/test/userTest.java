package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.testng.Assert;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

import api.endpoint.user_endpoints;
import api.payload.User;
import io.restassured.response.Response;

public class userTest {	
	Faker f;
	User u;
	User u1;
public Logger log;
	@BeforeClass
	public void testData() {
		f =new Faker();
		u =new User();
		
		u.setId(f.idNumber().hashCode());
		u.setUsername(f.name().username());
		u.setFirstName(f.name().firstName());
		u.setLastName(f.name().lastName());
		u.setEmail(f.internet().emailAddress());
		u.setPassword(f.internet().password());
		u.setPhone(f.phoneNumber().cellPhone());
		u.setUserStatus(0);
		
		u1 =new User();
		u1.setId(f.idNumber().hashCode());
		u1.setUsername(f.name().username());
		u1.setFirstName(f.name().firstName());
		u1.setLastName(f.name().lastName());
		u1.setEmail(f.internet().emailAddress());
		u1.setPassword(f.internet().password());
		u1.setPhone(f.phoneNumber().cellPhone());
		u1.setUserStatus(0);
	 log = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=0)
	public void createUser() {
		log.info("***************creating user***************");
		Response res=user_endpoints.createUser(u);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		log.info("***************created user***************");
		//logs
		
	}


@Test(priority=1)
public void getUser() {
	Response res=user_endpoints.readUser(this.u.getUsername());
	//res.then().log().all();
	Assert.assertEquals(res.getStatusCode(), 200);
}

@Test(priority=2)
public void updateUser() {
	Response res=user_endpoints.updateUser(u1,u.getUsername());

	Assert.assertEquals(res.getStatusCode(),200);
}


@Test(priority=3)
public void deleteUser() {
	Response res=user_endpoints.deleteUser(u1.getUsername());
	Assert.assertEquals(res.getStatusCode(),200);
	
}

}
