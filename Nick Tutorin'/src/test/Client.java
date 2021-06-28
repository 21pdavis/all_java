package test;

import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Musician[] band = new Musician[4];
		for(int i = 0; i < 4; i++) {
			band[i] = new Drummer("Bartholomew");
		}
//		Musician musician = new Musician("Clyde");
//		Drummer drummer = new Drummer("Zack");
		
		System.out.println(band[0].play());
		System.out.println(band[1].play());
		System.out.println(band[2].play());
		System.out.println(band[3].play());
	}
}
