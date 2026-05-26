// Last updated: 5/26/2026, 12:32:56 PM
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet=new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;
        Queue<String> queue=new LinkedList<>();
        queue.offer(beginWord);
        int result=1;
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            for(int i=0;i<levelSize;i++){
                String currWord=queue.poll();
                if(currWord.equals(endWord)) return result;
                char[] charArray=currWord.toCharArray();
                for(int j=0;j<charArray.length;j++){
                    char original=charArray[j];
                    for(char c='a';c<='z';c++){
                        charArray[j]=c;
                        String newWord=new String(charArray);
                        if(wordSet.contains(newWord)){
                            wordSet.remove(newWord);
                            queue.offer(newWord);
                        }
                    }
                    charArray[j]=original;
                }
            }
            result++;
        }
        return 0;
    }
}