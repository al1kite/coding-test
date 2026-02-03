import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int len = friends.length;
        Map<String, Integer> recievedMap = new HashMap<>();
        Map<String, Integer> sendMap = new HashMap<>();
        
        Map<String, Integer> index = new HashMap<>();
        int[][] giftBox = new int[len][len];
        
        int answer = 0;
        
        int num = 0;
        for(String friend : friends){
            index.put(friend, num++);
        }
        
        for(String gift : gifts){
            String[] giftFriend = gift.split(" ");
            
            // 선물을 준 사람
            sendMap.put(giftFriend[0], sendMap.getOrDefault(giftFriend[0], 0) + 1);  
            // 선물 받은 사람
            recievedMap.put(giftFriend[1], recievedMap.getOrDefault(giftFriend[1], 0) + 1);
            
            // 주고받은 선물 배열
            giftBox[index.get(giftFriend[0])][index.get(giftFriend[1])] += 1;
        }
        
        for(int i=0; i<len; i++){
            int nextGift = 0;
            for(int j=0; j<len; j++){
                if(giftBox[i][j] - giftBox[j][i] > 0){
                    nextGift++;
                } else if (giftBox[i][j] - giftBox[j][i] == 0) {
                    int me = sendMap.getOrDefault(friends[i], 0) - recievedMap.getOrDefault(friends[i], 0);
                    int you = sendMap.getOrDefault(friends[j], 0) - recievedMap.getOrDefault(friends[j], 0);
                    
                    if(me > you){
                        nextGift++;
                    }
                }
                
                if(nextGift > answer)
                    answer = nextGift;
            }          
        }
        
        return answer;
    }
}