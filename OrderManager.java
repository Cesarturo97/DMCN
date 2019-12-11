package omicron_15;

public class OrderManager {
	OrderControler boss;
	ComboDealer comunicator;
	public int counter;
	public OrderManager(ComboDealer comunicator){
		this.boss=new OrderControler();
		this.counter=0;
		this.comunicator=comunicator;
		System.out.println("Order Manager Iniciado");
	}
	public void builder(int key){
		this.boss.add(key);
	}
	public void incrementer(){
		if(!this.boss.isEmpty()){
			if(this.counter<4){
				this.counter++;
				this.comunicator.CharacterMovement();
			}else{
				this.counter=0;
				this.comunicator.wM.reciber(this.boss.consume());
				this.comunicator.getScore(this.comunicator.wM.current.id);
			}
		}
	}
}
class OrderControler{
	private OrderNode first,last;
	private int size;
	public OrderControler() {
		this.first=new OrderNode();
		this.last=new OrderNode();
		this.size=0;
	}
	public void add(int key) {
		OrderNode nuevo=new OrderNode(key);
		if(this.size>=2) {
			this.last.setNext(nuevo);
			this.last=nuevo;
		}else if(this.size==1) {
			this.last.setKey(key);
			this.first.setNext(this.last);
		}else if(this.size==0) {
			this.first.setKey(key);
		}
		this.size++;
	}
	public boolean isEmpty(){
		return this.size==0;
	}
	public int consume() {
		int key=this.first.getKey();
		if(this.size>2) {
			this.first.setKey(this.first.getNext().getKey());
			this.first.setNext(this.first.getNext().getNext());
		}else if(this.size==2) {
			this.first.setKey(this.last.getKey());
			this.last=new OrderNode();
		}else if(this.size==1) {
			this.first=new OrderNode();
		}
		this.size--;
		return key;
	}
}
class OrderNode{
	private int key;
	private OrderNode next;
	public OrderNode() {
		this(0);
	}
	public OrderNode(int key) {
		this(key,null);
	}
	public OrderNode(int key, OrderNode next){
		this.key=key;
		this.next=next;
	}
	public int getKey() {
		return this.key;
	}
	public void setKey(int key) {
		this.key=key;
	}
	public void setNext(OrderNode next) {
		this.next=next;
	}
	public OrderNode getNext() {
		return this.next;
	}
}
