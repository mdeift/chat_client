
public class UserOperations {

	Server server;
	
	UserOperations(Server server) {
		this.server = server;
	}
	
	public int addUser(User user) {
		return REST_API.PUT(server.getUrlUsers(), user.toJSON());
	}
	
	public int removeUser(User user) {
		return REST_API.DELETE(server.getUrlUsers(), user.toJSON());
	}
}
