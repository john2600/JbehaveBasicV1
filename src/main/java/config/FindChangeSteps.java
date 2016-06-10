package config;


import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import static org.junit.Assert.*;

import java.util.List;


public class FindChangeSteps extends FindChanges {

	private ChangeMachine cm;
	List<Integer> change;
	Exception error;
	
	
	@Given("a change machine")
	public void createChangeMachine(){
		cm = new ChangeMachine();
		error = null;
	}
	
	@When("I ask for change for <value>")
	@Alias("I ask for change of $value")
	public void changeFor(@Named("value") double value){
		try{
			change = cm.getCointsForChangeOf(value);
		}catch(Exception  err){
			error = err;
		}
	}

	@Then("it returns the <coin> coins")
	@Alias("it returns the $coin coins")
	public void changeCoins(@Named("coin") String coins){
		String expected ="";
		for(int i=0; i<change.size(); i++){
			expected +=change.get(i)+"c";
			if(i<change.size()-1){
				expected += ",";
			}
		}
		assertEquals(coins,expected);
	}
	
	@Then("it will raise an error")
	public void thenItWillRaiseAnError(){
		assertNotNull(error);
	}
	
	

	
	
	
}
