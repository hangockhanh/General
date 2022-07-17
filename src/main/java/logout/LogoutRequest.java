package logout;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import API.API;


public class LogoutRequest {
    public LogoutClass logout;
	public LogoutRequest(String access_token) throws MalformedURLException, ProtocolException, IOException {
	    URL url = new URL(API.logout);
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	    connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Bearer" + access_token);
        

	    try {

	        StringBuilder content;

	        try (BufferedReader in = new BufferedReader(
	                new InputStreamReader(connection.getInputStream()))) {
	        String line;
	        content = new StringBuilder();
	            while ((line = in.readLine()) != null) {
	                content.append(line);
	                content.append(System.lineSeparator());
	            }
	        }
	        // System.out.println(content.toString());
	        
	        Gson g = new Gson(); 
	        logout = g.fromJson(content.toString(), LogoutClass.class);
	    } finally {
	        connection.disconnect();
	    }
	}   
	public String getCode(){
		return logout.code;
	}
	public String getMessage(){
		return logout.message;
	}
	public Data getData(){
		return logout.data;
	}
}