package cn.didadu.sample.buffer;

import java.applet.Applet;
import java.awt.*;

/**
 * Created by jinggg on 16/2/1.
 */
public class NoBufferMovingCircle extends Applet implements Runnable{

    Image screenImage = null;
    Thread thread;
    int x = 5;
    int move = 1;

    public void init(){
        screenImage = createImage(230,160);
    }

    public void start(){
        if(thread == null){
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override public void run() {
        try{
            while(true){
                x += move;
                if((x > 105) || (x < 5)){
                    move *= -1;
                }
                repaint();
                Thread.sleep(10);
            }
        }catch (Exception e){

        }
    }

    public void drawCircle(Graphics gc){
        Graphics2D g = (Graphics2D) gc;
        g.setColor(Color.green);
        g.fillRect(0,0,200,100);
        g.setColor(Color.red);
        g.fillOval(x, 5, 90, 90);
    }

    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, 200, 100);
        drawCircle(g);
    }
}
