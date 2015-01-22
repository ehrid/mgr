package pl.wroc.pwr.na.database.objects;

import java.io.Serializable;

public class AddressObject implements Serializable {
	private static final long serialVersionUID = -1130811590154913844L;

	/***/
	public int adresId;
	public String adresUlica;
	public String adresMiasto;
	public String adresBudynek;
	public String adresStronaWww;
	public String adresKategoria;

	public AddressObject(int adresId, String adresUlica, String adresMiasto,
			String adresBudynek, String adresStronaWww, String adresKategoria) {
		this.adresId = adresId;
		this.adresUlica = adresUlica;
		this.adresMiasto = adresMiasto;
		this.adresBudynek = adresBudynek;
		this.adresStronaWww = adresStronaWww;
		this.adresKategoria = adresKategoria;
	}

}
