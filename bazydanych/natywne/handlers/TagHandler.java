package pl.wroc.pwr.na.database.handlers;

import pl.wroc.pwr.na.database.objects.TagObject;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TagHandler {
	/***/
	public static final String TABLE_NAME = "Tagi";

	private static final String KEY_ID = "tagId";
	private static final String KEY_NAZWA = "tagNazwa";

	/***/
	public static String getCreateSQL() {
		return "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + KEY_ID
				+ " INTEGER PRIMARY KEY," + KEY_NAZWA + " TEXT)";
	}

	/***/
	public static void addTagObject(TagObject object, SQLiteDatabase db) {
		ContentValues values = new ContentValues();
		values.put(KEY_ID, object.tagId);
		values.put(KEY_NAZWA, object.tagNazwa);

		// Inserting Row
		db.insert(TABLE_NAME, null, values);
		db.close(); // Closing database connection
	}

	/***/
	public static TagObject getTagObject(int tagId, SQLiteDatabase db) {
		String[] values = new String[] { KEY_ID, KEY_NAZWA };
		String where = KEY_ID + "=?"; // argument WHERE dla SQL
		String[] whatValue = new String[] { String.valueOf(tagId) };
		Cursor cursor = db.query(TABLE_NAME, values, where, whatValue, null,
				null, null, null);

		return get(cursor);
	}

	private static TagObject get(Cursor cursor) {
		if (cursor != null) {
			cursor.moveToFirst();

			if (cursor.getCount() > 0) { // sa pobrane rekordy, zapisane w
											// cursor

				int tagId = Integer.parseInt(cursor.getString(0));
				String tagNazwa = cursor.getString(1);

				return new TagObject(tagId, tagNazwa);
			}
		}

		return null;
	}
}
