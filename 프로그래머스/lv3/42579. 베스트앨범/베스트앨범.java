import java.util.*;
import java.util.Map.Entry;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
			map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
		}
        //System.out.println(map);
        
        List<Gen> list = new ArrayList<>();
        Set<Entry<String, Integer>> set = map.entrySet();
        for(Entry<String, Integer> e : set) {
        	String genre = e.getKey();
        	Integer play = e.getValue();
        	list.add(new Gen(genre, play));
        }
        Collections.sort(list);
        
        Map<String, List<Music>> musicMap = new TreeMap<>();
        List<String> keys = new ArrayList<>();
        for(Gen g : list) { // 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
        	String genre = g.genre;
        	keys.add(genre);
        	List<Music> musicList = new ArrayList<>();
        	for (int i = 0; i < genres.length; i++) {
        		if(genres[i].equals(genre)) {
        			musicList.add(new Music(plays[i], i));
        		}
        	}
        	Collections.sort(musicList); // 장르 내에서 많이 재생된 노래를 먼저 수록합니다. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
        	musicMap.put(genre, musicList);
        }
        
        List<Integer> ans = new ArrayList<>();
        
        map.clear();
        for(String key : keys) {
        	List<Music> musicList = musicMap.get(key);
        	for(Music m : musicList) {
        		map.put(genres[m.num], map.getOrDefault(genres[m.num], 0) + 1);
        		if(map.get(genres[m.num]) > 2) continue;
        		ans.add(m.num);
        	}
        }
        System.out.print(ans);
        int[] answer = new int[ans.size()];
        for (int i = 0; i < answer.length; i++) {
			answer[i] = ans.get(i);
		}
        return answer;
    }
}

class Music implements Comparable<Music>{
    int play;
    int num;
    
    @Override
    public int compareTo(Music m) {
        if (this.play != m.play) return m.play - this.play;
        else return this.num - m.num;
    }

	public Music(int play, int num) {
		this.play = play;
		this.num = num;
	}

	@Override
	public String toString() {
		return "Music [play=" + play + ", num=" + num + "]";
	}
}

class Gen implements Comparable<Gen> {

	String genre;
	int plays;
	
	@Override
	public int compareTo(Gen o) {
		return o.plays - this.plays;
	}

	public Gen(String genre, int plays) {
		super();
		this.genre = genre;
		this.plays = plays;
	}
}