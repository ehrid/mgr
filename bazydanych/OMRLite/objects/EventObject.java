package pl.wroc.pwr.na.database.objects;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.ExecutionException;

import pl.wroc.pwr.na.tools.RequestTaskBitmap;
import pl.wroc.pwr.na.tools.UseInternalStorage;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class EventObject {

	@DatabaseField(generatedId = true)
	public int wydarzenieId;

	@DatabaseField
	public String wydarzenieTytul;

	@DatabaseField
	public String wydarzenieTresc;

	@DatabaseField
	public String wydarzenieZewnetrznyLink;

	@DatabaseField
	public int organizacjaId;

	@DatabaseField
	public int adresId;

	@DatabaseField
	public String wydarzenieSala;

	@DatabaseField
	public String wydarzenieAdresInny;

	@DatabaseField
	public String plakatUrl;

	@DatabaseField
	public int tag1;

	@DatabaseField
	public int tag2;

	@DatabaseField
	public int tag3;

	@DatabaseField
	public int tag4;

	@DatabaseField
	public int tag5;

	@DatabaseField
	public String wydarzenieDataPoczatek;

	@DatabaseField
	public String wydarzenieDataKoniec;

	@DatabaseField
	public boolean wydarzeniePlatne;

	@DatabaseField
	public int wydarzenieCena;

	@DatabaseField
	public String wydarzenieZapisyPoczatek;

	@DatabaseField
	public String wydarzenieZapisyKoniec;

	@DatabaseField
	public boolean wydarzenieTrwaCalyDzien;

	@DatabaseField
	public boolean isLiked;

	public int getWydarzenieId() {
		return wydarzenieId;
	}

	public void setWydarzenieId(int wydarzenieId) {
		this.wydarzenieId = wydarzenieId;
	}

	public String getWydarzenieTytul() {
		return wydarzenieTytul;
	}

	public void setWydarzenieTytul(String wydarzenieTytul) {
		this.wydarzenieTytul = wydarzenieTytul;
	}

	public String getWydarzenieTresc() {
		return wydarzenieTresc;
	}

	public void setWydarzenieTresc(String wydarzenieTresc) {
		this.wydarzenieTresc = wydarzenieTresc;
	}

	public String getWydarzenieZewnetrznyLink() {
		return wydarzenieZewnetrznyLink;
	}

	public void setWydarzenieZewnetrznyLink(String wydarzenieZewnetrznyLink) {
		this.wydarzenieZewnetrznyLink = wydarzenieZewnetrznyLink;
	}

	public int getOrganizacjaId() {
		return organizacjaId;
	}

	public void setOrganizacjaId(int organizacjaId) {
		this.organizacjaId = organizacjaId;
	}

	public int getAdresId() {
		return adresId;
	}

	public void setAdresId(int adresId) {
		this.adresId = adresId;
	}

	public String getWydarzenieSala() {
		return wydarzenieSala;
	}

	public void setWydarzenieSala(String wydarzenieSala) {
		this.wydarzenieSala = wydarzenieSala;
	}

	public String getWydarzenieAdresInny() {
		return wydarzenieAdresInny;
	}

	public void setWydarzenieAdresInny(String wydarzenieAdresInny) {
		this.wydarzenieAdresInny = wydarzenieAdresInny;
	}

	public String getPlakatUrl() {
		return plakatUrl;
	}

	public void setPlakatUrl(String plakatUrl) {
		this.plakatUrl = plakatUrl;
	}

	public int getTag1() {
		return tag1;
	}

	public void setTag1(int tag1) {
		this.tag1 = tag1;
	}

	public int getTag2() {
		return tag2;
	}

	public void setTag2(int tag2) {
		this.tag2 = tag2;
	}

	public int getTag3() {
		return tag3;
	}

	public void setTag3(int tag3) {
		this.tag3 = tag3;
	}

	public int getTag4() {
		return tag4;
	}

	public void setTag4(int tag4) {
		this.tag4 = tag4;
	}

	public int getTag5() {
		return tag5;
	}

	public void setTag5(int tag5) {
		this.tag5 = tag5;
	}

	public String getWydarzenieDataPoczatek() {
		return wydarzenieDataPoczatek;
	}

	public void setWydarzenieDataPoczatek(String wydarzenieDataPoczatek) {
		this.wydarzenieDataPoczatek = wydarzenieDataPoczatek;
	}

	public String getWydarzenieDataKoniec() {
		return wydarzenieDataKoniec;
	}

	public void setWydarzenieDataKoniec(String wydarzenieDataKoniec) {
		this.wydarzenieDataKoniec = wydarzenieDataKoniec;
	}

	public boolean isWydarzeniePlatne() {
		return wydarzeniePlatne;
	}

	public void setWydarzeniePlatne(boolean wydarzeniePlatne) {
		this.wydarzeniePlatne = wydarzeniePlatne;
	}

	public int getWydarzenieCena() {
		return wydarzenieCena;
	}

	public void setWydarzenieCena(int wydarzenieCena) {
		this.wydarzenieCena = wydarzenieCena;
	}

	public String getWydarzenieZapisyPoczatek() {
		return wydarzenieZapisyPoczatek;
	}

	public void setWydarzenieZapisyPoczatek(String wydarzenieZapisyPoczatek) {
		this.wydarzenieZapisyPoczatek = wydarzenieZapisyPoczatek;
	}

	public String getWydarzenieZapisyKoniec() {
		return wydarzenieZapisyKoniec;
	}

	public void setWydarzenieZapisyKoniec(String wydarzenieZapisyKoniec) {
		this.wydarzenieZapisyKoniec = wydarzenieZapisyKoniec;
	}

	public boolean isWydarzenieTrwaCalyDzien() {
		return wydarzenieTrwaCalyDzien;
	}

	public void setWydarzenieTrwaCalyDzien(boolean wydarzenieTrwaCalyDzien) {
		this.wydarzenieTrwaCalyDzien = wydarzenieTrwaCalyDzien;
	}

	public boolean isLiked() {
		return isLiked;
	}

	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}

	public BitmapDataObject get_bdo_poster() {
		return _bdo_poster;
	}

	public void set_bdo_poster(BitmapDataObject _bdo_poster) {
		this._bdo_poster = _bdo_poster;
	}

	protected BitmapDataObject _bdo_poster;

	/***/
	protected Bitmap getImagePoster(Context context) {
		if (_bdo_poster != null)
			return BitmapFactory.decodeByteArray(_bdo_poster.imageByteArray, 0,
					_bdo_poster.imageByteArray.length);
		Bitmap poster = readPoster(context);
		if (poster == null)
			poster = invokeWritePoster(context);
		return poster;
	}

	/***/
	protected void setImagePoster(Context context) {
		if (_bdo_poster == null && readPoster(context) == null)
			invokeWritePoster(context);
	}

	private Bitmap invokeWritePoster(Context context) {
		try {
			return writePoster(context);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Bitmap writePoster(Context context) throws InterruptedException,
			ExecutionException {
		Bitmap imagePoster = downloadPoster();
		BitmapDataObject bdo = compressPoster(imagePoster);
		writePosterToFile(context, bdo);
		_bdo_poster = bdo;
		Bitmap poster = processPoster(bdo);
		return poster;
	}

	private Bitmap processPoster(BitmapDataObject bdo) {
		return BitmapFactory.decodeByteArray(bdo.imageByteArray, 0,
				bdo.imageByteArray.length);
	}

	private Bitmap downloadPoster() throws InterruptedException,
			ExecutionException {
		Bitmap imagePoster = new RequestTaskBitmap().execute(plakatUrl).get();
		return imagePoster;
	}

	private BitmapDataObject compressPoster(Bitmap imagePoster) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		imagePoster.compress(Bitmap.CompressFormat.PNG, 100, stream);
		BitmapDataObject bdo = new BitmapDataObject();
		bdo.imageByteArray = stream.toByteArray();
		return bdo;
	}

	private void writePosterToFile(Context context, BitmapDataObject bdo) {
		UseInternalStorage uis = new UseInternalStorage(context);
		uis.writeObject(bdo, "plakat_" + wydarzenieId);
	}

	private Bitmap readPoster(Context context) {
		UseInternalStorage uis = new UseInternalStorage(context);
		BitmapDataObject bdo = (BitmapDataObject) uis.readObject("plakat_"
				+ wydarzenieId);

		if (bdo == null)
			return null;
		_bdo_poster = bdo;
		return processPoster(bdo);

	}

	protected class BitmapDataObject implements Serializable {
		private static final long serialVersionUID = 6022430163107957510L;

		public byte[] imageByteArray;
	}

	public String getDay(String date) {
		// format 2014-04-29 08:00:00 (YYYY-MM-DD HH:MM:SS)
		return date.substring(8, 10);
	}

	public String getMonth(String date) {
		// format 2014-04-29 08:00:00 (YYYY-MM-DD HH:MM:SS)
		int numberOfMonth = Integer.parseInt(date.substring(5, 7));
		return getMonthName(numberOfMonth);
	}

	private String getMonthName(int numberOfMonth) {
		String nameOfMonth = "n/a";
		switch (numberOfMonth) {
		case 1:
			nameOfMonth = "Styczeń";
			break;
		case 2:
			nameOfMonth = "Luty";
			break;
		case 3:
			nameOfMonth = "Marzec";
			break;
		case 4:
			nameOfMonth = "Kwiecień";
			break;
		case 5:
			nameOfMonth = "Maj";
			break;
		case 6:
			nameOfMonth = "Czerwiec";
			break;
		case 7:
			nameOfMonth = "Lipiec";
			break;
		case 8:
			nameOfMonth = "Sierpień";
			break;
		case 9:
			nameOfMonth = "Wrzesień";
			break;
		case 10:
			nameOfMonth = "Październik";
			break;
		case 11:
			nameOfMonth = "Listopad";
			break;
		case 12:
			nameOfMonth = "Grudzień";
			break;
		}
		return nameOfMonth;
	}

	public String getDayOfWeek(String dateString) {
		Date date = new Date();
		SimpleDateFormat date_format = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Calendar calendar = new GregorianCalendar(2008, 01, 01);
		try {
			date = date_format.parse(dateString);
			calendar.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String dayOfWeek = "";

		int reslut = calendar.get(Calendar.DAY_OF_WEEK);
		switch (reslut) {
		case Calendar.MONDAY:
			dayOfWeek = "Poniedziałek";
			break;
		case Calendar.TUESDAY:
			dayOfWeek = "Wtorek";
			break;
		case Calendar.WEDNESDAY:
			dayOfWeek = "Środe";
			break;
		case Calendar.THURSDAY:
			dayOfWeek = "Czwartek";
			break;
		case Calendar.FRIDAY:
			dayOfWeek = "Piątek";
			break;
		case Calendar.SATURDAY:
			dayOfWeek = "Sobota";
			break;
		case Calendar.SUNDAY:
			dayOfWeek = "Niedziela";
			break;
		}

		return dayOfWeek;
	}

	public String getHoour(String dateString) {
		Date date = new Date();
		SimpleDateFormat date_format = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Calendar calendar = new GregorianCalendar(2008, 01, 01);
		String hour = "0:00";

		try {
			date = date_format.parse(dateString);
			calendar.setTime(date);

			int minute = calendar.get(Calendar.MINUTE);
			hour = calendar.get(Calendar.HOUR) + ":"
					+ (minute < 10 ? "0" + minute : minute);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return hour;
	}
}