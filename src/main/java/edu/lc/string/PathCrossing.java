package edu.lc.string;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {
	
	static class Solution {
		public boolean isPathCrossing(String path) {
	        Set<Integer> locations = new HashSet<>();
	        boolean crossed = false;
	        
	        char[] points = path.toCharArray();
	        int x = 0, y = 0;
	        locations.add(x * 10000 + y);
	        for(char c: points) {
	        	switch(c) {
	        		case 'N':
	        			y++;
	        			break;
	        		case 'E':
	        			x++;
	        			break;
	        		case 'S':
	        			y--;
	        			break;
	        		case 'W':
	        			x--;
	        			break;
	        	}
	        	System.out.println(c + " --> " + 10000*x + y + "," + x + " ," + y);
	        	crossed = !locations.add(10000*x + y);
	        	if(crossed)
	        		break;
	        }
	     
	        return crossed;
	    }
	}
	
	public static void main(String[] args) {
		Solution obj = new Solution();
		boolean result = obj.isPathCrossing("SN");
		System.out.println(result);
	}

}
