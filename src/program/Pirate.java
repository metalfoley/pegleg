package program;

public class Pirate {

	private int ID;
	private String firstName;
	private String lastName;
	private String shipName;
	private String pirateName;
	
	public Pirate() {}
	
	public Pirate(String firstName, String lastName, String shipName, String pirateName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.shipName = shipName;
		this.pirateName = pirateName;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getPirateName() {
		return pirateName;
	}

	public void setPirateName(String pirateName) {
		this.pirateName = pirateName;
	}
	
}
