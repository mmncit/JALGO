package algorithms;

/*
 * CarbonCalculatorTester
 *
 * A class to test the functions in CarbonCalculator class
 *
 */
public class CarbonCalculatorTester {

    private static int testPassCount = 0;
    private static int testCount = 0;

    // sample data you can use for tests
    private static double[] person1 = { 16, 19, 12, 18 }; // Carbon Footprint 16
    private static double[] person2 = { 14.4, 9, 5, 0 }; // Carbon Footprint 7
    private static double[] person3 = { 10, 2, 20, 9 }; // Carbon Footprint 2

    private static double[][] population1 = { person2 };
    private static double[][] population3 = { person3, person2, person1 };

    public static void main(String[] args) {

	testAutoUsage();
	testCalcAutoOwnership();
	testCalcTransit();
	testCalcCarbonFootprint();
	testCalcCarbonFootprints();
	testPopulationReport();

	System.out.println("Passed " + testPassCount + "/" + testCount
		+ " tests");

    }

    public static void displayResults(boolean passed, String testName) {
	/*
	 * There is some magic going on here getting the line number Borrowed
	 * from:
	 * http://blog.taragana.com/index.php/archive/core-java-how-to-get-
	 * java-source-code-line-number-file-name-in-code/
	 * 
	 * Once we've discussed Exceptions in more detail this won't be
	 * required.
	 */

	testCount++;
	if (passed) {
	    System.out.println("Passed test: " + testName);
	    testPassCount++;
	} else {
	    System.out
		    .println("Failed test: "
			    + testName
			    + " at line "
			    + Thread.currentThread().getStackTrace()[2]
				    .getLineNumber());
	}

    }

    public static void testAutoUsage() {
	double fuelEff = 14.4;
	int kmsDrive = 9;
	int result = 0;

	result = CarbonCalculator.calcAutoUsage(fuelEff, kmsDrive);
	// System.out.println("should be 6078:" + result);
	displayResults(result == 6078, "testAutoUsage");

	fuelEff = 21.2;
	kmsDrive = 21;

	result = CarbonCalculator.calcAutoUsage(fuelEff, kmsDrive);
	// System.out.println("should be 20880:" + result);
	displayResults(result == 20880, "testAutoUsage");

    }

    public static void testCalcAutoOwnership() {
	int age = 5;
	int result = 0;

	result = CarbonCalculator.calcAutoOwnership(age);
	// System.out.println("should be 1409:" + result);
	displayResults(result == 1409, "testCalcAutoOwnership");

	age = 9;

	result = CarbonCalculator.calcAutoOwnership(age);
	// System.out.println("should be 868:" + result);
	displayResults(result == 868, "testCalcAutoOwnership");

    }

    public static void testCalcTransit() {
	int kms = 0;
	int result = 0;

	result = CarbonCalculator.calcTransit(kms);
	// System.out.println("should be 0:" + result);
	displayResults(result == 0, "testCalcTransit");

	kms = 22;
	result = CarbonCalculator.calcTransit(kms);
	// System.out.println("should be 1445:" + result);
	displayResults(result == 1445, "testCalcTransit");

	kms = 2;
	result = CarbonCalculator.calcTransit(kms);
	// System.out.println("should be 131:" + result);
	displayResults(result == 131, "testCalcTransit");

    }

    public static void testCalcCarbonFootprint() {
	int result = 0;

	result = CarbonCalculator.calcCarbonFootprint(person1);
	// System.out.println("should be 16:" + result);
	displayResults(result == 16, "testCalcCarbonFootprint");

	result = CarbonCalculator.calcCarbonFootprint(person2);
	// System.out.println("should be 7:" + result);
	displayResults(result == 7, "testCalcCarbonFootprint");

	result = CarbonCalculator.calcCarbonFootprint(person3);
	// System.out.println("should be 2:" + result);
	displayResults(result == 2, "testCalcCarbonFootprint");

    }

    public static void testCalcCarbonFootprints() {

	int result1[] = new int[population1.length];
	int expected1[] = { 7 };

	CarbonCalculator.calcCarbonFootprints(population1, result1);
	// System.out.print("should be:");
	// ArrayOperations.printArray(expected1);
	// System.out.print("is:");
	// ArrayOperations.printArray(result1);
	displayResults(ArrayOperations.arraysEqual(result1, expected1),
		"testCalcCarbonFootprints");

	int result2[] = new int[population3.length];
	int expected2[] = { 2, 7, 16 };

	CarbonCalculator.calcCarbonFootprints(population3, result2);
	// System.out.print("should be:");
	// ArrayOperations.printArray(expected2);
	// System.out.print("is:");
	// ArrayOperations.printArray(result2);
	displayResults(ArrayOperations.arraysEqual(result2, expected2),
		"testCalcCarbonFootprints");

    }

    public static void testPopulationReport() {
	int test1[] = { 20 };
	int result1[] = new int[CarbonCalculator.NUM_STATS];
	int expected1[] = { 20, 20, 20, 20 };

	CarbonCalculator.populationReport(test1, result1);
	// System.out.print("should be:");
	// ArrayOperations.printArray(expected1);
	// System.out.print("is:");
	// ArrayOperations.printArray(result1);
	displayResults(ArrayOperations.arraysEqual(result1, expected1),
		"testPopulationReport");

	int test6[] = { 20, 50, 10, 89, 72, 19 };
	int result6[] = new int[CarbonCalculator.NUM_STATS];
	int expected6[] = { 260, 89, 10, 43 };

	CarbonCalculator.populationReport(test6, result6);
	// System.out.print("should be:");
	// ArrayOperations.printArray(expected6);
	// System.out.print("is:");
	// ArrayOperations.printArray(result6);
	displayResults(ArrayOperations.arraysEqual(result6, expected6),
		"testPopulationReport");
    }

}