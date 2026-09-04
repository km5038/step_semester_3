public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];

        int leftProduct = 1;

        // Store product of all elements to the left
        for (int i = 0; i < nums.length; i++) {

            answer[i] = leftProduct;
            leftProduct = leftProduct * nums[i];
        }

        int rightProduct = 1;

        // Multiply by product of all elements to the right
        for (int i = nums.length - 1; i >= 0; i--) {

            answer[i] = answer[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);

        for (int i = 0; i < result.length; i++) {

            System.out.print(result[i] + " ");
        }
    }
}