class Solution {
    List<List<String>> result;
    TrieNode root;

    class TrieNode {
        TrieNode[] children;
        List<String> startWith;

        TrieNode(){
            children = new TrieNode[26];
            startWith = new ArrayList<>();
        }
    }

    private void insert(String word) {
        TrieNode curr = root;

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
            curr.startWith.add(word);
        }
    }

    private List<String> search(String prefix) {
        TrieNode curr = root;

        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);

            if(curr.children[ch - 'a'] == null){
                return new ArrayList<String>();
            }
            curr = curr.children[ch - 'a'];
        }
        return curr.startWith;
    }

    public List<List<String>> wordSquares(String[] words) {
        root = new TrieNode();

        result = new ArrayList<List<String>>();
        List<String> path = new ArrayList<>();
        for(String word: words){
            // action
            path.add(word);

            //recurse
            dfs(words, path);

            // backtrack
            path.remove(path.size() -1);

        }
        return result;
    }



    private void dfs(String[] words, List<String> path) {
        // base
        if(path.size() == words[0].length()){
            result.add(new ArrayList<>(path));
            return;
        }

        int idx = path.size();
        StringBuilder prefix = new StringBuilder();

        for(String word : path){
            prefix.append(word.charAt(idx));
        }

        for(String word: search(prefix.toString())){
            path.add(word);
            dfs(words, path);
            path.remove(path.size() -1);
        }

    }
}
