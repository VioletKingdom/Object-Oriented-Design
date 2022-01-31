public class ParkingLot{

	private final Level[] levels;

	public ParkingLot(int numLevels, int numSpotsPerLvel){
		levels = new Level[numLevels];
		for (int i = 0; i < numLevels; i++){
			levels[i] = new Level(numSpotsPerLvel);
		}
	}

	public boolean hasSpot(Vehicle v){
		for (Level l: levels){
			if (l.hasSpot(v)){
				return true;
			}
		}
		return false;
	}

	public boolean parkVehicle(Vehicle v){
		for (Level l : levels){
			if (l.park(v)){
				return true;
			}
		}
		return false;
	}

	public boolean driveawayVehicle(Vehicle v){
		for (Level l : levels){
			if (l.leave(v)){
				return true;
			}
		}
		return false;
	}
}

public class Level{
	private final List<ParkingSpot> spots;

	public Level(int numOfSpots){
		spots = new ArrayList<ParkingSpots>(numOfSpots);
		int i = 0;
		for (; i < numOfSpots/3; i++){
			spots.add(new ParkingSpot(VehicleSize.Compact));
		}
		for (; i < numOfSpots*2/3; i++){
			spots.add(new ParkingSpot(VehicleSize.Large));
		}
		for (; i < numOfSpots; i++){
			spots.add(new ParkingSpot(VehicleSize.Electrical));
		}
		spots = Collections.unmodifiableList(spots);
	}

	boolean hasSpot(Vehicle v){
		for(ParkingSpot s : spots){
			if(s.canFit(v)){
				return true;
			}
		}
		return false;
	}

	boolean park(Vehicle v){
		for (ParkingSpot s : spots){
			if (s.canFit(v)){
				s.park(v);
				return true;
			}
		}
		return false;
	}

	boolean leave(Vehicle v){
		for (ParkingSpot s : spots){
			if (s.getCurrentVehicle() == v){
				s.leave();
				return true;
			}
		}
		return false;
	}
}

public enum VehicleSize{
	Compact(1), Large(2), Electrical(3);
}


public class ParkingSpot{
	private final VehicleSize size;
	private Vehicle cur_v;
	String location;

	boolean canFit(Vehicle v){
		return cur_v == null && size >= v.getSize();
	}

	void park(Vehicle v){
		cur_v = v;
	}

	void leave(Vehicle v){
		cur_v = null;
	}

	Vehicle getCurrentVehicle(){
		return cur_v;
	}
}


public abstract class Vehicle{
	private VehicleSize size; 
	private String plate_number;

	public abstract VehicleSize getSize();
}

public class Car extends Vehicle{
	@Overide
	public VehicleSize getSize(){
		return VehicleSize.Compact;
	}
}

public class Truck extends Vehicle{
	@Overide
	public VehicleSize getSize(){
		return VehicleSize.Large;
	}
}

public class Electrical extends Vehicle{
	@Overide
	public VehicleSize getSize(){
		return VehicleSize.Electrical;
	}
}