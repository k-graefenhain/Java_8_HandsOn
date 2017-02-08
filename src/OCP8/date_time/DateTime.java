package OCP8.date_time;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateTime {

	public static void main(String[] args) {
		System.out.println("plusMonths: ");
		LocalDate date = LocalDate.of(2016, 1, 31).plusMonths(1);
		System.out.println(date);

		System.out.println("now / plusYears: ");
		date = LocalDate.of(2015, 1, 31).now();		// now: static method that obtains the current date
		date.plusYears(2);					// WATCH OUT: date and time instances are immutable
		System.out.println(date);

		System.out.println("withDayOfMonth: // Returns a copy of this {@code LocalDateTime} with the day-of-month altered.");
		LocalDateTime ldt = LocalDateTime.of(LocalDate.of(2015,1,1), LocalTime.of(11,21));
		ldt = ldt.withDayOfMonth(12);
		System.out.println(ldt.getMonth() + ":" + ldt.getDayOfMonth() + ":" + ldt.getHour());

		System.out.println("atDay / atStartOfDay: ");
		Year y = Year.of(1991);
		LocalDate loc = y.atDay(32);
		ldt = loc.atStartOfDay();
		System.out.println(ldt);

		System.out.println("atMonthDay; ");
		y = Year.of(2014);
		LocalDate ym = y.atMonthDay(MonthDay.of(3, 3));
		System.out.println(ym);

		System.out.println("Period plusYears / withYear: ");
		System.out.println();
		Period p = Period.ofMonths(2);
		p = p.plusYears(1);
		System.out.println(p);
		p = p.withYears(2);
		System.out.println(p);

		System.out.println("last day of 2016: ");
		LocalDate last2016 = LocalDate.ofYearDay(2016, 365);
		System.out.println(last2016);

		System.out.println("plus(long amoung, TemporalAmount unit): ");
		Duration due = Duration.ofDays(-3);
		LocalDate ld = LocalDate.of(2017, 1, 1);
//		ld.plus(due.toDays());		// plus takes TemporalAmount, or long and TemporalUnit (Duration.toDays returns long)
		System.out.println(ld.plus(due.toDays(), ChronoUnit.DAYS));
	}
}
