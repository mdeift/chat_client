import java.net.URL;

public class Server {

	URL urlUsers;
	URL urlMessages;
	
	Server(URL users, URL messages) {
		this.urlUsers = users;
		this.urlMessages = messages;
	}
	
	URL getUrlUsers() {
		return this.urlUsers;
	}
	
	URL getUrlMessages() {
		return this.urlMessages;
	}
	
	void setUrlUsers(URL users) {
		this.urlUsers = users;
	}	
	
	void setUrlMessages(URL messages) {
		this.urlMessages = messages;
	}
}
