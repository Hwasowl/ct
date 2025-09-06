import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        /*
        1. 장르별 재생기록 합을 찾고, 역정렬해 순서를 정한다.
        2. 장르 별 재생기록 합이 높은 순서로 찾아 2개씩 반환한다.
        2-1. 만약 재생 횟수가 같다면 고유 번호가 낮은 노래를 먼저 수록 (idx 기준)
        */

        // 1. 재생기록 합을 찾아 장르별로 역정렬한다.
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> album = new HashMap<>();
        for(int j = 0; j < genres.length; j++) {
            album.put(genres[j], album.getOrDefault(genres[j], 0) + plays[j]);
        }
        List<Map.Entry<String, Integer>> sortedAlbum = new ArrayList<>(album.entrySet());
        sortedAlbum.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        List<String> genreList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : sortedAlbum) genreList.add(entry.getKey());
        
        // 2.key를 순회하며 key장르에 해당하는 값을 [idx][play]로 담고 역정렬 후 상위 2개를 answer에 저장
        // 단 play의 값이 같다면 idx가 더 낮은 걸 반환
        for(String genre : genreList) {
            List<int[]> songList = new ArrayList<>();
            for(int i = 0; i < genres.length; i++) {
                if (genres[i].equals(genre)) songList.add(new int[]{i, plays[i]});
            }
            songList.sort((a, b) -> Integer.compare(b[1], a[1]));
            
            // 최대 2개까지 반환
            for(int j = 0; j < songList.size(); j++) {
                if(j==2) break;
                answer.add(songList.get(j)[0]);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}