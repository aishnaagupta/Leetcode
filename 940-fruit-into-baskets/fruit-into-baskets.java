class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;

        for (int r = 0; r < fruits.length; r++) {
            int fruit = fruits[r];
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);

            if (map.size() > 2) {
                int extra = fruits[left];
                map.put(extra, map.get(extra) - 1);

                if (map.get(extra) == 0) {
                    map.remove(extra);
                }

                left++;
            }
            max = Math.max(max, r - left + 1);
        }
        return max;
    }
}