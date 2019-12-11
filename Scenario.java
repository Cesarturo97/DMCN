package omicron_15;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
//Circular Linked List
public class Scenario {
	
}
class BackGroundNode{
	private Image backGround;
	private BackGroundNode next,past;
	private Control obs;
	public BackGroundNode(String id){
		this.backGround=new ImageIcon(id+".jpg").getImage();
		this.past=null;
		this.next=null;
		this.obs=null;
	}
	public void setChain(BackGroundNode next, BackGroundNode past, Control obs){
		this.past=past;
		this.next=next;
		this.obs=obs;	
	}
	public BackGroundNode getNext(){
		return this.next;
	}
	public BackGroundNode getPast(){
		return this.past;
	}
	public void paint(Graphics g){
		g.drawImage(this.backGround,0,0,500,500,obs);
	}
}
	