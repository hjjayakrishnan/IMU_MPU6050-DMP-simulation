import processing.core.*; 
import processing.xml.*; 

import processing.serial.*; 
import processing.opengl.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class imusimulator extends PApplet {



Serial port;
float[] value=new float[5];
int i=0;
PFont f;


public void setup()
{
  size(1000,700,OPENGL);
  noStroke();
  port=new Serial(this, "COM10",115200);
  port.bufferUntil('\n');
  frameRate(300);
  f = createFont("ImprintMT-Shadow",30,true);
  //background(255);
  //fill(246,225,65);
}


public void draw()
{
  
  background(0);
  lights();
  pushMatrix();
  translate(width/2,height/2);
   fill(246, 225, 65);
   rotateX(value[0]);
  rotateY(value[1]);
  rotateZ(value[2]);
   box(150,250,200);
   popMatrix();
   
   pushMatrix();
   //translate(300,0);
   textFont(f,32);
fill(255);
     text("IMU Simulator", 400,40);
   popMatrix();
   textFont(f,28);
fill(255,0,0);
   text("Developed by HJ Jayakrishnan", 40,600);
   
  
   pushMatrix();
   fill(255);
    translate(width/3,50);
    textFont(f,16);
  text("Yaw: " + ((float) value[0]), 0, 100);
  text("Pitch: " + ((float) value[1]), 100, 100);
  text("Roll: " + ((float) value[2]), 200, 100);
  popMatrix();
//println(value);
  
}

public void serialEvent(Serial port)
{
   
 String mg; 
  mg=port.readStringUntil('\n');
  fill(0);
  
    if(mg!= null)
  {
 value = PApplet.parseFloat(split(mg, ' '));
 println(value);
  
  }
 
} 



  static public void main(String args[]) {
    PApplet.main(new String[] { "--present", "--bgcolor=#666666", "--stop-color=#cccccc", "imusimulator" });
  }
}
