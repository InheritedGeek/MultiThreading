package lab9;

public class Individual extends Guest {
	
	static int individualsServed;
	
	@Override
	void placeOrder() {
		individualsServed++;
	}

}
