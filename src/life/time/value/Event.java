package life.time.value;
import net.sf.json.JSONObject;

public class Event {
	
	private JSONObject jsonObject;

	public Event(JSONObject jsonObject){
		this.jsonObject = jsonObject;
	}

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}
	
	
}
