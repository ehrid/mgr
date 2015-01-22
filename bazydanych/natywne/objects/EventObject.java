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

public class EventObject implements Serializable {
	private static final long serialVersionUID = 8758719650084506599L;

	public int wydarzenieId;
	public String wydarzenieTytul;
	public String wydarzenieTresc;
	public String wydarzenieZewnetrznyLink;
	public int organizacjaId;
	public int adresId;
	public String wydarzenieSala;
	public String wydarzenieAdresInny;

	public String plakatUrl;
	public int tag1;
	public int tag2;
	public int tag3;
	public int tag4;
	public int tag5;
	public String wydarzenieDataPoczatek;
	public String wydarzenieDataKoniec;
	public boolean wydarzeniePlatne;
	public int wydarzenieCena;
	public String wydarzenieZapisyPoczatek;
	public String wydarzenieZapisyKoniec;
	public boolean wydarzenieTrwaCalyDzien;
	public boolean isLiked;

	public EventObject(int wydarzenieId, String wydarzenieTytul,
			String wydarzenieTresc, String wydarzenieZewnetrznyLink,
			int organizacjaId, int adresId, String wydarzenieSala,
			String wydarzenieAdresInny, String plakatUrl, int tag1, int tag2,
			int tag3, int tag4, int tag5, String wydarzenieDataPoczatek,
			String wydarzenieDataKoniec, boolean wydarzeniePlatne,
			int wydarzenieCena, String wydarzenieZapisyPoczatek,
			String wydarzenieZapisyKoniec, boolean wydarzenieTrwaCalyDzien,
			boolean isLiked) {
		this.wydarzenieId = wydarzenieId;
		this.wydarzenieTytul = wydarzenieTytul;
		this.wydarzenieTresc = wydarzenieTresc;
		this.wydarzenieZewnetrznyLink = wydarzenieZewnetrznyLink;
		this.organizacjaId = organizacjaId;
		this.adresId = adresId;
		this.wydarzenieSala = wydarzenieSala;
		this.wydarzenieAdresInny = wydarzenieAdresInny;
		this.plakatUrl = plakatUrl;
		this.tag1 = tag1;
		this.tag2 = tag2;
		this.tag3 = tag3;
		this.tag4 = tag4;
		this.tag5 = tag5;
		this.wydarzenieDataPoczatek = wydarzenieDataPoczatek;
		this.wydarzenieDataKoniec = wydarzenieDataKoniec;
		this.wydarzeniePlatne = wydarzeniePlatne;
		this.wydarzenieCena = wydarzenieCena;
		this.wydarzenieZapisyPoczatek = wydarzenieZapisyPoczatek;
		this.wydarzenieZapisyKoniec = wydarzenieZapisyKoniec;
		this.wydarzenieTrwaCalyDzien = wydarzenieTrwaCalyDzien;
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