package chapter5_2;

public class Trie<T> {
    private static int R = 256;
    private Node root;

    private static class Node<T> {
        private Object val;
        private Node[] next = new Node[R];
    }

    public T get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return (T) x.val;
    }
    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }
    public void put(String key, T value) {
        root = put(root, key, value, 0);
    }
    private Node put(Node x, String key, T value, int d) {
        // If the node we're putting the key on is null make a new node
        if (x == null) x = new Node();
        // If we're at the end of the key, get the value and return it. Could be null.
        if (d == key.length()) {
            x.val = value;
            return x;
        }
        // Otherwise, get the next character in the string
        char c = key.charAt(d);
        // Go to the next node and increase the position we are at
        x.next[c] = put(x.next[c], key, value, d + 1);
        return x;
    }
}
