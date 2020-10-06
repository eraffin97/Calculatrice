package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class VueController {

	private String a = "";
	private String b = "";
	private String op = "";
	
	@FXML
	Label resultat;
	
	public void clickMe(ActionEvent e) {
		

		
		// Bouton sur lequel l'utilisateur a cliqué
		String btnClique = e.getSource().toString();
		String value = 	btnClique.substring(btnClique.indexOf("'") +1 , btnClique.lastIndexOf("'"));
		
		if (value.matches("[0-9]")) {
			if (op.isEmpty()) {
				if (a.isEmpty()) {
					a = value;
				} else {
					a += value;
				}
				resultat.setText(a);
			} else {
				if (b.isEmpty()) {
					b = value;
				} else {
					b += value;
				}
				resultat.setText(b);
			}
		} else {
			if (value.indexOf(".") > -1) {
				if (b.isEmpty()) {
					a += value;
					resultat.setText(a);
				} else {
					b += value;
					resultat.setText(b);
				}
			} else {
				if (value.matches("=") &&  !a.isEmpty() && !op.isEmpty() && !b.isEmpty()) {
					Double op_a = new Double(a);
					Double op_b = new Double(b);
					Double result = new Double(0);
					switch (op) {
						case "+":
							result = op_a + op_b;
							break;
						case "-":
							result = op_a - op_b;
							break;
						case "÷":
							result = op_a / op_b;
							break;
						case "x":
							result = op_a * op_b;
							break;
					}
					resultat.setText(result.toString());
					a = "";
					b = "";
					op = "";
				} 
				
				else {
					if (op.isEmpty()) {
						op = value;
					}
				}
			}
			
			
			

			
		}

		}
		
			
}
