import java.util.Iterator;

public class TableIterator<E> implements Iterator<E> {
    private E[] lista;
    private int index;

    public TableIterator(E[] lista) {
        this.lista = lista;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < lista.length;
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        return lista[index++];
    }
}