class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int bit = 0; bit <= 31; bit++) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] & (1 << bit)) != 0) {
                    count++;
                }
            }
            if (count % 3 == 1) {
                ans = ans | (1 << bit);
            }
        }
        return ans;
    }
}

/*
Bit index = 0
Check the rightmost bit using mask 0001.
Number	Binary	AND 0001	Count?
2	     0010	  0000	      No
2	     0010	  0000	      No
3	     0011	  0001	      Yes (+1)
2	     0010	  0000	      No
Final count= 1
Since count % 3 == 1, we set bit 0 in ans.
----------------------------------
Bit index = 1
Check the second bit using mask 0010.
Number	Binary	AND 0010	Count?
2	     0010	  0010	     Yes (+1)
2	     0010	  0010	     Yes (+1)
3	     0011	  0010	     Yes (+1)
2	     0010	  0010	     Yes (+1)
Final count= 4
Since count % 3 == 1, we also set bit 1.
----------------------------------

Bit indices = 2 through 31
None of the numbers has these bits set, so count = 0 for each position.
Since 0 % 3 == 0, no bits are added to ans.

4. Final result
The bits we reconstructed are:
Bit 1
Set to 1

Bit 0
Set to 1


Binary result
11

Decimal result
3
*/