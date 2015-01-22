package pl.wroc.pwr.na.database.objects;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class ScheduleObject {

	@DatabaseField(generatedId = true)
	public int id;

	@DatabaseField
	public String time;

	@DatabaseField
	public String title;

	@DatabaseField
	public String place;

	@DatabaseField
	public String lecturer;

	@DatabaseField
	public String type;

	@DatabaseField
	public String date;

	@DatabaseField
	public int day;

	@DatabaseField
	public int week;

	@DatabaseField
	public int startHour;

	public ScheduleObject() {
	}

	public ScheduleObject(String type, String date) {
		this.type = type;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getStartHour() {
		return startHour;
	}

	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}

}
