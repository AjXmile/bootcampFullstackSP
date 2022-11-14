package tutorial;

import java.util.List;

public class Challenge1 {

	public String randomNumber(String type) {
		String result = "";
		
		if (type.equalsIgnoreCase("Tipo A")) {
			result = "54";
		}else {
			result = "08"; 
		}
		
		for( int i= 0; i <= 7; i++) {
			int int_random = (int) (Math.random()*10);
			result += int_random;
		}
		
		
		return result ;
	}
	
	public boolean stringList(String type, List<String> list) {
		
		boolean result = true;
		
		for(String s: list) {
			if(s.equals(type)) {
				result = false;
				break;
			} 
		}
				
		return result;
	}  
}
