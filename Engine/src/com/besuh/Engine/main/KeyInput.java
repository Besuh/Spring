package com.besuh.Engine.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i=0;i<handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Player) {
				//keyevents for player 1
				
				if(key == KeyEvent.VK_W) tempObject.setVelY(-5);
				if(key == KeyEvent.VK_S) tempObject.setVelY(5);
				if(key == KeyEvent.VK_D) tempObject.setVelX(5);
				if(key == KeyEvent.VK_A) tempObject.setVelX(-5);
				if(key == 32) {
					tempObject.x =320;
					tempObject.y=320;
				}
				
			}
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i=0;i<handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Player) {
				//keyevents for player 1
				
				if(key == KeyEvent.VK_W) {
					if(tempObject.getVelY()<0) {
						tempObject.setVelY(tempObject.getVelY()+5);
					}
				}
				if(key == KeyEvent.VK_S) {
					if(tempObject.getVelY()>0) {
						tempObject.setVelY(tempObject.getVelY()-5);
					}
				}
				if(key == KeyEvent.VK_D) {
					if(tempObject.getVelX()>0) {
						tempObject.setVelX(tempObject.getVelX()-5);
					}
				}
				if(key == KeyEvent.VK_A) {
					if(tempObject.getVelX()<0) {
						tempObject.setVelX(tempObject.getVelX()+5);
					}
				}
			}
		}
		
	}
	
}
