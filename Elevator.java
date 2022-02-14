/*
clarification
use cases
classes
correctness

clarification:
1 elevator? yes
2 take people to different floors
3 buttons in the elevator:
open/close
floor numbers
emergency
4 weight limitation

use cases:
1. users create the request(push buttons)
2. controller process users requests
	a) requests from elevator
	b) requests from the floor button
3. check weight and send alert
4. available or not

classes:
1 Button
	Elevator Button
	floor Button
2 Request
	list of floors
	elevator
	open/close
	emergency
	go to some floor
3 Elevator
	buttons
	totalWeight
	currentLevel
	status(idle, up, down, unavailable)
	List<Stops> 
	(isDoorOpen)

4 Controller
	take the users requests
*/


public class Elevator{
	private static Elevator instance = null;
	List<Button> buttons;
	int weightLimit;
	int currentLevel;
	Status status;
	List<Boolean> stops;
	boolean isDoorOpen;

	private Elevator(){}
	public Elevator getInstance(){
		if (instance == null){
			instance = new Elevator();
		}
		return instance;
	}

	public void moveUp(int to_floor){

	}

	public void moveDown(int to_floor){

	}

	public void openDoor(){

	}

	public void closeDoor(){

	}

	public boolean isValidRequest(){

	}
}

public class ElevatorController implements Runnable{
	public ArrayDeque<Request> deque;

	public void run(){
		while (true) {
			processRequest();
		}
	}

	public void addRequest(){

	}

	public void processRequest(){
		Request req = getNextAvailableRequest();
		if (req == null) return;
		Elevator.getInstance()
	}
}

public class Button {
	public abstract void pressButton(){
		Request req = new Request();
		ElevatorController ec = new ElevatorController();
		ec.addRequest();
	}
}

enum ElevatorStatus{
	IDLE, UP, DOWN;
}

