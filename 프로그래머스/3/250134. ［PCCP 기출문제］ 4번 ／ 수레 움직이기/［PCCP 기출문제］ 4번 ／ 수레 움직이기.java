import java.util.*;

class Solution {
    // 최소 이동 횟수를 저장하는 변수
    static int answer = Integer.MAX_VALUE;
    
    // 이동 방향: 상(-1,0), 하(1,0), 좌(0,-1), 우(0,1)
    static int[] arx = {-1, 1, 0, 0}; 
    static int[] ary = {0, 0, -1, 1}; 
    
    // 방문 여부를 저장할 배열 (빨간 수레와 파란 수레 각각)
    static boolean[][] red; 
    static boolean[][] blue;
    
    // 맵 정보와 도착 좌표, 맵 크기
    static int[][] map; 
    static int a, b;
    static int rex, rey, bex, bey; // 빨간, 파란 수레의 도착 좌표

    // solution 함수는 퍼즐을 풀기 위한 최소 턴 수를 계산
    public int solution(int[][] maze) {
        int rx = 0, ry = 0, bx = 0, by = 0;
        
        a = maze.length;
        b = maze[0].length;
        
        // 맵 및 방문 배열 초기화
        map = new int[a][b];
        red = new boolean[a][b];
        blue = new boolean[a][b];
        
        // 초기 상태 세팅
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (maze[i][j] == 1) {  // 빨간 수레 시작 위치
                    red[i][j] = true;
                    rx = i;
                    ry = j;
                } else if (maze[i][j] == 2) {  // 파란 수레 시작 위치
                    blue[i][j] = true;
                    bx = i;
                    by = j;
                } else if (maze[i][j] == 3) {  // 빨간 수레 도착 위치
                    rex = i;
                    rey = j;
                } else if (maze[i][j] == 4) {  // 파란 수레 도착 위치
                    bex = i;
                    bey = j;
                }
                // 벽은 지도에 그대로 기록
                if (maze[i][j] == 5) {
                    map[i][j] = 5;
                }
            }
        }
        
        // 백트래킹 탐색 시작
        move(rx, ry, bx, by, 0, false, false);
      
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    // 백트래킹 함수, 현재 빨간 수레와 파란 수레의 위치, 이동 횟수, 도착 여부 전달
    public static void move(int rx, int ry, int bx, int by, int move, boolean red_end, boolean blue_end) {
        // 빨간 수레가 도착했다면 red_end = true
        if (!red_end && rx == rex && ry == rey) red_end = true;
        // 파란 수레가 도착했다면 blue_end = true
        if (!blue_end && bx == bex && by == bey) blue_end = true;
        
        // 두 수레 모두 도착했을 때 최소 이동 횟수 업데이트 후 종료
        if (red_end && blue_end) {
            answer = Math.min(answer, move);
            return;
        }

        // 이동 가능한 좌표 리스트 생성
        ArrayList<int[]> r_list = new ArrayList<>();  // 빨간 수레
        ArrayList<int[]> b_list = new ArrayList<>();  // 파란 수레
        
        // 빨간 수레가 아직 도착하지 않았다면 이동 가능 좌표 계산
        if (!red_end) {
            for (int i = 0; i < 4; i++) {
                int nx = arx[i] + rx;
                int ny = ary[i] + ry;
                // 벽이 아니고, 맵을 벗어나지 않으며, 방문하지 않은 칸으로만 이동
                if (validation(nx, ny) && map[nx][ny] != 5 && !red[nx][ny]) {
                    r_list.add(new int[]{nx, ny});
                }
            }
        } else { // 도착한 경우, 현재 좌표에 고정
            r_list.add(new int[]{rx, ry});
        }

        // 파란 수레가 아직 도착하지 않았다면 이동 가능 좌표 계산
        if (!blue_end) {
            for (int i = 0; i < 4; i++) {
                int nx = arx[i] + bx;
                int ny = ary[i] + by;
                // 벽이 아니고, 맵을 벗어나지 않으며, 방문하지 않은 칸으로만 이동
                if (validation(nx, ny) && map[nx][ny] != 5 && !blue[nx][ny]) {
                    b_list.add(new int[]{nx, ny});
                }
            }
        } else { // 도착한 경우, 현재 좌표에 고정
            b_list.add(new int[]{bx, by});
        }

        // 빨간 수레와 파란 수레의 모든 이동 가능한 경우 탐색
        for (int[] r_arr : r_list) {
            for (int[] b_arr : b_list) {
                // 두 수레가 같은 좌표로 이동하지 않도록 검사
                if (r_arr[0] == b_arr[0] && r_arr[1] == b_arr[1]) continue;
                // 두 수레가 자리를 바꾸지 않도록 검사
                if (rx == b_arr[0] && ry == b_arr[1] && bx == r_arr[0] && by == r_arr[1]) continue;

                // 해당 좌표 방문 처리 후 재귀 호출
                red[r_arr[0]][r_arr[1]] = true;
                blue[b_arr[0]][b_arr[1]] = true;
                move(r_arr[0], r_arr[1], b_arr[0], b_arr[1], move + 1, red_end, blue_end);
                
                // 재귀 종료 후 방문 처리 원상복구
                red[r_arr[0]][r_arr[1]] = false;
                blue[b_arr[0]][b_arr[1]] = false;
            }
        }
    }
    
    // 유효한 좌표인지 검사하는 함수 (맵 범위 내에 있는지 확인)
    public static boolean validation(int nx, int ny) {
        return 0 <= nx && nx < a && 0 <= ny && ny < b;
    }
}
