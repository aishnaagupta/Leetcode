class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        return pad("", digits);
    }

    public ArrayList<String> pad(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        String[] mapping = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        int digit = up.charAt(0) - '0';
        String letters = mapping[digit];

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < letters.length(); i++) {
            char toAdd = letters.charAt(i);
            list.addAll(pad(p + toAdd, up.substring(1)));
        }
        return list;
    }
}