// Last updated: 5/26/2026, 8:35:34 PM
1class Solution {
2    public int minMutation(String startGene, String endGene, String[] bank) {
3        Set<String> bankSet=new HashSet<>(Arrays.asList(bank));
4        if(!bankSet.contains(endGene)) return -1;
5        Queue<String> queue=new LinkedList<>();
6        queue.offer(startGene);
7        Set<String> visited=new HashSet<>();
8        visited.add(startGene);
9        char[] validChars={'A','C','G','T'};
10        int mutations=0;
11        while(!queue.isEmpty()){
12            int levelSize=queue.size();
13            for(int i=0;i<levelSize;i++){
14                String currentGene=queue.poll();
15                if(currentGene.equals(endGene)) return mutations;
16                char[] currArray=currentGene.toCharArray();
17                for(int j=0;j<currArray.length;j++){
18                    char original=currArray[j];
19                    for(char c: validChars){
20                        currArray[j]=c;
21                        String mutatedGene=new String(currArray);
22                        if(bankSet.contains(mutatedGene) && !visited.contains(mutatedGene)){
23                            visited.add(mutatedGene);
24                            queue.offer(mutatedGene);
25                        }
26                    }
27                    currArray[j]=original;
28                }
29            }
30            mutations++;
31        }
32        return -1;
33    }
34}