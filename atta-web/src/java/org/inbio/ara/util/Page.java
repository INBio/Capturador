/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.util;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;


/**
 *
 * @author pcorrales
 */
public class Page implements Printable{


   /*start positions*/
   private int x = 5;
   private int y = 5;
   
   private ImageIcon printImage = null;
   private File currentFile = null;

   private Graphics2D  g2d;

   private List elementData;


   /**
    * implementation of method print 
    * @param g
    * @param pf
    * @param page
    * @return
    */

   Page(List elementsFormat)
   {
        this.setElementData(elementsFormat);
   }


   public int print(Graphics g,PageFormat pf, int page){

            this.setG2d((Graphics2D) g);
            this.getG2d().translate(pf.getImageableX(),pf.getImageableY());  //coordenadas 0

            this.addElements();
            return (Page.PAGE_EXISTS);       
   }

   /***
    *this method to add elements to the graphis, the type of added element depends on attributes of ElementXML
    */
    public  void addElements()
    {

        Iterator it = this.getElementData().iterator();
  
        while(it.hasNext())
        {
           ElementLabelXml elem = (ElementLabelXml) it.next();

           /*if elemnet Name  equals Barcode , the elements is a imagen with a barcode */
           if(elem.getElementName().equals("Barcode"))
           {
                try
                {
                    this.createBarcodeElement(elem.getValue());
                }
                catch (BarcodeException ex)
                {
                    Logger.getLogger(Page.class.getName()).log(Level.SEVERE, null, ex);
                }      
          }
          else
          {
              this.createTextElement(elem);
          }
             this.setY(getY() +10);
      }
    }

   /**
    * add a  text in a  graphis object with a special format (font)
    * @param text
    * @param formato
    * @param x
    * @param y
    */
   public void createTextElement(ElementLabelXml  elem)
   {
             
             if(elem.getLabelSize() != null)
             {

                   if(elem.getEmLabel() != null)
                      this.getG2d().setFont(new Font ("SansSerif", Font.ITALIC,14));
                   else if( elem.getStrongLabel() != null )
                       this.getG2d().setFont(new Font ("SansSerif", Font.BOLD,14));
                   else
                       this.getG2d().setFont(new Font ("SansSerif", Font.PLAIN,14));
               }
               /*default size*/
               else
               {
                   if(elem.getEmLabel() != null )
                      this.getG2d().setFont(new Font ("SansSerif", Font.ITALIC,10));
                   else if(elem.getStrongLabel() != null)
                       this.getG2d().setFont(new Font ("SansSerif", Font.BOLD,10));
                   else
                        this.getG2d().setFont(new Font ("SansSerif", Font.PLAIN,10));
               }              
       
         this.getG2d().drawString(elem.getValue(), x, y);
   }

     /**
     * create the barcode image this  method  takes the information provided and encoded in the bar code in formta 128
     * @throws BarcodeException
     */
    public void createBarcodeElement(String catalogNumber) throws BarcodeException {

                // get a Barcode from the BarcodeFactory
		Barcode barcode = BarcodeFactory.createCode128(catalogNumber);
                barcode.setBarHeight(0);
                barcode.setBarWidth(0);
                barcode.setSize(20,70);
                barcode.setBounds(0,0,0, 0);
                barcode.getBaseline(0,0);
                barcode.setFont(new Font ("SansSerif",Font.CENTER_BASELINE,8));
                barcode.setAlignmentX(0.0f);
                barcode.setAlignmentY(0.0f);
                barcode.createImage(0, 0);
                barcode.setDrawingText(true);
                barcode.setPreferredSize(new Dimension(0,0));
        try
        {
            this.setCurrentFile(this.generatedTemporalFile("barcode","png"));
            BarcodeImageHandler.savePNG(barcode,getCurrentFile());

             BufferedImage imagen = ImageIO.read(getCurrentFile());
             this.getG2d().drawImage(imagen, null, 50, 0);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


     /**
      * 
      * @param name
      * @param extension
      * @return
      */
     public File generatedTemporalFile(String name, String extension){
        try
        {
            setCurrentFile(File.createTempFile("barcode", ".png"));


            getCurrentFile().deleteOnExit();
            getCurrentFile().setWritable(true);
        }
        catch (IOException ex)
        {
            //Logger.getLogger(LabelSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }

     return getCurrentFile();
    }


    /**
     * @return the currentFile
     */
    public File getCurrentFile() {
        return currentFile;
    }

    /**
     * @param currentFile the currentFile to set
     */
    public void setCurrentFile(File currentFile) {
        this.currentFile = currentFile;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the printImage
     */
    public ImageIcon getPrintImage() {
        return printImage;
    }

    /**
     * @param printImage the printImage to set
     */
    public void setPrintImage(ImageIcon printImage) {
        this.printImage = printImage;
    }

    /**
     * @return the g2d
     */
    public Graphics2D getG2d() {
        return g2d;
    }

    /**
     * @param g2d the g2d to set
     */
    public void setG2d(Graphics2D g2d) {
        this.g2d = g2d;
    }

    /**
     * @return the elementData
     */
    public List getElementData() {
        return elementData;
    }

    /**
     * @param elementData the elementData to set
     */
    public void setElementData(List elementData) {
        this.elementData = elementData;
    }
}
