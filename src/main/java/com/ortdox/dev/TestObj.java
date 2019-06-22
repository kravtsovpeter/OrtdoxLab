
package com.ortdox.dev;

public class TestObj {
	
	private String firstName;
	
	private String lastName;
	
	public TestObj(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
	

}
