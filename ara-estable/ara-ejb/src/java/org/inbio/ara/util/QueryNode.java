/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.util;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * This QueryNode holds data to create queries for specimen reports.
 * @author herson
 */
public class QueryNode implements Serializable {
    private String logicalOperator;
    private int logicalOperatorId;
    private String dwcElement;
    private BigDecimal dwcElementId;
    private String comparator;
    private int comparatorId;
    private String userEntry;

    public QueryNode(String logicalOperator, int logicalOperatorId,
                     String dwcElement, BigDecimal dwcElementId,
                     String comparator, int comparatorId,
                     String userEntry)
    {
        this.logicalOperator = logicalOperator;
        this.logicalOperatorId = logicalOperatorId;
        this.dwcElement = dwcElement;
        this.dwcElementId = dwcElementId;
        this.comparator = comparator;
        this.comparatorId = comparatorId;
        this.userEntry = userEntry;
    }

    public QueryNode(String logicalOperator, String dwcElement,
                     String comparator, String userEntry)
    {
        this.logicalOperator = logicalOperator;
        this.dwcElement = dwcElement;
        this.comparator = comparator;
        this.userEntry = userEntry;
    }

    /**
     * @return the logicalOperator
     */
    public String getLogicalOperator() {
        return logicalOperator;
    }

    /**
     * @param logicalOperator the logicalOperator to set
     */
    public void setLogicalOperator(String logicalOperator) {
        this.logicalOperator = logicalOperator;
    }

    /**
     * @return the dwcElement
     */
    public String getDwcElement() {
        return dwcElement;
    }

    /**
     * @param dwcElement the dwcElement to set
     */
    public void setDwcElement(String dwcElement) {
        this.dwcElement = dwcElement;
    }

    /**
     * @return the comparator
     */
    public String getComparator() {
        return comparator;
    }

    /**
     * @param comparator the comparator to set
     */
    public void setComparator(String comparator) {
        this.comparator = comparator;
    }

    /**
     * @return the userEntry
     */
    public String getUserEntry() {
        return userEntry;
    }

    /**
     * @param userEntry the userEntry to set
     */
    public void setUserEntry(String userEntry) {
        this.userEntry = userEntry;
    }

    public void printNode() {
        String st = "";
        if(this.logicalOperator != null)
            st += this.logicalOperator;
        if(this.dwcElement != null)
            st += this.dwcElement;
        if(this.comparator != null)
            st += this.comparator;
        if(this.userEntry != null)
            st += this.userEntry;
        System.out.println(st);
    }

    /**
     * @return the logicalOperatorId
     */
    public int getLogicalOperatorId() {
        return logicalOperatorId;
    }

    /**
     * @param logicalOperatorId the logicalOperatorId to set
     */
    public void setLogicalOperatorId(int logicalOperatorId) {
        this.logicalOperatorId = logicalOperatorId;
    }

    /**
     * @return the dwcElementId
     */
    public BigDecimal getDwcElementId() {
        return dwcElementId;
    }

    /**
     * @param dwcElementId the dwcElementId to set
     */
    public void setDwcElementId(BigDecimal dwcElementId) {
        this.dwcElementId = dwcElementId;
    }

    /**
     * @return the comparatorId
     */
    public int getComparatorId() {
        return comparatorId;
    }

    /**
     * @param comparatorId the comparatorId to set
     */
    public void setComparatorId(int comparatorId) {
        this.comparatorId = comparatorId;
    }
}
