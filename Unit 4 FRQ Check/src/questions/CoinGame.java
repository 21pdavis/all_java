package questions;

public class CoinGame

{

	private int startingCoins; // starting number of coins

	private int maxRounds; // maximum number of rounds played

	public CoinGame(int s, int r)

	{

		startingCoins = s;

		maxRounds = r;

	}

	/**
	 * Returns the number of coins (1, 2, or 3) that player 1 will spend.
	 * 
	 */

	public int getPlayer1Move()
	{

		return 0;

	}

	/**
	 * Returns the number of coins (1, 2, or 3) that player 2 will spend, as
	 * described in part (a).
	 * 
	 */

	public int getPlayer2Move(int round) {
		int result = 0;
		if (round % 3 == 0)
			result = 3;
		else if (round % 3 != 0 && round % 2 == 0)
			result = 2;
		else if (round % 3 != 0 && round % 2 != 0)
			result = 1;
		return result;
	}

	/**
	 * Plays a simulated game between two players, as described in part (b).
	 * 
	 */

	public void playGame() {
		int p1Coins = startingCoins, p2Coins = startingCoins;
		for (int i = 0; i < maxRounds && p1Coins >= 3 && p2Coins >= 3; i++) {
			if(getPlayer1Move() == getPlayer2Move(i)) {
				p2Coins++;
			}
			else if(getPlayer1Move() - getPlayer2Move(i) == 1 || getPlayer2Move(i) - getPlayer1Move() == 1) {
				p2Coins++;
			}
			else if(getPlayer1Move() - getPlayer2Move(i) == 2 || getPlayer2Move(i) - getPlayer1Move() == 2) {
				p1Coins++;
			}
		}
		if(p1Coins == p2Coins)
			System.out.println("tie game");
		else if(p1Coins < p2Coins)
			System.out.println("player 2 wins");
		else if(p1Coins > p2Coins)
			System.out.println("player 1 wins");
	}

}