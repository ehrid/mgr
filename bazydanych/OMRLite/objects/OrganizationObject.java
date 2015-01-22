package pl.wroc.pwr.na.database.objects;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class OrganizationObject {
	@DatabaseField(generatedId = true)
	public int organizacjaId;

	@DatabaseField
	public String organizacjaPelnaNazwa;

	@DatabaseField
	public String avatarPlik;

	@DatabaseField
	public String uzytkownikNazwaWyswietlana;

	@DatabaseField
	public String organizacjaAdresWww;

	@DatabaseField
	public String organizacjaPrzewodniczacy;

	@DatabaseField
	public String organizacjaTelefon;

	@DatabaseField
	public String organizacjaFacebookStrona;

	@DatabaseField
	public String organizacjaGooglePlus;

	@DatabaseField
	public String organizacjaOpis;

	@DatabaseField
	public String organizacjaSala;

	@DatabaseField
	public String organizacjaTwitter;

	@DatabaseField
	public String organizacjaYoutube;

	@DatabaseField
	public String organizacjaPunktyAkcji;

	@DatabaseField
	public String organizacjaPrzeczytalo;

	@DatabaseField
	public String uzytkownikNazwaUrl;

	@DatabaseField
	public String uzytkownikEmail;

	public int getOrganizacjaId() {
		return organizacjaId;
	}

	public void setOrganizacjaId(int organizacjaId) {
		this.organizacjaId = organizacjaId;
	}

	public String getOrganizacjaPelnaNazwa() {
		return organizacjaPelnaNazwa;
	}

	public void setOrganizacjaPelnaNazwa(String organizacjaPelnaNazwa) {
		this.organizacjaPelnaNazwa = organizacjaPelnaNazwa;
	}

	public String getAvatarPlik() {
		return avatarPlik;
	}

	public void setAvatarPlik(String avatarPlik) {
		this.avatarPlik = avatarPlik;
	}

	public String getUzytkownikNazwaWyswietlana() {
		return uzytkownikNazwaWyswietlana;
	}

	public void setUzytkownikNazwaWyswietlana(String uzytkownikNazwaWyswietlana) {
		this.uzytkownikNazwaWyswietlana = uzytkownikNazwaWyswietlana;
	}

	public String getOrganizacjaAdresWww() {
		return organizacjaAdresWww;
	}

	public void setOrganizacjaAdresWww(String organizacjaAdresWww) {
		this.organizacjaAdresWww = organizacjaAdresWww;
	}

	public String getOrganizacjaPrzewodniczacy() {
		return organizacjaPrzewodniczacy;
	}

	public void setOrganizacjaPrzewodniczacy(String organizacjaPrzewodniczacy) {
		this.organizacjaPrzewodniczacy = organizacjaPrzewodniczacy;
	}

	public String getOrganizacjaTelefon() {
		return organizacjaTelefon;
	}

	public void setOrganizacjaTelefon(String organizacjaTelefon) {
		this.organizacjaTelefon = organizacjaTelefon;
	}

	public String getOrganizacjaFacebookStrona() {
		return organizacjaFacebookStrona;
	}

	public void setOrganizacjaFacebookStrona(String organizacjaFacebookStrona) {
		this.organizacjaFacebookStrona = organizacjaFacebookStrona;
	}

	public String getOrganizacjaGooglePlus() {
		return organizacjaGooglePlus;
	}

	public void setOrganizacjaGooglePlus(String organizacjaGooglePlus) {
		this.organizacjaGooglePlus = organizacjaGooglePlus;
	}

	public String getOrganizacjaOpis() {
		return organizacjaOpis;
	}

	public void setOrganizacjaOpis(String organizacjaOpis) {
		this.organizacjaOpis = organizacjaOpis;
	}

	public String getOrganizacjaSala() {
		return organizacjaSala;
	}

	public void setOrganizacjaSala(String organizacjaSala) {
		this.organizacjaSala = organizacjaSala;
	}

	public String getOrganizacjaTwitter() {
		return organizacjaTwitter;
	}

	public void setOrganizacjaTwitter(String organizacjaTwitter) {
		this.organizacjaTwitter = organizacjaTwitter;
	}

	public String getOrganizacjaYoutube() {
		return organizacjaYoutube;
	}

	public void setOrganizacjaYoutube(String organizacjaYoutube) {
		this.organizacjaYoutube = organizacjaYoutube;
	}

	public String getOrganizacjaPunktyAkcji() {
		return organizacjaPunktyAkcji;
	}

	public void setOrganizacjaPunktyAkcji(String organizacjaPunktyAkcji) {
		this.organizacjaPunktyAkcji = organizacjaPunktyAkcji;
	}

	public String getOrganizacjaPrzeczytalo() {
		return organizacjaPrzeczytalo;
	}

	public void setOrganizacjaPrzeczytalo(String organizacjaPrzeczytalo) {
		this.organizacjaPrzeczytalo = organizacjaPrzeczytalo;
	}

	public String getUzytkownikNazwaUrl() {
		return uzytkownikNazwaUrl;
	}

	public void setUzytkownikNazwaUrl(String uzytkownikNazwaUrl) {
		this.uzytkownikNazwaUrl = uzytkownikNazwaUrl;
	}

	public String getUzytkownikEmail() {
		return uzytkownikEmail;
	}

	public void setUzytkownikEmail(String uzytkownikEmail) {
		this.uzytkownikEmail = uzytkownikEmail;
	}

}
