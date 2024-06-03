public class Tree {

    private Node root;

    // Node class representing a node in tree
    private class Node {
        String key; // Key
        String[] value; // Value
        Node left, right; // Children of node

        // Constructor to create a new node with key and value
        public Node(String key, String[] value) {
            this.key = key;
            this.value = value;
        }
    }

    // Add key value pair to tree
    public void put(String key, String[] value) {
        root = put(root, key, value);
    }

    // Recursive method to add key value pair to the subtree at x
    private Node put(Node x, String key, String[] value) {
        if (x == null) return new Node(key, value); // If subtree is empty, create a new node
        int cmp = key.compareTo(x.key); // Compare new key with the key of current node

        if (cmp < 0) {
            // If new key is smaller, go to left node
            x.left = put(x.left, key, value);
        }
        else if (cmp > 0) { // If new key is bigger, go to right node
            x.right = put(x.right, key, value);
        }
        else { // If key already exist, update the value
            x.value = value;
        }
        return x; // Return the updated node
    }

    // Method to retrieve value of a key
    public String[] get(String key) {
        Node x = get(root, key);
        if (x == null) return null;
        return x.value;
    }

    // Method to find node with a given key in the subtree at x
    private Node get(Node x, String key) {
        if (x == null) return null; // If the subtree is empty, the key is not found
        int cmp = key.compareTo(x.key); // Compare the key with the key of the current node

        if (cmp < 0) { // If the key is smaller, go to the left subtree
            return get(x.left, key);
        }
        else if (cmp > 0) { // If the key is larger, go to the right subtree
            return get(x.right, key);
        }
        else { // If the key matches, return the current node
            return x;
        }
    }

    // Method to normalize caps of a key
    public String normalizeKey(String key) {
        if (key == null || key.isEmpty()) return key;
        return key.substring(0, 1).toUpperCase() + key.substring(1).toLowerCase();
    }
}
