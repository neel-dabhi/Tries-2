// TC: O(N * L)
// SC: O(1)
class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();

        for (String query : queries) {
            boolean answer = false;
            int p = 0;

            for (int i = 0; i < query.length(); i++) {
                char qChar = query.charAt(i);

                if (p < pattern.length() && qChar == pattern.charAt(p)) {
                    p++;
                    if (p == pattern.length()) {
                        answer = true;
                    }
                } else if (Character.isUpperCase(qChar)) {
                    answer = false;
                    break;
                }
            }
            result.add(answer);
        }

        return result;
    }
}