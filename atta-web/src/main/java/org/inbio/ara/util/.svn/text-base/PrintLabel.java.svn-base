/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.util;
import java.awt.print.Book;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Iterator;
import java.util.List;

/**
 * this class using the Java Print Service and added to the page elements according to the format needed to buy something.
 * @author pcorrales
 */
public class PrintLabel {

    
    /**
     * invokes the dialog box to use the Java Print Service
     */
    public void StartPrinting(List specimenData) {

        PrinterJob printJob = PrinterJob.getPrinterJob();

        Book bookPainting = new Book();

        Iterator it = specimenData.iterator();

        
        while(it.hasNext())
        {
            List listElem = (List)it.next();
            bookPainting .append(new Page(listElem),printJob.defaultPage());
        }

        //set the book with the labels
        printJob.setPageable(bookPainting);

        if (printJob.printDialog ())
        {
           try
           {
              printJob.print () ;
           }
           catch ( PrinterException e )
           {
               
           }
        }
    }
}
