public class StudentScore implements Comparable<StudentScore>
	{
	
	    private String name;
	    private int score; // score must be 0 or more
	    
	    public StudentScore(String nm, int score)
	    {
	    	name = nm;
	    	setScore(score);
	    }

	    public String getName()
	    {
	        return name;
	    }
	    public int getScore()
	    {
	    	return score;
	    }
	    
	    public void setName(String n) 
	    {
	        name = n;
	    }
	    public void setScore (int n)
	    {
	    	if (n >= 0)
	    	{
	    		score = n;
	    	}
	    	else
	    	{
	    		score = 0;
	    	}
	    }
	    public String toString()
	    {
			return "Student:"+getName()+" \nScore:"+getScore()+"\n----------";
	    }	
	    
		public int compareTo(StudentScore a) 
		{
			if (this.score != a.score)
				return a.score-this.score;
			else{
				return this.name.compareTo(a.name);
			
			}
				
			
		}
	    

	}