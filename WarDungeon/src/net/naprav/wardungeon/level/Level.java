package net.naprav.wardungeon.level;

import net.naprav.wardungeon.WarDungeon;
import net.naprav.wardungeon.block.AbyssBlock;
import net.naprav.wardungeon.block.Block;
import net.naprav.wardungeon.block.CobbleStoneBlock;
import net.naprav.wardungeon.block.IceBrickBlock;
import net.naprav.wardungeon.block.LavaBlock;
import net.naprav.wardungeon.block.MobSpawnBlock;
import net.naprav.wardungeon.block.MossBrickBlock;
import net.naprav.wardungeon.block.StoneBlock;
import net.naprav.wardungeon.block.StoneBrickBlock;
import net.naprav.wardungeon.block.item.HealthPodBlock;
import net.naprav.wardungeon.block.item.PowerUpBlock;
import net.naprav.wardungeon.block.wall.Wall;
import net.naprav.wardungeon.graphics.Display;

public class Level {

	/* Two integers for the width and height of the level and a blocks[] array to store all the block data. */
	protected int width, height;
	protected int xSpawn, ySpawn;

	protected int[] blocks;

	public static int FLOOR_1 = 1;
	public static int FLOOR_2 = 2;
	public static int FLOOR_3 = 3;
	public static int FLOOR_4 = 4;
	public static int FLOOR_5 = 5;
	public static int FLOOR_6 = 6;
	public static int FLOOR_7 = 7;

	public static int FLOOR_BOSS = 8;

	private boolean setWalls = false;

	/**
	 * The default constructor for all levels. It's important because it's needed to access the level's location.
	 * 
	 * @param pathway
	 */
	public Level(String pathway, int width, int height, int xSpawn, int ySpawn) {
		this.width = width;
		this.height = height;

		this.xSpawn = (int) (xSpawn * 31.5);
		this.ySpawn = (int) (ySpawn * 31);

		blocks = new int[width * height];

		loadLevel(pathway);
	}

	/**
	 * Generation of a random level. (EXPERIMENTAL!)
	 * 
	 * @param width
	 * @param height
	 */
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		blocks = new int[width * height];

		generateLevel();
	}

	/**
	 * Loads the level from a file.
	 * 
	 * @param pathway
	 */
	protected void loadLevel(String pathway) {
	}

	/**
	 * Generates the level, (free open-roam for future!)
	 * 
	 * @param width
	 * @param height
	 */
	protected void generateLevel() {
	}

	/**
	 * Setting the time of the level can affect how well and how fun it is. This method does that.
	 */
	protected void setTime() {
	}

	/**
	 * Responsible for updating the logic behind the level. Any things that occur are done here.
	 */
	protected void tick() {
	}

	public int getXSpawn() {
		return xSpawn;
	}

	public int getYSpawn() {
		return ySpawn;
	}

	/**
	 * Responsible for rendering the level to Display.java, the class in charge of all rendering.
	 * 
	 * @param xOffset
	 * @param yOffset
	 * @param display
	 */
	public void render(int xOffset, int yOffset, Display display) {
		display.setBlockOffset(xOffset, yOffset);
		final int block_size = 32;

		int x0 = xOffset / block_size;
		int x1 = (xOffset + display.WIDTH + block_size) / block_size;
		int y0 = yOffset / block_size;
		int y1 = (yOffset + display.HEIGHT + block_size) / block_size;

		// int centerX = x1, centerY = y1;
		int centerX = (int) (xOffset / 32 + 7.5);
		int centerY = (int) (yOffset / 32 + 5.5);

		// Integers for the blocks above, below and to the sides of the player. (Handy for collision!)
		int leftX = centerX - 1, leftY = centerY;
		int rightX = centerX + 1, rightY = centerY;
		int topX = centerX, topY = centerY - 1;
		int bottomX = centerX, bottomY = centerY + 1;

		for (int x = x0; x < x1; x++) {
			for (int y = y0; y < y1; y++) {
				getBlock(x, y).render(x, y, display);

				if (haveWallsBeenSet() == false) {
					setLevelWalls();
					return;
				}

				if (getBlock(centerX, centerY).doesKill()) WarDungeon.getPlayer().die();
				if (getBlock(centerX, centerY) == HealthPodBlock.block) {
					setBlock(centerX, centerY, 0xFF4C4C4C);
				}
			}
		}
	}

	/**
	 * Method for returning the block at a certain coordinate.
	 * 
	 * @param xPos
	 * @param yPos
	 * @return
	 */
	public Block getBlock(int xPos, int yPos) {
		if (xPos < 0 || xPos >= width || yPos < 0 || yPos >= height) return AbyssBlock.block;

		/* Checks for standard blocks. */
		if (blocks[xPos + (yPos * width)] == 0xFF7F7F7F) return StoneBlock.block;
		if (blocks[xPos + (yPos * width)] == 0xFF4C4C4C) return StoneBrickBlock.block;
		if (blocks[xPos + (yPos * width)] == 0xFFFF6543) return LavaBlock.block;
		if (blocks[xPos + (yPos * width)] == 0xFFA0A0A0) return CobbleStoneBlock.block;
		if (blocks[xPos + (yPos * width)] == 0xFF317232) return MossBrickBlock.block;
		if (blocks[xPos + (yPos * width)] == 0xFFCEF0FF) return IceBrickBlock.block;

		/* Special blocks. */
		if (blocks[xPos + (yPos * width)] == 0xFFFFFFFF) return MobSpawnBlock.block;
		if (blocks[xPos + (yPos * width)] == 0xFFAC0000) return HealthPodBlock.block;
		if (blocks[xPos + (yPos & width)] == 0xFFFFFF00) return PowerUpBlock.block;

		/* Checks for walls. */
		if (blocks[xPos + (yPos * width)] == 0xFFFF00FF) return Wall.bottomFlat;
		if (blocks[xPos + (yPos * width)] == 0xFFFA00FA) return Wall.rightFlat;
		if (blocks[xPos + (yPos * width)] == 0xFFF500F5) return Wall.topFlat;
		if (blocks[xPos + (yPos * width)] == 0xFFF000F0) return Wall.leftFlat;

		if (blocks[xPos + (yPos * width)] == 0xFFEB00EB) return Wall.bottomRightOutCorner;
		if (blocks[xPos + (yPos * width)] == 0xFFE600E6) return Wall.topRightOutCorner;
		if (blocks[xPos + (yPos * width)] == 0xFFE000E0) return Wall.topLeftOutCorner;
		if (blocks[xPos + (yPos * width)] == 0xFFDB00DB) return Wall.bottomLeftOutCorner;

		if (blocks[xPos + (yPos * width)] == 0xFFD600AB) return Wall.bottomLeftInCorner;
		if (blocks[xPos + (yPos * width)] == 0xFFD100A7) return Wall.topLeftInCorner;
		if (blocks[xPos + (yPos * width)] == 0xFFCC00A3) return Wall.bottomRightInCorner;
		if (blocks[xPos + (yPos * width)] == 0xFFC7009F) return Wall.topRightInCorner;

		return AbyssBlock.block;
	}

	public void setBlock(int xPos, int yPos, int block_color) {
		blocks[xPos + (yPos * width)] = block_color;
	}

	public void setLevelWalls() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (blocks[x + (y * width)] == 0xFFAA00AA) {
					if (getBlock(x + 1, y - 1) == AbyssBlock.block && getBlock(x - 1, y + 1) != AbyssBlock.block) {
						// Bottom corner left sticking out.
						setBlock(x, y, 0xFFDB00DB);
					} else if (getBlock(x - 1, y - 1) == AbyssBlock.block && getBlock(x + 1, y + 1) != AbyssBlock.block) {
						// Bottom corner right sticking out.
						setBlock(x, y, 0xFFEB00EB);
					} else if (getBlock(x - 1, y + 1) == AbyssBlock.block && getBlock(x + 1, y - 1) != AbyssBlock.block) {
						// Top corner right sticking out.
						setBlock(x, y, 0xFFE600E6);
					} else if (getBlock(x + 1, y + 1) == AbyssBlock.block && getBlock(x - 1, y - 1) != AbyssBlock.block) {
						// Top corner left sticking out.
						setBlock(x, y, 0xFFE000E0);
					}
				}
			}
		}

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (blocks[x + (y * width)] == 0xFFFF00FF) {
					if (getBlock(x, y - 1) != AbyssBlock.block && getBlock(x, y - 1) != Wall.leftFlat && getBlock(x, y + 1) == AbyssBlock.block) {
						// Flat top.
						setBlock(x, y, 0xFFF500F5);
					} else if (getBlock(x, y + 1) != AbyssBlock.block && getBlock(x, y - 1) != Wall.rightFlat && getBlock(x, y - 1) == AbyssBlock.block) {
						// Flat bottom.
						setBlock(x, y, 0xFFFF00FF);
					} else if (getBlock(x + 1, y) != AbyssBlock.block && getBlock(x - 1, y) == AbyssBlock.block) {
						// Flat right.
						setBlock(x, y, 0xFFFA00FA);
					} else if (getBlock(x - 1, y) != AbyssBlock.block && getBlock(x + 1, y) == AbyssBlock.block) {
						// Flat left.
						setBlock(x, y, 0xFFF000F0);
					}
				}
			}
		}

		setWalls = true;
	}

	public boolean haveWallsBeenSet() {
		return setWalls;
	}
}
