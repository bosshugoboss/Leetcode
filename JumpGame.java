/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
           int start = newInterval.start;
  	   int end = newInterval.end;
		   Interval frontInter = null;
		   int findFirst = 0;
		   ArrayList<Interval> result = new ArrayList<Interval>();
		   for(Interval inter : intervals){
		      if(findFirst == 0){
		       if(start >= inter.start && start <= inter.end){
			       frontInter = inter;
				   if(end <= inter.end) return intervals;
			       else findFirst = 1;
			   }
			   else if(start < inter.start){
			       if(end <= inter.end){
				       frontInter = new Interval(start, inter.end);
					   result.add(frontInter);
					   findFirst = 2;
				   }
				   else if(end >= inter.start){
				       frontInter = new Interval(start, inter.end);
					   findFirst = 1;
				   }
				   else{
				       result.add(newInterval);
					   result.add(inter);
					   findFirst = 2;
				   }
			   }
			   else{
                   result.add(inter);			   
			   }
			  }
			  else if(findFirst == 1){
			    if(end < inter.start){
				   Interval newAdd = new Interval(frontInter.start, end);
                   result.add(newAdd);	
                   findFirst = 2;				   
				}
			    else if( end >= inter.start && end <= inter.end ){
				   Interval newAdd = new Interval(frontInter.start, inter.end);
				   result.add(newAdd);
				   findFirst = 2;
				}
			  }
			  else{
			     result.add(inter);
			  }
		   }
		   if(findFirst == 0) result.add(newInterval);
		   if(findFirst == 1) result.add(new Interval(frontInter.start, newInterval.end));
		   return result;
    }
}
