package others;

/*Given a date, return the corresponding day of the week for that date.

		The input is given as three integers representing the day, month and year respectively.

		Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.



		Example 1:

		Input: day = 31, month = 8, year = 2019
		Output: "Saturday"
		Example 2:

		Input: day = 18, month = 7, year = 1999
		Output: "Sunday"
		Example 3:

		Input: day = 15, month = 8, year = 1993
		Output: "Sunday"


		Constraints:

		The given dates are valid dates between the years 1971 and 2100.*/
public class DayOfTheWeek {

	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Day of the Week.
	 * Memory Usage: 33.8 MB, less than 100.00% of Java online submissions for Day of the Week.
	 */
	public String dayOfTheWeek(int day, int month, int year) {

		String[] results = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] months = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
        int startYear = 1971,days = 0;

        while(startYear < year){
              days += startYear % 4 == 0 ? 366:365;
              startYear++;
        }
		// we don't wanna add an other day when the given day is 29 and it is already a leap year
        days += year % 4 == 0 && day != 29 ? 1 : 0;
        for(int i = 0; i < month; i++) {

        	days += months[i];
        }

        days += day;
		// Since 1971 started with a friday I have added 4 to the number of days
        return results[(days % 7 + 4) % 7];
    }

	public static void main(String[] args) {

		int day = 31, month = 8, year = 2019;

		System.out.println(new DayOfTheWeek().dayOfTheWeek(day, month, year));
	}
}
