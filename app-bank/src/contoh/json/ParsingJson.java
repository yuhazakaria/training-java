package contoh.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

public class ParsingJson {
	static InputStream is = null;
	static JSONObject jObj = null;
	static String json = "";
	
	public ParsingJson() {
		
	}
	
	public JSONObject getJSONFromUrl(String url) {
		//http request
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);
			
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			is = httpEntity.getContent();
		} catch (UnsupportedEncodingException | ClientProtocolException e) {
			
		} catch (IOException e) {
			//TODO : handle exception
			e.printStackTrace();
		}
		
		try {
			BufferedReader reader = new BufferedReader (new InputStreamReader(is, "iso-8859-1"), 8);
			StringBuilder sb =new StringBuilder();
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				sb.append(line).append("\n");
			}
			
			is.close();
			json = sb.toString();
		
		} catch (Exception e) {
			//TODO: handle exception	
				System.out.println("Error");
		}
		
		//try parse string to json 
		try {
			jObj = new JSONObject(json);
		} catch (JSONException e) {
			//TODO: handle exception
				System.out.println("Error");
		}
		return jObj;
	}
}
