package omicron_15;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
//Graph
public class WebManager {
	public ComboNode base,evade,current;
	public WebManager(int longitude) {
		this.base=new ComboNode("base",longitude);
		this.evade=new ComboNode("esquive",longitude);
		this.current=this.base;
		webBuilder(longitude);
		System.out.println("WebManager Iniciado");
	}
	public void reciber(int key) {
		if(key==1) {//---------------------------- Ataque Basico
			this.current=this.current.one;
		}else if(key==2) {//---------------------- Ataque Especial
			if(this.current.isSpaceable())
				this.current=this.current.two;
			else
				this.current=this.current.one;
		}else if(key==3) {//---------------------- Cancelar Combo
			this.current=this.current.home;
		}else if(key==5) {//---------------------- Reiniciar Combo
			this.current=this.current.restart;
		}else if(key==4){//----------------------- Cambio/Esquive
			this.evade.setNode(this.current.getOne());
			this.current=this.evade;
		}
		this.current.reStart();
		System.out.println("cambio a "+this.current.id);
	}
	public void paintNode(Graphics g) {
		this.current.paintNode(g);
	}
	public void incrementNode() {
		this.current.moverInt();
	}
	private void webBuilder(int longitude) {
		ComboNode home=new ComboNode("home",longitude);
		ComboNode a1=new ComboNode("a1",longitude);
		ComboNode a2=new ComboNode("a2",longitude);
		ComboNode a3=new ComboNode("a3",longitude);
		ComboNode a4=new ComboNode("a4",longitude);
		ComboNode b2=new ComboNode("b2",longitude);
		ComboNode b3=new ComboNode("b3",longitude);
		ComboNode b4=new ComboNode("b4",longitude);
		ComboNode c2=new ComboNode("c2",longitude);
		ComboNode c3=new ComboNode("c3",longitude);
		ComboNode c4=new ComboNode("c4",longitude);
		ComboNode d2=new ComboNode("d2",longitude);
		this.base.setNodes(a1,null,null,evade,a1);
		a1.setNodes(a2,b2,a1,this.evade,a1);
		b2.setNodes(b3, null, a1, this.evade, a1);
		b3.setNodes(b4, null, a1, this.evade, a1);
		b4.setNodes(a1, null, a1, this.evade, a1);
		a2.setNodes(a3, c2, a1, this.evade, a1);
		c2.setNodes(c3, null, a1, this.evade, a1);
		c3.setNodes(c4, null, a1, this.evade, a1);
		c4.setNodes(a1, null, a1, this.evade, a1);
		a3.setNodes(a4, d2, a1, this.evade, a1);
		d2.setNodes(a1,null, a1, this.evade, a1);
		a4.setNodes(a1, null, a1, this.evade, a1);
		this.evade.setNodes(null, null, a1, this.evade, a1);
		this.current=this.base;
		System.out.println("Red tejida");
	}
}
class ComboNode{
	public ComboNode one,two,home,evade,restart;
	public String id;
	private Image[] movement;
	private int mover;
	private boolean spaciable;
	private Control obs;
	public ComboNode(String id, int longitude){
		this(id,longitude,false,null,null,null,null,null);
	}
	public ComboNode(String id, int longitude, boolean spaceable, ComboNode one,ComboNode two,ComboNode home,ComboNode evade,ComboNode restart) {
		this.id=id;
		this.one=one;
		this.two=two;
		this.home=home;
		this.evade=evade;
		this.restart=restart;
		this.movement=new Image[longitude];
		this.spaciable=spaceable;
		movementCreator(this.id);
	}
	private void movementCreator(String id) {
		for(int i=0;i<=this.movement.length-1;i++)
			this.movement[i]=new ImageIcon(this.id+(i+1)+".jpg").getImage();
	}
	public void setNodes(ComboNode one,ComboNode two,ComboNode home,ComboNode evade,ComboNode a1) {
		this.one=one;
		this.two=two;
		this.home=home;
		this.evade=evade;
		this.restart=a1;
		if(two!=null)
		this.spaciable=true;
	}
	public ComboNode getOne(){
		return this.one;
	}
	public boolean isSpaceable(){
		return this.spaciable;
	}
	public void setNode(ComboNode one) {
		this.one=one;
	}
	public void moverInt() {
		if(this.mover==this.movement.length-1) {
			this.mover=0;
		}else {
			this.mover++;
			System.out.println(this.mover);
		}
	}
	public void reStart() {
		this.mover=0;
	}
	public void paintNode(Graphics g) {
		g.drawImage(this.movement[this.mover],100,100,200,200,obs);
	}
}
