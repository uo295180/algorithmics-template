package algstudent.s6;

public class Number {
	
	static int MAX_VALUE = 9;
	
	int value;
	boolean inmutable;
	
	public Number(int value, boolean inmutable){
		setValue(value);
		this.inmutable = inmutable;
	}
	
	public Number() {
		this.value = 0;
		this.inmutable = false;
	}
	
	public int getValue() {
		return value;
	}
	
	public boolean isInmutable() {
		return inmutable;
	}
	
	public void increase() {
		if(value == MAX_VALUE) value = 0; 
		else value++;
	}
	
	public void setValue(int value) {
		if(value > MAX_VALUE || value < 0) throw new IllegalArgumentException("Invalid value for the number");
		this.value = value;
	}
}
