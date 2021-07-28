package ua.lviv.lgs;

import java.util.function.Function;

public class Seance implements Comparable{
	Movie movie;
	Time startTime;
	Time endTime;
	public Seance(Movie movie, Time startTime) {
		super();
		this.movie = movie;
		this.startTime = startTime;
		this.endTime = add(startTime, movie.duration);
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "Seance [" + movie + ", startTime = " + startTime + ", endTime = " + endTime + "]";
	}
	public static Time add(Time obj1, Time obj2) {
		Time obj3 = new Time(1,1);
		CustomInterfaseImpl ci = new CustomInterfaseImpl();
		Function<Integer,Integer> func1 = p -> p + obj2.hour;
		Function<Integer,Integer> func2 = p -> p + obj2.min;
		Integer result1 = ci.use(obj1.hour,func1);
		Integer result2 = ci.use(obj1.min,func2);
		if (result2 >= 60) {
			result1 = result1 + 1;
			result2 = result2 - 60;
		}
		if (result1 >=24) {
			result1 = 0;
		}
		obj3.setHour(result1);
		obj3.setMin(result2);
		return obj3;
	}
	public int compareTo(Seance o) {
		return this.movie.title.compareTo(o.movie.getTitle());
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
class CustomInterfaseImpl {
	public Integer use(int hour,Function<Integer,Integer> fn) {
		return fn.apply(hour);
	}
}
