class Solution {
    public void sortColors(int[] nums) {

        int r = 0, w = 0, b = nums.length-1;

        while( w <= b){
            if(nums[w] == 0){
                int temp = nums[r];
                nums[r] = nums[w];
                nums[w] = temp;
                r++;
                w++;     
        }else if( nums[w] == 1){
            w++;
        }else{
            int temp = nums[w];
            nums[w] = nums[b];
            nums[b] = temp;
            b--;

        }
         
        }
        
    }
}