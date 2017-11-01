package alex0678.recyking;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class RecyKing extends Canvas implements Runnable{
    
    public static final String TITLE = "RecyKing";
    public static final int WIDTH = 1024, HEIGHT = 765;
    private JFrame frame;
    private boolean RUNNING = false;
    
    public RecyKing(){
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setMinimumSize(new Dimension(WIDTH,HEIGHT));
        setMaximumSize(new Dimension(WIDTH,HEIGHT));
        frame = new JFrame(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this,new BorderLayout().CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);   
        
    }
    
    private void start(){
        if(this.RUNNING) return;
        this.RUNNING = true;
        new Thread(this, "Game" + TITLE).start();
           
    }

    private void stop(){
        if(!this.RUNNING) return;
        this.RUNNING = false;
        frame.dispose();
        System.exit(0);
        
    }

    public void run(){
        while(this.RUNNING){
            update();
            render();
        }
        stop();
        
    }
    
    private void update(){
        System.out.println("foobar");
        
    }
    
    private void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH + 10, HEIGHT + 10);
        g.dispose();
        bs.show();
        
    }
    
    
    public static void main(String[] args) {
        new RecyKing().start();
        
    }

    
}
