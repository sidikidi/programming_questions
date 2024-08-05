import java.util.Arrays;

class TrieNodePrefixSolution {
    int index = 0;

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        TrieNode root = new TrieNode();
        for (int i = 0; i < strs.length; i++) {
            insert(strs[i], root);
        }
        TrieNode current = root;
        StringBuilder answer = new StringBuilder();
        while (!current.isLeaf && prefixChildCount(current)) {
            answer.append((char)(index + 'a'));
            current = current.children[index];
        }
        return answer.toString();

        // String common = strs[0];
        // for(int i =1; i< strs.length ;i++){
        //     common = getCommon(common, strs[i]);
        // }
        // return common;
    }

    private boolean prefixChildCount(TrieNode root) {
        int count = 0;
        for (int i = 0; i < 26; i++) {

            if (root.children[i] != null) {
                count++;
                if (count > 1) {
                    return false;
                }
                index = i;
            }

        }
        return count == 1;
    }

    private void insert(String input, TrieNode root) {
        TrieNode current = root;
        int n = input.length();
        for (int i = 0; i < n; i++) {
            int ch = input.charAt(i) -'a';
            if(current.children[ch] == null) {
                current.children[ch] = new TrieNode();
                current.children[ch].ch = (char)(ch+'a');
            }

            current = current.children[ch];

        }
        current.isLeaf = true;
    }

    private String getCommon(String first, String second) {
        StringBuilder builder = new StringBuilder();
        int n = Math.min(first.length(), second.length());
        for (int i = 0; i < n; i++) {
            if (first.charAt(i) == second.charAt(i)) {
                builder.append(first.charAt(i));
            } else {
                break;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        TrieNodePrefixSolution  trieNodePrefixSolution = new TrieNodePrefixSolution();
        String prefix = trieNodePrefixSolution.longestCommonPrefix(new String[]{"flower","flight","float"});
        System.out.println(prefix);
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    char ch;
    boolean isLeaf = false;

    TrieNode() {
        ch = '\0';
        isLeaf = false;
    }

}
