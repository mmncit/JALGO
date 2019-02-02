package algorithms;

/*
 * CarbonCalculator
 *
 * A class with basic carbon footprint calculation functions
 *
 */
public class CarbonCalculator {

    // Calculation constants:
    private static final double KGCO2_PER_LGAS = 12.85; // KG of CO2 per litre
							// of gas
    private static final double KGCO2_PER_M3GAS = 1.94; // KG of CO2 per cubic
							// meter of gas
    private static final double M3_PER_GJGAS = 26.137; // cubic meters (M3) of
						       // gas per gigajoule (GJ)
    private static final double GJ_MANUF_COST = 120; // total auto manufacturing
						     // cost in GJs
    private static final double GJ_MAINT_COST_PER_YR = 3.8; // auto maintenance
							    // cost per year in
							    // GJs
    private static final double KGCO2_PER_TRANSITKM = 0.18; // transit cost per
							    // km in KG of CO2
    private static final double KGS_PER_METRIC_TON = 1000; // number of kgs per
							   // metric ton
    private static final int DAYS_PER_YR = 365; // number of days in a calendar
						// year

    // Array access constants:
    protected static final int FUEL_EFF_INDEX = 0;
    protected static final int KMS_DRIVE_INDEX = 1;
    protected static final int CAR_AGE_INDEX = 2;
    protected static final int KMS_TRANSIT_INDEX = 3;

    protected static final int NUM_PARAMS = 4;
    protected static final int NUM_STATS = 4;
    protected static final int SUM_INDEX = 0;
    protected static final int MAX_INDEX = 1;
    protected static final int MIN_INDEX = 2;
    protected static final int AVG_INDEX = 3;

    /*
     * calcAutoUsage
     * 
     * Purpose: calculates the CO2 emissions for automobile use -uses kgCO2
     * generated per liter of gas as KGCO2_PER_LGAS -liters of gas used per year
     * calculated as: DAYS_PER_YR * (kms driven per day * fuel efficiency),
     * where fuelEfficiency of the car is in liters per km. NOTE: fuel
     * efficiency is input to the method as: liters per 100 km
     * 
     * Parameters: double - fuel efficiency of the car in liters per 100 km, int
     * - kms driven per day
     * 
     * Preconditions: none
     * 
     * Returns: carbon foot print of auto usage in kgCO2 cast to an integer
     */
    public static int calcAutoUsage(double fuelEfficiency, int kmPerDay) {

	double liters_per_year = DAYS_PER_YR
		* (kmPerDay * (fuelEfficiency / 100.0));
	double kgCO2 = KGCO2_PER_LGAS * liters_per_year;
	return (int) kgCO2;
    }

    /*
     * calcAutoOwnership
     * 
     * Purpose: calculates the yearly CO2 emissions for automobile ownership as:
     * kgCO2 for manufacturing + kgCO2 for maintenance -manufacturing is
     * GJ_MANUF_COST gigajoules in total, which is spread over the age of the
     * car ie: cost per year = total carbon to manufacture car ÷ age of car in
     * years -maintenance is GJ_MAINT_COST_PER_YR gigajoules in a year
     * 
     * NOTE: there is M3_PER_GJGAS cubic meters (M3) of gas per gigajoule (GJ)
     * NOTE: there is KGCO2_PER_M3GAS kg of carbon per cubic meter (M3)
     * 
     * 
     * Parameters: int - age of the car in years
     * 
     * Preconditions: none
     * 
     * Returns: carbon foot print of auto ownership in kgCO2 cast to an integer
     */
    public static int calcAutoOwnership(int age) {

	double manufacturing = GJ_MANUF_COST / age;
	double kgCO2 = (manufacturing + GJ_MAINT_COST_PER_YR) * M3_PER_GJGAS
		* KGCO2_PER_M3GAS;
	return (int) kgCO2;
    }

    /*
     * calcTransit
     * 
     * Purpose: calculates the yearly CO2 emissions for public transit where,
     * KGCO2_PER_TRANSITKM kg of CO2 is generated per km on transit
     * 
     * Parameters: int - average number of kms per day riding transit
     * 
     * Preconditions: none
     * 
     * Returns: carbon foot print of public transit use in kgCO2 cast to an
     * integer
     */
    public static int calcTransit(int km_per_day) {

	double kgCO2 = km_per_day * DAYS_PER_YR * KGCO2_PER_TRANSITKM;
	return (int) kgCO2;
    }

    /*
     * calcCarbonFootprint
     * 
     * Purpose: calculates carbon foot print of a person for year as: the sum of
     * kgCO2 emissions for automobile usage and ownership and transit use
     * converted to metric tons (KGS_PER_METRIC_TON kgs in a metric ton)
     * 
     * Parameters: double[] - an array of data from a single person at the
     * following indices: [FUEL_EFF_INDEX] - their car's fuel efficiency
     * [KMS_DRIVE_INDEX] - the average number of kms they drive in a day
     * [CAR_AGE_INDEX] - their car's age in years [KMS_TRANSIT_INDEX] - the
     * average number of kms they ride the bus in a day
     * 
     * Preconditions: none
     * 
     * Returns: total carbon foot print in metric tons per year as an integer
     */
    public static int calcCarbonFootprint(double[] data) {

	int auto_usage = calcAutoUsage((int) data[FUEL_EFF_INDEX],
		((int) data[KMS_DRIVE_INDEX]));
	int auto_ownership = calcAutoOwnership(((int) data[CAR_AGE_INDEX]));
	int transit = calcTransit(((int) data[KMS_TRANSIT_INDEX]));

	double tons = (auto_usage + auto_ownership + transit);
	tons = tons / KGS_PER_METRIC_TON;

	return (int) tons;
    }

    /*
     * calcCarbonFootprints
     * 
     * Purpose: calculates carbon foot print of each person in a population and
     * store the result in the corresponding index of the 1D result array
     * 
     * Parameters: double[] - a 2D array of data for a populution where, each
     * row represents an individual in the population and each column of a row
     * has the following data for that individual: -fuel efficiency of their car
     * -average kms driven per day -the age of their car -average kms on transit
     * per day int[] - a 1D array to store the total carbon footprint for each
     * individual
     * 
     * Preconditions: none
     * 
     * Returns: void
     */
    public static void calcCarbonFootprints(double[][] data,
	    int[] carbon_footprint_results) {
	int i = 0;
	for (double[] person : data) {
	    carbon_footprint_results[i++] = calcCarbonFootprint(person);
	}
    }

    /*
     * populationReport
     * 
     * Purpose: calculates stats (total, max, min and average) of carbon
     * footprint data of individuals in a population, stores the values of the
     * calculated stats into the array: -total stored at index SUM_INDEX -max
     * stored at index MAX_INDEX, -min stored at index MIN_INDEX, -average
     * stored at index AVG_INDEX (see constants listed at the top of this file)
     * 
     * Parameters: int[] - a 1D array of the carbon footprint result for a
     * population, int[] - a 1D array to store the stats results (total, max,
     * min and average)
     * 
     * Preconditions: none
     * 
     * Returns: void
     */
    public static void populationReport(int[] carbon_footprints,
	    int[] stats_results) {

	stats_results[0] = ArrayOperations.arraySum(carbon_footprints);
	stats_results[1] = ArrayOperations.arrayMax(carbon_footprints);
	stats_results[2] = ArrayOperations.arrayMin(carbon_footprints);
	stats_results[3] = (int) ArrayOperations.arrayAvg(carbon_footprints);

    }
    // HINT: You should use the methods you wrote in ArrayOperations.java for
    // this method. T
    // The syntax for accessing these methods is to write something like:
    // x = ArrayOperations.arraySum(input);

}