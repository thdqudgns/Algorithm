class Solution {
    public static String solution(String new_id) {
        String answer = new_id.toLowerCase();
        for (int i = answer.length() - 1; i >= 0; i--) {
			char tmp = answer.charAt(i);
			if ('a' <= tmp && tmp <= 'z') continue;
            if ('0' <= tmp && tmp <= '9') continue;
			if (tmp == '-' || tmp == '_' || tmp == '.') continue;
			answer = answer.substring(0, i) + answer.substring(i+1);
		}
        answer = removeDot(answer);
        answer = checkDot(answer);
        if (answer.equals("")) answer = "a";
        answer = checkLenth(answer);
        answer = addLast(answer);
        return answer;
    }

	private static String removeDot(String answer) {
		if (answer.length() <= 1) return answer;
		for (int i = answer.length() - 1; i >= 2; i--) {
			String dots = ".".repeat(i);
			if (answer.contains(dots)) answer = answer.replace(dots, ".");
		}
		return answer;
	}
	
	private static String checkDot(String answer) {
		if (answer.length() < 1) return answer;
		if (answer.lastIndexOf(".") == answer.length() - 1) answer = answer.substring(0, answer.length()-1);
		if (answer.length() < 1) return answer;
		if (answer.indexOf(".") == 0) answer = answer.substring(1, answer.length());
		return answer;
	}

	private static String checkLenth(String answer) {
		if (answer.length() < 16) return answer; 
		answer = answer.substring(0, 15);
		answer = checkDot(answer);
		return answer;
	}
	
	private static String addLast(String answer) {
		if (answer.length() > 2) return answer;
		if (answer.length() == 2) answer += String.valueOf(answer.charAt(1));
		else answer += String.valueOf(answer.charAt(0)).repeat(2);
		return answer;
	}
}