//swing���� ������ �ð踸���(Thread)

import java.awt.FlowLayout;   
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClock extends JFrame implements Runnable{
    Thread thread;
	 JLabel label;

	public DigitalClock(){
		super("������ �ð�");

		setLayout(new FlowLayout());

		label = new JLabel();
		label.setFont(new Font("Serif",Font.PLAIN, 20));

		if(thread == null){
			
			//this�� �ǹ̴� Runnable�� ������ ��ü�� ����(DigitalClock)
			thread = new Thread(this);
			thread.start();
		}
		add(label);
		setBounds(100,100,400,100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		DigitalClock d2 = new DigitalClock();
		d2.display();
		JFrame.setDefaultLookAndFeelDecorated(true); //����̹��� ����
		new DigitalClock();
	}  
	public void display() {
		DigitalClock d2 = new DigitalClock();
         
	}    
	public void run(){
		while(true){
			Calendar cal = Calendar.getInstance();
			String now = cal.get(Calendar.YEAR)+"��"+
					(cal.get(Calendar.MONTH)+1)+"��"+
					cal.get(Calendar.DATE)+"��"+
					cal.get(Calendar.HOUR)+"��"+
					cal.get(Calendar.MINUTE)+"��"+
					cal.get(Calendar.SECOND)+"��";
			label.setText(now); 
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}