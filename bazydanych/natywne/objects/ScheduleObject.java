package pl.wroc.pwr.na.database.objects;

public class ScheduleObject {
	public int id;
	public String time;
	public String title;
	public String place;
	public String lecturer;
	public String type;
	public String date;
	public int day;
	public int week;
	public int startHour;

	public ScheduleObject(String type, String date) {
		this.type = type;
		this.date = date;
	}

	/***/
	public ScheduleObject(int id, String time, String title, String place,
			String lecturer, String type, int day, int week, int startHour) {
		this.id = id;
		this.time = time;
		this.title = title;
		this.place = place;
		this.lecturer = lecturer;
		this.type = type;
		this.day = day;
		this.week = week;
		this.startHour = startHour;
	}
}
