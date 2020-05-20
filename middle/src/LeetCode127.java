package src;

import javafx.util.Pair;

import java.util.*;

/**
 * 127. 单词接龙
 */
public class LeetCode127 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        // 对worldlist每个单词做字符中的*ot的list
        Map<String, List<String>> allComboDict = new HashMap<>();
        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        String newWorld = word.substring(0, i) + "*" + word.substring(i + 1, L);
                        List<String> transformations = allComboDict.getOrDefault(newWorld, new ArrayList<>());
                        transformations.add(word);
                        allComboDict.put(newWorld, transformations);

                    }
                }
        );


        Queue<Pair<String, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(beginWord, 1));
        Map<String,Boolean> visited = new HashMap<>();
        visited.put(beginWord,true);
        while (!queue.isEmpty()){
            int l = queue.size();
            Pair<String,Integer>  p= queue.poll();
            int level = p.getValue();
            String key = p.getKey();

            for (int i =0;i<L;i++){
                String newWorld = key.substring(0,i)+"*"+key.substring(i+1,L);
                for (String adjacentWord : allComboDict.getOrDefault(newWorld,new ArrayList<>())){
                    if(adjacentWord.equals(endWord)){
                        return level+1;
                    }
                    if(!visited.containsKey(adjacentWord)){
                        visited.put(adjacentWord,true);
                        queue.add(new Pair<>(adjacentWord,level+1));
                    }
                }

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}
