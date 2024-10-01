import java.io.*;
import java.util.*;

public class Main {

    static class Title {
        String name;
        int powerLimit;

        public Title(String name, int powerLimit) {
            this.name = name;
            this.powerLimit = powerLimit;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 칭호의 개수
        int M = Integer.parseInt(st.nextToken()); // 캐릭터의 개수

        Title[] titles = new Title[N];

        // N개의 칭호 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int powerLimit = Integer.parseInt(st.nextToken());
            titles[i] = new Title(name, powerLimit);
        }

        StringBuilder sb = new StringBuilder();

        // M개의 캐릭터 전투력에 대한 칭호 찾기
        for (int i = 0; i < M; i++) {
            int power = Integer.parseInt(br.readLine());
            sb.append(findTitle(titles, power)).append("\n");
        }

        System.out.print(sb.toString());
    }

    // 이진 탐색으로 해당 전투력에 맞는 칭호 찾기
    static String findTitle(Title[] titles, int power) {
        int left = 0;
        int right = titles.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (titles[mid].powerLimit >= power) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return titles[left].name;
    }
}
