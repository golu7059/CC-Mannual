import java.util.Stack;

public class NextGreaterElement {
    public static void printNGE(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int nge[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.empty() && s.peek() <= arr[i]) {
                s.pop();
            }

            nge[i] = s.empty() ? -1 : s.peek();
            s.push(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " --> " + nge[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = {11, 13, 21, 3};
        printNGE(arr);
    }
}
