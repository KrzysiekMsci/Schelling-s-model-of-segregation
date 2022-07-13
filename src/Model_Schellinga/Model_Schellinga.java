package Model_Schellinga;

import java .awt.*; 

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*; 

public class Model_Schellinga{ 

 
    public static Object r;

	public static void main(String s[]) { 

        JFrame frame = new JFrame("Model Schellinga");   

        JPanel panel = new JPanel();   
        
        JPanel panel2 = new JPanel();  

        panel.setLayout(new FlowLayout()); 
        
        JButton button = new JButton();   

        button.setText("START/STOP"); 
        button.setEnabled(true);
    	wykres wykres = new wykres(); 
        
        JLabel R = new JLabel("R", JLabel.CENTER);
        R.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel G = new JLabel("G", JLabel.CENTER);
        G.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel B = new JLabel("B", JLabel.CENTER);
        B.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel W = new JLabel("W", JLabel.CENTER);
        W.setAlignmentX(Component.CENTER_ALIGNMENT);
    	
   	 	
   	 	
        button.addActionListener(new ActionListener() { 

        	@Override 

    		public void actionPerformed(ActionEvent arg0) { 

    			// TODO Auto-generated method stub 
    			if(wykres.rysowac==true)
    			{
    				wykres.rysowac=false;
    				wykres.R.setEnabled(true);
    				wykres.G.setEnabled(true);
    				wykres.B.setEnabled(true);
    				wykres.W.setEnabled(true);
    			}
    			else if(wykres.rysowac==false)
    			{
    				wykres.rysowac=true;
    				wykres.R.setEnabled(false);
    				wykres.G.setEnabled(false);
    				wykres.B.setEnabled(false);
    				wykres.W.setEnabled(false);
    				wykres.repaint(); 
    			}
        	}
        	
        }); 
        
    	double suma=50+50+50+50;
    	for(int i=0;i<wykres.wielkosc;i++)
    	{
    		for(int j=0;j<wykres.wielkosc;j++)
    		{
    			double losowa = Math.random(); 
    		
    			if(losowa<50/suma)		
    				wykres.lattice[i][j]=1;
    			else if(losowa<100/suma)		
    				wykres.lattice[i][j]=2;
    			else if(losowa<150/suma)		
    				wykres.lattice[i][j]=3;
    			else if(losowa<200/suma)
    				wykres.lattice[i][j]=0; 			
    		}

    	} 
    		wykres.repaint(); 

        panel.setBackground(Color.orange); 
        
        panel.add(wykres.R); 
        panel.add(R); 
        
        panel.add(wykres.G); 
        panel.add(G); 
        
        panel.add(wykres.B); 
        panel.add(B); 
        
        panel.add(wykres.W); 
        panel.add(W); 
        
        panel.add(button);
        
        panel.add(wykres); 
        
        panel.add(wykres.koniec); 

        frame.add(panel);  

        frame.setSize(550, 700);   

        frame.setLocationRelativeTo(null);   

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

        frame.setVisible(true);   

    } 

}   

class wykres extends JPanel{ 
	
	double r,g,b,w;
	
	int wielkosc=25; 

	int multiplier = 20;

	int idle=0;

	int[][] lattice = new int[wielkosc][wielkosc]; 

	boolean rysowac=false; 
	
	JSlider R = new JSlider( 0,100,50);{
	r=R.getValue();
	R.setPaintTrack(true);
	R.setPaintTicks(true);
	R.setPaintLabels(true);
	R.setMajorTickSpacing(10);
	R.setMinorTickSpacing(2);
	R.addChangeListener(new ChangeListener(){
	  public void stateChanged(ChangeEvent ce){	
			r=R.getValue();
			start();
	  }});
	}
	
	JSlider G = new JSlider( 0,100,50);
	{
	g=G.getValue();
	G.setPaintTrack(true);
	G.setPaintTicks(true);
	G.setPaintLabels(true);
	G.setMajorTickSpacing(10);
	G.setMinorTickSpacing(2);
	G.addChangeListener(new ChangeListener(){
	  public void stateChanged(ChangeEvent ce){	
			g=G.getValue();
			start();
	  }
	});
	}
	
	JSlider B = new JSlider( 0,100,50);
	{
		b=B.getValue();
	B.setPaintTrack(true);
	B.setPaintTicks(true);
	B.setPaintLabels(true);
	B.setMajorTickSpacing(10);
	B.setMinorTickSpacing(2);
	B.addChangeListener(new ChangeListener(){
	  public void stateChanged(ChangeEvent ce){	
			b=B.getValue();
			start();
	  }
	});
	}
	
	JSlider W = new JSlider( 0,100,50);
	{
		w=W.getValue();
	W.setPaintTrack(true);
	W.setPaintTicks(true);
	W.setPaintLabels(true);
	W.setMajorTickSpacing(10);
	W.setMinorTickSpacing(2);
	W.addChangeListener(new ChangeListener(){
	  public void stateChanged(ChangeEvent ce){	
			w=W.getValue();
			start();
	  }
	});
	}

  	 JLabel koniec = new JLabel(""); 

	

public wykres() {
  	setSize(wielkosc*multiplier,wielkosc*multiplier); 
  	Border border = BorderFactory.createLineBorder(Color.BLUE, 1); 
  	setBorder(border); 
}



  

public Dimension getPreferredSize()  

{return new Dimension(wielkosc*multiplier,wielkosc*multiplier);} 

     
void start()
{

	koniec.setText("");
	double suma=r+g+b+w;
	for(int i=0;i<wielkosc;i++)
	{
		for(int j=0;j<wielkosc;j++)
		{
			double losowa = Math.random(); 
		
			if(losowa<r/suma)		
				lattice[i][j]=1;
			else if(losowa<(r+g)/suma)		
				lattice[i][j]=2;
			else if(losowa<(r+g+b)/suma)		
				lattice[i][j]=3;
			else if(losowa<(r+g+b+w)/suma)
				lattice[i][j]=0; 			
		}

	} 
		repaint(); 
	}

void step() { 

	int x;
	int y;
	do
	{
		 x= (int) ((wielkosc) * Math.random()); 

		 y= (int) ((wielkosc) * Math.random()); 
	}while(lattice[x][y]==0);

		
		int k=lattice[x][y];

		int tempx=x,tempy=y;
		
		int max=check1(k,x,y);
		

			if(check(k,x-1,y-1)>max)
			{
				max=check(k,x-1,y-1);
				tempx=x-1;tempy=y-1;
			}

			if(check(k,x-1,y)>max)
			{
				max=check(k,x-1,y);
				tempx=x-1;tempy=y;
			}
			

			if(check(k,x-1,y+1)>max)
			{
				max=check(k,x-1,y+1);
				tempx=x-1;tempy=y+1;
			}


			if(check(k,x,y-1)>max)
			{
				max=check(k,x,y-1);
				tempx=x;tempy=y-1;
			}


			if(check(k,x,y+1)>max)
			{
				max=check(k,x,y+1);
				tempx=x;tempy=y+1;
			}


			if(check(k,x+1,y-1)>max)
			{
				max=check(k,x+1,y-1);
				tempx=x+1;tempy=y-1;
			}

			if(check(k,x+1,y)>max)
			{
				max=check(k,x+1,y);
				tempx=x+1;tempy=y;
			}

			if(check(k,x+1,y+1)>max)
			{
				max=check(k,x+1,y+1);
				tempx=x+1;tempy=y+1;
			}
		

		
if(tempx!=x || tempy!=y)
{
	lattice[tempx][tempy]=k;
	lattice[x][y]=0;
	idle=0;;
}
else
{
	idle++;
	if(idle>=wielkosc*wielkosc)
	{
		koniec.setText("koniec sortowania");
		System.out.println("Koniec sortowania"); 
		R.setEnabled(true);
		G.setEnabled(true);
		B.setEnabled(true);
		W.setEnabled(true);
		rysowac=false;
		idle=0;

	}
}
		
	
	
}
  
int check(int k,int x, int y) {
	int suma=0;
	if(x>-1 && x<wielkosc && y>-1 && y<wielkosc)
	{
		if(lattice[x][y]!=0)
			return 0;
		
		if(x+1<wielkosc)
		{
			if(y-1>0)
			{
				if(k==lattice[x+1][y-1])
					suma++;
			}
				if(k==lattice[x+1][y])
					suma++;
			if(y+1<wielkosc)
			{
				if(k==lattice[x+1][y+1])
					suma++;
			}
		}
		
		if(x-1>0)
		{
			if(y-1>0)
			{
				if(k==lattice[x-1][y-1])
					suma++;
			}
			if(k==lattice[x-1][y])
			suma++;
			if(y+1<wielkosc)
			{
				if(k==lattice[x-1][y+1])
					suma++;
			}
		}
	
		if(y-1>0)
		{
			if(k==lattice[x][y-1])
				suma++;
		}
		if(y+1<wielkosc)
		{
			if(k==lattice[x][y+1])
				suma++;
		}
	}
	return suma;
}

int check1(int k,int x, int y) {
	int suma=1;
	if(x>-1 && x<wielkosc && y>-1 && y<wielkosc)
	{
		
		if(x+1<wielkosc)
		{
			if(y-1>0)
			{
				if(k==lattice[x+1][y-1])
					suma++;
			}
				if(k==lattice[x+1][y])
					suma++;
			if(y+1<wielkosc)
			{
				if(k==lattice[x+1][y+1])
					suma++;
			}
		}
		
		if(x-1>0)
		{
			if(y-1>0)
			{
				if(k==lattice[x-1][y-1])
					suma++;
			}
			if(k==lattice[x-1][y])
			suma++;
			if(y+1<wielkosc)
			{
				if(k==lattice[x-1][y+1])
					suma++;
			}
		}
	
		if(y-1>0)
		{
			if(k==lattice[x][y-1])
				suma++;
		}
		if(y+1<wielkosc)
		{
			if(k==lattice[x][y+1])
				suma++;
		}
	}

	return suma;
}
  

public void paintComponent(Graphics graf){ 

super.paintComponent(graf);   

for (int i = 0; i < wielkosc; i++) { 

for (int j = 0; j < wielkosc; j++) { 

if (lattice[i][j] == 1) { 
graf.setColor(Color.red);
graf.fillRect(i*multiplier, j*multiplier, multiplier, multiplier); 

} 

if (lattice[i][j] == 2) { 
graf.setColor(Color.green);
graf.fillRect(i*multiplier, j*multiplier, multiplier, multiplier); 

} 

if (lattice[i][j] == 3) { 
graf.setColor(Color.blue);
graf.fillRect(i*multiplier, j*multiplier, multiplier, multiplier); 

} 

if (lattice[i][j] == 0) { 
graf.setColor(Color.white);
graf.fillRect(i*multiplier, j*multiplier, multiplier, multiplier); 

} 

} 

  

     if (rysowac) { 

    step(); 

    try { 

        Thread.sleep(1);            

      } catch (InterruptedException t){} 

    repaint(); 

     } 

} 

} 
}