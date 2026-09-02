class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum=n*(n+1)/2;
        int numsum=0;
        for (int i=0;i<n;i++){
            numsum+=nums[i];
        }
        int ans=sum-numsum;
        return ans;
    }
}