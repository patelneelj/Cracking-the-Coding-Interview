package Other;
import java.util.*;

public class LengthOfSubsequence {

	public static List<Integer> getSeqCount(String str) {
		int[] charMap = new int[26];
		List<Integer> returnList = new ArrayList<Integer>();
		str = str.toLowerCase();
		/*
		 * store index of last occurrence of every character in input string. eg for
		 * input => abcabcabc charMap => [(a-6), (b-7), (c-8)]
		 */
		for (int i = 0; i < str.length(); i++) {
			charMap[str.charAt(i) - 'a'] = i;
		}

		int start = 0;
		while (start < str.length()) {
			int seqLen = getSeq(start, str, charMap);
			returnList.add(seqLen);
			start += seqLen;
		}
		return returnList;
	}

	// get sequence length starting from character at start index
	public static int getSeq(int start, String str, int[] charMap) {
		int len = 1;
		int end = charMap[str.charAt(start) - 'a'];
		while (start < end) {
			len++;
			start++;
			end = charMap[str.charAt(start) - 'a'] > end ? charMap[str.charAt(start) - 'a'] : end;

		}
		return len;
	}

	public static void main(String[] args) {
		
		String s = "abcccbaaefffefhjkkkkk";
		System.out.println(s.length());
		System.out.println(getSeqCount(s));

	}
}
