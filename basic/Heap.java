/**
 * 堆化分为两种  从上到下  从下到上
 */
public class Heap {
    private int[] a;// 数组从下标1开始存储数据

    private int n; // 堆存储的最大数据个数

    private int count; // 堆已经存储的数据个数


    public Heap(int capcity) {
        this.a = new int[capcity+1];
        this.n = capcity;
        this.count = 0;
    }

    public Heap(int[] a) {
        this.a = a;
        this.n = a.length-1;
        this.count=a.length-1;
    }

    /**
     * 将对内数组堆化
     */
    public void buildHeap(){
        for (int i=(a.length)/2;i>0;i--){
            heapify(a,i);
        }
    }


    /**
     * 从下往上堆化
     * @param data 插入数据
     */
    public void insert(int data){
        if(n == count) return; // 堆满了
        count++;
        a[count] = data;
        int i = count;
        while (i/2 >0 && a[i]>a[i/2]){
            swap(a,i,i/2);
            i=i/2;
        }
    }

    /**
     * 从上往下对话
     */
    public int removeMax(){
        if(count == 0) return -1;
        int max = a[1];
        a[1]=a[count];
        count--;
        heapify(a,1);
        return max;
    }

    /**
     * @param a 数组
     * @param i 开始堆化的起始位置
     */
    private void heapify(int[] a,int i){ // 自上向下堆化
        while (true){
            int maxPos = i;
            if(i*2<=this.count && a[i]<a[i*2]) maxPos=i*2; // 左边元素对比
             if(i*2+1<=this.count && a[i]<a[i*2+1]) maxPos=i*2+1; // 右边元素对比
            swap(a,i,maxPos);
            if(maxPos == i) break;
            i=maxPos;
        }

    }




    private void swap(int[] a,int i,int j){
        a[0]= a[i];
        a[i] = a[j];
        a[j] = a[0];
    }
}
