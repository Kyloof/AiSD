import core.AbstractSortingAlgorithm;
import core.AbstractSwappingSortingAlgorithm;
import testing.comparators.AscendingComparator;
import testing.comparators.DescendingComparator;
import testing.comparators.IntegerComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InsertSort<T> extends AbstractSwappingSortingAlgorithm<T> {
    public InsertSort(Comparator<? super T> comparator) {
        super(comparator);
    }
    private int binarySearch(List<T> list, T what, int left, int right) {
        while (left <= right) {
            int middle = (left + right) / 2;
            int compValue = compare(what, list.get(middle));
            if (compValue < 0)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return left;
    }

    @Override
    public List<T> sort(List<T> list) {
        int n = list.size();
        for (int i = 1; i < n; ++i) {
            T item = list.get(i);
            int pos = binarySearch(list, item, 0, i);
            int j = i;
            while (pos<j && list.get(j-1)!=list.get(j)) {
                swap(list, j, j - 1);
                j--;

            }


        }
        return list;

    }

    public static void main(String[] args){
        List<Integer> lista1 = new ArrayList<>();
        lista1.add(5);
        lista1.add(2);
        lista1.add(2);
        lista1.add(51);
        lista1.add(0);

        InsertSort<Integer> insertSort = new InsertSort<>(new AscendingComparator<>());
        lista1 = insertSort.sort(lista1);
        for (int el:lista1){
            System.out.println(el);
        }
    }



}
