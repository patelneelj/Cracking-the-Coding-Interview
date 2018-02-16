
public class CheckUniqueCharacters {
	
	public boolean CheckStringUnique(String str){
		
 // Total count in Ascii table is 128. If is more than 128, then it is not unique.
		if(str.length() > 128){
			return false;
		}
		
		int asciiValue = 0;
		boolean checkAscii[]  = new boolean[128];
		
		str= str.toUpperCase().replaceAll("\\s", "");
		
		char ch[] = str.toCharArray();
		
		for (int i = 0; i < str.length() ; i++ ){
			asciiValue = str.charAt(i);
			if(checkAscii[asciiValue]) 
			{
				return false;
			}
			checkAscii[asciiValue]  = true;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		CheckUniqueCharacters cuc = new CheckUniqueCharacters();
		System.out.println(cuc.CheckStringUnique("Neel"));
	}
	

}
