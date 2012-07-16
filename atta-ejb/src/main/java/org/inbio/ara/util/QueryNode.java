/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.inbio.ara.util;

import java.io.Serializable;

/**
 * This QueryNode holds data to create queries for specimen reports.
 * @author herson
 */
public class QueryNode implements Serializable {
    private String logicalOperator;
    private int logicalOperatorId;
    private String dwcElement;
    private Long dwcElementId;
    private String comparator;
    private int comparatorId;
    private String userEntry;

    public QueryNode(String logicalOperator, int logicalOperatorId,
                     String dwcElement, Long dwcElementId,
                     String comparator, int comparatorId,
                     String userEntry)
    {
        System.out.println("Entra a QueryNode");
        this.logicalOperator = logicalOperator;
        this.logicalOperatorId = logicalOperatorId;
        this.dwcElement = dwcElement;
        this.dwcElementId = dwcElementId;
        this.comparator = comparator;
        this.comparatorId = comparatorId;
        this.userEntry = userEntry;
        System.out.println("Completa de construir el QueryNode");
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
    public Long getDwcElementId() {
        return dwcElementId;
    }

    /**
     * @param dwcElementId the dwcElementId to set
     */
    public void setDwcElementId(Long dwcElementId) {
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
