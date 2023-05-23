
public class Calculator {
	
	private String name;
	
	public Calculator() {}
	
	public Calculator(String name) {
		this.name = name;
	}
	
	public int add(int x, int y) {
		if (x > 0 && y > 0 && x + y < x && x + y < y)
			return Integer.MAX_VALUE;
		else
			return x + y;
	}
	
	public int subtract(int x, int y) {
		return x - y;
	}
	
	public int multiply(int x, int y) {
		return x * y;
	}
	
	public int divide(int x, int y) {
		return x / y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
