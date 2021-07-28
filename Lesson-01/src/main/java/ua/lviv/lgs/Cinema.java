package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Cinema {
	TreeMap<Days, Schedule> schedules;
	ArrayList<Movie> moviesLibrary = new ArrayList<>(); 
	Time open;
	Time close;
	
	public Cinema(TreeMap<Days, Schedule> schedules, ArrayList<Movie> moviesLibrary, Time open, Time close) {
		super();
		this.schedules = schedules;
		this.moviesLibrary = moviesLibrary;
		this.open = open;
		this.close = close;
	}
	void addMovie(){
		System.out.println("Enter the movie name: ");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("Enter the hour movie durates: ");
		Scanner sc1 = new Scanner(System.in);
		Integer hour = sc1.nextInt();
		System.out.println("Enter the minutes movie durates: ");
		Scanner sc2 = new Scanner(System.in);
		Integer min = sc2.nextInt();
		Time duration = new Time(hour,min);
		Movie film = new Movie(name,duration);
		moviesLibrary.add(film);
	}
	void addSeance() {
		System.out.println("Enter the day: ");
		Scanner sc = new Scanner(System.in);
		String day = sc.nextLine();
		ArrayList<String> list = new ArrayList<>();
		list.add(Days.Monday.toString());
		list.add(Days.Tuesday.toString());
		list.add(Days.Wednesday.toString());
		list.add(Days.Thursday.toString());
		list.add(Days.Friday.toString());
		list.add(Days.Saturday.toString());
		list.add(Days.Sunday.toString());
		while(!list.contains(day)) {
			System.out.println("This day is incorrect!!!");
			Scanner sc7 = new Scanner(System.in);
			String daynew = sc7.nextLine();
			day = daynew;
		};
		System.out.println("Enter the movie name: ");
		Scanner sc1 = new Scanner(System.in);
		String name = sc1.nextLine();
		System.out.println("Enter the hour movie durates: ");
		Scanner sc2 = new Scanner(System.in);
		Integer hour1 = sc2.nextInt();
		System.out.println("Enter the minutes movie durates: ");
		Scanner sc3 = new Scanner(System.in);
		Integer min1 = sc3.nextInt();
		System.out.println("Enter the hour movie starts: ");
		Scanner sc4 = new Scanner(System.in);
		Integer hour = sc4.nextInt();
		while(hour + hour1 >= close.hour | hour < open.hour) {
			System.out.println("This movie start hour is incorrect!!!");
			Scanner sc5 = new Scanner(System.in);
			Integer hournew = sc5.nextInt();
			hour = hournew;
		}
		System.out.println("Enter the minutes movie starts: ");
		Scanner sc6 = new Scanner(System.in);
		Integer min = sc6.nextInt();
		Time start = new Time(hour,min);
		Time duration = new Time(hour1,min1);
		Movie film = new Movie(name,duration);
		Seance s = new Seance(film,start);
		Set<Seance> seance = new TreeSet<>();
		Schedule s1 = new Schedule(seance);
		seance.add(s);
		schedules.put(Days.valueOf(day), s1);
	}
	void removeMovie() {
		System.out.println("Enter the movie name: ");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		moviesLibrary.removeIf(n -> n.title.equalsIgnoreCase(name));
	}
	void removeSeance () {
		System.out.println("Enter the day: ");
		Scanner sc = new Scanner(System.in);
		String day = sc.nextLine();
		ArrayList<String> list = new ArrayList<>();
		list.add(Days.Monday.toString());
		list.add(Days.Tuesday.toString());
		list.add(Days.Wednesday.toString());
		list.add(Days.Thursday.toString());
		list.add(Days.Friday.toString());
		list.add(Days.Saturday.toString());
		list.add(Days.Sunday.toString());
		while(!list.contains(day)) {
			System.out.println("This day is incorrect!!!");
			Scanner sc7 = new Scanner(System.in);
			String daynew = sc7.nextLine();
			day = daynew;
		};
		System.out.println("Enter the Seance name: ");
		Scanner sc1 = new Scanner(System.in);
		String name = sc1.nextLine();
		
		schedules.remove(Days.valueOf(day));
		
			
	
	}
	@Override
	public String toString() {
		return "Cinema [schedules=" + schedules + ", moviesLibrary=" + moviesLibrary + ", open=" + open + ", close="
				+ close + "]";
	}
	
}

