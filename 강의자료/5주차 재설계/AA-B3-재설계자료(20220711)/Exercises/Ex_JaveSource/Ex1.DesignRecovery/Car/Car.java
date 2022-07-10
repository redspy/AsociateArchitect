public class Car {
	public static final int LIMP_MODE_MAX_SPEED = 60;

	private int speed;
	private CarState curState;

	public Car() {
		curState = CarState.NORMAL;
	}

	public void stop() {
		setSpeed(0);
	}

	public void speedDown(int targetSpeed) {
		System.out.print("Speed: " + getSpeed());
		if (targetSpeed < getSpeed())
			setSpeed(targetSpeed);
		System.out.println(" ==> " + getSpeed());
	}

	public  void engineFailedDetected() {
		switch (curState) {
		case INITIAL :
			break;
		case NORMAL :
			System.out.print("Speed: " + getSpeed());
			setSpeed(LimpState.LIMP_MODE_MAX_SPEED);
			System.out.println(" ==> " + getSpeed());
			curState = CarState.LIMP;
			break;
		case LIMP : break;
		}
	}

	public  void speedUp(int targetSpeed) {
		switch (curState) {
		case INITIAL :
			break;
		case NORMAL :
			System.out.print("Speed: " + getSpeed());
			if (targetSpeed > getSpeed())
				setSpeed(targetSpeed);
			System.out.println(" ==> " + getSpeed());
			break;
		case LIMP :
			System.out.print("Speed: " + getSpeed());
			if (targetSpeed > getSpeed() && targetSpeed < LIMP_MODE_MAX_SPEED)
				setSpeed(targetSpeed);
			System.out.println(" ==> " + getSpeed());
			break;
		}
	}
	public void engineRepaired() {
		switch (curState) {
		case INITIAL :
		break;
		case NORMAL :
			System.out.println("Unexpeted Event");
			break;
		case LIMP :
			curState = CarState.NORMAL;
			break;
		}
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}

public enum CarState {
	INITIAL, NORMAL, LIMP
}
