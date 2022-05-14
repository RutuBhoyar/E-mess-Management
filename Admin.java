package e_mess_management;

import java.io.Console;
import java.util.Calendar;
import java.util.Scanner;

public class Admin extends E_mess
{

	Scanner sc = new Scanner(System.in); 
	int ch,op,cnt=0,ex;
	table1 t = new table1();
	orders obj = new orders();
	SMS s = new SMS();

	void accept()
	{
		System.out.println();
		for(int i=0;i<3;i++)
		{
			
			System.out.println("Enter Username : ");
			String ad_u_name = sc.next();
		
			Console cnsl = System.console();

			if(cnsl == null)
			{
				System.out.println("No console Available !");
				return ;
			}


			char[] c = cnsl.readPassword("Enter password : ");
			String ad_pass = String.valueOf(c);

			
			if(ad_u_name.equals("admin") && ad_pass.equals("admin@123"))
			{
				ex = 0;
				cnt =1;
				System.out.println();
				System.out.println("______________Welcome to Admin panel______________");
				
				do
				{
					System.out.println("1.Generate Menu\n2.Update table status\n3.Accept the order\n4.Exit");
					System.out.println("____________________________________________________");
					System.out.println("Enter your choice : ");
					ch = sc.nextInt();
					
					
				switch(ch)
				{
				case 1:
					
					generate_menu();
					break;
				case 2:
					System.out.println("Enter the number of customers arrived initially : ");
					cus = sc.nextInt();
					t.update_table(cus);
					break;
				case 3:
					accept_order();
					break;
				case 4:
					Entry e = new Entry();
                    System.out.println("Thank you !");
                    e.entry();
					break;
				default:
					System.out.println("Invalid choice !");
					break;
				}
					System.out.println("Do you want to continue with admin panel ...(0/1)");
					op = sc.nextInt();
				}while(op == 1);
			
				break;
			}
			else
			{
				ex = 1;
				System.out.println("_____________________________________________");
				System.out.println("\tInvalid Credentials !!! ");
				System.out.println("_____________________________________________");
			}
		
		}
		
		if(cnt == 0)
		{
			System.out.println("Your panel locked for 12 hour");
		}
		 
		
	}
	
	void generate_menu()
	{
		
		
		
		for(int i=0;i<14;i++)
		{
			
			arrayMenus[i] = new node_menu();
		}
		arrayMenus[0] = new node_menu(1,"AM","butter roti / chapati","chana dal","Bhendi Sabji","gulabjamun","buttermilk","dal_rice");
		arrayMenus[1] = new node_menu(2,"AM","butter roti / chapati","Jeera Aloo","Rajma Sabji","Sonpapadi","Tak","dal_rice");
		arrayMenus[2] = new node_menu(3,"AM","butter roti / chapati","patta gobi","Masoor Sabji","Strawberry rabdi","Tak","dal_rice");
		arrayMenus[3] = new node_menu(4,"AM","butter roti / chapati","Dudhi Bhopla","Chana dal","Basundi","buttermilk","dal_rice");
		arrayMenus[4] = new node_menu(5,"AM","butter roti / chapati","Mix-veg","Moong curry","Jilebi","buttermilk","dal_rice");
		arrayMenus[5] = new node_menu(6,"AM","butter roti / chapati","Bengan Bharta","Punjabi Chola","Kheer","buttermilk","dal_rice");
		arrayMenus[6] = new node_menu(7,"AM","butter roti / chapati","Soyabean Bhurji","Paneer Sabji","Fruit Custard","buttermilk","dal_rice");
		arrayMenus[7] = new node_menu(1,"PM","butter roti / chapati","Mix-veg","Moong curry","Jilebi","buttermilk","dal_rice");
		arrayMenus[8] = new node_menu(2,"PM","butter roti / chapati","Dudhi Bhopla","Chana dal","Basundi","buttermilk","dal_rice");
		arrayMenus[9] = new node_menu(3,"PM","butter roti / chapati","chana dal","Bhendi Sabji","gulabjamun","buttermilk","dal_rice");
		arrayMenus[10] = new node_menu(4,"PM","butter roti / chapati","Soyabean Bhurji","Paneer Sabji","Fruit Custard","buttermilk","dal_rice");
		arrayMenus[11] = new node_menu(5,"PM","butter roti / chapati","patta gobi","Masoor Sabji","Strawberry rabdi","Tak","dal_rice");
		arrayMenus[12]=new node_menu(6,"PM","Pav","Bhaji","Matki usal","Custard","Dahi","Pulav");
		arrayMenus[13] = new node_menu(7,"PM","butter roti / chapati","Bengan Bharta","Punjabi Chola","Kheer","buttermilk","dal_rice");
		
		menu_generation_status=1;
			
		System.out.println("_________________________________________________");
		System.out.println("\tMenu Generated Sucessfully !!");
		System.out.println("_________________________________________________");
	
	}

	void accept_order()
	{
		int op;

		do{

			System.out.println("______________________Options____________________");
			System.out.println("1.View the order to deliver\n2.View list of orders");
			System.out.println("___________________________________________________");
			System.out.println("Enter your choice : ");
			int ch = sc.nextInt();

			switch(ch)
			{
				case 1:
					view_order();
					break;
				case 2:
					view_list();
					break;
				case 3:
					System.exit(0);
					break;
				default:
					System.out.println("_____________________________________________");
					System.out.println("Invalid option !");
					System.out.println("_____________________________________________");
					break;
			}

			System.out.println("Do you want to continue to work in accept order ...(0/1)");
			op = sc.nextInt();
		}while(op == 1);

	}

		void view_order()
		{
				orders a = Customer.order_insert[front];
				if(obj.isEmpty() == true)
				{
					System.out.println("_____________________________________________");
					System.out.println("No orders to deliver !");
					System.out.println("_____________________________________________");
				}
				else{

					

				System.out.println("Details of Order to be delivered : ");
				System.out.println("Name : " + a.name);
				System.out.println("phone no. : " +a.phno);
				
				if(a.ch == 1)
				{
					System.out.println("Ordered  Full Thali ...");
				}
				else if(a.ch == 2)
				{
					System.out.println("Ordered Half thali...");
				}
				else if(a.ch == 3)
				{
					System.out.println("Ordered Rice plate...");
				}

				System.out.println("____________________________________________________");
				System.out.println("\tOrder successfully Delivered to the customer !");
				System.out.println("____________________________________________________");
				front++;

				//Fast2SMS
				String msg = "Your order is Ready ! Thank you for ordering ...";
				s.sendSms(msg,a.phno);
				

		}

	}

	void view_list()
	{
		int j=0;
		
		if(obj.isEmpty() == true)
		{
					System.out.println("___________________________________________________");
					System.out.println("No orders to deliver !");
					System.out.println("___________________________________________________");
		}
				else
				{
					System.out.println("________________Remaining orders_______________");
					for(int i = front;i<rear;i++)
					{
							orders b= Customer.order_insert[i];
							j++;
							System.out.println("________________Order " + j + "_______________");
							System.out.println("Name : " + b.name);
							System.out.println("phone no. : " +b.phno);
							
							if(b.ch == 1)
							{
								System.out.println("Ordered  Full Thali ...");
							}
							else if(b.ch == 2)
							{
								System.out.println("Ordered Half thali...");
							}
							else if(b.ch == 3)
							{
								System.out.println("Ordered Rice plate...");
							}

							System.out.println();



			        }

		        }	
	}
			
}

class table1 extends E_mess
{
    int number;
    int f;
    
    
    void set()
    {
        for(int i=0;i < 20;i++)
        {
            status[i].number = i+1;
            status[i].f = 0;
        }
    }
    
    table1()
    {
        this.number = 0;
        this.f = 0;
    }

    void update_table(int cus)
    {
	stat = 0;
    for(int i=0;i<20;i++)
        {
            status[i] = new table1();
        }
    
    
    set();

	for(int i=0;i<cus;i++)
	{
		status[i].f = 1;
	}
    Calendar calender = Calendar.getInstance();
    
    int time_hr = calender.get(Calendar.HOUR_OF_DAY);
    int time_min = calender.get(Calendar.MINUTE);

    current_time = String.valueOf(time_hr) + String.valueOf(time_min);
    
    int final_hr = 0;
    int final_min = 0;
    int res = time_min + 30;
    if(res>=60)
    {
        int rem = res%60;
        int hr = res / 60;

        final_hr = time_hr+hr;
        final_min = rem;
    }
	else{
		final_hr = time_hr;
		final_min = res;
	}
    
    
    final_time = String.valueOf(final_hr) + " : " + String.valueOf(final_min);
	System.out.println("___________________________________________________");
	System.out.println("\tStatus updated successfully !!!");
	System.out.println("___________________________________________________");

}
	
}
