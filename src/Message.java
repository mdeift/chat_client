import org.json.JSONObject;
import org.json.JSONException;

public class Message {
	
	String from;
	String to;
	String time;
	String payload;
	
	public Message() {
		// Default constructor
	}
	
	public Message(String from, String to, String payload) {
		this.from = from;
		this.to = to;
		this.payload = payload;
	}
	
	public Message(JSONObject json) {
		try {
			this.from = json.getString("From");
			this.to = json.getString("To");
			this.time = json.getString("Time");
			this.payload = json.getString("Payload");
		}
		catch (JSONException e) {
			// do nothing
		}
	}
	
	public String getFrom() {
		return from;
	}
	
	public String getTo() {
		return to;
	}

	public String getPayload() {
		return payload;
	}
	
	public String getTime() {
		return time;
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		
		try {
			json.put("From", from);
			json.put("To", to);
			json.put("Time", time);
			json.put("Payload", payload);
		}
		catch (JSONException e) {
			// do nothing
		}		
		return json;
	}
}
