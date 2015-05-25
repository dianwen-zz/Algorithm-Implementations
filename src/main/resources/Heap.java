package main.resources;

import java.util.Arrays;

/**
 * Created by dianwen on 5/25/15.
 */

public class Heap {
    Integer[] heap;
    int size;

    public Heap(int capacity) {
        heap = new Integer[capacity];
        size = 0;
    }

    public Heap(Integer[] heap) {
        this.heap = heap;
        size = heap.length;
    }

    public void insert(int value) {
        heap[size] = value;
        int valueIndex = size;
        size++;
        while(getParentIndex(valueIndex) >= 0 && heap[getParentIndex(valueIndex)] > heap[valueIndex]) {
            heap[valueIndex] = heap[getParentIndex(valueIndex)];
            valueIndex = getParentIndex(valueIndex);
            heap[valueIndex] = value;
        }
    }

    public Integer remove() {
        if(size > 0) {
            int removedValue = heap[0];
            heap[0] = heap[size - 1];
            heap[size - 1] = null;
            size--;
            int valueIndex = 0;
            // Need to refactor swapping
            while (getLeftChildIndex(valueIndex) < size && getRightChildIndex(valueIndex) < size
                    && heap[getLeftChildIndex(valueIndex)] != null && heap[getRightChildIndex(valueIndex)] != null
                    && (heap[valueIndex] > heap[getLeftChildIndex(valueIndex)] || heap[valueIndex] > heap[getRightChildIndex(valueIndex)])) {
                if (heap[getLeftChildIndex(valueIndex)] > heap[getRightChildIndex(valueIndex)]) {
                    // Swap parent with right child
                    int temp = heap[getRightChildIndex(valueIndex)];
                    heap[getRightChildIndex(valueIndex)] = heap[valueIndex];
                    heap[valueIndex] = temp;
                    valueIndex = getRightChildIndex(valueIndex);
                } else {
                    int temp = heap[getLeftChildIndex(valueIndex)];
                    heap[getLeftChildIndex(valueIndex)] = heap[valueIndex];
                    heap[valueIndex] = temp;
                    valueIndex = getLeftChildIndex(valueIndex);
                }
            }
            if ((getRightChildIndex(valueIndex) >= size || heap[getRightChildIndex(valueIndex)] == null)
                    && (getLeftChildIndex(valueIndex) < size && heap[getLeftChildIndex(valueIndex)] != null)
                    && heap[getLeftChildIndex(valueIndex)] < heap[valueIndex]) {
                int temp = heap[getLeftChildIndex(valueIndex)];
                heap[getLeftChildIndex(valueIndex)] = heap[valueIndex];
                heap[valueIndex] = temp;
            }

            return removedValue;
        }
        return null;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex + 1) / 2 - 1;
    }

    private int getLeftChildIndex(int parentIndex) {
        return (parentIndex + 1) * 2 - 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return (parentIndex + 1) * 2;
    }

    public String toString() {
        return Arrays.toString(heap);
    }

}
