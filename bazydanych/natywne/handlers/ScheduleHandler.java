package pl.wroc.pwr.na.database.handlers;

import java.util.ArrayList;
import java.util.List;

import pl.wroc.pwr.na.database.objects.ScheduleObject;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ScheduleHandler {
	/***/
	public static final String TABLE_NAME = "Schedule";

	private static final String KEY_ID = "scheduleId";
	private static final String KEY_TIME = "scheduleTime";
	private static final String KEY_PLACE = "schedulePlace";
	private static final String KEY_TITLE = "scheduleTitle";
	private static final String KEY_LECTURER = "scheduleLecturer";
	private static final String KEY_TYPE = "scheduleType";
	private static final String KEY_DAY = "scheduleDay";
	private static final String KEY_WEEK = "scheduleWeek";
	private static final String KEY_START_HOUR = "scheduleStartHour";

	/***/
	public static String getCreateSQL() {
		return "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + KEY_ID
				+ " INTEGER PRIMARY KEY," + KEY_TIME + " TEXT," + KEY_PLACE
				+ " TEXT," + KEY_TITLE + " TEXT," + KEY_LECTURER + " TEXT,"
				+ KEY_TYPE + " TEXT," + KEY_DAY + " INTEGER," + KEY_WEEK
				+ " INTEGER," + KEY_START_HOUR + " INTEGER)";
	}

	/***/
	public static void addScheduleObject(ScheduleObject object,
			SQLiteDatabase db) {
		ContentValues values = new ContentValues();
		values.put(KEY_TIME, object.time);
		values.put(KEY_PLACE, object.place);
		values.put(KEY_TITLE, object.title);
		values.put(KEY_LECTURER, object.lecturer);
		values.put(KEY_TYPE, object.type);
		values.put(KEY_DAY, object.day);
		values.put(KEY_WEEK, object.week);
		values.put(KEY_START_HOUR, object.startHour);

		// Inserting Row
		db.insert(TABLE_NAME, null, values);
		db.close(); // Closing database connection
	}

	/***/
	public static List<ScheduleObject> getAllScheduleObjects(SQLiteDatabase db) {
		String selectQuery = "SELECT  * FROM " + TABLE_NAME;
		Cursor cursor = db.rawQuery(selectQuery, null);

		return getAll(cursor);
	}

	private static List<ScheduleObject> getAll(Cursor cursor) {
		List<ScheduleObject> scheduleList = new ArrayList<ScheduleObject>();

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				scheduleList.add(get(cursor));
			} while (cursor.moveToNext());
		}

		return scheduleList;
	}

	private static ScheduleObject get(Cursor cursor) {
		if (cursor != null) {
			if (cursor.getCount() > 0) { // sa pobrane rekordy, zapisane w
											// cursor

				int id = Integer.parseInt(cursor.getString(0));
				String time = cursor.getString(1);
				String place = cursor.getString(2);
				String title = cursor.getString(3);
				String lecturer = cursor.getString(4);
				String type = cursor.getString(5);
				int day = cursor.getInt(6);
				int week = cursor.getInt(7);
				int startHour = cursor.getInt(8);

				return new ScheduleObject(id, time, place, title, lecturer,
						type, day, week, startHour);
			}
		}

		return null;
	}
}
