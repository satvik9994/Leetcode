class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        printSubsets(nums,0,list,ans);

        return ans;
    }

    private void printSubsets(int nums[],int idx,List<Integer> list,List<List<Integer>> ans)
    {
        if(idx==nums.length)
        {
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[idx]);
        printSubsets(nums,idx+1,list,ans);
        list.remove(list.size()-1);

        int i=idx+1;
        while(i<nums.length && nums[i]==nums[i-1])
        {
            i++;
        }
        printSubsets(nums,i,list,ans);
    }
}