package chapter1_4.exercises;

public class MergeArrays {

    public int[] merge(int[] a, int[] b) {
        int a_i = 0;
        int b_i = 0;
        int i = 0;
        int[] output = new int[a.length + b.length];
        while (a_i < a.length && b_i < b.length) {
            output[i++] = a[a_i] < b[b_i] ? a[a_i++] : b[b_i++];
        }
        while (a_i < a.length) {
            output[i++] = a[a_i++];
        }
        while (b_i < b.length) {
            output[i++] = b[b_i++];
        }
        return output;
    }

    public static void main(String[] args) {
        MergeArrays mergeArrays = new MergeArrays();
        int[] a = {1,2,3,4,5,6,7};
        int[] b = {3,4,5,6,7,10};
        int[] joined = mergeArrays.merge(a, b);
        for (int i = 0; i < joined.length; i++) {
            System.out.println(joined[i] + " ");
        }
    }
}
