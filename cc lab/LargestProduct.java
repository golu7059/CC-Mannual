import java.util.PriorityQueue;

public class LargestProduct {
    public static int largestProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > 3) {
                pq.poll();
            }
        }

        int product = 1;
        while (!pq.isEmpty()) {
            product *= pq.poll();
        }
        return product;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 4};
        System.out.println("Largest Product : "+largestProduct(nums));  // Output: 60
    }
}
