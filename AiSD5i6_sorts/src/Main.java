import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import core.AbstractSortingAlgorithm;
import core.AbstractSwappingSortingAlgorithm;
import testing.*;
import testing.comparators.*;
import testing.generation.*;
import testing.generation.conversion.*;
import testing.results.CSVResult;

public class Main {

	public static void main(String[] args) throws IOException {

		ArrayList<Generator<MarkedValue<Integer>>> generators = new ArrayList<>();
		ArrayList<AbstractSwappingSortingAlgorithm<MarkedValue<Integer>>> sortingSwapAlgorithms = new ArrayList<>();
		Comparator<MarkedValue<Integer>> markedComparator = new MarkedValueComparator<Integer>(new IntegerComparator());

		generators.add(new MarkingGenerator<Integer>(new OrderedIntegerArrayGenerator()));
		generators.add(new MarkingGenerator<Integer>(new RandomIntegerArrayGenerator(10)));
		generators.add(new MarkingGenerator<Integer>(new ShuffledIntegerArrayGenerator()));
		generators.add(new MarkingGenerator<Integer>(new ReversedIntegerArrayGenerator()));

		String[] generatorNames = new String[]{"OrderedIntegerArrayGenerator", "RandomIntegerArrayGenerator", "ShuffledIntegerArrayGenerator", "ReversedIntegerArrayGenerator"};

		sortingSwapAlgorithms.add(new QuickSort<>(markedComparator));
		sortingSwapAlgorithms.add(new QuickSortRandomPivot<>(markedComparator));
		sortingSwapAlgorithms.add(new SelectionSort<>(markedComparator));
		sortingSwapAlgorithms.add(new InsertSort<>(markedComparator));
		sortingSwapAlgorithms.add(new BubbleSort<>(markedComparator));
		sortingSwapAlgorithms.add(new ShakerSort<>(markedComparator));
		sortingSwapAlgorithms.add(new InsertSort<>(markedComparator));


		int[] tab = new int[]{5, 10, 15, 20, 30, 50, 100, 150, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 2000, 5000, 10000};

		Generator<MarkedValue<Integer>> generator = new MarkingGenerator<Integer>(new RandomIntegerArrayGenerator(10));


		for (AbstractSwappingSortingAlgorithm<MarkedValue<Integer>> algorithm : sortingSwapAlgorithms) {
			int index = 0;
			for (Generator<MarkedValue<Integer>> currGenerator : generators) {
				for (int n : tab) {
					testing.results.swapping.Result result = Tester.runNTimes(algorithm, currGenerator, n, 20);
					CSVResult csvResults = new CSVResult(n, result.averageTimeInMilliseconds(), result.timeStandardDeviation(),
							result.averageComparisons(), result.comparisonsStandardDeviation(), result.averageSwaps(), result.swapsStandardDeviation(), algorithm.getClass().getSimpleName() + "_" + generatorNames[index] + ".csv");
					csvResults.writeData();
					printStatistic("time [ms]", result.averageTimeInMilliseconds(), result.timeStandardDeviation());
					printStatistic("comparisons", result.averageComparisons(), result.comparisonsStandardDeviation());

					System.out.println("always sorted: " + result.sorted());
					System.out.println("always stable: " + result.stable());
				}
				index++;
			}

		/*
		int index = 0;
		for (Generator<MarkedValue<Integer>> currGenerator : generators){


			for (int n : tab) {
				AbstractSwappingSortingAlgorithm<MarkedValue<Integer>> algorithm = new BubbleSort<>(markedComparator);
				testing.results.Result result = Tester.runNTimes(algorithm, currGenerator, n, 20);
				CSVResult csvResults = new CSVResult(n, result.averageTimeInMilliseconds(), result.timeStandardDeviation(),
						result.averageComparisons(), result.comparisonsStandardDeviation(), 0,0, algorithm.getClass().getSimpleName() + "_" + generatorNames[index] + ".csv");
				csvResults.writeData();
				printStatistic("time [ms]", result.averageTimeInMilliseconds(), result.timeStandardDeviation());
				printStatistic("comparisons", result.averageComparisons(), result.comparisonsStandardDeviation());

				System.out.println("always sorted: " + result.sorted());
				System.out.println("always stable: " + result.stable());
			}
			index++;
		}
*/
		}
	}



	private static void printStatistic(String label, double average, double stdDev) {
		System.out.println(label + ": " + double2String(average) + " +- " + double2String(stdDev));
	}

	private static String double2String(double value) {
		return String.format("%.12f", value);
	}
}