import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 연산의 개수 입력
        int N = sc.nextInt();

        // PriorityQueue를 사용한 최대 힙 구현 (내림차순으로 설정)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();

            if (x == 0) {
                // 배열에서 가장 큰 값을 출력하고 제거하는 연산
                if (maxHeap.isEmpty()) {
                    System.out.println(0); // 배열이 비어있는 경우
                } else {
                    System.out.println(maxHeap.poll()); // 가장 큰 값 출력 후 제거
                }
            } else {
                // 배열에 자연수 x를 추가하는 연산
                maxHeap.add(x);
            }
        }

        sc.close();
    }
}
