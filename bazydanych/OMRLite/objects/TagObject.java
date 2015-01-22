package pl.wroc.pwr.na.database.objects;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class TagObject {

	@DatabaseField(generatedId = true)
	public int tagId;

	@DatabaseField
	public String tagNazwa;

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getTagNazwa() {
		return tagNazwa;
	}

	public void setTagNazwa(String tagNazwa) {
		this.tagNazwa = tagNazwa;
	}
}
