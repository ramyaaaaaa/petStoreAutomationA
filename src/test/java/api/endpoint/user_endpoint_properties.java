	package api.endpoint;
	import  io.restassured.response.Response;
	import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;

public class user_endpoint_properties {
	
	//to load property class via report bundle class and to get url from property file
	static ResourceBundle getUrl(){
		ResourceBundle r=ResourceBundle.getBundle("route");
		//route is name of property file, no need to specify path as by default if will check in 
		//resource folder
		return r;
		
	} 

		public static Response createUser(User body) {
			Response res;		
			res=given().accept("application/json").contentType("application/json").
					body(body).
					when().post(getUrl().getString("post_url"));
			return res;	
				}		
		
		public static Response readUser(String userName) {
			
			Response res;		
			res=given().accept("application/json").pathParam("user", userName).
					when().
					// get(routes.get_url + "{user}");
					get(getUrl().getString("get_url"));
			return res;	
				}
			

	public static Response updateUser(User body,String userName) {
		Response res;		
		res=given().accept("application/json").contentType("application/json").pathParam("user", userName).
				body(body).
				when().
				//put(routes.update_url+"{user}");
				put(getUrl().getString("update_url"));
		return res;
			}
		

	public static Response deleteUser(String userName) {

	    return given()
	            .accept("application/json")
	            .pathParam("username", userName)
	    .when()
	            .delete(getUrl().getString("delete_url"));
	}
	}
