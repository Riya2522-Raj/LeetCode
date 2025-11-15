class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        
        int countOnes = 0;
        for (int num : nums) {
            if (num == 1) countOnes++;
        }
    
        if (countOnes > 0) {
            return n - countOnes;
        }
        
        
        int minLen = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int currentGcd = nums[i];
            for (int j = i; j < n; j++) {
                currentGcd = gcd(currentGcd, nums[j]);
                if (currentGcd == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        

        if (minLen == Integer.MAX_VALUE) {
            return -1;
        }
        
        
        return n + minLen - 2;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}