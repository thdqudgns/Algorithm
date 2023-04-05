class Solution {
    public static void main(String[] args) {
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
	}

    public static String solution(String new_id) {
        String answer = new_id.toLowerCase();
        for (int i = answer.length() - 1; i >= 0; i--) {
			char tmp = answer.charAt(i);
			if ('a' <= tmp && tmp <= 'z') continue;
			if ('0' <= tmp && tmp <= '9') continue;
			if (tmp == '-' || tmp == '_' || tmp == '.') continue;
			answer = answer.substring(0, i) + answer.substring(i+1);
		}
        
        String result = new ID(answer)
        		.removeDot()
        		.checkDot()
        		.blank()
        		.checkLenth()
        		.checkDot()
        		.addLast()
        		.getResult();
        
        return result;
    }

    private static class ID {
    	private String s;
    	
    	ID(String s) {
    		this.s = s;
    	}
    	
    	private ID removeDot() {
    		if (s.length() <= 1) return this;
    		for (int i = s.length() - 1; i >= 2; i--) {
    			String dots = ".".repeat(i);
    			if (s.contains(dots)) s = s.replace(dots, ".");
    		}
    		return this;
    	}
    	
    	private ID checkDot() {
    		if (s.length() < 1) return this;
    		if (s.lastIndexOf(".") == s.length() - 1) s = s.substring(0, s.length()-1);
    		if (s.length() < 1) return this;
    		if (s.indexOf(".") == 0) s = s.substring(1, s.length());
    		return this;
    	}
    	
    	private ID blank() {
    		s = s.isEmpty() ? "a" : s;
    		return this;
    	}
    	
    	private ID checkLenth() {
    		if (s.length() < 16) return this; 
    		s = s.substring(0, 15);
    		return this;
    	}
    	
    	private ID addLast() {
    		if (s.length() > 2) return this;
    		if (s.length() == 2) s += String.valueOf(s.charAt(1));
    		else s += String.valueOf(s.charAt(0)).repeat(2);
    		return this;
    	}
    	
    	private String getResult() {
    		return s;
    	}
    }
}