public class HeapTest {
    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5,6};

        Heap heap = new Heap(a);
        heap.buildHeap();
        System.out.println(heap.removeMax());
        heap.insert(7);

        System.out.println(heap.removeMax());
    }
}
