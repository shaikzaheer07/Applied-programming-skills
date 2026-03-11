    class Solution {
        public List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> li = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                if(i == j){
                    continue;
                }
                if(words[i].contains(words[j]) && !li.contains(words[j])){
                li.add(words[j]);
                }
            }

        } 
        return li;
    }
    }