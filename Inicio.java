package omicron_15;
import java.awt.BorderLayout;
import javax.swing.JFrame;
public class Inicio extends JFrame{
	public Inicio(){
		super ("Devil May Cry Node Ultimate");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		Control ctrl=new Control();
		this.addKeyListener(ctrl);
		this.add(ctrl); 
		this.pack();                                        
		this.setVisible(true);
	}
	public static void main(String args[]) {
		Inicio portada=new Inicio();
	}
}