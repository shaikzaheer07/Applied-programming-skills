import java.util.*;

class ThroneInheritance {

    Map<String, List<String>> children = new HashMap<>();
    Set<String> dead = new HashSet<>();
    String king;

    public ThroneInheritance(String kingName) {
        king = kingName;
        children.put(kingName, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {
        children.putIfAbsent(parentName, new ArrayList<>());
        children.get(parentName).add(childName);
        children.put(childName, new ArrayList<>());
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }

    private void dfs(String person, List<String> order) {
        if (!dead.contains(person)) {
            order.add(person);
        }
        for (String child : children.get(person)) {
            dfs(child, order);
        }
    }
}
