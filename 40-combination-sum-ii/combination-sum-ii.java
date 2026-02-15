class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> set = new HashSet<>();
        solve(0, candidates, target, set, new ArrayList<>());
        return new ArrayList<>(set);
    }

    public void solve(int idx, int[] nums, int target,
                       Set<List<Integer>> set,
                       List<Integer> temp) {

        if (target == 0) {
            set.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0 || idx == nums.length) return;

        for (int i = idx; i < nums.length; i++) {
            // skip duplicates at the same recursion level
            if (i > idx && nums[i] == nums[i - 1]) continue;

            temp.add(nums[i]);
            solve(i + 1, nums, target - nums[i], set, temp);
            temp.remove(temp.size() - 1);
        }
    }
}