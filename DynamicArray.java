public class DynamicArray {
    private int[] array;
    private int size;
    private int maxCapacity;

    public DynamicArray() {
        maxCapacity = 25; 
        array = new int[maxCapacity];
        size = 0;
    }

    public void addElement(int element) {
        if (size == maxCapacity) {
            arrayResize();
        }
        array[size] = element;
        size++;
    }

    public int getElement(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds  " + size);
        }
        return array[index];
    }

    public int size() {
        return size;
    }


    public void removeElement(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds  " + size);
        }
        
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    
    private void arrayResize() {
        maxCapacity *= 2; 
        int[] newArray = new int[maxCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addElement(20);
        dynamicArray.addElement(10);
        dynamicArray.addElement(30);
        dynamicArray.addElement(50);

        System.out.println("Size of array before removal: " + dynamicArray.size());
        dynamicArray.removeElement(2); 
        System.out.println("Size of array after removal: " + dynamicArray.size());
        System.out.println("Element at index 1 : " + dynamicArray.getElement(1));
    }
}
