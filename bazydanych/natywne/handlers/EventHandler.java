package pl.wroc.pwr.na.database.handlers;

import java.util.ArrayList;
import java.util.List;

import pl.wroc.pwr.na.database.objects.EventObject;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class EventHandler {
	/***/
	public static final String TABLE_NAME = "Wydarzenia";

	private static final String KEY_ID = "wydarzenieId";
	private static final String KEY_TYTUL = "wydarzenieTytul";
	private static final String KEY_TRESC = "wydarzenieTresc";
	private static final String KEY_ZEWNETRZNY_LINK = "wydarzenieZewnetrznyLink";
	private static final String KEY_ORGANIZACJA_ID = "organizacjaId";
	private static final String KEY_ADRES_ID = "adresId";
	private static final String KEY_WYDARZENIE_SALA = "wydarzenieSala";
	private static final String KEY_ADRES_INNY = "wydarzenieAdresInny";
	private static final String KEY_PLAKAT_URL = "wydarzeniePlakatUrl";
	private static final String KEY_TAG_ID1 = "tagId1";
	private static final String KEY_TAG_ID2 = "tagId2";
	private static final String KEY_TAG_ID3 = "tagId3";
	private static final String KEY_TAG_ID4 = "tagId4";
	private static final String KEY_TAG_ID5 = "tagId5";
	private static final String KEY_DATA_POCZATEK = "wydarzenieDataPoczatek";
	private static final String KEY_DATA_KONIEC = "wydarzenieDataKoniec";
	private static final String KEY_PLATNE = "wydarzeniePlatne";
	private static final String KEY_CENA = "wydarzenieCena";
	private static final String KEY_ZAPISY_POCZATEK = "wydarzenieZapisyPoczatek";
	private static final String KEY_ZAPISY_KONIEC = "wydarzenieZapisyKoniec";
	private static final String KEY_TRWA_CALY_DZIEN = "wydarzenieTrwaCalyDzien";
	private static final String KEY_LIKE = "sayYouLikeIt";

	/***/
	public static String getCreateSQL() {
		return "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + KEY_ID
				+ " INTEGER PRIMARY KEY," + KEY_TYTUL + " TEXT," + KEY_TRESC
				+ " TEXT," + KEY_ZEWNETRZNY_LINK + " TEXT,"
				+ KEY_ORGANIZACJA_ID + " INTEGER," + KEY_ADRES_ID + " INTEGER,"
				+ KEY_WYDARZENIE_SALA + " TEXT," + KEY_ADRES_INNY + " TEXT,"
				+ KEY_PLAKAT_URL + " TEXT," + KEY_TAG_ID1 + " INTEGER,"
				+ KEY_TAG_ID2 + " INTEGER," + KEY_TAG_ID3 + " INTEGER,"
				+ KEY_TAG_ID4 + " INTEGER," + KEY_TAG_ID5 + " INTEGER,"
				+ KEY_DATA_POCZATEK + " TEXT," + KEY_DATA_KONIEC + " TEXT,"
				+ KEY_PLATNE + " INTEGER," + KEY_CENA + " TEXT,"
				+ KEY_ZAPISY_POCZATEK + " TEXT," + KEY_ZAPISY_KONIEC + " TEXT,"
				+ KEY_TRWA_CALY_DZIEN + " INTEGER," + KEY_LIKE + " INTEGER)";
	}

	/***/
	public static void addEventObject(EventObject object, SQLiteDatabase db) {
		ContentValues values = new ContentValues();
		values.put(KEY_ID, object.wydarzenieId);
		values.put(KEY_TYTUL, object.wydarzenieTytul);
		values.put(KEY_TRESC, object.wydarzenieTresc);
		values.put(KEY_ZEWNETRZNY_LINK, object.wydarzenieZewnetrznyLink);
		values.put(KEY_ORGANIZACJA_ID, object.organizacjaId);
		values.put(KEY_ADRES_ID, object.adresId);
		values.put(KEY_WYDARZENIE_SALA, object.wydarzenieSala);
		values.put(KEY_ADRES_INNY, object.wydarzenieAdresInny);
		values.put(KEY_PLAKAT_URL, object.plakatUrl);
		values.put(KEY_TAG_ID1, object.tag1);
		values.put(KEY_TAG_ID2, object.tag2);
		values.put(KEY_TAG_ID3, object.tag3);
		values.put(KEY_TAG_ID4, object.tag4);
		values.put(KEY_TAG_ID5, object.tag5);
		values.put(KEY_DATA_POCZATEK, object.wydarzenieDataPoczatek);
		values.put(KEY_DATA_KONIEC, object.wydarzenieDataKoniec);
		values.put(KEY_PLATNE, (object.wydarzeniePlatne ? 1 : 0));
		values.put(KEY_CENA, object.wydarzenieCena);
		values.put(KEY_ZAPISY_POCZATEK, object.wydarzenieZapisyPoczatek);
		values.put(KEY_ZAPISY_KONIEC, object.wydarzenieZapisyKoniec);
		values.put(KEY_TRWA_CALY_DZIEN,
				(object.wydarzenieTrwaCalyDzien ? 1 : 0));
		values.put(KEY_LIKE, 0);

		// Inserting Row
		db.insert(TABLE_NAME, null, values);
		db.close(); // Closing database connection
	}

	/***/
	public static List<EventObject> getAllEventObjeccts(SQLiteDatabase db) {
		List<EventObject> eventList = new ArrayList<EventObject>();

		String selectQuery = "SELECT  * FROM " + TABLE_NAME;
		Cursor cursor = db.rawQuery(selectQuery, null);

		return getAll(eventList, cursor);
	}

	private static List<EventObject> getAll(List<EventObject> continentList,
			Cursor cursor) {
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				continentList.add(get(cursor));
			} while (cursor.moveToNext());
		}

		return continentList;
	}

	/***/
	public static List<EventObject> getAllSavedEventObjeccts(SQLiteDatabase db) {
		List<EventObject> eventList = new ArrayList<EventObject>();

		String[] values = new String[] { KEY_ID, KEY_TYTUL, KEY_TRESC,
				KEY_ZEWNETRZNY_LINK, KEY_ORGANIZACJA_ID, KEY_ADRES_ID,
				KEY_WYDARZENIE_SALA, KEY_ADRES_INNY, KEY_PLAKAT_URL,
				KEY_TAG_ID1, KEY_TAG_ID2, KEY_TAG_ID3, KEY_TAG_ID4,
				KEY_TAG_ID5, KEY_DATA_POCZATEK, KEY_DATA_KONIEC, KEY_PLATNE,
				KEY_CENA, KEY_ZAPISY_POCZATEK, KEY_ZAPISY_KONIEC,
				KEY_TRWA_CALY_DZIEN, KEY_LIKE };
		String where = KEY_LIKE + "<>0";
		Cursor cursor = db.query(TABLE_NAME, values, where, null, null, null,
				null, null);

		return getAll(eventList, cursor);
	}

	/***/
	public static EventObject getEventObject(int wydarzenieId, SQLiteDatabase db) {
		String[] values = new String[] { KEY_ID, KEY_TYTUL, KEY_TRESC,
				KEY_ZEWNETRZNY_LINK, KEY_ORGANIZACJA_ID, KEY_ADRES_ID,
				KEY_WYDARZENIE_SALA, KEY_ADRES_INNY, KEY_PLAKAT_URL,
				KEY_TAG_ID1, KEY_TAG_ID2, KEY_TAG_ID3, KEY_TAG_ID4,
				KEY_TAG_ID5, KEY_DATA_POCZATEK, KEY_DATA_KONIEC, KEY_PLATNE,
				KEY_CENA, KEY_ZAPISY_POCZATEK, KEY_ZAPISY_KONIEC,
				KEY_TRWA_CALY_DZIEN, KEY_LIKE };
		String where = KEY_ID + "=?"; // argument WHERE dla SQL
		String[] whatValue = new String[] { String.valueOf(wydarzenieId) };
		Cursor cursor = db.query(TABLE_NAME, values, where, whatValue, null,
				null, null, null);

		return getSingle(cursor);
	}

	private static EventObject getSingle(Cursor cursor) {
		if (cursor != null) { // zapytanie bylo prawidlowe
			cursor.moveToFirst();

			if (cursor.getCount() > 0) { // sa pobrane rekordy, zapisane w
											// cursor
				return get(cursor);
			}
		}

		return null;
	}

	private static EventObject get(Cursor cursor) {
		int wydarzenieId = Integer.parseInt(cursor.getString(0));
		String wydarzenieTytul = cursor.getString(1);
		String wydarzenieTresc = cursor.getString(2);
		String wydarzenieZewnetrznyLink = cursor.getString(3);
		int organizacjaId = Integer.parseInt(cursor.getString(4));
		int adresId = Integer.parseInt(cursor.getString(5));
		String wydarzenieSala = cursor.getString(6);
		String wydarzenieAdresInny = cursor.getString(7);
		String plakatUrl = cursor.getString(8);
		int tag1 = Integer.parseInt(cursor.getString(9));
		int tag2 = Integer.parseInt(cursor.getString(10));
		int tag3 = Integer.parseInt(cursor.getString(11));
		int tag4 = Integer.parseInt(cursor.getString(12));
		int tag5 = Integer.parseInt(cursor.getString(13));
		String wydarzenieDataPoczatek = cursor.getString(14);
		String wydarzenieDataKoniec = cursor.getString(15);
		boolean wydarzeniePlatne = (Integer.parseInt(cursor.getString(16)) == 1 ? true
				: false);
		int wydarzenieCena = Integer.parseInt(cursor.getString(17));
		String wydarzenieZapisyPoczatek = cursor.getString(18);
		String wydarzenieZapisyKoniec = cursor.getString(19);
		boolean wydarzenieTrwaCalyDzien = (Integer.parseInt(cursor
				.getString(20)) == 1 ? true : false);
		boolean isLiked = cursor.getInt(21) > 0;

		return new EventObject(wydarzenieId, wydarzenieTytul, wydarzenieTresc,
				wydarzenieZewnetrznyLink, organizacjaId, adresId,
				wydarzenieSala, wydarzenieAdresInny, plakatUrl, tag1, tag2,
				tag3, tag4, tag5, wydarzenieDataPoczatek, wydarzenieDataKoniec,
				wydarzeniePlatne, wydarzenieCena, wydarzenieZapisyPoczatek,
				wydarzenieZapisyKoniec, wydarzenieTrwaCalyDzien, isLiked);
	}

	public static void addEventToLiked(int eventId, SQLiteDatabase db) {

		ContentValues args = new ContentValues();
		args.put(KEY_LIKE, 1);
		db.update(TABLE_NAME, args, KEY_ID + "=" + eventId, null);

	}

	public static void removeEventFromLiked(int eventId, SQLiteDatabase db) {

		ContentValues args = new ContentValues();
		args.put(KEY_LIKE, 0);
		db.update(TABLE_NAME, args, KEY_ID + "=" + eventId, null);

	}
}
