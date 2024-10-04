import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] words;
    static final int alphabet = (1 << 26) - 1;  // 모든 알파벳을 포함한 비트마스크
    static int result = 0;  // 가능한 조합의 수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        words = new int[n];  // 각 단어의 비트마스크를 저장하는 배열
        for (int i = 0; i < n; i++) {
            String[] word = br.readLine().split("");
            for (String w : word) {
                words[i] |= 1 << w.charAt(0) - 'a';  // 해당 문자의 비트를 켜기
            }
        }

        dfs(-1, 0);  // DFS 시작

        System.out.println(result);
    }

    private static void dfs(int count, int mask) {
        // 모든 단어를 사용한 경우
        if (count == n - 1) {
            // 현재 마스크가 모든 알파벳을 포함하고 있는지 확인
            if (mask == alphabet) {
                result += 1;  // 조건을 만족하는 경우 카운트 증가
            }
        } else {
            // 현재 단어를 선택하는 경우
            dfs(count + 1, mask | words[count + 1]);
            // 현재 단어를 선택하지 않는 경우
            dfs(count + 1, mask);
        }
    }
}
