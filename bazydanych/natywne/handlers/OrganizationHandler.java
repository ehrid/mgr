package pl.wroc.pwr.na.database.handlers;

import pl.wroc.pwr.na.database.objects.OrganizationObject;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class OrganizationHandler {
	/***/
	public static final String TABLE_NAME = "Organizacje";

	private static final String KEY_ID = "organizacjaId";

	private static final String KEY_FULL_NAME = "organizacjaPelnaNazwa";
	private static final String KEY_SCREEN_NAME = "uzytkownikNazwaWyswietlana";
	private static final String KEY_AVATAR = "avatarPlik";

	/***/
	public static String getCreateSQL() {
		return "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + KEY_ID
				+ " INTEGER," + KEY_FULL_NAME + " TEXT," + KEY_SCREEN_NAME
				+ " TEXT," + KEY_AVATAR + " INTEGER )";
	}

	/**
	 * Adding new page
	 */
	public static void addOrganizationObject(OrganizationObject object,
			SQLiteDatabase db) {
		ContentValues values = new ContentValues();
		values.put(KEY_ID, object.organizacjaId);
		values.put(KEY_FULL_NAME, object.organizacjaPelnaNazwa);
		values.put(KEY_SCREEN_NAME, object.uzytkownikNazwaWyswietlana);
		values.put(KEY_AVATAR, object.avatarPlik);

		// Inserting Row
		db.insert(TABLE_NAME, null, values);
		db.close(); // Closing database connection
	}

	/***/
	public static OrganizationObject getOrganizationObject(int organizacjaId,
			SQLiteDatabase db) {
		String[] values = new String[] { KEY_ID, KEY_FULL_NAME, KEY_SCREEN_NAME };
		String where = KEY_ID + "=?"; // argument WHERE dla SQL
		String[] whatValue = new String[] { String.valueOf(organizacjaId) };
		Cursor cursor = db.query(TABLE_NAME, values, where, whatValue, null,
				null, null, null);

		return get(cursor);
	}

	private static OrganizationObject get(Cursor cursor) {
		if (cursor != null) { // zapytanie bylo prawidlowe
			cursor.moveToFirst();

			if (cursor.getCount() > 0) { // sa pobrane rekordy, zapisane w
											// cursor

				int organizacjaId = Integer.parseInt(cursor.getString(0)); // KEY_ID=0,
																			// KEY_FULL_NAME=1,
																			// KEY_SCREEN_NAME=2
				String organizacjaPelnaNazwa = cursor.getString(1);
				String uzytkownikNazwaWyswietlana = cursor.getString(2);
				String avatarPlik = cursor.getString(3);

				// String uzytkownikNazwaWyswietlana, int organizacjaId, String
				// organizacjaPelnaNazwa

				return new OrganizationObject(organizacjaId,
						organizacjaPelnaNazwa, uzytkownikNazwaWyswietlana,
						avatarPlik);
			}
		}

		return null;
	}
}
