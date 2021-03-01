package AI1;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node("100");
		Node n2 = new Node("90");
		Node n3 = new Node("110");
		Node n4 = new Node("80");
		Node n5 = new Node("95");
		Node n6 = new Node("50");

		n1.addVertext(n2);
		n1.addVertext(n3);
		n2.addVertext(n4);
		n2.addVertext(n5);
		n5.addVertext(n6);

		IDDFS id = new IDDFS(n6);
		id.search(n1);

	}

}
