package src;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1311. 获取你好友已观看的视频
 */
public class LeetCode1311 {

    public static List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        HashMap<Integer,List<Integer>> edge = new HashMap<>();
        // 初始化边集合
        for (int i = 0;i<friends.length;i++){
            for (int x : friends[i]){
                List<Integer> l= edge.getOrDefault(i,new LinkedList<>());
                l.add(x);
                edge.put(i,l );
            }
        }
        int[] visited = new int[friends.length];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(id);
        visited[id] = -1;
        int row = 0;
        Map<String,Integer> result = new TreeMap<String, Integer>();

        while (!queue.isEmpty()){
            int size = queue.size();
            if (row==level){
                while (!queue.isEmpty()){
                    int f = queue.poll();
                    for (String s : watchedVideos.get(f)){
                        if(result.containsKey(s)){
                            result.put(s,result.get(s)+1);
                        }else {
                            result.put(s,1);
                        }
                    }
                }
                break;

            }
            for (int i =0;i<size;i++){
                Integer friend = queue.poll();
                for (int fs:edge.getOrDefault(friend,new ArrayList<>())){
                    if(visited[fs]!=-1){
                        queue.add(fs);
                        visited[fs]=-1;
                    }
                }
            }


            row++;
        }
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(result.entrySet());
        Collections.sort(list,
                (o1, o2) -> {
                    if (!o1.getValue().equals(o2.getValue())){
                        return o1.getValue().compareTo(o2.getValue());
                    }else {
                        return o1.getKey().compareTo(o2.getKey());
                    }

                });
        return list.stream().map(Map.Entry::getKey).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        List<List<String>> watchedVideos = new ArrayList<>();
        watchedVideos.add(new ArrayList<>());
        watchedVideos.get(0).add("A");
        watchedVideos.get(0).add("B");
        watchedVideos.add(new ArrayList<>());
        watchedVideos.get(1).add("C");
        watchedVideos.add(new ArrayList<>());
        watchedVideos.get(2).add("B");
        watchedVideos.get(2).add("C");
        watchedVideos.add(new ArrayList<>());
        watchedVideos.get(3).add("D");

        int[][] friends = {{1,2},{0,3},{0,3},{1,2}};
        int id = 0;
        int level=1;
        watchedVideosByFriends(watchedVideos, friends, id, level).forEach(System.out::println);
    }
}
