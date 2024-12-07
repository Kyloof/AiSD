package testing.results;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class CSVResult {
    private int inputSize;

    private double time;

    private double stdvTime;
    private double avgComparisons;

    private double stdvComparisons;

    private double avgSwaps;

    private double stdvSwaps;

    private String dir;

    public CSVResult(int inputSize, double time, double stdvTime, double avgComparisons, double stdvComparisons, double avgSwaps, double stdvSwaps, String dir) {
        this.inputSize = inputSize;
        this.time = time;
        this.avgComparisons = avgComparisons;
        this.avgSwaps = avgSwaps;
        this.stdvTime = stdvTime;
        this.stdvSwaps = stdvSwaps;
        this.stdvComparisons = stdvComparisons;
        this.dir = dir;
    }

    public void writeData() throws IOException {
        FileWriter csvWriter = new FileWriter(dir, true);
        csvWriter.append(String.join(";",
                String.valueOf(inputSize),
                String.format(Locale.GERMANY, "%.12f", time),
                String.format(Locale.GERMANY, "%.12f", stdvTime),
                String.format(Locale.GERMANY, "%.12f", avgComparisons),
                String.format(Locale.GERMANY, "%.12f", stdvComparisons),
                String.format(Locale.GERMANY, "%.12f", avgSwaps),
                String.format(Locale.GERMANY, "%.12f", stdvSwaps)
        ));
        csvWriter.append("\n");
        csvWriter.flush();
        csvWriter.close();
    }
}