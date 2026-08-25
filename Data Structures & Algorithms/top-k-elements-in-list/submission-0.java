class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        ArrayList<Integer> numbers = new ArrayList<>(map.keySet());
        Collections.sort(numbers, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        int[] result = new int[k];
        int index = 0;

        for (int i = numbers.size() - 1; i >= numbers.size() - k; i--) {
            result[index] = numbers.get(i);
            index++;
        }
        return result;
    }
}
