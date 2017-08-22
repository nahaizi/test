package reflact;

public class Car {
	private String brant;
	private String color;
	private int maxSpeed;
	private int a;

	public String getBrant() {
		return brant;
	}

	public void setBrant(String brant) {
		this.brant = brant;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public Car() {
	}

	public Car(String brant, String color, int max) {
		this.brant = brant;
		this.color = color;
		this.maxSpeed = max;

	}

	public String toString() {
		String a = brant + color + maxSpeed;
		return a;
	}

	public void print() {
		System.out.println(brant + color + maxSpeed + a);
	}
}
