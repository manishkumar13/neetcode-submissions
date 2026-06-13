class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int count[] = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 97]++;
            }
            StringBuilder key = new StringBuilder("");
            Character c = 'a';
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    key.append(c);
                    key.append(count[i]);
                }
                c++;
            }
            String mapKey = key.toString();
            if (!map.containsKey(mapKey)) {
                map.put(mapKey, new LinkedList<>());
            }
            map.get(mapKey).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
