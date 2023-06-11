package com.skillrisers.gaming.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class KenPlayer extends Sprite {
private	BufferedImage [] damageImages = new BufferedImage[5];
	 
	 public KenPlayer() throws IOException {
		 x = GWIDTH - 400;
		 h = 200;
		 w = 200;
		 y = FLOOR - h;
		 speed = 0;
		 image = ImageIO.read(KenPlayer.class.getResource(KEN_IMAGE));
		 loadDamageImage();
	 }
	 
	 public void loadDamageImage() {
		 damageImages[0] = image.getSubimage(120, 534, 89, 92);
		 damageImages[1] = image.getSubimage(228, 552, 92, 79);
		 damageImages[2] = image.getSubimage(329, 561, 90, 74);
		 damageImages[3] = image.getSubimage(440, 562, 90, 76);
		 damageImages[4] = image.getSubimage(551, 561, 91, 78);

	 }
	 
	 public BufferedImage damageImage() {
		 if(imageIndex>=5) {
			 imageIndex = 0;
			 currentMove = STANDING;
		 }
		 BufferedImage img = damageImages[imageIndex];
		 imageIndex++;
		 return img;
	 }
	 
	 	@Override
		public BufferedImage defaultImage() {
	 		if(currentMove == DAMAGE) {
	 			return damageImage();
	 		}
			BufferedImage subImage = image.getSubimage(16, 2, 78, 110);
			return subImage;
		}
}
