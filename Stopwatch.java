package Stopwatcher;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopwatch implements ActionListener {
    JFrame frame=new JFrame();
    JButton startButton=new JButton("Start");
    JButton resetButton =new JButton("Restart");
    JLabel timeLabel= new JLabel();
    int elapseTime=0;
    int miliseconds=0;
    int seconds=0;
    int minutes=0;
    int hours=0;
    boolean started=false;
    String milisecond_string=String.format("%02d", miliseconds);
    String second_string=String.format("%02d", seconds);
    String minute_string=String.format("%02d", minutes);
    String hour_string=String.format("%02d", hours);

    Timer time=new Timer(10,new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            elapseTime+=10;

            hours=elapseTime/(3600000);
            minutes=(elapseTime/60000)%60;
            seconds=(elapseTime/1000)%60;
            miliseconds=(elapseTime%1000)/10;
            milisecond_string = String.format("%02d", miliseconds);
            second_string = String.format("%02d", seconds);
            minute_string = String.format("%02d", minutes);
            hour_string = String.format("%02d", hours);

            timeLabel.setText("<html>" + hour_string + ":" + minute_string + ":" + second_string +
                    "<span style='font-size:18px;'>:" + milisecond_string + "</span></html>");



        }

    });

    Stopwatch(){
        timeLabel.setText("<html>" + hour_string + ":" + minute_string + ":" + second_string +
                "<span style='font-size:18px;'>:" + milisecond_string + "</span></html>");
        ;
        timeLabel.setBounds(200,200,400,400);
        timeLabel.setFont(new Font("Segoe Script", Font.PLAIN,35));
        timeLabel.setOpaque(true);
        timeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        startButton.setBounds(200,600,200,50);
        startButton.setFont(new Font("Segoe Script", Font.PLAIN,35));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        resetButton.setBounds(400,600,200,50);
        resetButton.setFont(new Font("Segoe Script", Font.PLAIN,35));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(timeLabel);
        frame.add(startButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setLayout(null);
        frame.setVisible(true);


    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==startButton){
            Start();
            if (started==false){
                started=true;
                startButton.setText("Stop");
                Start();
            }
            else{
                started=false;
                startButton.setText("Start");
                Stop();

            }
        }
        if (e.getSource()==resetButton){
            started=false;
            startButton.setText("Start");
            Reset();

        }


    }
    void Start(){
        time.start();

    }
    void Stop(){
        time.stop();

    }
    void Reset(){
        time.stop();
        elapseTime=0;
        seconds=0;
        minutes=0;
        hours=0;
        miliseconds=0;
        second_string=String.format("%02d", seconds);
        minute_string=String.format("%02d", minutes);
        hour_string=String.format("%02d", hours);
        milisecond_string=String.format("%02d", miliseconds);
        timeLabel.setText("<html>" + hour_string + ":" + minute_string + ":" + second_string +
                "<span style='font-size:18px;'>:" + milisecond_string + "</span></html>");

    }

}

