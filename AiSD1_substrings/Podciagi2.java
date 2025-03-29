import java.util.Arrays;

public class Podciagi2 {
    public static int[][] longestNondecreasingSubstrings(int[] numbers) {
        if (numbers.length == 0) {
            return new int[0][0];
        }
        int lastNumber = 0;
        int[][] result = new int[numbers.length][];

        int resultTabIndex = 0;
        int indexOfTab = 0;
        int[] tabPom = new int[numbers.length];

        if (numbers.length > 1) {
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] >= numbers[i - 1]) {
                    tabPom[indexOfTab] = numbers[i - 1];
                    indexOfTab++;
                    tabPom[indexOfTab] = numbers[i];

                } else {
                    tabPom[indexOfTab] = numbers[i - 1];
                    indexOfTab++;
                    //sprawdzam czy to juz jest ostatni element aby tez go uwzglednic

                    result[resultTabIndex] = new int[indexOfTab];

                    for (int k = 0; k < indexOfTab; k++) {
                        result[resultTabIndex][k] = tabPom[k];
                    }
                    resultTabIndex++;

                    if (i == numbers.length - 1 && numbers[i] != tabPom[indexOfTab - 1]) {
                        result[resultTabIndex] = new int[1];
                        result[resultTabIndex][0] = numbers[i];
                        resultTabIndex++;
                    }
                    tabPom = new int[numbers.length];
                    indexOfTab = 0;
                }
            }
        } else {
            int[][] finalResult = new int[1][1];
            finalResult[0][0] = numbers[0];
            return finalResult;
        }
        int[][] finalResult = new int[resultTabIndex][];
        int indexFinal = 0;
        for (int[] list : result) {
            if (list != null) {
                finalResult[indexFinal] = new int[list.length];
                for (int i = 0; i < list.length; i++) {
                    finalResult[indexFinal][i] = list[i];
                }
                indexFinal++;
            }
        }
        return finalResult;
    }

    public static void main(String[] args) {
        int[] numbers = {0, 1, 2, 8, -3, -3, -4, 0, 7, 10, 0};
        int[][] result = longestNondecreasingSubstrings(numbers);
        int lastNumber = 0;
        for (int[] list : result) {
            for (int element : list) {
                System.out.print(element + " ");
            }
            System.out.println();
        }


    }
}



