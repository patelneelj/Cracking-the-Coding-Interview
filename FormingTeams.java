package LeetCode;
import java.util.*;

public class FormingTeams {
    
	private static List<List<Integer>> totallist  = new ArrayList<List<Integer>>();
	
	public static void main(String[] args) {
		// Every student has there skills in this array. So skill[] length  = total number of student
		int skills[] = { 2,8,0,4,6}; 
		//Total number of team member in game.
		int memberCount = 3;
		int n = skills.length;
		//Required total Skill set
		int k = 10;
		System.out.println(getCombination(skills, n, memberCount,k));
	}

	static int getCombination(int skills[], int n, int memberCount, int k) {

		int teamForm[] = new int[memberCount];		
		helper(skills, teamForm, 0, n - 1, 0, memberCount, k);
		return totallist.size();
	}

	static void helper(int skills[], int teamForm[], int start, int end, int index, int r, int k ) {
	
		if (index == r) {
			
			int total = 0 ; 
			List<Integer> list  = new ArrayList<Integer>();
			List<Integer> requiredList  = new ArrayList<Integer>();
			for (int j = 0; j < r; j++) {
				//System.out.print(teamForm[j] + " ");
				total = total + teamForm[j];			    
				list.add(teamForm[j]);
			}
			if(total == k)
				totallist.add(list);
			
			//System.out.println("");
		
			return;
		}		
		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			teamForm[index] = skills[i];
			helper(skills, teamForm, i + 1, end, index + 1, r, k);
		}
	}

}
