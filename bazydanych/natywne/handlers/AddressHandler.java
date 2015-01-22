package pl.wroc.pwr.na.database.handlers;

import pl.wroc.pwr.na.database.objects.AddressObject;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class AddressHandler {
	/***/
	public static final String TABLE_NAME = "Adresy";

	private static final String KEY_ID = "adresId";

	private static final String KEY_ULICA = "adresUlica";
	private static final String KEY_BUDYNEK = "adresBudynek";
	private static final String KEY_MIASTO = "adresMiasto";
	private static final String KEY_STRONA_WWW = "adresStronaWww";
	private static final String KEY_KATEGORIA = "adresKategoria";

	/***/
	public static String getCreateSQL() {
		return "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + KEY_ID
				+ " INTEGER PRIMARY KEY," + KEY_ULICA + " TEXT," + KEY_BUDYNEK
				+ " TEXT," + KEY_MIASTO + " TEXT," + KEY_STRONA_WWW + " TEXT,"
				+ KEY_KATEGORIA + " TEXT)";
	}

	/***/
	public static void addAddressObject(AddressObject object, SQLiteDatabase db) {
		ContentValues values = new ContentValues();
		values.put(KEY_ID, object.adresId);
		values.put(KEY_ULICA, object.adresUlica);
		values.put(KEY_BUDYNEK, object.adresBudynek);
		values.put(KEY_MIASTO, object.adresMiasto);
		values.put(KEY_STRONA_WWW, object.adresStronaWww);
		values.put(KEY_KATEGORIA, object.adresKategoria);

		// Inserting Row
		db.insert(TABLE_NAME, null, values);
		db.close(); // Closing database connection
	}

	/***/
	public static AddressObject getAddressObject(int adresId, SQLiteDatabase db) {
		String[] values = new String[] { KEY_ID, KEY_ULICA, KEY_BUDYNEK,
				KEY_MIASTO, KEY_STRONA_WWW, KEY_KATEGORIA };
		String where = KEY_ID + "=?"; // argument WHERE dla SQL
		String[] whatValue = new String[] { String.valueOf(adresId) };
		Cursor cursor = db.query(TABLE_NAME, values, where, whatValue, null,
				null, null, null);

		return get(cursor);
	}

	private static AddressObject get(Cursor cursor) {
		if (cursor != null) { // zapytanie bylo prawidlowe
			cursor.moveToFirst();

			if (cursor.getCount() > 0) { // sa pobrane rekordy, zapisane w
											// cursor

				int adresId = Integer.parseInt(cursor.getString(0));
				String adresUlica = cursor.getString(1);
				String adresMiasto = cursor.getString(2);
				String adresBudynek = cursor.getString(3);
				String adresStronaWww = cursor.getString(4);
				String adresKategoria = cursor.getString(5);

				return new AddressObject(adresId, adresUlica, adresMiasto,
						adresBudynek, adresStronaWww, adresKategoria);
			}
		}

		return null;
	}
}
