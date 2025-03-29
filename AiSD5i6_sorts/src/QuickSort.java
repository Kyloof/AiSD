import core.AbstractSortingAlgorithm;
import core.AbstractSwappingSortingAlgorithm;
import testing.comparators.AscendingComparator;
import testing.comparators.DescendingComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QuickSort<T> extends AbstractSwappingSortingAlgorithm<T> {

    public QuickSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {
        quickSort(list,0,list.size()-1);
        return list;
    }

    private void quickSort(List<T> list,int start,int end){
        if (end<=start) return;

        int pivotPos = partition(list,start,end);
        quickSort(list,start,pivotPos - 1);
        quickSort(list,pivotPos + 1,end);


    }

    private int partition(List<T> list, int start, int end){
        T pivot = list.get(start);
        int i = end + 1;

        for (int j = end; j > start; j--){
            if (compare(list.get(j),pivot)>0){
                i--;
                swap(list,i,j);
            }
        }
        i--;
        swap(list,i,start);
        return i;
    }

    public static void main(String[] args) {
        List<Integer> lista1 = new ArrayList<>();

        QuickSort<Integer> sort1 = new QuickSort<>(new DescendingComparator<>());
        sort1.sort(lista1);

        for (int el : lista1) {
            System.out.println(el);
        }
    }
}
