import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int N = sc.nextInt(); // 회원 수
        int M = sc.nextInt(); // 치킨 종류 수
        int[][] preferences = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                preferences[i][j] = sc.nextInt();
            }
        }

        int maxSatisfaction = 0;

        // 치킨 종류 중 3개를 선택하는 모든 경우의 수를 검사
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                for (int k = j + 1; k < M; k++) {
                    int currentSatisfaction = 0;

                    // 각 회원의 만족도 계산
                    for (int n = 0; n < N; n++) {
                        int maxPreference = Math.max(preferences[n][i], 
                            Math.max(preferences[n][j], preferences[n][k]));
                        currentSatisfaction += maxPreference;
                    }

                    // 만족도 합의 최댓값 갱신
                    maxSatisfaction = Math.max(maxSatisfaction, currentSatisfaction);
                }
            }
        }

        // 결과 출력
        System.out.println(maxSatisfaction);
    }
}
