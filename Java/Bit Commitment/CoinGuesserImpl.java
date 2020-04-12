//**********************
//Group D
//CoinGuesserImpl
//**********************

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import edu.rit.m2mi.M2MI;
import edu.rit.m2mi.SynthesisException;
import edu.rit.m2mi.Handle ;

 * CoinGuesserImpl allows the user to pick a coin flipper
 * and guess the outcome.
 *
 * @authors  Jeremy Balmos, Shawn Chasse, Eric Ferguson, Jeremy Dahlgren.
 */
public class CoinGuesserImpl extends JFrame implements 
    ActionListener, CoinGuesser {
  
    // GUI components.
    JPanel contentPane;
    JPanel eventPanel;
    JPanel textAreaButtonPanel;
    JScrollPane textPane;
    JTextArea eventArea;
    JButton clearArea;
    JButton saveArea;
    int counter = 1;
  
    // Frames for setting up reports.
    playerFrame myPlayerFrame;
  
    // The unihandle reference for this object.
    CoinGuesser myHandle;
    String myName = null;
  
    // Menus used.
    JMenuBar jMenuBar1 = new JMenuBar();
    JMenu jMenuFile = new JMenu("File");
    JMenuItem jMenuFileExit = new JMenuItem("Exit");
    JMenu JMenuGame = new JMenu("New Game");
    JMenuItem pickPlayer = new JMenuItem("Pick Player");	
  
    CoinFlipper theFlipper = null;
    String theFlipperName = null;
  
    BigInteger myBlob = null;
	 Random theGenerator = null;
	 
    BigInteger p = null;
    BigInteger q = null;
	 int bitLength = 512;
    BigInteger n = null;
    BigInteger m = null;
  
/**
 * Constructor.  Sets up frame components and initializes the M2MI layer.
 * 
 */
public CoinGuesserImpl(String theName) {
	contentPane = (JPanel) this.getContentPane();
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	contentPane.setLayout(new BorderLayout());
	this.setTitle("Coin Flipper");
	this.setJMenuBar(jMenuBar1);
	this.setSize(new Dimension(600, 600));
	generateNums();	 
	// Set the name.
	myName = theName;
	  
	// Add the action listeners for the menus.
	jMenuFileExit.addActionListener(this);
	jMenuFile.add(jMenuFileExit);
		 
	// Add action listeners for the menu choices.
	pickPlayer.addActionListener(this);
		 
	// Finish the menu setup.
	JMenuGame.add(pickPlayer);
	jMenuBar1.add(jMenuFile);
	jMenuBar1.add(JMenuGame);
		 
	// Set up the event panel.
	eventPanel = new JPanel();
	eventPanel.setBorder(BorderFactory.createCompoundBorder(
	  						BorderFactory.createTitledBorder("Game Summaries"),
	  						BorderFactory.createEmptyBorder(5,5,5,5)));
	eventPanel.setLayout(new BorderLayout());
		 
	// Set up the text area and put it in a scroll pane.
	eventArea = new JTextArea(20, 40);
	textPane = new JScrollPane(eventArea);
		 
	// Button to clear the text area.
	clearArea = new JButton("Clear TextArea");
	clearArea.addActionListener(this);
		 
	// Add the text area and button panel to the event panel.
	eventPanel.add(clearArea, "South");
	eventPanel.add(textPane, "Center");
		 
	// Add the event panel to the main panel.
	contentPane.add(eventPanel, "Center");
		 
	// Setup the frames used for setting up specific reports.
	myPlayerFrame = new playerFrame("Choose Player");
		 
	// Initialize the M2MI layer.
	M2MI.initialize (1234L);	 
	// Make this frame visible.
	contentPane.setVisible(true);
}
  
    /**
     * actionPerformed.  Processes a GUI event.
     *
     * @param e  The ActionEvent.  
     */
    public void actionPerformed(ActionEvent e) {
	// Exit the system.
	if(e.getSource() == jMenuFileExit) {
	    System.exit(0);
	}
	  
	// Start up a new game and pick a player.
	if(e.getSource() == pickPlayer) {
	    try {			
			allFlippers.discoverPlayer(myHandle);
			myPlayerFrame.reset();
			myPlayerFrame.setVisible(true);
	    }
	    catch(SynthesisException se){
		eventArea.setText(se.toString());
	    }
	}
	  
	// Clear the text area.
	if(e.getSource() == clearArea) {
	    eventArea.setText("");  
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
		myPlayerFrame.addPlayer(theHandle, theName);
		System.out.println( "presentPlayer() end" ) ;
	
	* Generate new p and q values.
	* 
	*/
	public void generateNums() {
		theGenerator.setSeed(System.currentTimeMillis());
		//theGenerator.setSeed(System.currentTimeMillis());
		
	}
	
	public BigInteger getM() {
		return m;	
	}
	
	public BigInteger getN() {
		return n;	
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
					
		Object[] options = {"Heads", "Tails"};

		int n = JOptionPane.showOptionDialog(this,
			"What is your guess?",
			"Coin Guess",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,
			options,
			options[0]);
					
		if (n == 0) input = "Heads";
		else input = "Tails";
		
		print("Telling " + theFlipperName + " the guess is " + input + ".\n");
		theFlipper.receiveGuess(n, myHandle);
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
		
		if (flipResult == 0) result = "Heads";
		else result = "Tails";
				 
		if(myBlob.equals((((m.pow(flipResult)).multiply(x.pow(2))).mod(n))))
			verified = "verified";
		else
			verified = "not verified";
				 
		print("The flip result was " + result + " and " + theFlipperName +
			" was " + verified + ".\n");
		
	}
	 
	/**
	* Add this event to the event text field.
	* 
	* @param s  The String representing the event monitored.
	*/
	private void print(String s) {
		eventArea.setText(counter++ + " " + s + "\n" + eventArea.getText());
	}
  
	/**
	* Set the selected player.
	* 
	* @param theHandle  The selected player handle.
	*/
	public void setPlayer( CoinFlipper theHandle, String theName) {
		theFlipper = theHandle;
		theFlipperName = theName;
	}
	
	/**
	* Set the handle reference for this monitor object.  Also sets the references
	* for the frames used in the GUI.
	* 
	*/
	private void setReference() {
		try {
			myHandle = (CoinGuesser) M2MI.getUnihandle ((CoinGuesser) this, CoinGuesser.class);
			myPlayerFrame.setReference(this, myHandle, myName);
		}
		catch(SynthesisException se){
			System.out.println(se.toString());
		}

	}
	
	/**
	* main method.  Creates a new frame instance and sets it to visible.
	* 
	* @param args[]  Array of string arguments.
	*/
		CoinGuesserImpl c = new CoinGuesserImpl(args[0]);
		
		c.pack();
		c.setVisible(true);
	}
}