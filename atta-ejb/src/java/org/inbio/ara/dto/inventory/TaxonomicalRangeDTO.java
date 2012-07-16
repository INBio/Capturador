/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.inventory;

import java.io.Serializable;

/**
 *
 * @author asanabria
 */
public class TaxonomicalRangeDTO   implements Serializable {

	private Long TaxonomicalRangeKey;
	private String name;

	public TaxonomicalRangeDTO() {
	}

	public TaxonomicalRangeDTO(Long TaxonomicalRangeKey, String name) {
		this.TaxonomicalRangeKey = TaxonomicalRangeKey;
		this.name = name;
	}

	public Long getTaxonomicalRangeKey() {
		return TaxonomicalRangeKey;
	}

	public void setTaxonomicalRangeKey(Long TaxonomicalRangeKey) {
		this.TaxonomicalRangeKey = TaxonomicalRangeKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
