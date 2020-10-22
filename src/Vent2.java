import java.awt.BorderLayout;

import javax.swing.JFrame;
/**
 * 
 * @2018-07-13	
 * @author Pedro Illaisaca
 * @
 */
public class Vent2 extends JFrame {
	
	public Vent2() {
		this.setSize(500,500);
		getContentPane().setLayout(new BorderLayout());
		PanelVent v=new PanelVent();
		add(v);
	}

}
