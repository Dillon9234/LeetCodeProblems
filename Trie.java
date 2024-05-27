import java.util.ArrayList;

class Trie {

    char val;
    ArrayList<Trie> connections;
    int size;
    boolean flag;

    public Trie() {
        connections = new ArrayList<>();
        size = 0;
        flag = false;
    }

    public Trie(char val){
        this();
        this.val = val;
    }
    
    public void insert(String word) {
        int n = word.length();
        int i = 0;
        Trie next = this;
        outer:
        while(i<n){
            for (Trie trie : next.connections) {
                if(trie.val == word.charAt(i)){
                    i++;
                    next = trie;
                    continue outer;
                }
            }
            break;
        }
        if(i == n){
            next.flag = true;
            return;
        }
        while (i<n) {
            Trie newNode = new Trie(word.charAt(i++));
            next.connections.add(newNode);
            next = newNode;
        }
        next.flag = true;
    }
    
    public boolean search(String word) {
        int n = word.length();
        int i = 0;
        Trie next = this;
        outer:
        while(i<n){
            for (Trie trie : next.connections) {
                if(trie.val == word.charAt(i)){
                    i++;
                    next = trie;
                    continue outer;
                }
            }
            return false;
        }
        return next.flag;
    }
    
    public boolean startsWith(String prefix) {
        int n = prefix.length();
        int i = 0;
        Trie next = this;
        outer:
        while(i<n){
            for (Trie trie : next.connections) {
                if(trie.val == prefix.charAt(i)){
                    i++;
                    next = trie;
                    continue outer;
                }
            }
            break;
        }
        return i == n;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
