class Employee 								
{	
	int empId;
	String empName;
	int total_leaves=15;								//Assigning total number of leaves
	double total_salary;
	double basic;
	int num_leaves;
	char type_leave;
	int pl=7,sl=6,cl=2;									//Assgning maximum number of paid, sick and casual leaves
	static int pflag=7,sflag=6,cflag=2;					//Used for reducing the number of leaves only for the given leave type

//Initializing the Construtor
	Employee(double bas,int leave,char lType)			
	{
		basic=bas;
		num_leaves=leave;
		type_leave=lType;
	}

	void calculate_balance_leaves()
	{
		if(avail_leave(num_leaves,type_leave)==true)		//Checking whether the requested leave can be granted or not
		{
			int result=total_leaves-num_leaves;
			System.out.println("Balance leaves: "+result);
		}
		else
			System.out.println("Requested leaves cannot be granted");
	}

//Checking whether requested leave is less than or equal to the maximum number of leaves possible in either paid, sick or casual category	
	boolean avail_leave(int no_of_leaves, char type_of_leave)		
	{
		if(type_of_leave=='p')
		{
			if(no_of_leaves<=pl)
			{
				pflag=pl-no_of_leaves;
				return true;
			}
			else
				return false;
		}
		if(type_of_leave=='s')
		{
			if(no_of_leaves<=sl)
			{
				sflag=sl-no_of_leaves;
				return true;
			}
			else
				return false;
		}
		if(type_of_leave=='c')
		{
			if(no_of_leaves<=cl)
			{
				cflag=cl-no_of_leaves;
				return true;
			}
			else
				return false;
		}

	  return false;

	}
	void calculate_salary()
	{
		double pf=(12*basic)/100;					//pf is 12% of basic
		double hra=(50*basic)/100;					//hra is 50% of basic
		total_salary=basic+hra-pf;					//total salary calculation using the given formula
		System.out.println("Total salary of the employee: "+total_salary);
	}


}

class PermanentEmp extends Employee
{
	PermanentEmp(double basic,int leave_applied,char leave_type)
	{
		super(basic,leave_applied,leave_type);
	}

//Overriding method in the super class
	@Override
	void calculate_balance_leaves()					
	{
		super.calculate_balance_leaves();
	}
	void calculate_salary()
	{
		super.calculate_salary();
	}
	void print_leave_details()
	{
		System.out.println("Total number of leaves: "+total_leaves);
		System.out.println("Balance paid leaves: "+pflag);
		System.out.println("Balance sick leaves: "+sflag);
		System.out.println("Balance casual leaves: "+cflag);
		
	}
}

class TemporaryEmp extends Employee
{
	TemporaryEmp(double basic,int leave_applied,char leave_type)
	{
		super(basic,leave_applied,leave_type);
	}
	@Override
	void calculate_balance_leaves()
	{
		super.calculate_balance_leaves();
	}
	void calculate_salary()
	{
		super.calculate_salary();
	}
}

public class Assgn5_3
{
	public static void main(String []args)
	{
		PermanentEmp pe=new PermanentEmp(20000.00,3,'c');			//Object creation
		TemporaryEmp te=new TemporaryEmp(10000.00,3,'s');
		System.out.println("Permanent Employee details:");
		pe.calculate_salary();
		pe.calculate_balance_leaves();
		pe.print_leave_details();
		System.out.println("------------------------------------------------------------");
		System.out.println("Temporary Employee details:");
		te.calculate_salary();
		te.calculate_balance_leaves();
			
		
	}
}
