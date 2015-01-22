package pl.wroc.pwr.na.database.objects;

import java.io.Serializable;

public class OrganizationObject implements Serializable {
	private static final long serialVersionUID = 2199900062677829827L;

	public int organizacjaId;
	public String organizacjaPelnaNazwa;
	public String avatarPlik;
	public String uzytkownikNazwaWyswietlana;

	public String organizacjaAdresWww;
	public String organizacjaPrzewodniczacy;
	public String organizacjaTelefon;
	public String organizacjaFacebookStrona;
	public String organizacjaGooglePlus;
	public String organizacjaOpis;
	public String organizacjaSala;
	public String organizacjaTwitter;
	public String organizacjaYoutube;
	public String organizacjaPunktyAkcji;
	public String organizacjaPrzeczytalo;
	public String uzytkownikNazwaUrl;
	public String uzytkownikEmail;

	public OrganizationObject(int organizacjaId, String organizacjaPelnaNazwa,
			String uzytkownikNazwaWyswietlana, String avatarPlik) {
		this.uzytkownikNazwaWyswietlana = uzytkownikNazwaWyswietlana;
		this.organizacjaId = organizacjaId;
		this.organizacjaPelnaNazwa = organizacjaPelnaNazwa;
		this.avatarPlik = avatarPlik;
	}
}
