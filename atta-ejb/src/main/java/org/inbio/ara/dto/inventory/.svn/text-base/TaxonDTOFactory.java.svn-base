/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
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


package org.inbio.ara.dto.inventory;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.taxonomy.Taxon;

/**
 *
 * @author asanabria
 */
public class TaxonDTOFactory  
        extends BaseEntityOrDTOFactory<Taxon, TaxonDTO> {

	public TaxonDTO createDTO(Taxon entity) {
		if(entity == null)
			return null;

		TaxonDTO aDTO = new TaxonDTO();

		aDTO.setTaxonKey(entity.getTaxonId());
		aDTO.setCurrentName(entity.getCurrentName());
		aDTO.setDefaultName(entity.getDefaultName());
        aDTO.setCollectionId(entity.getCollectionId());
		aDTO.setTaxonomicalRangeId(entity.getTaxonomicalRangeId());

		aDTO.setAncestorId(entity.getAncestorId());
		aDTO.setAuthorFormatParenthesis(entity.getAuthorFormatParenthesis());
		aDTO.setBasionym(entity.getBasionym());
		aDTO.setClassTaxonId(entity.getClassTaxonId());
		aDTO.setCollectionId(entity.getCollectionId());
		aDTO.setCountryId(entity.getCountryId());
		aDTO.setCurrentName(entity.getCurrentName());
		aDTO.setCurrentNameTimestamp(entity.getCurrentNameTimestamp());
		aDTO.setCurrentPredecessorTimestamp(entity.getCurrentPredecessorTimestamp());
		aDTO.setDefaultName(entity.getDefaultName());
		aDTO.setDescriptionMonth(entity.getDescriptionMonth());
		aDTO.setDescriptionYear(entity.getDescriptionYear());
		aDTO.setDominiumTaxonId(entity.getDominiumTaxonId());
		aDTO.setFamilyTaxonId(entity.getFamilyTaxonId());
		aDTO.setGenusTaxonId(entity.getGenusTaxonId());
		aDTO.setInfrakingdomTaxonId(entity.getInfrakingdomTaxonId());
		aDTO.setInfraphylumInfradivisionTaxonId(entity.getInfraphylumInfradivisionTaxonId());
		aDTO.setKingdomTaxonId(entity.getKingdomTaxonId());
		aDTO.setOrderTaxonId(entity.getOrderTaxonId());
		aDTO.setPhylumDivisionTaxonId(entity.getPhylumDivisionTaxonId());
		aDTO.setSectionTaxonId(entity.getSectionTaxonId());
		aDTO.setSpeciesTaxonId(entity.getSpeciesTaxonId());
		aDTO.setStirpsTaxonId(entity.getStirpsTaxonId());
		aDTO.setSubclassTaxonId(entity.getSubclassTaxonId());
		aDTO.setSubfamilyTaxonId(entity.getSubfamilyTaxonId());
		aDTO.setSubgenusTaxonId(entity.getSubgenusTaxonId());
		aDTO.setSubkingdomTaxonId(entity.getSubkingdomTaxonId());
		aDTO.setSuborderTaxonId(entity.getSuborderTaxonId());
		aDTO.setSubphylumSubdivisionTaxonId(entity.getSubphylumSubdivisionTaxonId());
		aDTO.setSubsectionTaxonId(entity.getSubsectionTaxonId());
		aDTO.setSubspeciesTaxonId(entity.getSubspeciesTaxonId());
		aDTO.setSubtribeTaxonId(entity.getSubtribeTaxonId());
		aDTO.setSuperclassTaxonId(entity.getSuperclassTaxonId());
		aDTO.setSuperfamilyTaxonId(entity.getSuperfamilyTaxonId());
		aDTO.setSuperorderTaxonId(entity.getSuperorderTaxonId());
		aDTO.setSuperphylumTaxonId(entity.getSuperphylumTaxonId());
		aDTO.setSynonymTaxonId(entity.getSynonymTaxonId());
		aDTO.setTaxonCategoryId(entity.getTaxonCategoryId());
		aDTO.setTribeTaxonId(entity.getTribeTaxonId());
		aDTO.setVarietyTaxonId(entity.getVarietyTaxonId());

		return aDTO;
	}

    @Override
    public Taxon getEntityWithPlainValues(TaxonDTO aDTO) {
        if(aDTO == null) return null;

		Taxon newTaxon = new Taxon();

		newTaxon.setTaxonId(aDTO.getTaxonKey());
		newTaxon.setCurrentName(aDTO.getCurrentName());
		newTaxon.setDefaultName(aDTO.getDefaultName());
        newTaxon.setCollectionId(aDTO.getCollectionId());
		newTaxon.setTaxonomicalRangeId(aDTO.getTaxonomicalRangeId());

		newTaxon.setAncestorId(aDTO.getAncestorId());
		newTaxon.setAuthorFormatParenthesis(aDTO.getAuthorFormatParenthesis());
		newTaxon.setBasionym(aDTO.getBasionym());
		newTaxon.setClassTaxonId(aDTO.getClassTaxonId());
		newTaxon.setCollectionId(aDTO.getCollectionId());
		newTaxon.setCountryId(aDTO.getCountryId());
		newTaxon.setCurrentName(aDTO.getCurrentName());
		newTaxon.setCurrentNameTimestamp(aDTO.getCurrentNameTimestamp());
		newTaxon.setCurrentPredecessorTimestamp(aDTO.getCurrentPredecessorTimestamp());
		newTaxon.setDefaultName(aDTO.getDefaultName());
		newTaxon.setDescriptionMonth(aDTO.getDescriptionMonth());
		newTaxon.setDescriptionYear(aDTO.getDescriptionYear());
		newTaxon.setDominiumTaxonId(aDTO.getDominiumTaxonId());
		newTaxon.setFamilyTaxonId(aDTO.getFamilyTaxonId());
		newTaxon.setGenusTaxonId(aDTO.getGenusTaxonId());
		newTaxon.setInfrakingdomTaxonId(aDTO.getInfrakingdomTaxonId());
		newTaxon.setInfraphylumInfradivisionTaxonId(aDTO.getInfraphylumInfradivisionTaxonId());
		newTaxon.setKingdomTaxonId(aDTO.getKingdomTaxonId());
		newTaxon.setOrderTaxonId(aDTO.getOrderTaxonId());
		newTaxon.setPhylumDivisionTaxonId(aDTO.getPhylumDivisionTaxonId());
		newTaxon.setSectionTaxonId(aDTO.getSectionTaxonId());
		newTaxon.setSpeciesTaxonId(aDTO.getSpeciesTaxonId());
		newTaxon.setStirpsTaxonId(aDTO.getStirpsTaxonId());
		newTaxon.setSubclassTaxonId(aDTO.getSubclassTaxonId());
		newTaxon.setSubfamilyTaxonId(aDTO.getSubfamilyTaxonId());
		newTaxon.setSubgenusTaxonId(aDTO.getSubgenusTaxonId());
		newTaxon.setSubkingdomTaxonId(aDTO.getSubkingdomTaxonId());
		newTaxon.setSuborderTaxonId(aDTO.getSuborderTaxonId());
		newTaxon.setSubphylumSubdivisionTaxonId(aDTO.getSubphylumSubdivisionTaxonId());
		newTaxon.setSubsectionTaxonId(aDTO.getSubsectionTaxonId());
		newTaxon.setSubspeciesTaxonId(aDTO.getSubspeciesTaxonId());
		newTaxon.setSubtribeTaxonId(aDTO.getSubtribeTaxonId());
		newTaxon.setSuperclassTaxonId(aDTO.getSuperclassTaxonId());
		newTaxon.setSuperfamilyTaxonId(aDTO.getSuperfamilyTaxonId());
		newTaxon.setSuperorderTaxonId(aDTO.getSuperorderTaxonId());
		newTaxon.setSuperphylumTaxonId(aDTO.getSuperphylumTaxonId());
		newTaxon.setSynonymTaxonId(aDTO.getSynonymTaxonId());
		newTaxon.setTaxonCategoryId(aDTO.getTaxonCategoryId());
		newTaxon.setTribeTaxonId(aDTO.getTribeTaxonId());
		newTaxon.setVarietyTaxonId(aDTO.getVarietyTaxonId());

        return newTaxon;
    }

    @Override
    public Taxon updateEntityWithPlainValues(TaxonDTO aDTO, Taxon entity) {
        if(aDTO == null || entity == null) return null;

		entity.setTaxonId(aDTO.getTaxonKey());
		entity.setCurrentName(aDTO.getCurrentName());
		entity.setDefaultName(aDTO.getDefaultName());
        entity.setCollectionId(aDTO.getCollectionId());
		entity.setTaxonomicalRangeId(aDTO.getTaxonomicalRangeId());

		entity.setAncestorId(aDTO.getAncestorId());
		entity.setAuthorFormatParenthesis(aDTO.getAuthorFormatParenthesis());
		entity.setBasionym(aDTO.getBasionym());
		entity.setClassTaxonId(aDTO.getClassTaxonId());
		entity.setCollectionId(aDTO.getCollectionId());
		entity.setCountryId(aDTO.getCountryId());
		entity.setCurrentName(aDTO.getCurrentName());
		entity.setCurrentNameTimestamp(aDTO.getCurrentNameTimestamp());
		entity.setCurrentPredecessorTimestamp(aDTO.getCurrentPredecessorTimestamp());
		entity.setDefaultName(aDTO.getDefaultName());
		entity.setDescriptionMonth(aDTO.getDescriptionMonth());
		entity.setDescriptionYear(aDTO.getDescriptionYear());
		entity.setDominiumTaxonId(aDTO.getDominiumTaxonId());
		entity.setFamilyTaxonId(aDTO.getFamilyTaxonId());
		entity.setGenusTaxonId(aDTO.getGenusTaxonId());
		entity.setInfrakingdomTaxonId(aDTO.getInfrakingdomTaxonId());
		entity.setInfraphylumInfradivisionTaxonId(aDTO.getInfraphylumInfradivisionTaxonId());
		entity.setKingdomTaxonId(aDTO.getKingdomTaxonId());
		entity.setOrderTaxonId(aDTO.getOrderTaxonId());
		entity.setPhylumDivisionTaxonId(aDTO.getPhylumDivisionTaxonId());
		entity.setSectionTaxonId(aDTO.getSectionTaxonId());
		entity.setSpeciesTaxonId(aDTO.getSpeciesTaxonId());
		entity.setStirpsTaxonId(aDTO.getStirpsTaxonId());
		entity.setSubclassTaxonId(aDTO.getSubclassTaxonId());
		entity.setSubfamilyTaxonId(aDTO.getSubfamilyTaxonId());
		entity.setSubgenusTaxonId(aDTO.getSubgenusTaxonId());
		entity.setSubkingdomTaxonId(aDTO.getSubkingdomTaxonId());
		entity.setSuborderTaxonId(aDTO.getSuborderTaxonId());
		entity.setSubphylumSubdivisionTaxonId(aDTO.getSubphylumSubdivisionTaxonId());
		entity.setSubsectionTaxonId(aDTO.getSubsectionTaxonId());
		entity.setSubspeciesTaxonId(aDTO.getSubspeciesTaxonId());
		entity.setSubtribeTaxonId(aDTO.getSubtribeTaxonId());
		entity.setSuperclassTaxonId(aDTO.getSuperclassTaxonId());
		entity.setSuperfamilyTaxonId(aDTO.getSuperfamilyTaxonId());
		entity.setSuperorderTaxonId(aDTO.getSuperorderTaxonId());
		entity.setSuperphylumTaxonId(aDTO.getSuperphylumTaxonId());
		entity.setSynonymTaxonId(aDTO.getSynonymTaxonId());
		entity.setTaxonCategoryId(aDTO.getTaxonCategoryId());
		entity.setTribeTaxonId(aDTO.getTribeTaxonId());
		entity.setVarietyTaxonId(aDTO.getVarietyTaxonId());

        return entity;
    }
}
