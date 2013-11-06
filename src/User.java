import org.json.JSONObject;
import org.json.JSONException;

public class User {
	
	String name;
	int age;
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		
		try {
			json.put("name", name);
			json.put("age", age);
		}
		catch (JSONException e) {
			// do nothing
		}		
		return json;		
	}

}
