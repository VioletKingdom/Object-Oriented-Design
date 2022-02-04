/*
design a locker or a bunch of lockers?
one locker, or start from one

the size of the locker, three sizes, small, medium, large
only the locker is same or large than package, the package can be put into the locker
locker has two conditions: available or in use

if the package was taken out, the locker is in reset? or available?


use cases:
the deliverman check if the locker is large enough, and then put the package into the locker
the customer put in tthe code, and take out the package



*/

public class AmazonLocker{

}

public interface Checker {
	// true: fit, false: not fit
	public boolean isSuitable(Locker locker, Pkg pkg){

	}
}

public class SizeChecker implements Checker{
	public boolean isSuitable(Locker locker, Pkg pkg){
		return locker.getSize() >= pkg.getSize();
	}
}

public class WeightChecker implements Checker{
	public boolean isSuitable(Locker locker, Pkg pkg){
		return locker.getWeight() >= pkg.getWeight(); 
	}
}

enum Size {
	SMALL(0), MEDIUM(1), LARGE(2);
	private final int size;
	public Size(int size){
		this.size = size;
	}
	public int getSize() {
		return size;
	}

	public boolean isOversize(Locker locker, Pkg pkg){

	}
}

public class Pkg{
	int64 pkg_id;
	Size size;
	// String code;
}


public class Locker{
	int64 locker_id;
	String code;
	Size size;
	Weight weight;
	boolean isEmpty;
}


public class Controller{
	private static class LockerErrorException extends Exception{
		public LockerErrorException(String msg){
			super(msg);
		}
	}
	List<Checker> checkers;
	List<Locker> emptyLockers;
	List<Locker> occupiedLockers;

	public Controller(List<Lockers> lockers){
		this.emptyLockers = lockers;
		this.occupiedLockers = new ArrayList<Locker>();
		this.checkers = new ArrayList<Checker>();
		checkers.add(new SizeChecker());
		checkers.add(new WeightChecker());
	}

	private Locker findSuitableLocker(Pkg pkg){
		for (Locker aL : aLockers){
			boolean flag = true;
			for (Checker ck : checkers){
				if (flag && ck.isSuitable(aL, pkg)){
					continue;
				} else {
					flag = false;
				}
			}
			if (flag) {
				return aL;
			}
		}
	}

	public Locker putPackage(Pkg pkg){
		/*
		1 iterate available lockers and pick the suitable locker
		2 set the params in the corresponding locker with pkg info
		3 generate pick out code
		4 move cuurent locker into empty lockers
		5 memorize the code to the locker
		6 return necessary pointers
		*/
	}

	public void getPackage(String code) throws Exception{
		/*
		1 look up code from hashmap
		2 if not found the code, throw code cannot found exception
		3 if found
		4 set the locker status to empty
		5 release the locker from occupied to empty

		*/
		Locker findLocker = hm.get(code);
		if (findLocker == null){
			throw new LockerErrorException("code does not exist");
		}
	}
}

