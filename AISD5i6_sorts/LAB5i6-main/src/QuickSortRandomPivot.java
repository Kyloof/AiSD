import core.AbstractSwappingSortingAlgorithm;
import testing.comparators.AscendingComparator;

import java.util.*;

public class QuickSortRandomPivot<T> extends AbstractSwappingSortingAlgorithm<T> {
    Random random = new Random();

    public QuickSortRandomPivot(Comparator<? super T> comparator) {
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
        int pivotIndex = random.nextInt(start,end);
        T pivot = list.get(pivotIndex);
        swap(list,pivotIndex,end);
        int i = start;
        for (int j = start; j < end; j++){
            if (compare(list.get(j),pivot)<0){
                swap(list,i,j);
                i++;
            }
        }
        swap(list,i,end);
        return i;
    }

    public static void main(String[] args) {
        List<Integer> lista1 = new ArrayList<>();

        QuickSort<Integer> sort1 = new QuickSort<>(new AscendingComparator<>());

        lista1.add(5);
        lista1.add(2);
        lista1.add(4);
        lista1.add(51);
        lista1.add(0);
        sort1.sort(lista1);

        for (int el : lista1) {
            System.out.println(el);
        }
    }
}
