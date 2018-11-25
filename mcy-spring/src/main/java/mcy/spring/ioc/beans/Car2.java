package mcy.spring.ioc.beans;

public class Car2 {

	public Car2(String brand, String color, int speed) {
		this.brand = brand;
		this.color = color;
		this.speed = speed;
	}

	private String brand;
	private String color;
	private int speed;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void info() {
		System.out.println("brand:"+brand+" color:"+color+" speed:"+speed);
	}
}
