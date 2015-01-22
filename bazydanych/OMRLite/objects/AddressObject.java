package pl.wroc.pwr.na.database.objects;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class AddressObject {

	@DatabaseField(generatedId = true)
	public int adresId;

	@DatabaseField
	public String adresUlica;

	@DatabaseField
	public String adresMiasto;

	@DatabaseField
	public String adresBudynek;

	@DatabaseField
	public String adresStronaWww;

	@DatabaseField
	public String adresKategoria;

	public int getAdresId() {
		return adresId;
	}

	public void setAdresId(int adresId) {
		this.adresId = adresId;
	}

	public String getAdresUlica() {
		return adresUlica;
	}

	public void setAdresUlica(String adresUlica) {
		this.adresUlica = adresUlica;
	}

	public String getAdresMiasto() {
		return adresMiasto;
	}

	public void setAdresMiasto(String adresMiasto) {
		this.adresMiasto = adresMiasto;
	}

	public String getAdresBudynek() {
		return adresBudynek;
	}

	public void setAdresBudynek(String adresBudynek) {
		this.adresBudynek = adresBudynek;
	}

	public String getAdresStronaWww() {
		return adresStronaWww;
	}

	public void setAdresStronaWww(String adresStronaWww) {
		this.adresStronaWww = adresStronaWww;
	}

	public String getAdresKategoria() {
		return adresKategoria;
	}

	public void setAdresKategoria(String adresKategoria) {
		this.adresKategoria = adresKategoria;
	}

}
