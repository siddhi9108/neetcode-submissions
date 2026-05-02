class Solution {
    public String minWindow(String s, String t) {
        String res = "";

        for(int start = 0;start<s.length();start++){
            for(int end = start;end<s.length();end++){
                String substring = s.substring(start, end+1);

                if(substring.length()<t.length()){
                    continue;
                }

                int[] tFreq = new int[128];
                for(char c : t.toCharArray()){
                    tFreq[c]++;
                }

                int[] windowFreq = new int[128];
                for(char c : substring.toCharArray()){
                    windowFreq[c]++;
                }

                boolean containsAll = true;
                for(int i = 0;i<128;i++){
                    if(tFreq[i]>0 && windowFreq[i]< tFreq[i]){
                        containsAll = false;
                        break;
                    }
                }
                if(containsAll){
                    if (res.isEmpty() || substring.length() < res.length()){
                        res = substring;
                    }
                }
            }
        }
        return res;
    }
}
