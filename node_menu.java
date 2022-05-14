package e_mess_management;


class node_menu
{
	int day;
	String time;
	String roti;
	String curry1;
	String curry2;
	String sweet;
	String drink;
	String dal_rice;
	

	node_menu()
	{
		day = 0;
		time=null;
		roti = null;
		curry1 = null;
		curry2 = null;
		sweet = null;
		drink = null;
		dal_rice = null;
	}

	node_menu(int day,String time,String roti,String curry1,String curry2,String sweet,String drink,String dal_rice)
	{
		this.day = day;
		this.time=time;
		this.roti = roti;
		this.curry1 = curry1;
		this.curry2 = curry2;
		this.sweet = sweet;
		this.drink = drink;
		this.dal_rice = dal_rice;
	}
}