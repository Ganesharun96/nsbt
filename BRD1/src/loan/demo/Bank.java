package loan.demo;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Bank {

	public void getInstallments() {
		int Residual_value = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("loan Amount");
		float Loan_Amount = sc.nextFloat();
		System.out.println("Rate_of_Interest");
        float Rate_of_Interest = sc.nextFloat();
		//System.out.println("Tenure");
		//float Tenure = sc.nextFloat();
         float Tenure=0; 
		try {
		System.out.println("value of tenure");
		Tenure = sc.nextFloat();
		if(Tenure<0)
		{
			throw new InputMismatchException("negative number");
		}
	}
	
	catch(InputMismatchException e)
	{System.out.println(e.getMessage());
	while(Tenure<0)
	{System.out.println("enter positive no");
	Tenure = sc.nextFloat();
	}
	}
		float Number_of_Installments=0;
		try {
			System.out.println("Number_of_Installments");
			Number_of_Installments = sc.nextFloat();
			if(Number_of_Installments<12||Number_of_Installments>12)
			{
				throw new InputMismatchException("incorrect number");
			}
		}
		
		catch(InputMismatchException e)
		{
			System.out.println(e.getMessage());
		while(Number_of_Installments < 12 || Number_of_Installments > 12)
		{
			System.out.println("enter correct  no of insta");
			Number_of_Installments = sc.nextFloat();
		}
		}
		

		

	    
//		System.out.println("Number_of_Installments");
//		float Number_of_Installments = sc.nextFloat();
		
		float emi = calculateEMI(Loan_Amount, Rate_of_Interest, Tenure, Number_of_Installments);
		System.out.println("sno loanamt inr principle emi");
//		try {
//			System.out.println("value of tenure");
//			 Tenure = sc.nextFloat();
//			if(Tenure<0)
//			{
//				throw new InputMismatchException("negative number");
//			}
//		}
//		
//		catch(InputMismatchException e)
//		{System.out.println(e.getMessage());
//		while(Tenure<0)
//		{System.out.println("enter positive no");
//		Tenure = sc.nextFloat();
//		}
//		}
		
		
		
		float Loan_Amount1 = Loan_Amount;
		for (int i1 = 1; i1 <= 12; i1++) {
//			System.out.println(i1);
			Loan_Amount = (float) getInstallment(i1,Loan_Amount, Rate_of_Interest, Tenure, Number_of_Installments, emi);
		}
		System.out.println("instno");
		
		int insNo = sc.nextInt();
		System.out.println("sno loanamt inr principle emi");
		for (int i1 = 0; i1 <= 12; i1++) {
			
			Loan_Amount1 = (float) getInstallmentNo(Loan_Amount1, Rate_of_Interest, Tenure, Number_of_Installments, emi,
					insNo, i1);
		}
	}
	

	float getInstallmentNo(float Loan_Amount, float Rate_of_Interest, float Tenure, float Number_of_Installments,
			float f, int insNo, int iteration) {
		
		DecimalFormat formatter = new DecimalFormat("0.00");
		
		float a = ((Rate_of_Interest / 100) / Number_of_Installments);
		float a1 = Loan_Amount * a;
		float principle = f - a1;
		float os = Loan_Amount - principle;

		if (insNo == iteration + 1) {
			System.out.println((iteration+1)+" "+formatter.format(Loan_Amount) + " " + formatter.format(a1) + " "
					+ formatter.format(principle) + " " + formatter.format(f));
			
		}
		return os;
	}

	float getInstallment(int i1,float Loan_Amount, float Rate_of_Interest, float Tenure, float Number_of_Installments,
			float f) {
		
		DecimalFormat formatter = new DecimalFormat("0.00");
//		System.out.println("Installment Amount" + formatter.format(f));
		float a = ((Rate_of_Interest / 100) / Number_of_Installments);
		float a1 = Loan_Amount * a;
		float principle = f - a1;
		float os = Loan_Amount - principle;
		
		System.out.println(i1+"  "+formatter.format(Loan_Amount) + " " + formatter.format(a1) + " "
				+ formatter.format(principle) + " " + formatter.format(f));
		

		System.out.println();
		return os;

	}

	public float calculateEMI(float Loan_Amount, float Rate_of_Interest, float Tenure, float Number_of_Installments) {
		int Residual_value = 0;
		float a = ((Rate_of_Interest / 100) / Number_of_Installments);
		float a1 = Loan_Amount * a;
		float b = (1 + a);
		float c = (float) Math.pow(b, Tenure);
		float d = (a1 - ((Residual_value * a)) / c);
		float e = (1 - (1 / c));
		float f = d / e;
		return f;
	}



	public static void main(String[] args) {

		Bank bank = new Bank();
		bank.getInstallments();



	}
}
