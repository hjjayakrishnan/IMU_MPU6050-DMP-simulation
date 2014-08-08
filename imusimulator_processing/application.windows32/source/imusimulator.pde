import processing.serial.*;
import processing.opengl.*;
Serial port;
float[] value=new float[5];
int i=0;
PFont f;


void setup()
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


void draw()
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

void serialEvent(Serial port)
{
   
 String mg; 
  mg=port.readStringUntil('\n');
  fill(0);
  
    if(mg!= null)
  {
 value = float(split(mg, ' '));
 println(value);
  
  }
 
} 



