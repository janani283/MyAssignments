package week3.day2;

public class APIClient {
	
	public void sendRequest(String endpoint) {
		
		System.out.println("The endpoint is : "+endpoint);
	}
	
	public void sendRequest(String endpoint, String requestbody, boolean requeststatus) {
		
		System.out.println("The endpoint is : "+endpoint);
		System.out.println("The requestbody is : "+requestbody);
		System.out.println("The requeststatus is : "+requeststatus);
	}

	public static void main(String[] args) {
		
		APIClient client = new APIClient();
		client.sendRequest("100");
		client.sendRequest("50", "span", true);

	}

}
