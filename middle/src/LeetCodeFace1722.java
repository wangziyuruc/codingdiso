package src;

import java.util.*;

/**
 * 面试题 17.22. 单词转换
 */
public class LeetCodeFace1722 {

    public static List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        HashMap<String,List<String>> allWorldDict = new HashMap<>();
        wordList.forEach(word->{
            for (int i=0;i<L;i++){
                String newWorld = word.substring(0,i)+"*"+word.substring(i+1,L);
                List<String> strings = allWorldDict.getOrDefault(newWorld,new ArrayList<>());
                strings.add(word);
                allWorldDict.put(newWorld,strings);
            }
        });
        Queue<String> queue = new ArrayDeque<>();
        Map<String,Boolean> visited = new HashMap<>();
        queue.add(beginWord);
        visited.put(beginWord,true);
        HashMap<String,String> res = new HashMap<>();
        List<String> r = new ArrayList<>();

        while (!queue.isEmpty()){
            String word = queue.poll();
            if(word.equals(endWord)){
                r.add(0,endWord);
                String key = endWord;
                while (!res.get(key).equals(beginWord)){
                    r.add(0,res.get(key));
                    key=res.get(key);
                }
                r.add(0,beginWord);
                return r;
            }

            for (int i=0;i<L;i++){
                String newWorld = word.substring(0,i)+"*"+word.substring(i+1,L);
                List<String> strings = allWorldDict.getOrDefault(newWorld,new ArrayList<>());
                for (String w : strings){
                    if (!visited.containsKey(w)){
                        visited.put(w,true);
                        queue.add(w);
                        res.put(w,word);
                    }
                }
            }

        }
        return new ArrayList<>();

    }


    public static void main(String[] args) {
        String beginWord ="hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
//        wordList.add("cog");
        findLadders(beginWord,endWord, wordList).forEach(System.out::println);
    }
}
