package omicron_15;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class Control extends JPanel implements KeyListener,Runnable{
	Thread hilo=new Thread(this);
	ComboDealer cD;
	Musica musica=new Musica();
	private Image titulo;
	private Image fondo;
	public Control(){
		super();
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(500,500));
		this.cD=new ComboDealer();
		this.fondo= new ImageIcon("nico dmcn.jpg").getImage();
		this.titulo= new ImageIcon("titulo.png").getImage();
		this.musica.start();
		hilo.start();
	}
	public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	if(this.cD.oD.boss.isEmpty()) {
    		g.drawImage(fondo,0,0,500,500,this);
			g.drawImage(titulo, 15, 15, 150, 150,this);
    	}
    	this.cD.paintComponent(g);
    }
	@Override
	public void run() {
		try{
			while(true) {
				this.cD.timelapse();
				Thread.sleep(150);
				repaint();
			}
		}catch (Exception e){
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_UP) {
			this.cD.reciber(1);
		}
		if(key == KeyEvent.VK_DOWN) {
			this.cD.reciber(3);
		}
		if(key == KeyEvent.VK_LEFT) {
			this.cD.reciber(2);
		}
		if(key == KeyEvent.VK_RIGHT) {
			this.cD.reciber(4);
		}
		if(key == KeyEvent.VK_C){
			this.cD.reciber(5);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
}
