package pl.wroc.pwr.na.database;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;


public class NAPWrDatabaseGenerator {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1000, "pl.wroc.pwr.na");

        addTagObject(schema);
        addAddressObject(schema);
        addScheduleObject(schema);
        addOrganizationObject(schema);
        addEventObject(schema);

        new DaoGenerator().generateAll(schema, "../pl/wroc/pwr/na/database/dao/");
    }

    private static void addTagObject(Schema schema) {
        Entity tagObject = schema.addEntity("TagObject");
        tagObject.addIdProperty();
        tagObject.addStringProperty("tagNazwa").notNull();
    }
	
	private static void addAddressObject(Schema schema) {
        Entity addressObject = schema.addEntity("AddressObject");
        addressObject.addIdProperty();
        addressObject.addStringProperty("adresUlica");
		addressObject.addStringProperty("adresMiasto");
		addressObject.addStringProperty("adresBudynek");
		addressObject.addStringProperty("adresStronaWww");
		addressObject.addStringProperty("adresKategoria");
    }
	
	private static void addScheduleObject(Schema schema) {
        Entity scheduleObject = schema.addEntity("ScheduleObject");
        scheduleObject.addIdProperty();
        scheduleObject.addStringProperty("time");
        scheduleObject.addStringProperty("title");
        scheduleObject.addStringProperty("place");
        scheduleObject.addStringProperty("lecturer");
        scheduleObject.addStringProperty("type");
        scheduleObject.addStringProperty("date");
		scheduleObject.addIntProperty("day");
		scheduleObject.addIntProperty("week");
		scheduleObject.addIntProperty("startHour");
    }

	private static void addOrganizationObject(Schema schema) {
        Entity organizationObject = schema.addEntity("OrganizationObject");
        organizationObject.addIdProperty();
        organizationObject.addStringProperty("organizacjaPelnaNazwa");
        organizationObject.addStringProperty("avatarPlik");
        organizationObject.addStringProperty("uzytkownikNazwaWyswietlana");
        organizationObject.addStringProperty("organizacjaAdresWww");
        organizationObject.addStringProperty("organizacjaPrzewodniczacy");
        organizationObject.addStringProperty("organizacjaTelefon");
        organizationObject.addStringProperty("organizacjaFacebookStrona");
        organizationObject.addStringProperty("organizacjaGooglePlus");
        organizationObject.addStringProperty("organizacjaOpis");
        organizationObject.addStringProperty("organizacjaSala");
        organizationObject.addStringProperty("organizacjaTwitter");
        organizationObject.addStringProperty("organizacjaYoutube");
        organizationObject.addStringProperty("organizacjaPunktyAkcji");
        organizationObject.addStringProperty("organizacjaPrzeczytalo");
        organizationObject.addStringProperty("uzytkownikNazwaUrl");
        organizationObject.addStringProperty("uzytkownikEmail");
    }
	
	private static void addEventObject(Schema schema) {
        Entity eventObject = schema.addEntity("EventObject");
        eventObject.addIdProperty();
        eventObject.addStringProperty("wydarzenieTytul");
        eventObject.addStringProperty("wydarzenieTresc");
        eventObject.addStringProperty("wydarzenieZewnetrznyLink");
		eventObject.addIntProperty("organizacjaId");
		eventObject.addIntProperty("adresId");
		eventObject.addStringProperty("wydarzenieSala");
        eventObject.addStringProperty("wydarzenieAdresInny");
        eventObject.addStringProperty("plakatUrl");
		eventObject.addIntProperty("tag1");
		eventObject.addIntProperty("tag2");
		eventObject.addIntProperty("tag3");
		eventObject.addIntProperty("tag4");
		eventObject.addIntProperty("tag5");
		eventObject.addStringProperty("wydarzenieDataPoczatek");
		eventObject.addStringProperty("wydarzenieDataKoniec");
		eventObject.addBooleanProperty("wydarzeniePlatne");
		eventObject.addIntProperty("wydarzenieCena");
		eventObject.addStringProperty("wydarzenieZapisyPoczatek");
		eventObject.addStringProperty("wydarzenieZapisyKoniec");
		eventObject.addBooleanProperty("wydarzenieTrwaCalyDzien");
		eventObject.addBooleanProperty("isLiked");
    }
}