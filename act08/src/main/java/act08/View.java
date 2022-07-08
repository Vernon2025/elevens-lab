package act08;

import com.mrjaffesclass.apcs.messenger.*;
import javax.swing.JLabel;

public class View extends javax.swing.JFrame implements MessageHandler {

  private final Messenger mvcMessaging;
  
  private final JLabel[] cards;
  
  /**
   * Creates a new view
   * @param messages mvcMessaging object
   */
  public View(Messenger messages) {
    mvcMessaging = messages;   // Save the calling controller instance
    initComponents();           // Create and init the GUI components
    cards = new JLabel[9];
  }
  
  /**
   * Initialize the model here and subscribe
   * to any required messages
   */
  public void init() {
    // Subscribe to messages here
    mvcMessaging.subscribe("model:selectedCardsChanged", this);
    mvcMessaging.subscribe("model:isLegalMove", this);
    mvcMessaging.subscribe("model:boardChanged", this);
    mvcMessaging.subscribe("model:cardsLeftInDeck", this);
    mvcMessaging.subscribe("model:gamesWon", this);
    mvcMessaging.subscribe("model:gamesPlayed", this);
    mvcMessaging.subscribe("model:gameStatus", this);    
  }
  
  /**
   * The model must implement messageHandler so the Model can process
   * messages sent from the View.  messagePayload can be any object, but
   * it must be cast into the expected class.
   * @param messageName
   * @param messagePayload 
   */
  @Override
  public void messageHandler(String messageName, Object messagePayload) {
    switch(messageName) {
            
      default: {
        
      }
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    canvas1 = new java.awt.Canvas();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(271, 271, 271)
        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(238, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(501, Short.MAX_VALUE)
        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
   * Handler for the up button for field 1
   * @param evt 
   */
  /**
   * @param args the command line arguments
   */

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private java.awt.Canvas canvas1;
  // End of variables declaration//GEN-END:variables
}
