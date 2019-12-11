package omicron_15;

import java.awt.Graphics;

//System Manager
public class ComboDealer {
	public OrderManager oD;
	public  WebManager wM;
	private Scenario sO;
	private ScoreControler sC;
	public ComboDealer(){
		this.oD=new OrderManager(this);
		this.wM=new WebManager(3);
		this.sC=new ScoreControler();
	}
	public void paintComponent(Graphics g){
		this.sC.paint(g);
		this.wM.paintNode(g);
	}
	public void reciber(int key){
		this.oD.builder(key);
		System.out.println("Orden recibida "+key);
	}
	public void timelapse() {
		this.oD.incrementer();
	}
	public void getScore(String key) {
		this.sC.scoreMaker(key);
	}
	public void CharacterMovement() {
		this.wM.incrementNode();
	}
	
}
class ComboKiller{
	
}