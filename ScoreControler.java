package omicron_15;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

//Double Linked List
public class ScoreControler {
	private int score, scoreAcumulative;
	private String analizer;
	private SignNode current, first;
	Control obs;
	public ScoreControler(){
		this.score=0;
		this.scoreAcumulative=0;
		this.analizer="";
		this.first=new SignNode("D");
		this.first.setChain(null, null);
		this.current=this.first;
		this.obs=null;
		builder();
		System.out.println("Score iniciado");
	}
	public void builder(){
		SignNode C = new SignNode("D");
		SignNode B = new SignNode("B");
		SignNode A = new SignNode("A");
		SignNode S = new SignNode("S");
		SignNode SS= new SignNode("SS");
		SignNode SSS=new SignNode("SSS");
		this.first.setChain(C, null);//---- D
		C.setChain(B, this.first);//------- C
		B.setChain(A, C);//---------------- B
		A.setChain(S, B);//---------------- A
		S.setChain(SS, A);//--------------- S
		SS.setChain(SSS, S);//------------- SS
		SSS.setChain(null, SS);//---------- SSS
		
		
	}
	public void paint(Graphics g){
		this.current.paint(g);
	}
	public int getScore(){
		return this.scoreAcumulative;
	}
	public void reset(){
		this.scoreAcumulative=0;
		this.score=0;
		this.analizer="";
	}
	public void scoreMaker(String key){
		if(!key.equals("base")){
			this.analizer+=key;
			this.score+=5;
			if(this.score==20 || this.score==25){
				if(this.analizer.equals("A1A2A3A4"))
					this.scoreAcumulative+=this.score*1.5;
				else if(this.analizer.equals("A1B2B3B4")){
					this.scoreAcumulative+=this.score*1.6;
				}else if(this.analizer.equals("A1A2C2C3C4")){
					this.scoreAcumulative+=this.score*1.7;
				}else if(this.analizer.equals("A1A2A3D2D3")){
					this.scoreAcumulative+=this.score*1.8;
				}
				System.out.println(this.score+" "+this.scoreAcumulative);
				if(this.current.getNext()!=null)
				this.current=this.current.getNext();
				this.scoreAcumulative+=this.score/2;
				this.score=0;
				this.analizer="";
			}
		}
	}
}
class SignNode{
	private Image score;
	private SignNode next,past;
	private Control obs;
	public SignNode(String id){
		this.score=new ImageIcon(id+".png").getImage();
		this.past=null;
		this.next=null;
		this.obs=null;
	}
	public void setChain(SignNode next, SignNode past){
		this.past=past;
		this.next=next;
		this.obs=obs;	
	}
	public SignNode getNext(){
		return this.next;
	}
	public SignNode getPast(){
		return this.past;
	}
	public void paint(Graphics g){
		if(this.next==null)
			g.drawImage(this.score,350,0,150,150,obs);
		else
		g.drawImage(this.score,400,0,90,50,obs);
	}
}
class ScoreSaver{
	
}
