package numbers;

public class Numbers {

	private static Numbers instance;
	private boolean numbers[] = {true,true,true,true,true,true,true,true,true};
	
	private Numbers() {}
	
	public static Numbers getIstance() {
		if(instance == null)
			instance = new Numbers();
		return instance;
	}

	public void clear() {
		for(int i = 0; i<9; i++){
			numbers[i] = true;
		}
	}

	public int take(int i) throws IllegalArgumentException{
		//Wrong index
		if(i<1 || i>9)
			throw new IllegalArgumentException("The number " + i + " does not exist");
		
		//Number already taken
		if(numbers[i-1] == false)
			throw new IllegalArgumentException("Number already taken");
		
		//Set the number as taken
		numbers[i-1] = false;
		return i;		
	}
	
	public boolean isNumberAllTaken(){
		for(boolean numberNotTaken: numbers){
			if(numberNotTaken == true){
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isNotNumberAllTaken(){
		for(boolean numberNotTaken: numbers){
			if(numberNotTaken == true){
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return numbers.toString();
	}
	
}
