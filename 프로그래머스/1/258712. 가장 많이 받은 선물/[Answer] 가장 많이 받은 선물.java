import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;

        // 1) 이름 -> 인덱스
        Map<String, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++) idx.put(friends[i], i);

        // 2) cnt[a][b] = a가 b에게 준 선물 수
        int[][] cnt = new int[n][n];

        // 3) give/receive 합계로 선물지수 계산 준비
        int[] give = new int[n];
        int[] receive = new int[n];

        for (String g : gifts) {
            String[] sp = g.split(" ");
            int a = idx.get(sp[0]);
            int b = idx.get(sp[1]);

            cnt[a][b]++;
            give[a]++;
            receive[b]++;
        }

        int[] giftIndex = new int[n];
        for (int i = 0; i < n; i++) {
            giftIndex[i] = give[i] - receive[i];
        }

        // 4) 다음 달 받을 선물 수
        int[] next = new int[n];

        // 핵심: 쌍을 한 번만 (i < j) 판단하고, 승자에게 +1
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (cnt[i][j] > cnt[j][i]) {
                    next[i]++;
                } else if (cnt[i][j] < cnt[j][i]) {
                    next[j]++;
                } else {
                    if (giftIndex[i] > giftIndex[j]) next[i]++;
                    else if (giftIndex[i] < giftIndex[j]) next[j]++;
                    // 같으면 아무도 안 받음
                }
            }
        }

        // 5) 최댓값 반환
        int ans = 0;
        for (int v : next) ans = Math.max(ans, v);
        return ans;
    }
}
