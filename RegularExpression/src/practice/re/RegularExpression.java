package practice.re;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		new RegularExpression().validateExtention();
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
	
	public void otherExamples() {
		/**
		/s : matches any whitespace characters such as space and tab
		/S : matches any non-whitespace characters
		/d : matches any digit character
		/D : matches any non-digit characters
		/w : matches any word character (basically alpha-numeric)
		/W : matches any non-word character
		/b : matches any word boundary (this would include spaces, dashes, commas, semi-colons, etc)
		*/
		System.out.println(Pattern.matches("^\\d{3}", "912"));//starting 3 should be number
		System.out.println(Pattern.matches("(.)*\\d{3}$", "aa2121"));//ending with 3 digit with any length
		Pattern pattern = Pattern.compile("\\.");
		Matcher matcher = pattern.matcher("gaurav.rajput");
		if(matcher.find())
		System.out.println(matcher.start());//output is 6 as it starts from 0
		}
/*
 * Java regex with case insensitive
 */
	
public void caseInsencestive() {
/*We need to pass Pattern.CASE_INSENSITIVE constant to Pattern.compile() method, 
*along with regular expression. This makes case insensitive matches
**/
	Pattern pattern = Pattern.compile("gaurav",Pattern.CASE_INSENSITIVE);
	Matcher matcher = pattern.matcher("My name is GauraV Rajput");
	if(matcher.find())
	System.out.println(matcher.start());
}

/*
 * Java regex to validate Ip address
 */
public void validateIpAddress() {
	// ^ denotes starting and $ denotes end of the address
	Pattern pattern = Pattern.compile("^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$");
	Matcher matcher = pattern.matcher("192.10.07.111");
	if(matcher.find())
	System.out.println("Valid Ip address");
	else {
		System.out.println("Not a Valid Ip address");
	}
}

/*
 * Java regex to remove multiple spaces into single space
 */
public void removeMultipleSpace() {
	Pattern pattern = Pattern.compile("\\s+");
	Matcher matcher = pattern.matcher("I       have  lots    of spaces");
	System.out.println(matcher.replaceAll(" "));
}

/*
 * Java regex to validate email id
 */
public void validateEmailId() {
	Pattern pattern = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[a-zA-Z]{2,})$");
	Matcher matcher = pattern.matcher("satish_12raj.put@google.com");
	if(matcher.find())
	System.out.println("Valid email");
	else {
		System.out.println("Not a Valid email");
	}
}

/*
 * Java regex to validate user name
 */
public void validatePassword() {
	//Password should contain one digit, one lower case char, 
	//one upper case char, some special chars, 
	//length should be within 6 to 15 chars
	Pattern pat=Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15}");
	Matcher matcher=pat.matcher("B#2@asn");
	if(matcher.find())
		System.out.println("Valid credentials");
		else {
			System.out.println("Invalid credentials");
		}
}


/*
 * Java regex to validate file extension
 */
public void validateExtention() {
//(?i) starts case-insensitive mode
//(?-i) turns off case-insensitive mode
	Pattern pat=Pattern.compile("\\.(?i)(txt|doc|csv|pdf)$");
	Matcher matcher=pat.matcher("abc.xt");
	if(matcher.find())
		System.out.println("Valid extension");
		else {
			System.out.println("Invalid extension");
		}
}
}
