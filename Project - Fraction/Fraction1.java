
public class Fraction {
	
	private int numer,denom;
	
	public Fraction(int n,int d){//If there is no return type of void then the method is a constructor.
		numer = n;
		denom = d;
	}
	
	public Fraction(int n){//If the user enters only 1 value it creates a faction with a whole number
		numer = n;
		denom = 1;
	}
	
	public Fraction(){//If the user doesn't enter any numbers it sets the value to zero
		numer = 0;
		denom = 1;
	}
	
//{Getters	
	public int getNumer(){
		return numer;
	}

	public int getDenom(){
		return denom;
	}
//}

//{Setters
	public void setNumer(int n){
		numer = n;
	}
	
	public void setDenom(int d){
		if (d == 0){//Stops users from making errors
		System.out.println("Don't put a 0 in the denominator");
		System.exit(0);
		} else {
			denom = d;
		}
	}
//}	
	
	
	public String add(Fraction f){
		int numer1 = numer;
		int denom1 = denom;
		int numer2 = f.getNumer;
		int denom2 = f.getDenom;
		return (numer1 + " " + numer2 + " " + denom1 + " " + denom2);	
	
	}

}