import core.AbstractSwappingSortingAlgorithm;
import testing.comparators.AscendingComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SelectionSort<T> extends AbstractSwappingSortingAlgorithm<T> {

    public SelectionSort(Comparator<? super T> comparator) {
        super(comparator);
    }


    @Override
    public List<T> sort(List<T> list){
        int n = list.size();
        for (int i = 0; i < n / 2; i++) {
            int currentMin = i;
            int currentMax = i;
            for (int j = i + 1; j < n - i; j++) {
                if (compare(list.get(currentMin), list.get(j)) > 0) {
                    currentMin = j;
                }
                if (compare(list.get(currentMax), list.get(j)) < 0) {
                    currentMax = j;
                }
            }
            swap(list, currentMin, i);
            if (currentMax == i) {
                currentMax = currentMin;
            }
            swap(list, currentMax, n - i - 1);
        }
        return list;
    }

    public static void main(String[] args){
        List<Integer> lista1 = new ArrayList<>();
        lista1.add(5);
        lista1.add(2);
        lista1.add(4);
        lista1.add(51);
        lista1.add(0);
        SelectionSort<Integer> sort1 = new SelectionSort<>(new AscendingComparator<>());
        sort1.sort(lista1);

        for (int el:lista1){
            System.out.println(el);
        }
    }


}
