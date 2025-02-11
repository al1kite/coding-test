class Solution {
    public double solution(int[] arr) {
        double average = 0;
        for(int i=0; i<arr.length; i++){
            average += arr[i];
        }
    
        return average / arr.length;
    }
}