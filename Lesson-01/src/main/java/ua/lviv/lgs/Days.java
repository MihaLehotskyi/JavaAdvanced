package ua.lviv.lgs;

public enum Days {
	Monday("Monday"), Tuesday("Tuesday"), Wednesday("Wednesday"), Thursday("Thursday"), Friday("Friday"), Saturday("Saturday"), Sunday("Sunday");
	private String string;
	Days(String string) {
		this.string = string;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	
}