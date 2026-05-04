class Solution {
    public int characterReplacement(String s, int k) {
       int maxLength = 0;

        for (int start = 0; start < s.length(); start++) {
            HashMap<Character, Integer> map = new HashMap<>();

            for (int end = start; end < s.length(); end++) {
                char ch = s.charAt(end);

                map.put(ch, map.getOrDefault(ch, 0) + 1);

                int mostFrequent = 0;
                for (int count : map.values()) {
                    mostFrequent = Math.max(mostFrequent, count);
                }

                int length = end - start + 1;
                int changesNeeded = length - mostFrequent;

                if (changesNeeded <= k) {
                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength; 
    }
}
