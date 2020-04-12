//**********************
//Group D
//MiddleManCoinFlipperImpl
//**********************

import java.io.*;
import edu.rit.m2mi.M2MI;
import edu.rit.m2mi.SynthesisException;

import java.util.Random;
import edu.rit.m2mi.Unihandle;

/**
 * CoinServer waits to play coin guessing games
 * with a CoinClient.
 *
 * @authors  Jeremy Balmos, Shawn Chasse, Eric Ferguson, Jeremy Dahlgren.
 */
  
	// The unihandle reference for this object.
	private Unihandle myHandle;
	private String myName = null;
    
	private Hashtable playerSet = null;
	private String myFlipper = null;
	
	private BigInteger myBlob = null;
	/**
	 * Constructor.  
	 * 
	 */
	public MiddleManCoinFlipperImpl(String theName) {
	    // Set the name.
	    myName = theName;
	 
	    // Initialize the M2MI layer.
	    M2MI.initialize (1234L);
		 playerSet = new Hashtable();
	}
   
	/**
	 * Receive the name and unihandle of a coin guessing participant.
	 * 
	 * @param theHandle  The unihandle for the participant.
	 * @param theName	String name of the participant.
	 */
	public void discoverPlayer( CoinGuesser theHandle ) {
	}
	 
	/**
	 * Receive the guess of a coin flip.
	 * 
	 * @param theGuess  (1 == heads, 0 == tails).
	 * @param theHandle  The unihandle for the response to be sent to.
	 */
	public void receiveGuess( int theGuess, CoinGuesser theHandle ) {
		myFlipperHandle.receiveGuess( theGuess, myHandle1 );
	}
	 
	/**
	 * Start a coin flipping round.  We send the blob encoding
	 * of the flip result and the value x in the blob y.
	 * 
	 * @param theHandle  The unihandle for the participant.
	 * @param theName	String name of the participant.
	 */
	public void startRound(CoinGuesser theHandle, String theName, BigInteger m, BigInteger n) {
		
		try {			
			
			allFlippers.discoverPlayer((CoinGuesser) myHandle);
			
	    }
	    catch(SynthesisException se){
			System.out.print( se.toString() );
	    }
			 // do nothing, we are blocking.
				Thread.currentThread().sleep(1);
			 }
			 catch( InterruptedException IE )
			 {
				System.out.print( IE.toString() );
			 }
		
	}
	
	/**
	 * Set the handle reference for this coin flipper
	 * 
	 */
	private void setReference() {
		try {
			myHandle = M2MI.getUnihandle(this, classes);
		}
		catch(SynthesisException se){
			System.out.println(se.toString());
		}
		catch(Exception e) {
			System.out.println(e.toString());	
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
	
	 
	/**
	* Discover a new player.  A unihandle and name will be given
	* as arguments.
	* 
	* @param theHandle  The unihandle for the discovered player.
	* @param theName  The string name of the player
	*/
	public void presentPlayer(CoinFlipper theHandle, String theName) {
		System.out.println( "presentPlayer(... beginning ...)" ) ;
		{
					System.out.println( "presentPlayer(... the name is not me ...) Name = " + theName ) ;
			if(!playerSet.contains(theHandle)) {
				  playerSet.put(theName, theHandle);
				  myFlipper = theName;
			}
	}
	
	/**
	* Receive the blob encoding
	* of the flip result and the value x in the blob y.
	* 
	* @param theBlob  The encoded x and bit values ('y' == theBlob).
	*/
	public void receiveBlob( BigInteger theBlob ) {
		myBlob = theBlob;		
		String input = null;
		
	    theGuesser.receiveBlob(myBlob);
		
	}
	
	/**
	* Receive the answer and the x encoding value.  This will 
	* allow the guesser to verify that the result is true.
	* 
	* @param flipResult  The actual coin flip result.
	* @param x  The x encoding value.
	*/
	public void receiveResult( int flipResult, BigInteger x) {
		String result = null;
		String verified = null;
		
		// Send back the actual result and the x value used.
	}