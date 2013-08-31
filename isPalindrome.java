public boolean isPalindrome(String s){
		s= s.toLowerCase();
        s= s.replaceAll("[^a-z0-9]","");
        int halfLength = (s.length() - 1)/2;
        for(int i = 0; i <= halfLength; i++){
        	if(s.charAt(i) != s.charAt(s.length() - 1 - i))
        		return false;
        }
        return true;
	}
