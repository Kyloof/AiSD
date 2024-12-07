import java.util.Arrays;

public class Podciagi {
    public static int[][] longestNondecreasingSubstrings(int[] numbers) {
        if (numbers.length == 0) {
            return new int[0][0];
        }

        int[][] result = new int[numbers.length][numbers.length];
        int indexOfTab = 0;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] >= numbers[i - 1]) {
                result[indexOfTab][i-1] = numbers[i-1];
                result[indexOfTab][i] = numbers[i];
            }

            else if (numbers[i] < numbers[i - 1]){
                result[indexOfTab][i-1] = numbers[i-1];
                indexOfTab+=1;
                //sprawdzam czy to juz jest ostatni element aby tez go uwzglednic
                if (i == numbers.length-1){
                    result[indexOfTab][i] = numbers[i];
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {


        int[] numbers = {0, 1, 2, 8, -3, -3, -4, 0, 7, 10, 0 };
        int[][] result = longestNondecreasingSubstrings(numbers);
        int lastNumber = 0;
        boolean isZero = false;
            for (int[] list : result) {
                if (isZero){
                    break;
                }
                isZero=true;
                System.out.println();
                for (int i = 0; i < list.length; i++) {
                    if (list[i] != 0)
                        isZero = false;
                    if (list[i] == 0 ){
                        if (i==0 && list[i]<=list[i+1] && list[i+1] != 0){
                            System.out.print(list[i] + " ");
                            lastNumber=list[i];
                        }
                        else if (i==list.length-1 && lastNumber == list[i-1] && list[i-1]<=list[i] && lastNumber!=0){
                            System.out.print(list[i]);
                            lastNumber=list[i];
                        }
                        else if (i>0 && list[i]>list[i-1]){
                            System.out.print(list[i] + " ");
                            lastNumber=list[i];
                        }
                    }
                    else{
                        System.out.print(list[i] + " ");
                        lastNumber=list[i];
                    }


                }
            }
        }
    }


