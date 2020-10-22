import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.KeyEventPostProcessor;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 
 * @2018-07-10	
 * @author Pedro Illaisaca
 * @
 */
public class PanelVent extends JPanel implements KeyListener{
	int x1=180;
	int x2=0;
	TimerTask hilo;
	
	
	int amarillo=75;
	int rosa=320;
	int cyan=300;
	int green=50;
	//Variables globales las cuales se establecen al iniciar el programa
	int mar1=40;
	int mar2=250;
	//imagen de mario cargada
	Image mario=Toolkit.getDefaultToolkit().getImage("mariobros50_50.png");
	//metodo que dibuja las figuras en el panel	
	public void paint(Graphics g) {
			
		super.paint(g);
		g.setColor(new java.awt.Color(153, 102, 51));
		g.fillRect(0, 450, 500, 50);
		
		
		g.setColor(Color.yellow);
		g.fillOval( 420,20, 100, 100);
	//cuadro rosa
		g.setColor(Color.pink);
		g.fillRect(rosa, 350, 90, 100);
		
		//cuadro cyan
		g.setColor(Color.cyan);
		g.fillRect(cyan, 370, 50, 80);
		//amarillo
		g.setColor(Color.yellow);
		g.fillRect(amarillo, 350, 80, 100);
		g.setColor(Color.yellow);
		g.fillOval(amarillo, 300, 80, 80);
		//verde
		g.setColor(Color.GREEN);
		g.fillRect(green, 350, 50, 100);
		
		g.setColor(Color.GREEN);
		g.fillOval(green, 325, 50, 50);
		///nubes
		g.setColor(Color.WHITE);
		
		//g.fillOval(120, 85, 80, 50);
		//g.fillOval(140, 70, 50, 80);
		g.fillOval((x1), 85, 80, 50);
		g.fillOval( (x1+20), 70, 50, 80);
		//g.fillOval(330,185, 80, 50);
		//g.fillOval(340,170, 50, 80);

		g.fillOval((x2),185, 80, 50);
		g.fillOval((x2+10),170, 50, 80);
		
		//g.drawImage(mario, 0, 0, 10, 10, 0, 10, 10, 10, null);
		
		
      
		
		Graphics2D g2= (Graphics2D)g;
		
		g2.drawImage(mario,mar1,410,  this);
		//g2.drawImage(marioIn,mar2,410,  this);
		
	}	
	public PanelVent() {
		
		//super("graficas");
		this.setBackground(Color.BLUE);
		//setSize(500, 500);
		
		
		this.addKeyListener(this);//Escucha al teclado
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		 hilo=new  TimerTask() {
				
			@Override
			public void run() {
				/**
				 * Por cada intracion que tiene el bucle 
				 * la coordenada del la primera x1 nube aumentara de 10 en 10 
				 * mientras que la segunda nuve la x2 incrementara de 5 en 5
				 */
				x1 += 6;
				x2 += 2;

				if (x1 > 500)
					x1 = 0;

				if (x2 > 500)
					x2 = 0;

				System.out.println(x1 + " " + x2);
				repaint();
			}
		};
		Timer hill = new Timer();
		hill.scheduleAtFixedRate(hilo, 0, 200);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("teclas");
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
			moverDerecha();
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
			moverIzquierda();
		
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
			System.out.println("abajo");
			//moverIzquierda();		
		
		if(e.getKeyCode()==KeyEvent.VK_UP)
			System.out.println("arriba");
		//moverIzquierda();	
	}
	private void moverIzquierda() {
		if(amarillo<500)
			amarillo+=10;
		else
			amarillo=0;
		
		if(cyan<500)
			cyan+=10;
		else
			cyan=0;

		if(rosa<500)
			rosa+=10;
		else
			rosa=0;
		
		if(green<500)
			green+=10;
		else
			green=0;
		
		
		
		if(mar1> 100)
			mar1-=10;
		repaint();
		
		
		
	}
	
	private void moverDerecha() {
	
		//marioIn=null;
		
		if(amarillo>0)
			amarillo-=10;
		else
			amarillo=500;
		
		if(cyan>0)
			cyan-=10;
		else
			cyan=500;
		
		if(rosa>0)
			rosa-=10;
		else
			rosa=500;	
	
		if(green>0)
			green-=10;
		else
			green=500;
		
		if(mar1<290)
			mar1+=10;
		repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}



