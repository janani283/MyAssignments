package week3.day3homeassignments;

public class JavaConnection implements DatabaseConnection {

	@Override
	public void connect() {
		System.out.println("Connect to DataBase");
		
	}

	@Override
	public void disconnect() {
		System.out.println("DisConnect from DataBase");
		
	}

	@Override
	public void executeUpdate() {
		System.out.println("Execute in DataBase");
		
	}
	
	public void closeDB() {
		System.out.println("The DataBase is closed");
	}

	public static void main(String[] args) {
		
		JavaConnection call = new JavaConnection();
		call.connect();
		call.disconnect();
		call.executeUpdate();
		call.closeDB();

	}

}
