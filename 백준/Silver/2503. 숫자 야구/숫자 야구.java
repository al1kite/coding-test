import java.util.*;

public class Main {

    // 두 숫자의 스트라이크와 볼 개수를 계산하는 함수
    public static int[] calculateStrikeAndBall(String guess, String target) {
        int strikes = 0, balls = 0;
        
        // 스트라이크 계산
        for (int i = 0; i < 3; i++) {
            if (guess.charAt(i) == target.charAt(i)) {
                strikes++;
            }
        }
        
        // 볼 계산
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && guess.charAt(i) == target.charAt(j)) {
                    balls++;
                }
            }
        }
        
        return new int[]{strikes, balls};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int N = sc.nextInt();
        int[][] questions = new int[N][3];
        int[] strikeResults = new int[N];
        int[] ballResults = new int[N];
        
        for (int i = 0; i < N; i++) {
            questions[i][0] = sc.nextInt(); // 질문한 세 자리 수
            strikeResults[i] = sc.nextInt(); // 스트라이크 개수
            ballResults[i] = sc.nextInt(); // 볼 개수
        }
        
        // 가능한 모든 세 자리 수를 후보로 생성 (1~9까지의 숫자로 구성된 세 자리 수)
        List<String> possibleNumbers = new ArrayList<>();
        
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i != j) {
                    for (int k = 1; k <= 9; k++) {
                        if (i != k && j != k) {
                            possibleNumbers.add("" + i + j + k);
                        }
                    }
                }
            }
        }
        
        // 가능한 수 중에서 조건을 만족하는 수만 남기기
        int possibleCount = 0;
        
        for (String candidate : possibleNumbers) {
            boolean isValid = true;
            
            for (int i = 0; i < N; i++) {
                String question = String.valueOf(questions[i][0]);
                int[] result = calculateStrikeAndBall(question, candidate);
                
                // 각 질문에 대한 결과가 일치하지 않으면 제외
                if (result[0] != strikeResults[i] || result[1] != ballResults[i]) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                possibleCount++;
            }
        }
        
        // 가능한 수의 개수를 출력
        System.out.println(possibleCount);
    }
}
