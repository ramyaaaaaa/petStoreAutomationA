package api.endpoint;
/*
Swagger URI --> https://petstore.swagger.io

Create user (Post) : https://petstore.swagger.io/v2/user
Get user (Get) : https://petstore.swagger.io/v2/user/{username}
Update user (Put) : https://petstore.swagger.io/v2/user/{username}
Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}
*/
//v2/user is endpoint uri--is domain together is url
public class routes {
	public static String base_url="https://petstore.swagger.io/v2";
	//public to access from anywhere ands static to access without creating object
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/";
	public static String update_url=base_url+"/user/";
	public static String delete_url=base_url+"/user/";
}
