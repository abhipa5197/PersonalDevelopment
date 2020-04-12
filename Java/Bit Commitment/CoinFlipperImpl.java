//**********************
//Group D
//CoinFlipperImpl
//**********************

import java.io.*;
import edu.rit.m2mi.M2MI;
import edu.rit.m2mi.SynthesisException;

import java.util.Random;

/**
 * CoinServer waits to play coin guessing games
 * with a CoinClient.
 *
 * @authors  Jeremy Balmos, Shawn Chasse, Eric Ferguson, Jeremy Dahlgren.
 */
public class CoinFlipperImpl implements CoinFlipper {
  
        // The unihandle reference for this object.
        private CoinFlipper myHandle;
        private String myName = null;
    
        private BigInteger myBlob = null;
        private BigInteger theX = null;
        private int theBit = -1;
  
        /**
         * Constructor.  
         * 
         */
        public CoinFlipperImpl(String theName) {
            // Set the name.
            myName = theName;
         
            // Initialize the M2MI layer.
            M2MI.initialize (1234L);
   
        /**
         * Receive the name and unihandle of a coin guessing participant.
         * 
         * @param theHandle  The unihandle for the participant.
         * @param theName       String name of the participant.
         */
        public void discoverPlayer( CoinGuesser theHandle ) {
                System.out.println( "We are been discovered by " + ((Handle)theHandle).getEoid().toString() ) ;
                System.out.println( "We have been discovered" ) ;
         
        /**
         * Receive the guess of a coin flip.
         * 
         * @param theGuess  (1 == heads, 0 == tails).
         * @param theHandle  The unihandle for the response to be sent to.
         */
        public void receiveGuess( int theGuess, CoinGuesser theHandle ) {
        }
         
        /**
         * Start a coin flipping round.  We send the blob encoding
         * of the flip result and the value x in the blob y.
         * 
         * @param theHandle  The unihandle for the participant.
         * @param theName       String name of the participant.
         */
        public void startRound(CoinGuesser theHandle, String theName, BigInteger m, BigInteger n) {
                
                // Flip the coin.
                        theBit = 0;
                        theBit = 1;
                
                // Generate the x.
            // Calculate the blob.
            myBlob = ((m.pow(theBit)).multiply(theX.pow(2))).mod(n);
                
            System.out.println("The flip = " + theBit + " the blob = " + myBlob.toString() + ".\n");
                 
            theHandle.receiveBlob(myBlob);
        }
        
        /**
         * Set the handle reference for this coin flipper
         * 
         */
        private void setReference() {
                try {
                        myHandle = (CoinFlipper) M2MI.getUnihandle ((CoinFlipper) this, CoinFlipper.class);
                }
                catch(SynthesisException se){
                        System.out.println(se.toString());
                }

        }
        
        /**
         * main method.  Creates a new coin flipper.
         * 
         * @param args[]  Array of string arguments.
         */
        public static void main(String args[]) {
           // Create the class instance. 
           
                // Set the handle reference.
                try {
                        Thread.currentThread().join();
                }
                catch(InterruptedException ie) {
                        System.out.println(ie.toString());
                }
        }