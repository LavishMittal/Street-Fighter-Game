package com.skillrisers.gaming.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RyuPlayer extends Sprite  {
	
	private BufferedImage walkImages [] = new BufferedImage[6];
	private BufferedImage standingImages[] = new BufferedImage[8];
	private BufferedImage kickImages[] = new BufferedImage[6];
	private BufferedImage punchImages[] = new BufferedImage[6];

	public RyuPlayer() throws IOException {
		x = 230;
		h = 220;
		w = 170;
		y = FLOOR - h;
		speed = 0;
		currentMove = STANDING;
		image = ImageIO.read(RyuPlayer.class.getResource(RYU_IMAGE));
		loadWalkImages();
		loadStandingImages();
		loadkickImages();
		loadPunchImages();
	}
	
	public void jump() {
		if(!isJump) {
		force = DEFAULT_FORCE;
		y = y + force;
		isJump = true;
		}
	}
	
	public void fall() {
		if(y>=(FLOOR - h)) {
			isJump = false;
			return;
		}
		force = force +GRAVITY;
		y = y + force;
	}
	
	private void loadWalkImages() {
		walkImages[0] = image.getSubimage(56, 207, 64, 85);
		walkImages[1] = image.getSubimage(129, 205, 63, 87);
		walkImages[2] = image.getSubimage(202, 206, 54, 90);
		walkImages[3] = image.getSubimage(266, 207, 58, 86);
		walkImages[4] = image.getSubimage(330, 206, 61, 90);
		walkImages[5] = image.getSubimage(401, 210, 58, 87);
	}
	
	private void loadStandingImages() {
		standingImages[0] = image.getSubimage(15, 4, 59, 94);
		standingImages[1] = image.getSubimage(80, 4, 61, 92);
		standingImages[2] = image.getSubimage(144, 4, 61, 94);
		standingImages[3] = image.getSubimage(213, 4, 66, 97);
		standingImages[4] = image.getSubimage(286, 4, 58, 94);
		standingImages[5] = image.getSubimage(345, 4, 63, 95);
		standingImages[6] = image.getSubimage(414, 4, 55, 92);
		standingImages[7] = image.getSubimage(474, 4, 57, 94);

	}
	
	private void loadkickImages() {
		kickImages[0] = image.getSubimage(37, 922, 58, 90);
		kickImages[1] = image.getSubimage(104, 924, 66, 88);
		kickImages[2] = image.getSubimage(176, 926, 108, 88);
		kickImages[3] = image.getSubimage(291, 923, 62, 91);
		kickImages[4] = image.getSubimage(362, 928, 58, 86);
		kickImages[5] = image.getSubimage(425, 926, 91, 88);

	}
	
	private void loadPunchImages() {
		punchImages[0] = image.getSubimage(22, 726, 64, 87);
		punchImages[1] = image.getSubimage(92, 724, 67, 90);
		punchImages[2] = image.getSubimage(162, 727, 106, 87);
		punchImages[3] = image.getSubimage(271, 723, 76, 91);
		punchImages[4] = image.getSubimage(353, 724, 100, 88);
		punchImages[5] = image.getSubimage(456, 726, 73, 88);

	}
	
	private BufferedImage walkImages() {
		if(imageIndex>5) {
			imageIndex = 0;
			
		}
		BufferedImage img = walkImages[imageIndex];
		imageIndex++;
		return img;
	}
	
	private BufferedImage kickImages() {
		if(imageIndex>5) {
			imageIndex = 0;
			currentMove = STANDING;
			isAttacking = false;
			
		}
		BufferedImage img = kickImages[imageIndex];
		imageIndex++;
		return img;
	}
	
	private BufferedImage punchImages() {
		if(imageIndex>5) {
			imageIndex = 0;
			currentMove = STANDING;
			isAttacking = false;
			
		}
		BufferedImage img = punchImages[imageIndex];
		imageIndex++;
		return img;
	}
	
	private BufferedImage standingImage() {
		if(imageIndex>7) {
			imageIndex = 0;
			currentMove = STANDING;
		}
		BufferedImage img = standingImages[imageIndex];
		imageIndex++;
		return img;
	}
	
	@Override
	public BufferedImage defaultImage() {
		
		 if(currentMove == WALK) {
			return walkImages();
		}
		
		else if(currentMove == PUNCH) {
			return punchImages();
		}
		
		else if(currentMove == KICK) {
			return kickImages();
		}
		 
		return standingImage();
			
	}
}
