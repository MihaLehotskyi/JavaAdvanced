package ua.lviv.lgs;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Schedule {
	Set<Seance> seances = new TreeSet<>();
	
	public Set<Seance> getSeances() {
		return seances;
	}
	public void setSeances(Set<Seance> seances) {
		this.seances = seances;
	}
	
	public Schedule(Set<Seance> seances) {
		super();
		this.seances = seances;
	}
	@Override
	public String toString() {
		return "Schedule [seances=" + seances + "]";
	}
	void addSeance(){
		System.out.println("Enter the movie name: ");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("Enter the hours movie starts: ");
		Scanner sc1 = new Scanner(System.in);
		Integer hour = sc1.nextInt();
		System.out.println("Enter the minutes movie starts: ");
		Scanner sc2 = new Scanner(System.in);
		Integer min = sc2.nextInt();
		System.out.println("Enter the hours movie durates: ");
		Scanner sc3 = new Scanner(System.in);
		Integer hour1 = sc3.nextInt();
		System.out.println("Enter the minutes movie durates: ");
		Scanner sc4 = new Scanner(System.in);
		Integer min1 = sc4.nextInt();
		Time start = new Time(hour,min);
		Time duration = new Time(hour1,min1);
		Movie film = new Movie(name,duration);
		seances.add(new Seance(film,start));
	}
	void removeSeance(Integer index) {
		seances.remove(index);
	}
}
