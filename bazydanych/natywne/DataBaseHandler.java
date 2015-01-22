package pl.wroc.pwr.na.database;

import java.util.List;

import pl.wroc.pwr.na.database.handlers.AddressHandler;
import pl.wroc.pwr.na.database.handlers.EventHandler;
import pl.wroc.pwr.na.database.handlers.OrganizationHandler;
import pl.wroc.pwr.na.database.handlers.ScheduleHandler;
import pl.wroc.pwr.na.database.handlers.TagHandler;
import pl.wroc.pwr.na.database.objects.AddressObject;
import pl.wroc.pwr.na.database.objects.EventObject;
import pl.wroc.pwr.na.database.objects.OrganizationObject;
import pl.wroc.pwr.na.database.objects.ScheduleObject;
import pl.wroc.pwr.na.database.objects.TagObject;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHandler extends SQLiteOpenHelper {

	/***/
	public static final int DATABASE_VERSION = 2;

	/***/
	public static final String DATABASE_NAME = "NAPWrDatabase";

	/***/
	public DataBaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + OrganizationHandler.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + AddressHandler.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + TagHandler.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + EventHandler.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + ScheduleHandler.TABLE_NAME);
		onCreate(db);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(OrganizationHandler.getCreateSQL());
		db.execSQL(AddressHandler.getCreateSQL());
		db.execSQL(TagHandler.getCreateSQL());
		db.execSQL(EventHandler.getCreateSQL());
		db.execSQL(ScheduleHandler.getCreateSQL());
	}

	// organizacje
	public void addAllOrganizationObjects(List<OrganizationObject> objects) {
		for (OrganizationObject object : objects) {
			OrganizationHandler.addOrganizationObject(object,
					getWritableDatabase());
		}
	}

	public OrganizationObject getOrganizationObject(int organizacjaId) {
		return OrganizationHandler.getOrganizationObject(organizacjaId,
				getWritableDatabase());
	}

	// adresy
	public void addAllAddressObjects(List<AddressObject> objects) {
		for (AddressObject object : objects) {
			AddressHandler.addAddressObject(object, getWritableDatabase());
		}
	}

	public AddressObject getAddressObject(int addressId) {
		return AddressHandler
				.getAddressObject(addressId, getWritableDatabase());
	}

	// tagi
	public void addAllTagObjects(List<TagObject> objects) {
		for (TagObject object : objects) {
			TagHandler.addTagObject(object, getWritableDatabase());
		}
	}

	public TagObject getTagObject(int tagId) {
		return TagHandler.getTagObject(tagId, getWritableDatabase());
	}

	// eventy
	public void addAllEventObjects(List<EventObject> objects) {
		for (EventObject object : objects) {
			EventHandler.addEventObject(object, getWritableDatabase());
		}
	}

	public EventObject getEventObject(int eventId) {
		return EventHandler.getEventObject(eventId, getWritableDatabase());
	}

	public void addEventToLiked(int eventId) {
		EventHandler.addEventToLiked(eventId, getWritableDatabase());
	}

	public void removeEventFromLiked(int eventId) {
		EventHandler.removeEventFromLiked(eventId, getWritableDatabase());
	}

	public List<EventObject> getAllEventObjects() {
		return EventHandler.getAllEventObjeccts(getWritableDatabase());
	}

	public List<EventObject> getAllSavedEventObjects() {
		return EventHandler.getAllSavedEventObjeccts(getWritableDatabase());
	}

	// plan zajęć
	public void cleanScheduleObjects() {
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("DROP TABLE IF EXISTS " + ScheduleHandler.TABLE_NAME);
		db.execSQL(ScheduleHandler.getCreateSQL());
	}

	public void addAllScheduleObjects(List<ScheduleObject> objects) {
		for (ScheduleObject object : objects) {
			ScheduleHandler.addScheduleObject(object, getWritableDatabase());
		}
	}

	public List<ScheduleObject> getAllScheduleObjects() {
		return ScheduleHandler.getAllScheduleObjects(getWritableDatabase());
	}

}
