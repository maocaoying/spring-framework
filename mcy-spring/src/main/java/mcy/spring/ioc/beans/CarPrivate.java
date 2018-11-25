package mcy.spring.ioc.beans;

public class CarPrivate {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;

	protected void drive() {
		System.out.println("driver private car ,the name is "+name);
	}

}
