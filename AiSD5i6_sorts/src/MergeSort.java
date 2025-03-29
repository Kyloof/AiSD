import core.AbstractSortingAlgorithm;
import testing.comparators.IntegerComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeSort<T> extends AbstractSortingAlgorithm<T> {


    public MergeSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    @SuppressWarnings("unchecked")
    public LinkedList<T> merge(LinkedList<T> l1, LinkedList<T> l2){
        LinkedList<T> newList = new LinkedList<>();
        while(!l1.isEmpty() || !l2.isEmpty()){

            if(l2.isEmpty()) newList.addLast(l1.pop());
            else if(l1.isEmpty()) newList.addLast(l2.pop());

            else {
                if (compare(l1.getFirst(), l2.getFirst()) <= 0) {
                    newList.addLast(l1.pop());
                } else {
                    newList.addLast(l2.pop());
                }
            }
        }
        return newList;
    }

    @Override
    public List<T> sort(List<T> list) {
        LinkedList<LinkedList<T>> queue = new LinkedList<>();
        for (T element:list){
            LinkedList<T> newList = new LinkedList<>();
            newList.addLast(element);
            queue.addLast(newList);
        }

        while(queue.size()>1){
            queue.addLast(merge(queue.pop(),queue.pop()));
        }

        int size = list.size();
        for(int i=0; i<size;i++){
            list.set(i,queue.get(0).pop());
        }
        return list;
    }

    public static void main(String[] args){
        MergeSort<Integer> mergeSort = new MergeSort<>(new IntegerComparator());
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(2);
        list.add(109);
        list.add(4);
        list.add(2);
        list.add(0);

        List<Integer> List1 = mergeSort.sort(list);
        for(Integer element:list){
            System.out.println(element);
        }

    }
}