package base;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AlarmRunner {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		Alarm alarm = new Alarm();
		
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		System.out.println("Enter time for alarm in the format (hh:mm)");
		String[] time = scanner.next().split(":");
		
		
		int alarmHour = Integer.parseInt(time[0]);
		int alarmMinutes = Integer.parseInt(time[1]);
		
		int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
		int currentMinutes = calendar.get(Calendar.MINUTE);
		
		int delayInMinutes = (currentHour*60+currentMinutes) < (alarmHour*60+alarmMinutes) ? (alarmHour*60+alarmMinutes) - (currentHour*60+currentMinutes) : 24*60 - ((currentHour*60+currentMinutes) - (alarmHour*60 + alarmMinutes));

		System.out.println("Current time: " + currentHour + ":" + currentMinutes);
		if (delayInMinutes > 60) {
			System.out.println("Next alarm in " + delayInMinutes/60 + " hours, " + delayInMinutes%60 + " minutes.");
		}
		else {
			System.out.println("Next alarm in: " + delayInMinutes + " minutes");
		}
		
		executor.scheduleAtFixedRate(alarm, delayInMinutes, 24*60, TimeUnit.MINUTES);
		
		
		scanner.close();
				
	}
}
