import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        int[] a = new int[n];
        Map<String, Integer> alphabet = new HashMap<>();
        alphabet.put("A", 0);
        alphabet.put("B", 1);
        alphabet.put("C", 2);
        alphabet.put("D", 3);
        alphabet.put("E", 4);
        alphabet.put("F", 5);
        alphabet.put("G", 6);
        alphabet.put("H", 7);
        alphabet.put("I", 8);
        alphabet.put("J", 9);
        alphabet.put("K", 10);
        alphabet.put("L", 11);
        alphabet.put("M", 12);
        alphabet.put("N", 13);
        alphabet.put("O", 12);
        alphabet.put("P", 11);
        alphabet.put("Q", 10);
        alphabet.put("R", 9);
        alphabet.put("S", 8);
        alphabet.put("T", 7);
        alphabet.put("U", 6);
        alphabet.put("V", 5);
        alphabet.put("W", 4);
        alphabet.put("X", 3);
        alphabet.put("Y", 2);
        alphabet.put("Z", 1);
        
        for(int i=0; i<n; i++){
            answer += alphabet.get(String.valueOf(name.charAt(i)));
        }
        
        int move = n-1;
        for(int i=0; i<n; i++){
            int j = i+1;
            while(j < n && name.charAt(j) == 'A'){
                j++;
            }
            int case1 = 2*i + (n - j);
            int case2 = i + 2*(n - j);
            move = move < Math.min(case1, case2) ? move : Math.min(case1, case2);
        } answer += move;
        return answer;
    }
}