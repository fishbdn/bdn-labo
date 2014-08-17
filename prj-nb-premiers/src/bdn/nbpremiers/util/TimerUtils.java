package bdn.nbpremiers.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Utilisataire pour les chronometrages de temps d'execution
 * @author bdn
 */
public class TimerUtils {

	/**
	 * Formate la duree "[time] ms"
	 * @param startTimeInMillis
	 * @return
	 */
	public static String timerFormatter(long startTimeInMillis) {
		long duration = Calendar.getInstance().getTimeInMillis() - startTimeInMillis;
		return duration + " ms";
	}

	public static String timerFormatter(final Date beginDate, final Date endDate) {
		long duration = -1;
		if (endDate != null && beginDate != null) {
			duration = endDate.getTime() - beginDate.getTime();
		}

		return duration + " ms";
	}

	public static String dateFormatter(final Date date) {
		String formattedDate = "";
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		if (date != null) {
			formattedDate = sdf.format(date);
		}
		return formattedDate;
	}

}
