import core.AbstractSwappingSortingAlgorithm;
import testing.comparators.AscendingComparator;
import testing.comparators.DescendingComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShakerSort<T> extends AbstractSwappingSortingAlgorithm<T> {

    public ShakerSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {
        boolean isSorted = false;
        int start = 0;
        int end = list.size() - 1;

        while (!isSorted) {
            isSorted = true;

            // Pętla przechodząca od początku do końca listy
            for (int i = start; i < end; i++) {
                if (compare(list.get(i), list.get(i + 1)) > 0) {
                    swap(list, i, i + 1);
                    isSorted = false;
                }
            }
            // Jeśli lista jest już posortowana, kończymy
            if (isSorted) break;

            isSorted = true;
            end--;

            // Pętla przechodząca od końca do początku listy
            for (int i = end - 1; i >= start; i--) {
                if (compare(list.get(i), list.get(i + 1)) > 0) {
                    swap(list, i, i + 1);
                    isSorted = false;
                }
            }
            start++;
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> lista1 = new ArrayList<>();
        lista1.add(5);
        lista1.add(2);
        lista1.add(4);
        lista1.add(51);
        lista1.add(0);

        ShakerSort<Integer> sort1 = new ShakerSort<>(new AscendingComparator<>());
        sort1.sort(lista1);

        for (int el : lista1) {
            System.out.println(el);
        }
    }
}
