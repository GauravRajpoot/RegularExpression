# RegularExpression
This Repo contains regular expression using java.

Regex Character classes
No.	Character_Class	     Description
1	[abc]	            a, b, or c (simple class)
2	[^abc]	          Any character except a, b, or c (negation)
3	[a-zA-Z]	        a through z or A through Z, inclusive (range)
4	[a-d[m-p]]	      a through d, or m through p: [a-dm-p] (union)
5	[a-z&&[def]]	    d, e, or f (intersection)
6	[a-z&&[^bc]]	    a through z, except for b and c: [ad-z] (subtraction)
7	[a-z&&[^m-p]]	    a through z, and not m through p: [a-lq-z](subtraction)


Regex	    Description
.	    Any character (may or may not match terminator)
\d	  Any digits, short of [0-9]
\D	  Any non-digit, short for [^0-9]
\s	  Any whitespace character, short for [\t\n\x0B\f\r]
\S	  Any non-whitespace character, short for [^\s]
\w	  Any word character, short for [a-zA-Z_0-9]
\W	  Any non-word character, short for [^\w]
\b	  A word boundary
\B	  A non word boundary

