import java.io.*;
import java.util.*;

class Solution {
    Map<String, Genre> map = new HashMap<>();
    List<Genre> genreList = new ArrayList<>();
    
    public int[] solution(String[] genres, int[] plays) {
        
        for(int i = 0; i < genres.length; i++) {
            String genreKey = genres[i];
            
            // 키가 없으면
            if(!map.containsKey(genreKey)) {
                map.put(genreKey, new Genre());
            }
            
            Genre genre = map.get(genreKey);
            genre.addSong(new Song(i, plays[i]));
        }
        
        // 맵 순회하면서 sort하기
        for(Map.Entry<String, Genre> entry : map.entrySet()) {
            String key = entry.getKey();
            Genre genre = entry.getValue();
            
            genre.sortSong();
            genreList.add(genre);
        }    
        
        // totalPlay 기준 정렬
        genreList.sort((a,b) -> Integer.compare(b.totalPlay, a.totalPlay));
        
        // 장르당 최대 2곡씩 리스트에 담기
        List<Integer> answerList = new ArrayList<>();
        for (Genre genre : genreList) {
            int count = 0;
            for (Song song : genre.songs) {
                if (count == 2) {
                    break; // 장르당 최대 2곡만 수록
                }
                answerList.add(song.index);
                count++;
            }
        }
        
        // for문으로 int[] 배열 만들어서 반환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    public class Genre{
        public int totalPlay = 0;
        List<Song> songs = new ArrayList<>();
        
        public Genre() {
            
        }
        
        public void addSong(Song song) {
            songs.add(song);
            this.totalPlay += song.play;
        }
        
        // 정렬
        public void sortSong() {
            songs.sort((a, b) -> {
                int playTime = Integer.compare(b.play, a.play); // 내림차순
                if(playTime != 0) {
                    return playTime;
                }
                return Integer.compare(a.index, b.index);
            });
        }
    }
    
    public class Song {
        int index;
        int play;
        
        public Song(int index, int play) {
            this.index = index;
            this.play = play;
        }
    }
}