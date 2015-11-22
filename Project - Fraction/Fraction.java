/* Fraction.java  A class (data type) definition file
   This file just defines what a Fraction is
   This file is NOT a program
   ** data members are PRIVATE
   ** method members are PUBLIC
*/
public class Fraction
{
	private int numer;
	private int denom;

	// ACCESSORS
	public int getNumer()
	{
		return numer;
	}
	public int getDenom()
	{
		return denom;
	}
	public String toString()
	{
		return numer + "/" + denom;
	}

	// MUTATORS
	public void setNumer( int n )
	{
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

	// DEFAULT CONSTRUCTOR - no args passed in
	public Fraction(  )
	{
		this( 0, 1 ); // "this" means call a fellow constructor
	}

	// 1 arg CONSTRUCTOR - 1 arg passed in
	// assume user wants whole number
	public Fraction( int n )
	{
		this( n, 1 ); // "this" means call a fellow constructor

	}

	// FULL CONSTRUCTOR - an arg for each class data member
	public Fraction(int n,int d){	
		setNumer(n);
		setDenom(d);
		this.reduce();
	}

	// COPY CONSTRUCTOR - takes ref to some already initialized Fraction object
	public Fraction( Fraction other )
	{
		this( other.numer, other.denom ); // call my full C'Tor with other Fraction's data
	}
	

	
	public Fraction add(Fraction f){
		int newNumer = ((f.numer * denom) + (numer * f.denom));
		int newDenom = (denom * f.denom);
		Fraction addFrac = new Fraction(newNumer,newDenom);
		return addFrac;
	}
	
	public Fraction subtract(Fraction f){
		int newNumer = ((numer * f.denom)-(f.numer * denom));
		int newDenom = (denom * f.denom);
		Fraction addFrac = new Fraction(newNumer,newDenom);
		return addFrac;
	}	
	
	public Fraction multiply(Fraction f){
		int newNumer = (numer * f.numer);
		int newDenom = (denom * f.denom);
		Fraction addFrac = new Fraction(newNumer,newDenom);
		return addFrac;
	}	

	public Fraction divide(Fraction f){
	
		int newNumer = (numer * f.denom);
		int newDenom = (denom * f.numer);
		Fraction addFrac = new Fraction(newNumer,newDenom);
		return addFrac;
	}	
	
	public Fraction reciprocal(){
	
		int newNumer = denom;
		int newDenom = numer;
		Fraction addFrac = new Fraction(newNumer,newDenom);
		return addFrac;
	}		
	
	
	private void reduce(){
		for (int i = 2; i<(numer)&& i<(denom); i++){
			if(numer%i==0 && denom%i==0){
				numer = numer/i;
				denom = denom/i;
				i = 2;
			}
		}
	}	
	
}
