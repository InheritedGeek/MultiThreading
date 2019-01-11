package lab9;

public class Group extends Guest {
	
	static int groupsServed;
	
	@Override
	void placeOrder() {
		groupsServed++;
	}
}
