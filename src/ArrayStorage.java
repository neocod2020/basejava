import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    public Resume[] storage = new Resume[10000];

    private int size;


    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public void save(Resume r) {
        arrange();
        storage[size] = r;
        size++;
        System.out.println("save resume: " + storage[size - 1] + ", size= " + size());
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                storage[i] = null;
                arrange();
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        arrange();
        Resume[] valueArray = new Resume[size];
        System.arraycopy(storage, 0, valueArray, 0, size);
        return valueArray;
    }

    private void arrange() {
        Resume[] sortedArray = new Resume[storage.length];
        size = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                sortedArray[size] = storage[i];
                size++;
            }
        }
        storage = sortedArray;
    }

    public int size() {
        return size;
    }
}
