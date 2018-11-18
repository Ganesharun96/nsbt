package loan;

import java.util.Scanner;

public class Bank {

public  void installmentAmount() {
	int Residual_value= 0;
	 Scanner sc = new Scanner(System.in);
	 System.out.println("loan Amount" );
    float Loan_Amount = sc.nextFloat();
    System.out.println("Rate_of_Interest" );
    
	  float Rate_of_Interest = sc.nextFloat();
	 System.out.println("Tenure" );
	 float Tenure = sc.nextFloat();
	 System.out.println("Number_of_Installments" );
	 float Number_of_Installments = sc.nextFloat();
	 System.out.println("Loan_Amount Rateofinterest principle installmentAmount");
		for(int i1=0;i1<12;i1++)
	 {
//	 System.out.println(i1);
		 
		 Loan_Amount = (float) getinsta(Loan_Amount,Rate_of_Interest ,Number_of_Installments,Tenure);
	 }
}

double getinsta(float Loan_Amount, float Rate_of_Interest, float Tenure,float Number_of_Installments) {
	int Residual_value= 0;
//	float num1 = Loan_Amount*((Rate_of_Interest/100)/Number_of_Installments);
	float num= ((Rate_of_Interest/100)/Number_of_Installments);
	float num1=  Loan_Amount *num;
//	float b = (1 + a);
	float denom=1+num;
	double denom1 =  Math.pow(denom, Tenure);
//	double d = (a1 -((Residual_value*a))/c);
	double denom2 = (1 - (1/denom1));
	double installmentAmount = num1/denom2 ;
//	System.out.println("Installment Amount" +f);
//	double interest= Loan_Amount *((Rate_of_Interest/100)/Number_of_Installments);
	double principle = installmentAmount - num1;
	double os= Loan_Amount-principle;
	System.out.println(Loan_Amount+"  "+num1+"  "+principle+"  "+installmentAmount);
//	System.out.println(os);
	return os;
}
		 
	
//public  void installmentAmount1(float  Loan_Amount,float Rate_of_Interest,double Tenure,float Number_of_Installments)
//{
//	double interest= Loan_Amount *((Rate_of_Interest/100)/Number_of_Installments);
//	double principle = f - interest;
//	double os= Loan_Amount-principle;
//}

 public static void main(String[] args) {
	
	 Bank bank = new Bank();
	 bank.installmentAmount();
	
	 
	 
//	 float Number_of_Installments = sc.nextFloat();
//	 bank.installmentAmount(Loan_Amount,Rate_of_Interest,Tenure,Number_of_Installments);
	 	 
}
}
