import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 1) 정렬 (그리디 안정화)
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 2) 여벌인데 도난도 당한 학생(교집합) 제거 처리
        boolean[] lostUsed = new boolean[lost.length];
        boolean[] reserveUsed = new boolean[reserve.length];

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (reserveUsed[j]) continue;
                if (lost[i] == reserve[j]) {
                    lostUsed[i] = true;
                    reserveUsed[j] = true;
                    break;
                }
            }
        }

        // 3) 실제로 빌려야 하는 lost만 처리
        int answer = n;
        for (int i = 0; i < lost.length; i++) {
            if (lostUsed[i]) continue; // 자기 여벌로 해결
            int x = lost[i];

            boolean borrowed = false;

            // 왼쪽에게 빌리기
            for (int j = 0; j < reserve.length; j++) {
                if (reserveUsed[j]) continue;
                if (reserve[j] == x - 1) {
                    reserveUsed[j] = true;
                    borrowed = true;
                    break;
                }
            }

            // 오른쪽에게 빌리기
            if (!borrowed) {
                for (int j = 0; j < reserve.length; j++) {
                    if (reserveUsed[j]) continue;
                    if (reserve[j] == x + 1) {
                        reserveUsed[j] = true;
                        borrowed = true;
                        break;
                    }
                }
            }

            if (!borrowed) answer--; // 못 빌림
        }

        return answer;
    }
}
