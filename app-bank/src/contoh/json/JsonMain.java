package contoh.json;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonMain {
	private static final String URL = "http://localhost/example.json";
	static ParsingJson parser = null;
	
	public static JSONObject getObject() {
		JSONObject json = null;
	try {
		json = parser.getJSONFromUrl(URL);
	} catch (Exception e) {
		System.out.println(e);
	}
	return json;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println("DATA");
		//deklarasi JSONObject jsonObj yang mendapat data dari method jsonObj
			JSONObject jsonObj = getObject();
		//deklarasi array contacts dari objek jsonObj
			
			JSONArray contacts = jsonObj.getJSONArray("contacts");
					
		//mengambil data dari array contacts
		for (int i = 0; i < contacts.length(); i++) {
			JSONObject c = contacts.getJSONObject(i);
			String id = c.getString("id");
			String name = c.getString("name");
			String email = c.getString("email");
			String address = c.getString("address");
			String gender = c.getString("gender");
			
			//deklarasi object phone dari array contact
			JSONObject phone = c.getJSONObject("phone");
			
			//mengambil data dari array phone
			String mobile = phone.getString("mobile");
			String home = phone.getString("home");
			String office = phone.getString("office");
			
			//mencetak data 
			System.out.println("ID       : " + id);
			System.out.println("Name     : " + name);
			System.out.println("gender   : " + gender);
			System.out.println("Address  : " + address);
			System.out.println("Email    : " + email);
			System.out.println("PHONE");
			System.out.println("-mobile  : " + mobile);
			System.out.println("Home     : " + home);
			System.out.println("office   : " + office);
			System.out.println("----------------------");
		}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
