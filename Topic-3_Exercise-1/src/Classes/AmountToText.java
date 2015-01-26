package Classes;

import java.text.DecimalFormat;
import java.text.ParseException;

public class AmountToText {
	
	public String convertToText(double amount){
		double dec = amount%1; 
		
		//get and convert decimals
		DecimalFormat df=new DecimalFormat("0.00");
		String formate = df.format(dec); 
		try {
			dec = (Double)df.parse(formate) ;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int aux1=(int) (dec*100);
		
		// get and convert integer
		
		int inte = (int) (amount-dec);
		String string =String.valueOf(inte);
		int size = string.length();
		int aux2=0;
		int multi=1;
		String total = "";
		for(int i=size;i>0;i--){
			if(i==4){
				if(((int) string.charAt(i-2)-48)==1 ){
					total=  convertionTable((int) string.charAt(i-1)-48,0)+" "+total;
					i=3;
				}else{
					total=  convertionTable((int) string.charAt(i-1)-48,i)+" "+total;
				}
			}else{
			total=  convertionTable((int) string.charAt(i-1)-48,i)+" "+total;
			}
		}
		
		
		String text= total+ "and " +aux1 + "/100 dollars";
		return text;
	}
	
	
	// convertion table 
	public String convertionTable(int number,int position){
		switch(position){
		case 4:	switch(number){
					case 1: return "one";
					case 2: return "two";
					case 3: return "three";
					case 4: return "four";
					case 5: return "five";
					case 6: return "six";
					case 7: return "seven";
					case 8: return "eight";
					case 9: return "nine";
					default: return "";
				}
		case 3:	switch(number){
					case 1: return "ten";
					case 2: return "twenty";
					case 3: return "thirty";
					case 4: return "forty";
					case 5: return "fifty";
					case 6: return "sixty";
					case 7: return "seventy";
					case 8: return "eighty";
					case 9: return "ninety";
					default: return "";
				}
		case 2:	switch(number){
					case 1: return "one hundred";
					case 2: return "two hundred";
					case 3: return "three hundred";
					case 4: return "four hundred";
					case 5: return "five hundred";
					case 6: return "six hundred";
					case 7: return "seven hundred";
					case 8: return "eight hundred";
					case 9: return "nine hundred";
					default: return "";
				}
		case 1:	switch(number){
					case 1: return "one thousand";
					case 2: return "two thousand";
					case 3: return "three thousand";
					case 4: return "four thousand";
					case 5: return "five thousand";
					case 6: return "six thousand";
					case 7: return "seven thousand";
					case 8: return "eight thousand";
					case 9: return "nine thousand";
					default: return "";
				}
		case 0:	switch(number){
					case 1: return "eleven";
					case 2: return "twelve";
					case 3: return "thirteen";
					case 4: return "fourteen";
					case 5: return "fifteen";
					case 6: return "sixteen";
					case 7: return "seventeen";
					case 8: return "eighteen";
					case 9: return "nineteen";
					default: return "";
				}
		default: return "";
		}
		
	}

}
