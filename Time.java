public class Time { // unfinished work!

    boolean leapYear = true;

    /**
     * Determines the number of days in a month.
     * 
     * @author Carrano, F., Prichard, J. (2006). Book: Data abstraction and
     *         problem solving with Java : Walls and mirrors (2nd ed) page: 23
     * 
     * @param month
     *            nonnegative integer designating the month
     * @return the number of days in the given month
     */
    public int getNumberOfDays(int month) {
	int daysInMonth = 0;
	switch (month) {
	// 30 days hath April, June, September and November
	case 4:
	case 6:
	case 9:
	case 11:
	    daysInMonth = 30;
	    break;
	// all the rest have 31 days
	case 1:
	case 3:
	case 5:
	case 7:
	case 8:
	case 10:
	case 12:
	    daysInMonth = 31;
	    break;
	// except February
	case 2:
	    if (this.leapYear) {
		daysInMonth = 29;
	    } else {
		daysInMonth = 28;
	    }
	    break;
	default:
	    System.err.println("Incorrect vale for month.");
	}
	return daysInMonth;
    }
}
