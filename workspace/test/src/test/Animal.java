package test;

public class Animal {

	String sound;
	
	public Animal(String sound) {
		this.sound = sound;
	}
	
	public void makeSound(int repeat) {
		for (int i = 0; i < repeat; i++) {
			System.out.println(sound);
		}
	}
	
	public static void main(String[] args) {
		
		String code = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*";
		
		
		
		String new_pw = "";
		for (int i = 0; i < 12; i++) {
			new_pw += code.charAt((int)(Math.random()*code.length()));
		}
		
		System.out.println(new_pw);
		
	}
	
}
