
import java.util.*;
import java.io.*;


class employee {
 Scanner in =new Scanner(System.in);
    public int emp_no;
    public String emp_name;
   public String emp_add;
    public String emp_dept;
    public String emp_desg;


  public void getdata(){
        System.out.println("enter your name");
        emp_name=in.nextLine();
        System.out.println("enter address");
        emp_add=in.nextLine();
        System.out.println("enter designation");
        emp_desg=in.nextLine();
        System.out.println("enter department");
        emp_dept=in.nextLine();
  }
    void displaydata() {
        System.out.println("employee no " + emp_no + "name" + emp_name + "Address " + emp_add + " designation " + emp_desg + "department" + emp_dept);
        

    }
}

    class permanent_employee extends employee{
Scanner in=new Scanner(System.in);
String emp_type;
int emp_basic;
int emp_da;
int emp_hra;
int emp_ma;
int emp_pf;
int ptax;
int itax;
int gross;
int net;
int da;
int hra;


@Override public void  getdata(){
    super.getdata();
    System.out.println("enter employee type");
    emp_type=in.nextLine();
    System.out.println("enter dearness allowance");
    da=in.nextInt();
    System.out.println("enter basic salary");
    emp_basic=in.nextInt();
    System.out.println("enter house allowance");
    hra=in.nextInt();
    System.out.println("enter medical allowance");
    emp_ma=in.nextInt();
    System.out.println("enter professional tax");
    ptax=in.nextInt();
    System.out.println("enter income tax");
    itax=in.nextInt();
}

@Override public void displaydata(){
    super.displaydata();
    System.out.println("EMPLOYEE TYPE :\n" + emp_type );
    System.out.println("Basic salary \n" + emp_basic);
    System.out.println("\n Dearness allowance " + emp_da);
    System.out.println("\n HRA" + emp_hra);
    System.out.println("\n Medical allowance " +  emp_ma);
    System.out.println("\n PF " + emp_pf);
    System.out.println("\n Professional tax" + ptax );
    System.out.println("\n Income tax" + itax);
    System.out.println("\n Gross salary" + gross);
    System.out.println("\n Net Salary " + net);
}

void  calculate(){
    emp_da=emp_basic*da/100;
    emp_hra=emp_basic*hra/100;
    emp_pf=(emp_basic + emp_da) *12/100;
    gross=emp_basic + emp_da + emp_hra + emp_ma;
    net=gross-ptax-itax-emp_pf;
}

void generate_pay_slip_permanent_employee(){
    int no;
    Scanner in=new Scanner(System.in);
    no=in.nextInt();
    if (no>12||no<0){
        System.out.println("Invalid month number");
        return;
    }
    System.out.println();
    calculate();
    displaydata();

    System.out.println("Emp Number \n" + emp_no);
    System.out.println("Emp Name \n" + emp_name);
    System.out.println("Emp Add \n" + emp_add);
    System.out.println("Emp designation \n" + emp_desg);
    System.out.println("Emp Department \n" + emp_dept);
    System.out.println("Emp type " + emp_type + "\n" + "Basic salary" + emp_basic+ "\n" +  "Employee gross salary" + gross + "\n" + "Professional tax " + ptax + "\n" + "Income tax " + itax + "\n" + "Net Salary" + net + "\n"
    + "Dearness Allowance" + emp_da + "\n" + "House rent Allowance" + emp_hra + "\n" + "medical allowance" + emp_ma + "\n" +
             "provident fund" + emp_pf + "\n");
    System.out.println();
        }
        }


        class contractual_employee extends employee {
    Scanner in=new Scanner(System.in);
            String emp_type;
            int gross;
            int ptax;
            int itax;
            int net;

            @Override public  void getdata(){
                super.getdata();
                System.out.println("enter employee ttype");
                emp_type=in.nextLine();
                System.out.println("enter gross salary");
                gross=in.nextInt();
                System.out.println("enter income tax");
                itax=in.nextInt();
                System.out.println();

            }


            @Override void displaydata(){
                super.displaydata();
                System.out.println("\n EMPLOYEE TYPE : " + emp_type);
                System.out.println("\n Gross salary : " + gross);
                System.out.println("\n Professional tax :" + ptax);
                System.out.println("\n Income tax :" + itax);
                System.out.println("\n Net Salary : "+ net);
            }
            void calculate(){
                net=gross-ptax-itax;
            }
            
            void generate_pay_slip_contractualemployee(){
                int no;
                Scanner in=new Scanner(System.in);
                 no=in.nextInt();
                if (no>12||no<0){
                    System.out.println("Invalid month number");
                    return;
                }
                System.out.println();
                calculate();
                displaydata();
                
                System.out.println("Emp Number \n" + emp_no);
                System.out.println("Emp Name \n" + emp_name);
                System.out.println("Emp Add \n" + emp_add);
                System.out.println("Emp designation \n" + emp_desg);
                System.out.println("Emp Department \n" + emp_dept);
                System.out.println("Emp type " + emp_type + "\n" + "Employee gross salary" + gross + "\n" + "Professional tax " + ptax + "\n" + "Income tax " + itax + "\n" + "Net Salary" + net + "\n");
                System.out.println();
                
                
            }
            
        }
        
        class demo{
    public static void main(String[] args ){
        int choice;
        Scanner in=new Scanner(System.in);
        permanent_employee p=new permanent_employee();
        contractual_employee c=new contractual_employee();
        
        
        
        
        
        do {
            System.out.println("::::::::::MENU:::::: \n");
            System.out.println("1. GENERATE PERMWNENT EMPLOYEE PAYSLIP \n");
            System.out.println("2.GENERATE CONTRACTUAL EMPLOYEE PAYSLIP \n");
            System.out.println("3. DISPLAY PERMANENT EMPLOYEE DATA \n");
            System.out.println("4. DISPLAY CONTRACTUAL EMPLOYEE DATA \n");
            System.out.println("Press 5 for exit");
            System.out.println("Enter your choice \n");
            choice=in.nextInt();
            
            switch (choice){
                case 1:
                    p.getdata();
                    p.generate_pay_slip_permanent_employee();
                    break;
                case 2:
                    c.getdata();
                    c.generate_pay_slip_contractualemployee();
                    break;
                case 3:
                    p.displaydata();
                    break;
                case 4:
                    c.displaydata();
                    break;
                default:
                    System.out.println("invalid input");
                    break;
                    
            }
        }
        while (choice!=5);
        
    }
        }