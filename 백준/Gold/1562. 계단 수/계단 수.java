import java.util.Scanner;

public class Main {
    static final int MOD = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][][] dp = new long[N+1][10][1 << 10]; // dp[i][j][k] -> 길이가 i이고 마지막 숫자가 j일 때, k는 0~9까지 등장한 상태

        // 초기 값 설정
        for (int i = 1; i <= 9; i++) {
            dp[1][i][1 << i] = 1; // 1자리 수는 각 숫자가 그 자체로 하나의 계단 수
        }

        // DP 수행
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int bit = 0; bit < (1 << 10); bit++) {
                    if (dp[i][j][bit] == 0) continue;
                    
                    // j-1로 이동 가능하면
                    if (j > 0) {
                        int nextBit = bit | (1 << (j - 1)); // 숫자 j-1 등장 기록
                        dp[i+1][j-1][nextBit] = (dp[i+1][j-1][nextBit] + dp[i][j][bit]) % MOD;
                    }
                    
                    // j+1로 이동 가능하면
                    if (j < 9) {
                        int nextBit = bit | (1 << (j + 1)); // 숫자 j+1 등장 기록
                        dp[i+1][j+1][nextBit] = (dp[i+1][j+1][nextBit] + dp[i][j][bit]) % MOD;
                    }
                }
            }
        }

        // 결과 계산 (길이가 N이고, 0부터 9까지 모든 숫자가 등장한 경우)
        long result = 0;
        int fullBit = (1 << 10) - 1; // 0부터 9까지 모든 숫자가 등장했을 때의 상태 (1111111111)
        for (int j = 0; j <= 9; j++) {
            result = (result + dp[N][j][fullBit]) % MOD;
        }

        System.out.println(result);
    }
}
