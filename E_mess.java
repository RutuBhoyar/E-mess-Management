package e_mess_management;
import java.util.Scanner;

class Entry{

    Admin a = new Admin();
	
	Customer c = new Customer();
	E_mess e= new E_mess();
    void entry()
    {
        int ch,op;
		do
		{
			System.out.println("_______________________________________________________");
			System.out.println("\tWELCOME TO E-MESS MANAGEMENT SYSTEM");
			System.out.println("_______________________________________________________");
			System.out.println();
			System.out.println("1.Admin\n2.Customer\n3.Exit");
			System.out.println("_______________________________________________________");
			System.out.println("Select your panel : ");
			
			ch = sc.nextInt();
			
			switch(ch)
			{
			case 1:
				if(a.ex == 1)
				{
					System.out.println("See you after 12 hours !!!");
				}
				else
				{
					a.accept();
				}
				
				break;
			case 2:
		          e.cust();
				break;
			case 3:
                System.exit(0);
				break;
			default:
				System.out.println("Invalid choice ...");
				break;
			}
			System.out.println("Do you want to continue Home page ?0/1");
			op = sc.nextInt();
		}while(op == 1);
		
		System.out.println("Thank You !!!");
    }
	static Scanner sc = new Scanner(System.in);
	
	
}
public class E_mess
 {
	
	static orders[] order_insert = new orders[30];
	static int front,rear;
	static node_menu[] arrayMenus = new node_menu[14];
	static table1[] status = new table1[20];
	static String final_time;
	static int menu_generation_status=0;
	static String current_time;
	static int cus;


	
    public static void main(String args[])
	{
    
        Entry e = new Entry();
		e.entry();
		
	}

	void cust()
	{
		Scanner sc=new Scanner(System.in);
		Customer c = new Customer();
		Entry e = new Entry();
		int ch,op;
		orders obj = new orders();
		do
			{
				System.out.println("____________________Customer Panel___________________");
					System.out.println("1.Register for monthly mess \n2.Login to your profile \n3.Display menu\n4.Display table status\n5.Place order\n6.Exit");
					System.out.println("______________________________________________________________");
					System.out.println("Enter your choice : ");
					ch = sc.nextInt();
					
					
				switch(ch)
				{
				case 1:
					c.register();
					break;
				case 2:
				System.out.println();
					System.out.println("_____________Welcome to your profile___________");
					c.login();
					break;
				case 3:
					
					c.show_menu();
					break;
				case 4:
					c.view_table_status();
					break;
					
				case 5:
					obj.place_order();
					break;
                case 6:
                    System.out.println("_________________Thank you_______________");
                    e.entry();
                    break;
				default:
					break;
				}
					System.out.println();
					System.out.println("Do you want to continue with customer panel ? 1/0");
					op = sc.nextInt();
				}while(op == 1);
	}

}

