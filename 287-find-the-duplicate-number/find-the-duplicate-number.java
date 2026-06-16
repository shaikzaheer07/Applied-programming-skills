    class Solution {
        public int findDuplicate(int[] nums) {
            
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){

            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        
        }
        int key =0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        if(entry.getValue() > 1){
            key = entry.getKey();
        }
        }
    return key;
        }
    }