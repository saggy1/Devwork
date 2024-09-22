 Public class abstract Account throws Exception{

abstract withdraw(float balance);

}
class SavingsAccount extends Account throws Exception{
	@override
	void withdraw(float balance){

	}
}
class CurrentAccount extends Account throws Exception{
	@override
	void withdraw(float balance){
		System.out.println("withdrawal allowed");
	}
}
class FixedAccount extends Account throws Exception{
	@override
	void withdraw(float balance){
		System.out.println("withdrawal not allowed");
	}
}

public class Polymorphism throws Exception{
	public static void main(String [] args){
		var acctList =new Account[3];
		acctList[0]= new SavingsAccount();
		acctList[1]=new CurrentAccount();
		acctList[2]=new FixedAccount();
		//~# polymorphism
		for(account :acctList){

			account.withdraw(100);
		}

	}
}