class Solution {
    private static final int dx[] = {0, -1, 1, 0};
    private static final int dy[] = {-1, 0, 0, 1};

    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
        // 여기서 P를 찾은 경우 P O P인 상황이기에 방역 수칙을 지키지 않은 것이다.
        // P라면 true, 그 외 나머지는 false로 반환한다.
        for (int d = 0; d < 4; d++) {
            if (d == exclude) continue;
            
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) 
                continue;
            if (room[ny][nx] == 'P') return true;
        }
        return false;
    }
    
    private boolean isDistanced(char[][] room, int x, int y) {
        // P의 위치를 기준으로 상좌우하를 탐색한다. (방향 순서 없어서 맘대로 해도 된다.)
        // 만약 P를 1 맨해튼 거리에서 찾은 경우 거리두기가 지켜지지 않아서 false
        // 만약 O인 경우 1 맨해튼 거리를 더 탐색한다.
        // 만약 X인 경우 잘 지키고 있기 때문에 true를 반환한다.
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) 
                continue;
            switch(room[ny][nx]) {
                case 'P': return false;
                case 'O':
                    // 방향 인덱스가 0상 3하 1좌 2우
                    // d=0 (상) d=1 (좌) d=2 (우) d=3 (하)
                    // 만약 d=2(우)인 상태에서 발견했다면 3-d를 쳐서 1(좌)를 제외한다. (응시자 방향을 검사하면 안되기 때문.)
                    if (isNextToVolunteer(room, nx, ny, 3 - d)) return false;
                    break;
            }
        }
        return true;
    }
    
    private boolean isDistanced(char[][] room) {
        // 원하는건 응시자의 위치이기 때문에, P가 아니라면 건너뛰기.
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                if (room[y][x] != 'P') continue;
                if (!isDistanced(room, x, y)) return false;
            }
        }
        return true;
    }
    
    public int[] solution(String[][] places) { // 대기실이 여러개 존재한다.
        int[] answer = new int[places.length];  // 대기실마다 방역을 잘 지키고 있다면 1 아니라면 0
        
        for (int i = 0; i < answer.length; i++) {
            String[] place = places[i]; // 대기실 여러개 중 하나.
            char[][] room = new char[place.length][]; // 각 대기실을 검사할 것이므로 2차 배열
            for (int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();    
            }        
            if (isDistanced(room)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }
}
