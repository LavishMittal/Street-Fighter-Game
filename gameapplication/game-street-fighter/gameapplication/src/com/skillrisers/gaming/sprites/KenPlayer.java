package com.skillrisers.gaming.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class KenPlayer extends Sprite {
	
	private BufferedImage walkImages[] = new BufferedImage[11];
//	private BufferedImage jumpImage[] = new BufferedImage[11];
	private BufferedImage[] damageImages = new BufferedImage[5];

	public KenPlayer() throws IOException {
		x = GWIDTH - 400;
		h = 200;
		w = 200;
		y = FLOOR - h;
		speed = 0;
		currentMove = STANDING;
		image = ImageIO.read(KenPlayer.class.getResource(KEN_IMAGE));
		loadDamageImage();
		loadWalkImages();
//		loadJumpImages();
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
		force = force + GRAVITY;
		y = y + force;
	}

	private void loadWalkImages() {
		walkImages[0] = image.getSubimage(0, 127, 98, 115);
		walkImages[1] = image.getSubimage(104, 129, 99, 114);
		walkImages[2] = image.getSubimage(208, 131, 83, 116);
		walkImages[3] = image.getSubimage(294, 130, 77, 113);
		walkImages[4] = image.getSubimage(384, 128, 76, 117);
		walkImages[5] = image.getSubimage(474, 129, 70, 121);
		walkImages[6] = image.getSubimage(551, 132, 74, 116);
		walkImages[7] = image.getSubimage(634, 128, 86, 121);
		walkImages[8] = image.getSubimage(723, 128, 97, 119);
		walkImages[9] = image.getSubimage(825, 130, 96, 117);
		walkImages[10] = image.getSubimage(925, 134, 96, 118);

	}
	
//	private void loadJumpImages() {
//		walkImages[0] = image.getSubimage(15, 648, 84, 139);
//		walkImages[1] = image.getSubimage(113, 650, 82, 131);
//		walkImages[2] = image.getSubimage(205, 670, 85, 113);
//		walkImages[3] = image.getSubimage(295, 674, 75, 103);
//		walkImages[4] = image.getSubimage(384, 670, 82, 94);
//		walkImages[5] = image.getSubimage(484, 679, 81, 92);
//		walkImages[6] = image.getSubimage(580, 677, 74, 90);
//		walkImages[7] = image.getSubimage(666, 678, 76, 100);
//		walkImages[8] = image.getSubimage(757, 678, 76, 116);
//		walkImages[9] = image.getSubimage(845, 663, 77, 135);
//		walkImages[10] = image.getSubimage(933, 661, 77, 135);
//
//	}

	public void loadDamageImage() {
		damageImages[0] = image.getSubimage(120, 534, 89, 92);
		damageImages[1] = image.getSubimage(228, 552, 92, 79);
		damageImages[2] = image.getSubimage(329, 561, 90, 74);
		damageImages[3] = image.getSubimage(440, 562, 90, 76);
		damageImages[4] = image.getSubimage(551, 561, 91, 78);

	}
	
	private BufferedImage walkImages() {
		if(imageIndex>10) {
			imageIndex = 0;
		}
		BufferedImage img = walkImages[imageIndex];
		imageIndex++;
		return img;
	}

	public BufferedImage damageImage() {
		if (imageIndex >= 5) {
			imageIndex = 0;
			currentMove = STANDING;
		}
		BufferedImage img = damageImages[imageIndex];
		imageIndex++;
		return img;
	}
	
//	public BufferedImage jumpImage() {
//		if (imageIndex >= 10) {
//			imageIndex = 0;
//			currentMove = STANDING;
//			isAttacking = false;
//		}
//		BufferedImage img = damageImages[imageIndex];
//		imageIndex++;
//		return img;
//	}

	@Override
	public BufferedImage defaultImage() {
		
		if(currentMove == WALK) {
			return walkImages();
		}
		
		else if (currentMove == DAMAGE) {
			return damageImage();
		}
//		
//		else if(currentMove == JUMP) {
//			return jumpImage();
//		}
//		BufferedImage subImage = image.getSubimage(16, 2, 78, 110);
		return walkImages();
	}

	
}
