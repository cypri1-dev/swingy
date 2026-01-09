package com.swingy.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class HeroCreationRequest {

	@NotBlank(message = "Le nom ne peut pas être vide")
	@Size(min = 3, max = 20, message = "Le nom doit faire entre 3 et 20 caractères")
	@Pattern(regexp = "^[^|,*%={}]+$", message = "Le nom contient des caractères interdits")
	private String inputName;

	@NotBlank(message = "La classe doit être sélectionnée")
	private String selectedClass;

	public HeroCreationRequest(String inputName, String selectedClass) {
		this.inputName = inputName;
		this.selectedClass = selectedClass;
	}

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public String getSelectedClass() {
		return selectedClass;
	}

	public void setSelectedClass(String selectedClass) {
		this.selectedClass = selectedClass;
	}
}
