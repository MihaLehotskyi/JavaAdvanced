package ua.lviv.lgs;

public class Time {
	int min;
	int hour;
	public Time(int hour, int min) {
		super();
		if(min > 60 & min < 0 | min > 60 | min < 0) {
			System.out.println("Minutes are incorrect");
		} else {
		this.min = min;}
		if(hour > 24 & hour < 0 | hour > 24 | hour < 0) {
			System.out.println("Hours are incorrect");
		} else {
		this.hour = hour;}
	}
	
	@Override
	public String toString() {
		return "Time ["+ hour +":" + min + "]";
	}

	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}

}
	

