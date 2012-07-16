/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Naciona de Biodiversidad)
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
/*
 * DynamicPanelForm.java
 *
 * Created on 1 de agosto de 2007, 04:39 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package org.inbio.ara.guimanagers;

import com.sun.webui.jsf.component.AddRemove;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.HiddenField;
import com.sun.webui.jsf.component.Hyperlink;
import com.sun.webui.jsf.model.Option;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectManyCheckbox;
import javax.faces.component.html.HtmlSelectManyListbox;
import javax.faces.component.html.HtmlSelectOneListbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.component.html.HtmlSelectOneRadio;
import javax.faces.context.FacesContext;

/**
 * Panel con los componentes del formulario que se crea dinamicamente basado en
 * la codificacion de componentes (Identificadores) y las propiedades que se
 * desean asignar a dichos componentes
 * @author herson
 */
public class DynamicPanelForm {

	private HtmlPanelGrid panel;
	private Option[] referenceOption;
	private Long[] selectedReference;

	/** Creates a new instance of DynamicPanelForm */
	public DynamicPanelForm() {
	}
	HtmlSelectManyListbox list = new HtmlSelectManyListbox();

	/**
	 * Retorna el panel con el formulario apropiado.
	 * El jsp debe tener un enlace (binding) con este metodo para que cargue el
	 * formulario
	 * @return HtmlPanelGrid
	 */
	public HtmlPanelGrid getPanel() {
		if (panel == null) {
			Application ap = FacesContext.getCurrentInstance().getApplication();
			panel = (HtmlPanelGrid) ap.createComponent(HtmlPanelGrid.COMPONENT_TYPE);
		}
		return panel;
	}

	public void setPanel(HtmlPanelGrid panel) {
		this.panel = panel;
	}

	public void setPanelProperties(HashMap properties) {
		Iterator it = properties.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			this.panel.getAttributes().put(key, properties.get(key));
		}
	}

	/**
	 * Integra los componentes del formulario al panel que sera presentado en el jsp.
	 * @param dataTypeId Id numerico que indica el numero de componente segun el Id de la BD
	 * @param args HashMap con las propiedades que se le asignaran al componente
	 */
	public void setComponent(Long dataTypeId, HashMap args) {
		if (panel != null) {
			Set keys = args.keySet();
			Iterator it = keys.iterator();
			UIComponent finalComponent = null;
			try {
				//Se asignan las propiedades del componente
				//No funciona el metodo putAll() que seria la mejor forma de
				//asignar las propiedades:
				//component.getAttributes().putAll(args);
				while (it.hasNext()) {
					String key = (String) it.next();
					if (dataTypeId == 6L) {
						// Componente textarea
						HtmlInputTextarea component = new HtmlInputTextarea();
						component.setCols(60);
						component.setRows(8);
						component.setStyle("font-family: Arial, Helvetica,sans-serif; font-size: 12px;width: 100%;");
						component.getAttributes().put(key, args.get(key));
						finalComponent = component;
					} else {
						if (dataTypeId == 15L) {
							// Componente ListBox con múltiple selección
							AddRemove addremove = new AddRemove();
							addremove.setId("ar_TaxonDescriptionRecordReference");
							addremove.setItems(this.referenceOption);
							addremove.setSelected(this.selectedReference);
							finalComponent = addremove;
						} else {
							// Todos los demas                            
							UIComponent component = this.createComponent(dataTypeId);
							component.getAttributes().put(key, args.get(key));
							finalComponent = component;
						}
					}
				}
				panel.getChildren().add(finalComponent);
			} catch (Exception e) {
				System.err.println("setComponent: " + e.getMessage());
			}
		}
	}

	/**
	 * Este metodo es apropiado para componentes que tienen interdependencia con
	 * otros componentes, como es el caso de las listas de seleccion que
	 * requieren de otro objeto (UISelectIntems) para mostrar las opciones.
	 * @param TypeIdCont Id del tipo de componente "contenedor"
	 * @param argsCont HashMap con las propiedades del objeto "contenedor"
	 * @param TypeIdChild Id del tipo de componente "contenido"
	 * @param argsChild HashMap con las propiedades del objeto "contenido"
	 */
	public void setComponent(Long TypeIdCont, HashMap argsCont,
			Long TypeIdChild, HashMap argsChild) {
		if (panel != null) {
			UIComponent componentChild = this.createComponent(TypeIdChild);
			UIComponent componentCont = this.createComponent(TypeIdCont);
			Set keys = argsCont.keySet();
			Iterator it = keys.iterator();

			//Se asignan las propiedades del componente
			//No funciona el metodo putAll() que seria la mejor forma de
			//asignar las propiedades:
			//component.getAttributes().putAll(args);
			while (it.hasNext()) {
				String key = (String) it.next();
				componentCont.getAttributes().put(key, argsCont.get(key));
			}

			((UISelectItems) componentChild).setValue(argsChild);
			try {
				componentCont.getChildren().add(componentChild);
				panel.getChildren().add(componentCont);
			} catch (Exception e) {
				System.err.println(e.toString());
			}
		}
	}

	/**
	 * Crea un componente de formulario que sera utilizado en el panel
	 * @param dataTypeId Id del componente que debe ser creado
	 * @return El tipo generico UIComponent del componente seleccionado
	 */
	private UIComponent createComponent(Long dataTypeId) {
		Application ap;
		ap = FacesContext.getCurrentInstance().getApplication();
		switch (dataTypeId.intValue()) {
			/*
			 * Estos casos son de componentes dependietes de UISelectItems (1)
			 * Impares
			 */
			case 1:
				return (UISelectItems) ap.createComponent(UISelectItems.COMPONENT_TYPE);
			case 3:
            {
                 HtmlSelectOneListbox aux = (HtmlSelectOneListbox) ap.createComponent
                         (HtmlSelectOneListbox.COMPONENT_TYPE);
                 aux.setRequired(true);
                 aux.setStyle("width:300px;height:120px;");
                return aux;
            }
			case 5:
            {
                HtmlSelectOneMenu aux =  (HtmlSelectOneMenu) ap.createComponent
                        (HtmlSelectOneMenu.COMPONENT_TYPE);
                aux.setRequired(true);
                aux.setStyle("width:300px;height:120px;");
                return aux;
            }
			case 7:
				return (HtmlSelectOneRadio) ap.createComponent
                        (HtmlSelectOneRadio.COMPONENT_TYPE);
			case 9:
				return (HtmlSelectManyListbox) ap.createComponent
                        (HtmlSelectManyListbox.COMPONENT_TYPE);
			case 11:
				return (HtmlSelectManyCheckbox) ap.createComponent
                        (HtmlSelectManyCheckbox.COMPONENT_TYPE);
			case 15:
				return (AddRemove) ap.createComponent
                        (AddRemove.COMPONENT_TYPE);
			/*
			 * Estos casos son de componentes independietes
			 * Pares
			 */
			case 0: 
                return  (HtmlOutputText) ap.createComponent
                    (HtmlOutputText.COMPONENT_TYPE);
			case 2:
				return (HtmlInputText) ap.createComponent
                        (HtmlInputText.COMPONENT_TYPE);
			case 4: 
                return (HtmlSelectBooleanCheckbox) ap.createComponent
                    (HtmlSelectBooleanCheckbox.COMPONENT_TYPE);
			case 6:
				return (HtmlInputTextarea) ap.createComponent
                        (HtmlInputTextarea.COMPONENT_TYPE);
			case 8:
				return (HtmlCommandButton) ap.createComponent
                        (HtmlCommandButton.COMPONENT_TYPE);
			case 10:
				return new Calendar();
			case 12:
				return new HiddenField();
			case 14:
				return new Hyperlink();
			default:
				return null;
		}
	}

	public Option[] getReferenceOption() {
		return referenceOption;
	}

	public void setReferenceOption(Option[] referenceOption) {
		this.referenceOption = referenceOption;
	}

	public Long[] getSelectedReference() {
		return selectedReference;
	}

	public void setSelectedReference(Long[] selectedReference) {
		this.selectedReference = selectedReference;
	}
}
