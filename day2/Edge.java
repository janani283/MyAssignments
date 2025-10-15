package week3.day2;

public class Edge extends Chrome{
	
	public void takeSnap() {
		System.out.println("Take Snap");
	}

	public void clearCookies() {
		System.out.println("Cookies cleared");
	}
	public static void main(String[] args) {
		
		Edge edge = new Edge();
		edge.takeSnap();
		edge.clearCookies();
		edge.navigateBack();
		edge.openURL();
		edge.openCognito();
		edge.clearCache();
		edge.clearCookies();
		edge.browserName="Edge";
		edge.browserVersion="10";
		
		
		System.out.println("The browsername is : "+edge.browserName);
		System.out.println("The browsername is : "+edge.browserVersion);
		

	}

}
