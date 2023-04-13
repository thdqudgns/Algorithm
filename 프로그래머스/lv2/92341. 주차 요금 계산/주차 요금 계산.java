/*
    초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림합니다.
    ⌈a⌉ : a보다 작지 않은 최소의 정수를 의미합니다. 즉, 올림을 의미합니다.
    IDE 없이는 풀 수 없을듯...
*/
import java.util.*;
import java.util.Map.Entry;
class Solution {
    static int basicTime, basicFee;
	static double unitTime;
	static int unitFee;
	
	public static int[] solution(int[] fees, String[] records) {
        
        basicTime = fees[0];
        basicFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];

        // 차 번호, {시, 분}
        Map<String, int[]> cars = new HashMap<>();
        // 차 번호, 주차한 시간
        Map<String, Integer> parkingTime = new HashMap<>();
        
        for(String rec : records) {
        	String[] recs = rec.split(" ");
        	String[] time = recs[0].split(":");
        	int hour = Integer.parseInt(time[0]);
        	int minute = Integer.parseInt(time[1]);
        	int[] newTime = {hour, minute};
        	String carNum = recs[1];
        	
        	// 먼저 시간관리 해주기
        	if (!parkingTime.containsKey(carNum)) parkingTime.put(carNum, 0);
        	
        	// carNum이 들어있지 않을 때 : 삽입
        	if (!cars.containsKey(carNum)) cars.put(carNum, newTime);
        	// 들어있을 때 : 빼서 계산
        	else {
        		int[] getTime = cars.remove(carNum);
        		int useTime = calculationTime(newTime, getTime);
        		parkingTime.put(carNum, parkingTime.get(carNum) + useTime);
        	}
        }
        
        if (!cars.isEmpty()) {
        	Set<Entry<String, int[]>> remains = cars.entrySet();
        	int[] newTime = {23, 59};
        	for (Entry<String, int[]> remain : remains) {
        		String carNum = remain.getKey();
        		int[] getTime = remain.getValue();
        		parkingTime.put(carNum, parkingTime.get(carNum) + calculationTime(newTime, getTime));
        	}
        }
        
        // parkingTime에는 차 번호별 주차 시간이 모두 저장된 상태
        List<Parking> list = new ArrayList<>();
        Set<Entry<String, Integer>> parks = parkingTime.entrySet();
        for(Entry<String, Integer> e : parks) {
        	String carNum = e.getKey();
        	Integer totalTime = e.getValue();
        	list.add(new Parking(carNum, totalTime));
        }
        
        Collections.sort(list);
        //System.out.println(list);
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
			int feeByTime = list.get(i).time;
			answer[i] = getFee(feeByTime);
		}
        
        return answer;
    }

	private static int getFee(int time) {
		int fee = basicFee;
		if (time <= basicTime) return fee;
		int overTime = time - basicTime;
		fee += (int) Math.ceil(Math.ceil(overTime / unitTime) * unitFee);
		return fee;
	}

	// 최근 시간, 이전 시간
	private static int calculationTime(int[] newTime, int[] getTime) {
		// [0]: 시간, [1]: 분
		int res = 0;
		// 최근 시간의 분 단위가 이전 시간의 분 단위보다 크거나 같을 때 : 분은 빼기, 시는 빼고 * 60 
		if(newTime[1] >= getTime[1]) {
			res += newTime[1] - getTime[1];
			res += (newTime[0] - getTime[0]) * 60;
		// 최근 시간의 분 단위가 이전 시간의 분 단위보다 작을 때 : 각각의 분 더하기, 최근 시간의 시간을 1 빼고 이전 시간의 시를 뺀 값에 * 60
		} else {
			res += newTime[1] + (60 - getTime[1]);
			res += (newTime[0] - 1 - getTime[0]) * 60;
		}
		
		return res;
	}
}

class Parking implements Comparable<Parking>{
	String carNum;
	int time;
	
	public Parking(String carNum, int time) {
		super();
		this.carNum = carNum;
		this.time = time;
	}

	@Override
	public int compareTo(Parking p) {
		return this.carNum.compareTo(p.carNum);
	}

	@Override
	public String toString() {
		return "Parking [carNum=" + carNum + ", time=" + time + "]";
	}
	
}