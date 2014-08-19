public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        if (start.equals(end)) {
            path.add(start);
            path.add(end);
            result.add(path);
            return result;
        }

        // record all posible pre
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        map.put(start, new ArrayList<String>());
        map.put(end, new ArrayList<String>());

        for (String str : dict)
            map.put(str, new ArrayList<String>());
        
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);

        List<String> cur_level = new ArrayList<String>();
        while (!queue.isEmpty()) {
            int level = queue.size();
            cur_level.clear();

            for (int i = 0; i < level; i++) {
                String str = queue.poll();
                if (dict.contains(str))
                    dict.remove(str);
                cur_level.add(str);
            }

            for (String str : cur_level) {
                for (int i = 0; i < str.length(); i++) {
                    char[] carray = str.toCharArray();
                    char origin = carray[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != origin) {
                            carray[i] = c;
                            String new_str = new String(carray);
                            if (new_str.equals(end)) {
                                map.get(end).add(str);
                                queue.add(end);
                            } else if (dict.contains(new_str)) {
                                if (!queue.contains(new_str))
                                    queue.add(new_str);
                                map.get(new_str).add(str);
                            }
                        }
                    }
                }
            }

            if (queue.contains(end))
                break;
        }
        path.add(end);
        build_path(start, end, path, map, result);
        return result;
    }

    //DFS
    private void build_path(String start, String end, List<String> path,
        HashMap<String, List<String>> map, List<List<String>> result)
    {
        if (end.equals(start)) {
            List<String> tmp = new ArrayList<String>(path);
            Collections.reverse(tmp);
            result.add(tmp);
            return;
        }

        for (String str : map.get(end)) {
            path.add(str);
            build_path(start, str, path, map, result);
            path.remove(path.size() - 1);
        }
    }
}