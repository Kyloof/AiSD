import java.util.Iterator;

public class Table<E> implements Iterable<E> {
    private E[] lista;

    public Table(E[] lista) {
        this.lista = lista;
    }

    @Override
    public Iterator<E> iterator() {
        return new TableIterator<>(lista);
    }

}