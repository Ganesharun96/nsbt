package loan.demo;

import java.util.HashMap;
import java.util.Map;

public class RepaymentSchedule {
	
	Bank bank=new Bank();
	float Loan_Amountnew = bank.Loan_Amount;
	float Rate_of_Interestnew = bank.Rate_of_Interest;
	double fnew = bank.f;
	public RepaymentSchedule(float loan_Amountnew, float rate_of_Interestnew, double fnew) {
		super();
		Loan_Amountnew = loan_Amountnew;
		Rate_of_Interestnew = rate_of_Interestnew;
		this.fnew = fnew;
	}
	RepaymentSchedule re;
	Map<Integer,RepaymentSchedule> map =new HashMap<>();
	
	{
		for(int i=1;i<=12;i++)
		{
			map.put(i, re);
		}
	 }
	
	
	

}
//public void repay(float loan_Amount, float rate_of_Interest, double f ,double P)
//{
//	int j;
//	double OPn[]=new double[100];
//	double Pn[]=new double[100];
//	double In[]=new double[100];
//	OPn[1]=P;
//	
//	int n = 0;
//	for( j=1;j<=n;j++)
//	{
//		In[j] = ((Rate_of_Interest/100)/Number_of_Installments);
//				· Pn = Installment – In;
//				· OPn+1 = OPn – Pn;
//	}
//}