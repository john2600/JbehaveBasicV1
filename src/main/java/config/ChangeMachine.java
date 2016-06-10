package config;

import java.util.ArrayList;
import java.util.List;

public class ChangeMachine {
	private final int[] coinType={50,25,10,5,1};

	public List<Integer> getCointsForChangeOf(double value) {
		if(value>=1 || value<=0){
			throw new RuntimeException();
		}
		int ammountOfCents = (int) (value*100);
		List<Integer> list = new ArrayList<Integer>();
		for(int coin:coinType){
			while(ammountOfCents >= coin){
				ammountOfCents-= coin;
				list.add(coin);
			}
		}
			
		return list;
	}

}
