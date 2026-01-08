package api.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileNotFoundException;
import org.json.JSONObject;
import api.endpoint.user_endpoints;
import api.utility.readJsonFile;
import io.restassured.response.Response;

public class clearingValidation {	
	public Logger log = LogManager.getLogger(clearingValidation.class);

	
	@Test(priority=0,dataProviderClass=api.utility.DataProviders.class,dataProvider="clearingData")
	public void createUser(String authpath, String clearingpath) throws FileNotFoundException {
		log.info("***************creating user***************");
	
		JSONObject authData =readJsonFile.userJsonFile("./testdata/auth.json");
		JSONObject clearingData =readJsonFile.userJsonFile("./testdata/clearing.json");
	
		Response res=user_endpoints.createUser(authData);
		res.then().log().all();
		SoftAssert Ass = new SoftAssert();
		Ass.assertEquals(res.jsonPath().get(authpath), clearingData.get(clearingpath));
		Ass.assertAll();
		log.info(res.then().log().all());
		log.info("***************created user***************");
		//logs
		
	}
	

}
