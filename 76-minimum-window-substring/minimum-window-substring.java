class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int l = 0, r = 0, minlen = Integer.MAX_VALUE, count = 0, strt = -1;

        HashMap<Character, Integer> map = new HashMap<>();

        //putting all characters of 't' in map
        for (int i = 0; i < m; i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        while (r < n) {
            char c = s.charAt(r);
            if (map.containsKey(c)) { //if charac in map inc count and decrease freq
                if (map.get(c) > 0) {
                    count++;
                }
                map.put(c, map.get(c) - 1);
            }

            while (count == m) { //if all letter found, try and reduce length from the left
                if (r - l + 1 < minlen) {
                    minlen = Math.min(minlen, r - l + 1);
                    strt = l;
                }

                char left = s.charAt(l);
                if (map.containsKey(left)) {
                    map.put(left, map.get(left) + 1); //increase freq 

                    if (map.get(left) > 0) { //meaning we found one character from 't'
                        count--;
                    }
                }
                l++;
            }
            r++;
        }

        return strt == -1 ? "" : s.substring(strt, strt + minlen);
    }
}