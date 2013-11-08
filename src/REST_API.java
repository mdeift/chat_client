import java.net.URL;
import org.json.JSONObject;
import org.json.JSONException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

public class REST_API {
		
	public static int PUT(URL url, JSONObject obj) {
		
		try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Content-Type", "application/json");
			 
			OutputStream os = conn.getOutputStream();
			os.write(obj.toString().getBytes());
			os.flush();
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}	
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));			
	 
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
	 
			conn.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static JSONObject GET(URL url) throws JSONException {
		
		String output = new String();
		try {			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
	 
			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
	 
			System.out.println("Output from Server .... \n");
			String tmp = new String();
			while ( (tmp = br.readLine()) != null) {
				System.out.println(tmp);
				output += tmp;
			}
			 
			conn.disconnect();
 
		} catch (MalformedURLException e) {
			e.printStackTrace();
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JSONObject json = new JSONObject(output);
		return json;
	}
	
	public static int POST(URL url, JSONObject obj) {
		try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			 
			OutputStream os = conn.getOutputStream();
			os.write(obj.toString().getBytes());
			os.flush();
			
			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}	
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
	 
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
	 
			conn.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int DELETE(URL url, JSONObject obj) {
		try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("DELETE");
			conn.setRequestProperty("Content-Type", "application/json");
			 
			OutputStream os = conn.getOutputStream();
			os.write(obj.toString().getBytes());
			os.flush();
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}	
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
	 
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
	 
			conn.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}   

}
