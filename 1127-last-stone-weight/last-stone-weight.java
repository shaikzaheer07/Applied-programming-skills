 class Solution {
    public int lastStoneWeight(int[] stones) {
        
          ArrayList<Integer> list = new ArrayList<>();

        for (int stone : stones) {
            list.add(stone);
        }

        while (list.size() > 1) {

            Collections.sort(list);

            int first = list.get(list.size() - 1);
            int sec = list.get(list.size() - 2);

            list.remove(list.size() - 1);
            list.remove(list.size() - 1);

            if (first != sec) {
                list.add(first - sec);
            }
        }
      return list.isEmpty() ? 0 : list.get(0);
    }
}