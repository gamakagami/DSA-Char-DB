public class Tree {
    private Node root;

    private class Node {
        String key;
        String[] value;
        Node left, right;

        public Node(String key, String[] value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(String key, String[] value) {
        root = put(root, key, value);
    }

    private Node put(Node x, String key, String[] value) {
        if (x == null) return new Node(key, value);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        return x;
    }

    public String[] get(String key) {
        Node x = get(root, key);
        if (x == null) return null;
        return x.value;
    }

    private Node get(Node x, String key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x;
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node x) {
        if (x == null) return;
        printInOrder(x.left);
        System.out.println(x.key + " : " + String.join(", ", x.value));
        printInOrder(x.right);
    }

    public String normalizeKey(String key) {
        if (key == null || key.isEmpty()) return key;
        return key.substring(0, 1).toUpperCase() + key.substring(1).toLowerCase();
    }
}
