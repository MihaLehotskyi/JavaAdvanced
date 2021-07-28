package ua.lviv.lgs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

	static void menu() {
		System.out.println("Press 1 to add Movie");
		System.out.println("Press 2 to add Seance");
		System.out.println("Press 3 to delete Movie");
		System.out.println("Press 4 to delete Seance");
		System.out.println("Press 5 to show");
	}

	public static void main(String[] args) {

		Cinema c = new Cinema(new TreeMap<Days, Schedule>(), new ArrayList<Movie>(),new Time(10,0),new Time(23,0));

		Scanner sc = new Scanner(System.in);

		while (true) {
			menu();
			switch (sc.next()) {
			case "1": {
				c.addMovie();
			}
				break;
			case "2": {
				c.addSeance();
			}
				break;

			case "3": {
				c.removeMovie();
			}
				break;
			case "4": {
				c.removeSeance();
			}
				break;
			case "5": {
				System.out.println(c);
			}
				break;

			}
		}
	}
}