import java.util.Arrays;

public class PermutationOfOther {
	
	public boolean Checkpermutation(String str1, String str2) {
		
		str1= str1.toUpperCase().replaceAll("\\s", "");
		str2= str2.toUpperCase().replaceAll("\\s", "");
		
		if(str1.length()!=str2.length()){
			return false;
		}
		else
		{
			 
			if(sort(str1).equals(sort(str2))){
				return true;
			}
		}
		return false;
	}
	
	public String sort(String str){
		char ch[] = str.toCharArray();
		Arrays.sort(ch);
		String sortString = new String(ch);
		return sortString;
		
	}

	public static void main(String[] args) {
		PermutationOfOther p = new PermutationOfOther();
		System.out.println(p.Checkpermutation("Neel", "Elen"));
	}
}
