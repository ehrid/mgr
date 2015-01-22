package pl.wroc.pwr.na.database.objects;

import java.io.Serializable;

public class TagObject implements Serializable {
	private static final long serialVersionUID = -1130822690154913844L;

	public int tagId;
	public String tagNazwa;

	public TagObject(int tagId, String tagNazwa) {
		this.tagId = tagId;
		this.tagNazwa = tagNazwa;
	}
}
