package lab9;

import java.util.Queue;
import java.util.Random;

public class DynamicKitchen implements Runnable{
	
	int mealStock = 175, mealRate = 6;
	boolean underStock;
	int guestsServed, income;
	Queue<Guest> guestQ;
	
	DynamicKitchen (Queue<Guest> guestQ) {
		this.guestQ = guestQ;
	}

	@Override
	public void run() {
		//write your code here
		
		Guest guest;
		Random rand = new Random();
		
		while (DynamicDiner.dinerOpen && !underStock) {
			synchronized (guestQ) {
				guest = guestQ.poll();
			}
			
			
			if (guest != null) {
				guest.placeOrder();
				
				
				if (guest instanceof Individual) {
					mealStock-=1;
					income+=mealRate;
				}
				else {
					mealStock-=4;
					income+=mealRate*4;
				}
				guestsServed++;
				try {
					Thread.sleep(rand.nextInt(20)+5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (mealStock <=4)
				underStock = true;
		}
		
		
		
		
	}
}
