// Last updated: 5/26/2026, 12:34:22 PM
/*class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> hm= new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        int n=s.length();
        for(String i:words){
            hm.put(i,hm.getOrDefault(i, 0) + 1);
        }
        int wordLen=words[0].length();
        for(int i=0;i<wordLen;i++){
            HashMap<String,Integer> hm2=new HashMap<>();
            int left=i;int right=i;int count=0;
            while(right+wordLen<=n){
                String sub=s.substring(right,right+wordLen);
                right+=wordLen;
                if(hm.containsKey(sub)){
                    hm2.put(sub,hm2.getOrDefault(sub,0)+1);
                   // if(hm2.get(sub).equals(hm.get(sub))) count++;
                    while(hm2.get(sub)>hm.get(sub)){
                        String leftWord=s.substring(left,left+wordLen);
                        if(hm2.get(leftWord).equals(hm.get(leftWord))) count--;
                        hm2.put(leftWord,hm2.getOrDefault(leftWord,0)-1);
                        left+=wordLen;
                    }
                    if(hm2.get(sub).equals(hm.get(sub))) count++;
                }
                else{
                    hm2.clear();
                    count=0;
                    left=right;
                }
                if(count==words.length) 
                {ans.add(left);
                String leftWord=s.substring(left,left+wordLen);
                if(hm2.get(leftWord).equals(hm.get(leftWord))) count--;
                hm2.put(leftWord,hm2.getOrDefault(leftWord,0)-1);
                left+=wordLen;}
            }
        }
        return ans;
    }
}
*/
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int wordLen = words[0].length();
        int wordCount = words.length;

        HashMap<String, Integer> hm = new HashMap<>();
        for (String word : words) {
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            HashMap<String, Integer> hm2 = new HashMap<>();
            int left = i, right = i, count = 0;

            while (right + wordLen <= n) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (hm.containsKey(word)) {
                    hm2.put(word, hm2.getOrDefault(word, 0) + 1);
                    count++;

                    while (hm2.get(word) > hm.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        hm2.put(leftWord, hm2.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                } else {
                    hm2.clear();
                    count = 0;
                    left = right;
                }

                if (count == wordCount) {
                    ans.add(left);
                    String leftWord = s.substring(left, left + wordLen);
                    hm2.put(leftWord, hm2.get(leftWord) - 1);
                    left += wordLen;
                    count--;
                }
            }
        }
        return ans;
    }
}