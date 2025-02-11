class Solution {
    public int solution(int n) {
        if (n == 0) return 0; 

        int sum = 0;
        int sqrt = (int) Math.sqrt(n); 

        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) { 
                sum += i; 
                if (i != n / i) 
                    sum += n / i; 
            }
        }

        return sum;
    }
}