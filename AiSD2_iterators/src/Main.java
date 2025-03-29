public class Main {



    public static void main(String[] args){
        //Testowanie pętli foreach na tableach roznych typow danych
        Table<String> tab1 = new Table<String>(new String[]{"napis1", "napis2","napis3"});
        Table<Boolean> tab2 = new Table<Boolean>(new Boolean[]{true,false,true});
        Table<Integer> tab3 = new Table<Integer>(new Integer[]{1,2,3});
        Table<Double> tab4 = new Table<Double>(new Double[]{1.4,2.5,3.2});
        Table<Double> tab5 = new Table<Double>(new Double[]{});

        for(String element : tab1){
            System.out.println(element);
        }
        System.out.println();
        for(Boolean element : tab2){
            System.out.println(element);
        }
        System.out.println();
        for(Integer element : tab3){
            System.out.println(element);
        }
        System.out.println();
        for(Double element : tab4){
            System.out.println(element);
        }
        System.out.println();
        for(Double element : tab5){
            System.out.println(element);
        }

        Integer[] testData = {1, 2, 3, 4, 0};
        TableIterator<Integer> iterator = new TableIterator<>(testData);

        // Testowanie iteratora
        System.out.println("Testowanie iteratora:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();
        //Testowanie PascalIterator

        PascalIterator Pascal1 = new PascalIterator(5);
        while (Pascal1.hasNext()){
            System.out.println(Pascal1.next());
        }

    }
}
