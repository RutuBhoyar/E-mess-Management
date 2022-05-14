package e_mess_management;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.io.Console;

class orders extends E_mess
{
	
	Scanner sc = new Scanner(System.in);
	String name;
	String phno;
	int ch;
	int Max;
	int flag;
	SMS s = new SMS();

	orders()
	{

		for(int i = 0;i<Max;i++)
		{
			order_insert[i] = new orders();
		}

		this.name = null;
		this.phno = null;
		this.ch = 0;
		front = 0;
		rear = 0;
		this.Max = 30;
		this.flag = 0;
	}
	
	orders(String name,String phno,int ch)
	{
		this.name = name;
		this.phno = phno;
		this.ch = ch;
	}
	
	
	boolean isFull()
	{
		if(rear == Max-1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	boolean isEmpty()
	{
		if(front==rear)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	void place_order()
    {
    	
    	String name;
    	String phno;
    	
    	
    	
    	if(isFull()==true)
    	{
			System.out.println("___________________________________________________________");
    		System.out.println("Sorry !!! We cant accept the order ... See you tommorrow !");
    	}
    	else
    	{
    		
    		int op;
    		System.out.println("Enter your name : ");
        	name = sc.next();
        	

        	System.out.println("Enter your phone no:");
        	phno = sc.next();

			int a=Customer.check(phno);
			if(a==0)
			{
				int b;
				do
				{
					System.out.println("______________________________________________");
					System.out.println("\tInvalid phone number !!!");
					System.out.println("\tEnter valid phoneno :");
					System.out.println("______________________________________________");
					String pno=sc.next();
					b=Customer.check(pno);
					
				}while(b==0);
			}

        	
        	do
        	{
        		int res = Customer.menu();
        		order_insert[rear] = new orders(name,phno,res);
        		
        		rear++;
        		System.out.println("__________________________________________");
        		System.out.println("Woho ! Order placed successfully !");
				System.out.println("__________________________________________");

        		//Fast2SMS
				String msg = "You have new order to deliver !";
				s.sendSms(msg,"7709567104");
        		
        		
        		System.out.println("Do you want to continue to place order ! 1/0" );
        		op = sc.nextInt();

        	}while(op == 1);
        	
    	}
    	
    	
    }
}


class node
{
	String name;
	String phno;
	String cust_u_name;
	String c_pass;
	double price;
	String menu;
	String date;
	node next;

	
	node()
	{
		this.name = null;
		this.phno = null;
		this.cust_u_name = null;
		this.c_pass = null;
		this.price = 0;
		this.menu  = null;
		this.next=null;
		this.date = null;

	}

	node(String name,String phno,String cust_u_name,String c_pass,double price,String menu,String date)
	{
		this.name = name;
		this.phno = phno;
		this.cust_u_name = cust_u_name;
		this.c_pass = c_pass;
		this.price = price;
		this.menu  = menu;
		this.date = date;
	}
}

public class Customer extends E_mess
{

	String name;
	String phno;
	String cust_u_name;
	String c_pass;
	int price;
	String menu;
	String date;
	SMS s1 = new SMS();

	Scanner sc = new Scanner(System.in);
	int ch,op;
	node head=null;
	static int check(String pno)
	{
		if(pno.length()==10)
			return 1;
		else
			return 0;
	}
	
	void register()
	{
		System.out.println("Enter your name :");
		name=sc.next();
		
		System.out.println("Enter your phoneno :");
		phno=sc.next();
	    int a=check(phno);
	    if(a==0)
	    {
	    	int b;
		    do
		    {
		    	System.out.println("Invalid phone number !!!");
		    	System.out.println("Enter valid phoneno :");
				String pno=sc.next();
			    b=check(pno);
		    	
		    }while(b==0);
	    }

		System.out.println("Enter username : ");
		cust_u_name = sc.next();
		

		Console cnsl2 = System.console();

			if(cnsl2 == null)
			{
				System.out.println("No console Available !");
				return ;
			}


			char[] c = cnsl2.readPassword("Enter password : ");
			 c_pass = String.valueOf(c);
		
		

		int val = menu();
		if(val == 1)
		{
			System.out.println();
			System.out.println("You are registered for full thali !!");
			price = 4200;
			menu = "FUll Thali";

			//Fast2SMS
			String msg = "You are registered successfully .... Welcome to our E-mess";
			s1.sendSms(msg,phno);
			
		}
		else if(val==2)
		{
			System.out.println();
			System.out.println("You are registered for half thali !!");
			price = 2400;
			menu = "Half Thali";

			//Fast2SMS
			String msg = "You are registered successfully .... Welcome to our E-mess";
			s1.sendSms(msg,phno);
			
		}
		else if(val == 3)
		{
			System.out.println();
			System.out.println("You are registered for Rice plate !!");
			price = 2400;
			menu = "Rice Plate";

			//Fast2SMS
			String msg = "You are registered successfully .... Welcome to our E-mess";
			s1.sendSms(msg,phno);
			
		}
		else
		{
			System.out.println("__________________________________________________");
			System.out.println("Opps ! Invalid choice ...");
			System.out.println("___________________________________________________");
		}

		Date d = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy");
		date = ft.format(d);
       store();

	}

	static int menu()
	{
		Scanner sc=new Scanner(System.in);
		int choice = 0;
		System.out.println("___________________Menu We Serve__________________");
		
		System.out.println("1.Full thali (3 chapati,2 sabji,dal rice, sweet dish) - Rs.70\n2.Roti sabji(2 sabji,3 roti) - Rs.40\n3.Dal rice - Rs.40");
		System.out.println("___________________________________________________________________________________");
		System.out.println("Select Type of dish you prefer : ");
		choice = sc.nextInt();
		
		return choice;
	}

	void store()
	{
		node newNode = new node(name,phno,cust_u_name,c_pass,price,menu,date);
		node temp = head;
	
		if(head==null)
		{
			head = newNode;
		}
		else
		{
			while(temp.next!=null)
			{
				temp = temp.next;
				
			}
			temp.next = newNode;
		}
		
	}
	
	void login()
	{
		System.out.println("Enter username : ");
		String u_name = sc.next();
		
		Console cnsl3 = System.console();

			if(cnsl3 == null)
			{
				System.out.println("No console Available !");
				return ;
			}


			char[] c = cnsl3.readPassword("Enter password : ");
			String pass = String.valueOf(c);
			
		
		
		int cnt=0;
		node ptr = head;
		while(ptr!=null)
		{
			if(ptr.cust_u_name.equals(u_name) && ptr.c_pass.equals(pass))
			{
				cnt = 1;
				System.out.println("Login Successfull");
				
				System.out.println();
				
				do{
					System.out.println("________________Dashboard_______________");
					System.out.println("1.Display profile\n2.Payment Status\n3.Logout");
					System.out.println("Enter your choice : ");
					int ch = sc.nextInt();

					switch(ch)
					{
						case 1:
						    Display_profile(u_name,pass);
							break;
						case 2:
							Payment(u_name,pass);
							break;
						case 3:
							logout();
							break;
						default:
							break;

					}

					System.out.println("Do you want to continue with your login ...1/0");
					op = sc.nextInt();
				}while(op == 1);
				
				break;
			}
			ptr=ptr.next;
		}
		if(cnt == 0)
		{
			System.out.println("Invalid Credential !!!");
		}
	}
	
	void Display_profile(String u_name,String pass)
	{
		node ptr = head;
		
		while(ptr!=null)
		{
			if(ptr.cust_u_name.equals(u_name) && ptr.c_pass.equals(pass))
			{
				System.out.println("___________Profile Details__________");
				System.out.println();
				System.out.println("Customer User Name : " + ptr.cust_u_name);
				System.out.println("Customer Name : "  + ptr.name);
				System.out.println("Customer Phone no : " + phno);
				System.out.println("Date Of Joining : " +ptr.date);
				System.out.println("Thali : " +ptr.menu);
				break;
			}
			ptr=ptr.next;
		}

	}
	
    void logout()
	{
		System.out.println("You are logout Successfully !!");
		System.out.println();
		cust();
	}
	
    void Payment(String u_name,String pass)
	{
       	node ptr=head;
		
	   	while(ptr != null)
		{
			if(ptr.cust_u_name.equals(u_name) && ptr.c_pass.equals(pass))
			{
				System.out.println("________________Payment Details________________");
				System.out.println();
				System.out.println("Thali name : " + ptr.menu);
				System.out.println("Payment you need to pay : " + ptr.price);
				System.out.println("Date of joining  : "  + ptr.date);
				System.out.println("________________________________________________");
				break;
			}
			ptr=ptr.next;
		}
	}
    
    void show_menu()
    {
    	if(menu_generation_status==1)
    	{
    		Calendar calender = Calendar.getInstance();
    		int day = calender.get(Calendar.DAY_OF_WEEK);
    		int time = calender.get(Calendar.HOUR_OF_DAY);
    		String t;
             if(time>=12)
    		 {
    		 	t="PM";
    		 }
    		 else
    		 {
    			t="AM";
    		 }

    		for(int i=0;i<14;i++)
    		{
    			if(day==arrayMenus[i].day && t.equals(arrayMenus[i].time))
    			{
    				System.out.println("_________________Today's Menu_______________");
    				System.out.println("Roti :"+arrayMenus[i].roti);
    				System.out.println("Sabji : "+arrayMenus[i].curry1+" "+arrayMenus[i].curry2);
    				System.out.println("Sweet : "+arrayMenus[i].sweet);
    				System.out.println("Drink : "+arrayMenus[i].drink);
    				System.out.println("Rice plate : "+arrayMenus[i].dal_rice);

    				System.out.println("____________Stay Healthy with us____________");

    				break;

    			}
    		}	
    	}
    	else
    	{
			System.out.println("_______________________________________________");
    		System.out.println("Menu Not Generated By Admin Yet !!!!");
			System.out.println("_______________________________________________");
    	}
    	
    }

    void view_table_status()
	{
		Calendar calender = Calendar.getInstance();
    
		int time_hr = calender.get(Calendar.HOUR_OF_DAY);
		int time_min = calender.get(Calendar.MINUTE);
		
		//System.out.print(time_hr + ":");
		//System.out.println(time_min);
	
		String current_time1 = String.valueOf(time_hr) +  " : " + String.valueOf(time_min);
		
		if(stat == -1)
		{
			System.out.println("_________________________________________________");
			System.out.println("The status is not generated yet !!!");
			System.out.println("_________________________________________________");

		}
		else if(current_time1.equals(final_time))
		{
			for(int i=0;i<cus;i++)
			{
				status[i].f = 0;
			}

			dis();
		}
		else
		{
			dis();
		}
		System.out.println();


		
	}

	void dis()
	{
		System.out.println();
			System.out.println("Number of tables available : ");
			for(int i=0;i<20;i++)
			{
				if(status[i].f == 0)
				{
					System.out.println("Table number " + status[i].number );
				}
			}
	}
	
}
