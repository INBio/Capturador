/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio ( Instituto Nacional de Biodiversidad )
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

import com.sun.webui.jsf.model.Option;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asanabria
 */
public class AddRemoveList implements Serializable {

// <editor-fold defaultstate="collapsed" desc="Labels del componente">
	// Titulo del select
	private String lbTitle;
	// Label de disponibles.
	private String lbAvailable;
	// Label de selecionados
	private String lbSelected;
// </editor-fold>
	
// <editor-fold defaultstate="collapsed" desc="Listas de elementos">

	// Lista global de opciones
	private Option[] options = new Option[0];

	// lista de disponibles (lista de la izquierda).
	private Long[] leftSelected = new Long[0];
	private Option[] leftOptions = new Option[0];

	// lista de selecionados (lista de la izquierda).
	private Long[] rightSelected = new Long[0];
	private Option[] rightOptions = new Option[0];
	
// </editor-fold>

	/**
	 * Default constructor
	 */
	public AddRemoveList() {}

	/**
	 * Agrega Opciones selecionadas en la lista de disponibles a la lista de
	 * seleccionados.
	 * @return <code>null</code>
	 */
	public String addSelectedOptions() {

		Long[] selected = null;
		Option[] newSelectedOptions = null;
		Option[] newAvailableOptions = null;

		// Determino cuales fueron selecionados
		selected = leftSelected;
		
		// Tomo los selecionados y los agrego a la lista de selecionados.
		newSelectedOptions = this.intersect(this.options, selected);
		this.rightOptions = this.add(this.rightOptions, newSelectedOptions);
		
		// Elimino los selecionados de la lista de disponibles.
		newAvailableOptions = this.substract(this.leftOptions, selected);
		this.leftOptions = newAvailableOptions;

		return null;
	}

	/**
	 * Elimina las Opciones selecionadas en la lista de selecionadas y la agrega
	 * a la lista de disponibles
	 * @return <code>null</code>
	 */
	public String removeSelectedOptions() {

		Long[] selected = null;
		Option[] newSelectedOptions = null;
		Option[] newAvailableOptions = null;

		// Determino cuales fueron selecionados
		selected = rightSelected;
		
		// Tomo los selecionados y los agrego a la lista de selecionados.
		newAvailableOptions = this.intersect(this.options, selected);
		this.leftOptions = this.add(this.leftOptions, newAvailableOptions);
		
		// Elimino los selecionados de la lista de disponibles.
		newSelectedOptions = this.substract(this.rightOptions, selected);
		this.rightOptions = newSelectedOptions;

		return null;	
	}

	/**
	 * Asigna las opciones indicadas a la lista de disponibles.
	 * @param options
	 */
	public void setAvailableOptions(Option[] newAvailableOptions) {

		Long[] selected = null;
		Option[] available = null;

		//asigno la lista global de opciones
		this.options = newAvailableOptions;

		/**
		 * Elimino de la lista de disponibles las opciones que estan en
		 * la lista de selecionados.
		 */

		// Tomo las opciones selecionadas
		selected = this.getSelectedOptions();

		// Extraigo los objetos Option del arreglo global de opciones
		available = this.substract(this.options, selected);

		// asigno las opciones disponibles.
		this.leftOptions = available;
		
	}

	public Option[] getAvailableOptions() {
		return this.options;
	}

	/**
	 * Asigna las opciones indicadas a la lista de selecionados.
	 * @param options
	 */
	public void setSelectedOptions(Long[] newSelectedOptions) {
		
		Option[] selected = null;
		
		/**
		 * Elimino de la lista de selecionados las opciones que estan en
		 * la lista de disponibles.
		 */

		// Extraigo los objetos Option del arreglo global de opciones
		selected = this.intersect(this.options, newSelectedOptions);

		// Asigno a la lista de selecionados las opciones indicadas por los
		// valores del arreglo newSelectedOptions
		this.rightOptions = this.add(this.rightOptions, selected);

		// Los elimino de la izquierda
		this.leftOptions = this.substract(this.leftOptions, newSelectedOptions);
		
	}

	/**
	 * Retorna un arreglo con los valores de las opciones selecionadas.
	 * @return <code>Long[]</code>
	 */
	public Long[] getSelectedOptions(){

		int selectedLength = 0;
		List<Long> result = new ArrayList<Long>();


		if(this.rightOptions != null)
			selectedLength = this.rightOptions.length;
		
		for(int i=0; i < selectedLength; i++){
			result.add((Long)this.rightOptions[i].getValue());
		}
		
		return result.toArray(new Long[result.size()]);
	}

// <editor-fold defaultstate="collapsed" desc="Funciones de utileria">
	/**
	 * Retorna la un arreglo con la interseccion de la lista de opciones
	 * disponibles y la lista de opciones selecionadas.
	 *
	 * @param availableOptions
	 * @param selectedOptions
	 * @return <code>Option[]</code>
	 */
	private Option[] intersect(Option[] availableOptions, Long[] selectedOptions) {

		int selectedLength = 0;
		int availableLength = 0;
		Long optionValue = null;
		List<Option> result = new ArrayList<Option>();

		if(selectedOptions != null){

			availableLength = availableOptions.length;
			selectedLength = selectedOptions.length;

			for (int i = 0; i < availableLength; i++) {
				for (int j = 0; j < selectedLength; j++) {

					optionValue = (Long) availableOptions[i].getValue();

					if (optionValue.equals(selectedOptions[j])) {
						result.add(availableOptions[i]);
					}
				}
			}
		}
		return result.toArray(new Option[result.size()]);
	}

	/**
	 * Retorna la un arreglo con la resta de la lista de opciones
	 * disponibles y la lista de opciones selecionadas.
	 *
	 * @param availableOptions
	 * @param selectedOptions
	 * @return <code>Option[]</code>
	 */
	private Option[] substract(Option[] availableOptions, Long[] selectedOptions) {

		List<Option> result = new ArrayList<Option>();
		List<Option> temp = new ArrayList<Option>();


		int availableLength = availableOptions.length;
		int selectedLength = selectedOptions.length;
		Long optionValue = null;
		Long resultValue = null;

		//pasa todas las opciones a A.
		for (int i = 0; i < availableLength; i++) {
			result.add(availableOptions[i]);
		}

		for (Option current : result) {
			for (int i = 0; i < selectedLength; i++) {
				resultValue = (Long)current.getValue();
				optionValue = selectedOptions[i];
				if(resultValue.equals(optionValue))
					temp.add(current);
			}
		}

		result.removeAll(temp);

		return result.toArray(new Option[result.size()]);
	}

	/**
	 * Retorna la un arreglo con la adicion de 2 listas de opciones
	 *
	 * @param availableOptions
	 * @param selectedOptions
	 * @return <code>Option[]</code>
	 */
	private Option[] add(Option[] left, Option[] rigth) {

		List<Option> result = new ArrayList<Option>();
		
		for (int i = 0; i < left.length; i++) {
			result.add(left[i]);
		}

		for (int i = 0; i < rigth.length; i++) {
			result.add(rigth[i]);
		}

		return result.toArray(new Option[result.size()]);
	}

	// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Getters y Setters">

	public String getLbAvailable() {
		return lbAvailable;
	}

	public void setLbAvailable(String lbAvailable) {
		this.lbAvailable = lbAvailable;
	}

	public String getLbSelected() {
		return lbSelected;
	}

	public void setLbSelected(String lbSelected) {
		this.lbSelected = lbSelected;
	}

	public String getLbTitle() {
		return lbTitle;
	}

	public void setLbTitle(String lbTitle) {
		this.lbTitle = lbTitle;
	}

	public Option[] getLeftOptions() {
		return leftOptions;
	}

	public void setLeftOptions(Option[] leftOptions) {
		this.leftOptions = leftOptions;
	}

	public Long[] getLeftSelected() {
		return leftSelected;
	}

	public void setLeftSelected(Long[] leftSelected) {
		this.leftSelected = leftSelected;
	}

	public Option[] getRightOptions() {
		return rightOptions;
	}

	public void setRightOptions(Option[] rightOptions) {
		this.rightOptions = rightOptions;
	}

	public Long[] getRightSelected() {
		return rightSelected;
	}

	public void setRightSelected(Long[] rightSelected) {
		this.rightSelected = rightSelected;
	}

// </editor-fold>

}
