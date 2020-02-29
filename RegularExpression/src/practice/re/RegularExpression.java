package practice.re;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		new RegularExpression().practiceSecond();
	}
	
	public void firstMatchInput() {
	/*
	 * In this we checking match for 2 length word containing "g" as first letter
	 */
	Pattern pat = Pattern.compile("g."); 
	Matcher match = pat.matcher("ga");
	boolean matchValue1 = match.matches();
	/*
	 * Other ways
	 */	
	boolean matchValue2=Pattern.compile(".b").matcher("ab").matches();  
	boolean matchValue3 = Pattern.matches("....av", "gaurav");  
	System.out.println("matchValue1:"+matchValue1+"\nmatchValue2:"+matchValue2+"\nmatchValue3:"+matchValue3);  
	}
	
	public void secondInputMatch() {
		/*
		 *   X?  -->	X occurs atleast once or not at all
		 *   X+  -->	X occurs once or more times
		 *   X*	 -->    X occurs zero or more times
		 *   X{n} -->	X occurs n times only
		 */
		System.out.println(Pattern.matches("[amn]?", "a"));//true (a or m or n comes one time)  
		System.out.println(Pattern.matches("[amn]?", "aaa"));//false (a comes more than one time)  
		System.out.println(Pattern.matches("[amn]?", "aammmnn"));//false (a m and n comes more than one time)  
		System.out.println(Pattern.matches("[amn]?", "aazzta"));//false (a comes more than one time)  
		System.out.println(Pattern.matches("[amn]?", "am"));//false (a or m or n must come one time)  
		  
		System.out.println("+Gaurav....");  
		System.out.println(Pattern.matches("[amn]+", "a"));//true (a or m or n once or more times)  
		System.out.println(Pattern.matches("[amn]+", "aaa"));//true (a comes more than one time)  
		System.out.println(Pattern.matches("[amn]+", "aammmnn"));//true (a or m or n comes more than once)  
		System.out.println(Pattern.matches("[amn]+", "aazzta"));//false (z and t are not matching pattern)  
		  
		System.out.println("Rajput....");  
		System.out.println(Pattern.matches("[amn]*", "ammmna"));//true (a or m or n may come zero or more times)  
		  
		}
	
	public void thirdInputMatch() {
	System.out.println("metacharacters d....");//d means digit  
  
	System.out.println(Pattern.matches("\\d", "abc"));//false (non-digit)  
	System.out.println(Pattern.matches("\\d", "1"));//true (digit and comes once)  
	System.out.println(Pattern.matches("\\d", "4443"));//false (digit but comes more than once)  
	System.out.println(Pattern.matches("\\d", "323abc"));//false (digit and char)  
	  
	System.out.println("metacharacters D...."); //D means non-digit  
	  
	System.out.println(Pattern.matches("\\D", "abc"));//false (non-digit but comes more than once)  
	System.out.println(Pattern.matches("\\D", "1"));//false (digit)  
	System.out.println(Pattern.matches("\\D", "4443"));//false (digit)  
	System.out.println(Pattern.matches("\\D", "323abc"));//false (digit and char)  
	System.out.println(Pattern.matches("\\D", "m"));//true (non-digit and comes once)  
	  
	System.out.println("metacharacters D with quantifier....");  
	System.out.println(Pattern.matches("\\D*", "mak"));//true (non-digit and may come 0 or more times)  
	  
	}
	
	/*Create a regular expression that accepts alphanumeric characters only.  
	Its length must be six characters long only.*/ 
	public void practiceOne() {
		System.out.println(Pattern.matches("[a-zA-Z[0-9]]{2}", "aa1"));
	}
	
	/*Create a regular expression that accepts 10 digit numeric characters 
	 starting with 7, 8 or 9 only.*/
	public void practiceSecond() {
		System.out.println(Pattern.matches("[789]{1}[0-9]{9}", "9999999999"));
	}
	
	}

