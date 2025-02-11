import java.util.*;

public class Solution {
    public int solution(int n) {
        if (n < 1) return 0; 
         return (n % 10) + solution(n / 10); 
    }
}