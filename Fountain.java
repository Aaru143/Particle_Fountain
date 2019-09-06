//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P02 - Fountain
// Files: Fountain.java, P2ParticleFountai.java
// Course: CS-300, Spring 2019
//
// Author: Aarushi Gupta
// Email: gupta232@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Naman Ladsaria
// Partner Email: nladsaria@wisc.edu
// Partner Lecturer's Name: Gary Dahl
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X__ Write-up states that pair programming is allowed for this assignment.
// _X__ We have both read and understand the course Pair Programming Policy.
// _X__ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Random;

public class Fountain {

  
  /**
   * Creates a single particle at position (3,3) with velocity (-1,-2). 
   * Then checks whether calling updateParticle() on this particle's index 
   * correctly results in changing its position to (2,1.3).
   * 
   * @return true when no defect is found, and false otherwise
   */
  private static boolean testUpdateParticle() {
    boolean testPassed = false; // sets the testPassed to false which becomes
    // true if the test is passed
    particles = new Particle[1]; // creates an array with length 1
    particles[0] = new Particle(); // assigns the index 0 with a new particle
    particles[0].setPositionX(3); // sets its X position
    particles[0].setPositionY(3); // sets its Y position
    particles[0].setVelocityX(-1); // sets its X velocity
    particles[0].setVelocityY(-2); // sets its Y velocity
    updateParticle(0); // calls updateParticle
    if (Math.abs(particles[0].getPositionX() - 2.0) < 0.001
        && Math.abs(particles[0].getPositionY() - 1.3) < 0.001) { // checks if
      // after calling
      // updateParticle the new X
      // position to be 2.0 and new Y
      // position to be 1.3
      testPassed = true; // if the new positions are correct, sets the
                         // testPassed to true
    }
    return testPassed;
  }


  /**
   * Calls removeOldParticles(6) on an array with three particles 
   * (two of which have ages over six
   * and another that does not). Then checks whether the old particles 
   * were removed and the young
   * particle was left alone.
   * 
   * @return true when no defect is found, and false otherwise
   */
  private static boolean testRemoveOldParticles() {
    boolean testPassed = false;// sets the testPassed to false which becomes
    // true if the test is
    // passed
    particles = new Particle[3]; // creates a new array of size 3
    particles[0] = new Particle(); // assigns a new particle
    particles[0].setAge(12); // sets its age
    particles[1] = new Particle();// assigns a new particle
    particles[1].setAge(15);// sets its age
    particles[2] = new Particle();// assigns a new particle
    particles[2].setAge(2);// sets its age
    removeOldParticles(6);// calls removeOldParticles to remove particles
    // with age greater than 6
    if (particles[0] == null && particles[1] == null && particles[2] != null) {
      // checks if the
      // particles with
      // age greater than
      // 6 removed
      testPassed = true; // if the particles are removed sets testPassed as true
    }
    return testPassed;
  }


  private static Random randGen = new Random(); // creates a random object
  private static Particle[] particles; // creates an array to store the particles
//declares a variable to store the initial X position
  private static int positionX;
//declares a variable to store the initial Y position
  private static int positionY;
  private static int startColor; // declares a variable to store color
  private static int endColor; // declares a variable to store color


  /**
   * Calls several Utility class methods to assign new position, size
   * velocity, age to the particle
   * 
   * @param the index of the particle to be updated
   * @return none
   */
  private static void updateParticle(int index) {
    Utility.fill(particles[index].getColor(), particles[index].getTransparency());
    
    // sets the color with shapes would be drawn
    Utility.circle(particles[index].getPositionX(), particles[index].getPositionY(),
        
        particles[index].getSize()); // draws the circle on the screen at 
                                     //specified position of specified size
    
    particles[index].setVelocityY(particles[index].getVelocityY() + 0.3f); 
    // adds 0.3f to the initial velocity to make the ball bounce
    
    particles[index]
        .setPositionX(particles[index].getPositionX() + 
            particles[index].getVelocityX()); // sets new X position to old
                                             // plus the new velocity
  
    particles[index]
        .setPositionY(particles[index].getPositionY() +
            particles[index].getVelocityY()); // sets new Y position to old plus
    //the new velocity
    
    particles[index].setAge(particles[index].getAge() + 1); // increases the age
                                                        // of the particle by 1
  }

  
  /**
   * Creates the required number of particles with properties
   * 
   * @param number of particles to be created
   * @return none
   */
  private static void createNewParticles(int ParticlesToCreate) {
    int particlesCreated = 0; // initially the number of particles created is 0
    for (int j = 0; j < particles.length; j++) { // iterates through the array 
                                                //particles whose length is 800
      if (particlesCreated == ParticlesToCreate) {
        break; // if the number of particles created is equal to the number of 
               // particles user wants then the loop breaks
      }
      if (particles[j] == null) { // if the array holds a null value at index 'j'
        
        particles[j] = new Particle(); // assign index 'j' with a new particle
        
        float randSize = (randGen.nextFloat() * 7) + 4;
        particles[j].setSize(randSize); // sets the size with a random number 
                                        // between 4(inclusive) and 11(exclusive)

        particles[j].setPositionX(positionX + delta()); // sets the position X 
                       //of the particle within +/- 3 pixels of psotitionX = 400
        
        particles[j].setPositionY(positionY + delta()); // sets the position Y 
                       //of the particle within +/- 3 pixels of psotitionY = 300

        float amountMixed = randGen.nextFloat(); // generates a random float number
        
     // sets the color of the particles
        particles[j].setColor(Utility.lerpColor(startColor, endColor, amountMixed)); 
     
     // sets the X velocity of the  particle to a random number between -1 and 1
        particles[j].setVelocityX((randGen.nextFloat() * 2) - 1); 
        
    // sets the Y velocity of the  particle to a random number between -5 and 10
        particles[j].setVelocityY((randGen.nextFloat() * 5) - 10); 
        
     // sets the age of the particle to a random number between 0 and 40
        particles[j].setAge(randGen.nextInt(40)); 
        
     // sets the transparency of the particle to a random number between 32 and 127
        particles[j].setTransparency(randGen.nextInt(95) + 32); 

        particlesCreated++; // increases the number of particles created by 1

      }
    }
  }


  /**
   * Return the float value delta which is a random number
   * 
   * @return random number
   */
  private static float delta() {
 // generates a random float number
    float f = randGen.nextFloat(); 
    
    while (f == 1) {
      f = randGen.nextFloat();
    }
 // generates a random float number between -3 and +3
    float delta = (f * 6) - 3; 
    
 // returns the random float number between +3 and -3
    return delta; 
  }


  /**
   * Removes the particles that exceeded the specified maximum age
   * 
   * @param Maximum age that particles should have
   * @return none
   */
  private static void removeOldParticles(int maxAge) {
 // iterates through the array containing the particles
    for (int i = 0; i < particles.length; i++) { 
      
      if (particles[i] != null) { // checks if the value at index 'j' is null
        int age = particles[i].getAge(); // stores the age of the particle
        if (age > maxAge) {
          
       // if the age of the particle is greater than the maximum age,removes 
          //the particle by setting it to null
          particles[i] = null; 
        }
      }
    }
  }

  
  /**
   * changes the position of fountain according to the position of mouse
   * 
   * @param X position of mouse
   * @param Y position of mouse
   * @return none
   */
  public static void mousePressed(int mouseAtX, int mouseAtY) {
 // sets the X position of the particle to the X coordinate of the mouse
    Fountain.positionX = mouseAtX; 
    
 // sets the Y position of the particle to the Y coordinate of the mouse
    Fountain.positionY = mouseAtY; 
  }

  
  /**
   *takes a screenshot if the appropriate key is pressed
   * 
   * @param key pressed by user
   * @return none
   */
  public static void keyPressed(char keyPressedByUser) {
    if (keyPressedByUser == 'p') { // checks if the key pressed by user is 'p'
      
      // takes a screenshot of the screen and stores it
      Utility.save("screenshot.png");
    }
  }


  /**
   * sets the initial conditions
   * 
   * @param none
   * @return none
   */
  public static void setup() {
    // calls the test method for UpdateParticle()
    System.out.println("The value of testUpdateParticle is: " + testUpdateParticle()); 
    
    // calls the test method for RemoveOldParticles()
    System.out.println("The value of testRemoveOldParticles is: " + testRemoveOldParticles()); 

    particles = new Particle[800]; // creates an array with the length 800
    positionX = 400; // sets the initial X position to 400
    positionY = 300; //// sets the initial Y position to 300
    startColor = Utility.color(23, 141, 235); // sets the startColor 
    endColor = Utility.color(23, 200, 255); // sets the endColor 
  }

  
  /**
   * this method is called until the program terminates
   * 
   * @param none
   * @return none
   */
  public static void update() {
    Utility.background(Utility.color(235, 213, 186)); // sets the background color
    createNewParticles(10); // calls createNewParticles with value 10 
    
 // iterates through the array containing the particles
    for (int i = 0; i < particles.length; i++) { 
      if (particles[i] != null) {
     // if the value of particle at index 'i' is not null, calls updateParticle
        updateParticle(i); 
      }
    }
 // calls removeOldParticles to remove particles with age above 80
    removeOldParticles(80); 
  }

  
  /**
   * Calls runApplicationmethod 
   * 
   * @param args (unused)
   */
  public static void main(String[] args) {
    Utility.runApplication();
  }
}
