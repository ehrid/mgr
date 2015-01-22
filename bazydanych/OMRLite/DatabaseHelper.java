package pl.wroc.pwr.na.database;

import java.sql.SQLException;

import pl.wroc.pwr.na.database.objects.AddressObject;
import pl.wroc.pwr.na.database.objects.EventObject;
import pl.wroc.pwr.na.database.objects.OrganizationObject;
import pl.wroc.pwr.na.database.objects.ScheduleObject;
import pl.wroc.pwr.na.database.objects.TagObject;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

/**
 * Helper class which creates/updates our database and provides the DAOs.
 * 
 * @author kevingalligan
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	private static final String DATABASE_NAME = "notify.db";
	private static final int DATABASE_VERSION = 4;
	private final String LOG_NAME = getClass().getName();

	private Dao<TagObject, Integer> tagDao;
	private Dao<ScheduleObject, Integer> scheduleDao;
	private Dao<OrganizationObject, Integer> organizationDao;
	private Dao<EventObject, Integer> eventDao;
	private Dao<AddressObject, Integer> addressDao;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase,
			ConnectionSource connectionSource) {
		try {
			TableUtils.createTable(connectionSource, TagObject.class);
			TableUtils.createTable(connectionSource, ScheduleObject.class);
			TableUtils.createTable(connectionSource, OrganizationObject.class);
			TableUtils.createTable(connectionSource, EventObject.class);
			TableUtils.createTable(connectionSource, AddressObject.class);
		} catch (SQLException e) {
			Log.e(LOG_NAME, "Could not create new tables", e);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase,
			ConnectionSource connectionSource, int oldVersion, int newVersion) {
		try {
			TableUtils.dropTable(connectionSource, TagObject.class, true);
			TableUtils.dropTable(connectionSource, ScheduleObject.class, true);
			TableUtils.dropTable(connectionSource, OrganizationObject.class,
					true);
			TableUtils.dropTable(connectionSource, EventObject.class, true);
			TableUtils.dropTable(connectionSource, AddressObject.class, true);
			onCreate(sqLiteDatabase, connectionSource);
		} catch (SQLException e) {
			Log.e(LOG_NAME, "Could not upgrade the tables", e);
		}
	}

	public Dao<TagObject, Integer> getTagObjectDao() throws SQLException {
		if (tagDao == null) {
			tagDao = getDao(TagObject.class);
		}
		return tagDao;
	}

	public Dao<ScheduleObject, Integer> getScheduleObjectDao()
			throws SQLException {
		if (scheduleDao == null) {
			scheduleDao = getDao(ScheduleObject.class);
		}
		return scheduleDao;
	}

	public Dao<OrganizationObject, Integer> getOrganizationObjectDao()
			throws SQLException {
		if (organizationDao == null) {
			organizationDao = getDao(OrganizationObject.class);
		}
		return organizationDao;
	}

	public Dao<EventObject, Integer> getEventObjectDao() throws SQLException {
		if (eventDao == null) {
			eventDao = getDao(EventObject.class);
		}
		return eventDao;
	}

	public Dao<AddressObject, Integer> getAddressObjectDao()
			throws SQLException {
		if (addressDao == null) {
			addressDao = getDao(AddressObject.class);
		}
		return addressDao;
	}
}
