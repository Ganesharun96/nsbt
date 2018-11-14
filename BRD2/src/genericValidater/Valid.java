/*
 *
 */
package genericValidater;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Valid
{ 
	static SimpleDateFormat dates = new SimpleDateFormat("dd/MM/yyyy");
	public static boolean validDatatype(Object numeric )
	{

	if( numeric.getClass().getSimpleName().equals("Integer"))
	{
return true;
}
	else if( numeric.getClass().getSimpleName().equals("Double"))
	{
return true;
}
	if( numeric.getClass().getSimpleName().equals("Character"))
	{
return true;
}
	if( numeric.getClass().getSimpleName().equals("String"))
	{
return true;
}
	if( numeric.getClass().getSimpleName().equals("Boolean"))
	{
return true;
}
	return false;
	}
	public static boolean maxLength(String object,short length)
	{

if( (object.length())<=length)
		
	{
return true;
}
	return false;
	}
	public static boolean specialCharacters(String s)
	{

	Pattern pattern=Pattern.compile("[a-zA-Z0-9]+");
	Matcher matcher =pattern.matcher(s);
	if(matcher.matches())

return true;
	else
		return false;
	}
	public static boolean domainvalue(ArrayList al,String value) {
		
	
	if(al.contains(value))
	{return true;
	}return false;
	
}

	public static boolean email(String email)
	{
		if(email.contains("@")||email.contains("."))
		{
			if(!email.contains(" "))
			{
				return true;
			}
		}
		
		return false;
		
	}
	public static Boolean formatValidation(SimpleDateFormat dates,String value)
	{
		dates.setLenient(false);
		try
		{
			dates.parse(value);
			return true;
		}
		catch(ParseException e)
		{
			return false;
		}
	}
	
	public static void main(String[] args) { 
		 

		ArrayList<String> al=new ArrayList<String>();  
		al.add("mon");  
		al.add("tue");  
		al.add("wed");  
		al.add("thur");  
		System.out.println(validDatatype(12));
		System.out.println(maxLength("1234567",(short)6));
		System.out.println(specialCharacters("$"));
		System.out.println(domainvalue(al,"mon"));
		
	   System.out.println(formatValidation(dates,"13/12/1997"));
	
		System.out.println(email("gary @nucl.com"));
	}
}
