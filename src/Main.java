import java.net.MalformedURLException;
import java.net.URL;

public class Main {

	public static void main(String [] args) throws MalformedURLException {
		
		// Initialize constants
		String usersPage = new String("_user/");
		String messagesPage = new String("_message/");
		URL serverURL = new URL("http://localhost:8080/");
		
		// Initialize URLs
		URL usersURL = new URL(serverURL, usersPage);
		URL messagesURL = new URL(serverURL, messagesPage);
		
		// Initialize main parts
		Server server = new Server(usersURL, messagesURL);		
		UserOperations user_ops = new UserOperations(server);
		MessageOperations message_ops = new MessageOperations(server); 
		
		
		User user1 = new User("Name1", 21);
		User user2 = new User("Name2", 22);
		User user3 = new User("Name3", 23);
		
		int rc;
		//rc = user_ops.addUser(user1);
		//System.out.println("rc = " + rc);
		//rc = user_ops.addUser(user2);
		//System.out.println("rc = " + rc);
		//rc = user_ops.addUser(user3);
		//System.out.println("rc = " + rc);
		
		Message msg1 = new Message(user1.getName(), user2.getName(), "Hello4");
		rc = message_ops.sendMessage(msg1);
		System.out.println("rc = " + rc);
		
		Message msg2 = message_ops.receiveMessage(user2);
		System.out.println("Received message" + msg2.toJSON().toString());
		
	}
}
