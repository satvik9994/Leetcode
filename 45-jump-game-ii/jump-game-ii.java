class Solution {

public int jump(int[] nums) {

    int jump = 0;

    // End of current jump range
    int currentEnd = 0;

    // Farthest reachable index in current range
    int farthest = 0;

    // Traverse until second last element
    for (int i = 0; i < nums.length - 1; i++) {

        // Update farthest reachable index
        farthest = Math.max(farthest,
                            i + nums[i]);

        // If we reached boundary of current jump
        if (i == currentEnd) {

            jump++;

            // Move boundary to farthest
            currentEnd = farthest;
        }
    }

    return jump;
}
}