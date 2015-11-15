package KennethAzodeh;

/**
 * Class to represent leagues.
 * 
 * @author Kenneth Azodeh.
 *
 */

public class Leagues {
	private String leagueName;
	private String topScorer;
	private String table;

	public Leagues(String name) {
		this.leagueName = leagueName;
	}

	/**
	 * @return The name of the league.
	 */
	public String getName() {
		return leagueName;
	}

	/**
	 * @param leagueName
	 *            Sets the name of the league.
	 */
	public void setName(String name) {
		this.leagueName = name;
	}

}
