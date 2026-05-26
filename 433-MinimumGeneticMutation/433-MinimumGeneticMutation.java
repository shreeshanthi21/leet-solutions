// Last updated: 5/26/2026, 12:31:40 PM
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet=new HashSet<>(Arrays.asList(bank));
        if(!bankSet.contains(endGene)) return -1;
        Queue<String> queue=new LinkedList<>();
        queue.offer(startGene);
        Set<String> visited=new HashSet<>();
        visited.add(startGene);
        char[] validChars={'A','C','G','T'};
        int mutations=0;
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            for(int i=0;i<levelSize;i++){
                String currentGene=queue.poll();
                if(currentGene.equals(endGene)) return mutations;
                char[] currArray=currentGene.toCharArray();
                for(int j=0;j<currArray.length;j++){
                    char original=currArray[j];
                    for(char c: validChars){
                        currArray[j]=c;
                        String mutatedGene=new String(currArray);
                        if(bankSet.contains(mutatedGene) && !visited.contains(mutatedGene)){
                            visited.add(mutatedGene);
                            queue.offer(mutatedGene);
                        }
                    }
                    currArray[j]=original;
                }
            }
            mutations++;
        }
        return -1;
    }
}