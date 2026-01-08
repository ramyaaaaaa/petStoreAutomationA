package api.endpoint;
import  io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.io.File;

import org.json.JSONObject;

import api.payload.User;

public class user_endpoints {

	public static Response createUser(User body) {
		Response res;		
		res=given().accept("application/json").contentType("application/json").
				body(body).
				when().post(routes.post_url);
		return res;	
			}		
	
	public static Response readUser(String userName) {
		Response res;		
		res=given().accept("application/json").pathParam("user", userName).
				when().
				 get(routes.get_url + "{user}");
			
		return res;	
			}
		

public static Response updateUser(User body,String userName) {
	Response res;		
	res=given().accept("application/json").contentType("application/json").pathParam("user", userName).
			body(body).
			when().put(routes.update_url+"{user}");
	return res;
		}
	

public static Response deleteUser(String userName) {
	Response res;		
	res=given().accept("application/json").pathParam("user", userName).
			when().delete(routes.delete_url+"{user}");
	return res;	
		}

public static Response createUser(JSONObject body) {
	Response res;		
	res=given().accept("application/json").contentType("application/json").
			body(body).
			when().post(routes.post_url);
	return res;	
		}
}