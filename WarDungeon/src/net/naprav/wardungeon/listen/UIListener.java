package net.naprav.wardungeon.listen;

import net.naprav.wardungeon.WarDungeon;
import net.naprav.wardungeon.level.ClassicLevel;
import net.naprav.wardungeon.player.PlayerClass;
import net.naprav.wardungeon.sound.Sound;

public class UIListener {

	private Mouser mouse;

	public UIListener(Mouser mouser) {
		mouse = mouser;
	}

	/**
	 * The method for listening for mouse clicks in the main menu.
	 */
	public final void listenInMenu() {
		int xClick = mouse.xClick;
		int yClick = mouse.yClick;

		if ((xClick > 66 && xClick < 214) && (yClick > 300 && yClick < 374)) {
			// Goes to selection screen.
			Sound.pushButtonSound();
			mouse.resetCoords();
			WarDungeon.setState('S');
			return;
		} else if ((xClick > 231 && xClick < 380) && (yClick > 450 && yClick < 524)) {
			// Goes to options.
			Sound.pushButtonSound();
			mouse.resetCoords();
			WarDungeon.setState('O');
			return;
		} else if ((xClick > 550 && xClick < 699) && (yClick > 450 && yClick < 523)) {
			// Goes to credits.
			Sound.pushButtonSound();
			mouse.resetCoords();
			WarDungeon.setState('C');
			return;
		} else if ((xClick > 716 && xClick < 865) && (yClick > 300 && yClick < 373)) {
			// Exits game.
			Sound.pushButtonSound();
			mouse.resetCoords();
			WarDungeon.setState('Q');
		}
	}

	public final void listenInClassSelection() {
		int xClick = mouse.xClick;
		int yClick = mouse.yClick;

		int player_select = 0;

		if ((xClick > 402 && xClick < 536) && (yClick > 48 && yClick < 311)) {
			// Enters game with knight.
			player_select = PlayerClass.KNIGHT;
			WarDungeon.setPlayer(player_select);
			Sound.pushButtonSound();
			mouse.resetCoords();
			return;
		}
		if ((xClick > 252 && xClick < 381) && (yClick > 41 && yClick < 303)) {
			// Enters game with wizard.
			player_select = PlayerClass.WIZARD;
			WarDungeon.setPlayer(player_select);
			Sound.pushButtonSound();
			mouse.resetCoords();
			return;
		}
		if ((xClick > 545 && xClick < 674) && (yClick > 52 && yClick < 307)) {
			// Enters game with archer.
			player_select = PlayerClass.ARCHER;
			WarDungeon.setPlayer(player_select);
			Sound.pushButtonSound();
			mouse.resetCoords();
			return;
		}
		if ((xClick > 66 && xClick < 215) && (yClick > 450 && yClick < 524)) {
			// Returns to the main menu.
			Sound.pushButtonSound();
			mouse.resetCoords();
			WarDungeon.setState('M');
			return;
		}
		if ((xClick > 716 && xClick < 865) && (yClick > 451 && yClick < 523)) {
			// Continues into the level selection screen.
			Sound.pushButtonSound();
			mouse.resetCoords();
			WarDungeon.setState('L');
			return;
		}
	}

	public final void listenInLevelSelection() {
		int xClick = mouse.xClick;
		int yClick = mouse.yClick;

		if ((xClick > 402 && xClick < 536) && (yClick > 48 && yClick < 311)) {
			// Enters game with classic level.
			Sound.pushButtonSound();
			mouse.resetCoords();
			WarDungeon.setLevel(ClassicLevel.FLOOR_1);
			return;
		}
		if ((xClick > 252 && xClick < 381) && (yClick > 41 && yClick < 303)) {
			// Enters game with second level.
			Sound.pushButtonSound();
			mouse.resetCoords();
			WarDungeon.setLevel('2');
			return;
		}
		if ((xClick > 545 && xClick < 674) && (yClick > 52 && yClick < 307)) {
			// Enters game with third level.
			Sound.pushButtonSound();
			mouse.resetCoords();
			WarDungeon.setLevel('3');
			return;
		}
		if ((xClick > 545 && xClick < 674) && (yClick > 52 && yClick < 307)) {
			// Enters game with fourth level.
			Sound.pushButtonSound();
			mouse.resetCoords();
			WarDungeon.setLevel('4');
			return;
		}
		if ((xClick > 545 && xClick < 674) && (yClick > 52 && yClick < 307)) {
			// Enters game with fifth level.
			Sound.pushButtonSound();
			mouse.resetCoords();
			WarDungeon.setLevel('5');
			return;
		}

		if ((xClick > 66 && xClick < 215) && (yClick > 450 && yClick < 522)) {
			// Enters returns to the previous menu.
			Sound.pushButtonSound();
			mouse.resetCoords();
			WarDungeon.setState('S');
			return;
		}
		if ((xClick > 717 && xClick < 863) && (yClick > 450 && yClick < 524)) {
			// Enters game with selected level.
			Sound.pushButtonSound();
			mouse.resetCoords();
			WarDungeon.setState('G');
			return;
		}
	}

	/**
	 * The method for listening to mouse clicks in the credits.
	 */
	public final void listenInCredits() {
		int xClick = mouse.xClick;
		int yClick = mouse.yClick;

		if ((xClick > 391 && xClick < 539) && (yClick > 450 && yClick < 523)) {
			// Returns to menu.
			Sound.pushButtonSound();
			mouse.resetCoords();
			WarDungeon.setState('M');
			return;
		}
	}

	public final void listenInGameMenu() {
		int xClick = mouse.xClick;
		int yClick = mouse.yClick;

		if ((xClick > 23 && xClick < 211) && (yClick > 470 && yClick < 548)) {
			// Applies settings and returns to menu.
			Sound.pushButtonSound();
			applySettings();
			mouse.resetCoords();
			WarDungeon.setState('M');
			return;
		} else if ((xClick > 715 && xClick < 905) && (yClick > 470 && yClick < 548)) {
			// Returns to menu.
			Sound.pushButtonSound();
			mouse.resetCoords();
			WarDungeon.setState('M');
			return;
		}
	}

	/**
	 * The method for listening for mouse clicks in options.
	 */
	public final void listenInOptions() {
		int xClick = mouse.xClick;
		int yClick = mouse.yClick;

		if ((xClick > 23 && xClick < 211) && (yClick > 470 && yClick < 548)) {
			// Applies settings and returns to menu.
			Sound.pushButtonSound();
			applySettings();
			mouse.resetCoords();
			WarDungeon.setState('M');
			return;
		} else if ((xClick > 715 && xClick < 905) && (yClick > 470 && yClick < 548)) {
			// Returns to menu.
			Sound.pushButtonSound();
			mouse.resetCoords();
			WarDungeon.setState('M');
			return;
		}
	}

	/**
	 * The method for applying user settings to game!
	 */
	public void applySettings() {
	}
}
