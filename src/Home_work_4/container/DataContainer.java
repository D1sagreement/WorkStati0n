package Home_work_4.container;

import java.util.Arrays;
import java.util.Comparator;

public class DataContainer<T> {
    private T[] data;

    @SuppressWarnings("Непроверенно")
    public DataContainer(T[] initData) {
        this.data = initData != null ? initData : (T[]) new Object[0];
    }

    public int add(T item) {
        if (item == null) {
            return -1;
        }

        int firstEmptyIndex = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                firstEmptyIndex = i;
                break;
            }
        }

        if (firstEmptyIndex != -1) {
            data[firstEmptyIndex] = item;
            return firstEmptyIndex;
        } else {
            data = Arrays.copyOf(data, data.length + 1);
            data[data.length - 1] = item;
            return data.length - 1;
        }
    }

    public T get(int index) {
        if (index < 0 || index >= data.length) {
            return null;
        }

        return data[index];
    }

    public T[] getItems() {
        return data;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= data.length || data[index] == null) {
            return false;
        }

        @SuppressWarnings("Непроверенно")
        T[] newData = (T[]) new Object[data.length - 1];

        for (int i = 0, j = 0; i < data.length; i++) {
            if (i != index) {
                newData[j++] = data[i];
            }
        }

        data = newData;
        return true;

    }

    public boolean delete(T item) {
        if (item == null) {
            return false;
        }

        int indexToDelete = -1;
        for (int i = 0; i < data.length; i++) {
            if (item.equals(data[i])) {
                indexToDelete = i;
                break;
            }
        }
        if (indexToDelete == -1) {
            return false;
        }

        return delete(indexToDelete);
    }

    public void sort(Comparator<? super T> comparator) {
        if (comparator == null) {
            return;
        }

        for (int i = 0; i < data.length -1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (comparator.compare(data[j], data[j + 1]) > 0) {
                    T temp = data[j];
                    data[j] = data [j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        boolean first = true;

        for (T item : data) {
            if (item != null) {
                if (!first) {
                    sb.append(", ");
                }

                sb.append(item);
                first = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
