import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class LargestSum {

	  public int maxSubArray(String line) {
		  String[] num = line.split(",");
		  int max_so_far = Integer.parseInt(num[0].trim());
		    int curr_max = Integer.parseInt(num[0].trim());;
		    for (int i = 1; i < num.length; i++)
		    {
		           curr_max = Math.max(Integer.parseInt(num[i].trim()), curr_max+Integer.parseInt(num[i].trim()));
		           max_so_far = Math.max(max_so_far, curr_max);
		    }
		 return max_so_far;
	    }
	
	public static void main(String[] args) throws IOException{
		
		LargestSum ls = new LargestSum();
		 File f = new File("E:/data.txt");
		//InputStreamReader reader = new InputStreamReader(System.in , StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(new FileReader(f));
		String line="";
		while((line = in.readLine()) != null) {
			System.out.println(line);
			System.out.println(ls.maxSubArray(line));
		}
		
		
	}
}
