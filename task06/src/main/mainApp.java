package main;

import javax.swing.JOptionPane;

public class mainApp {
	public static void main(String[] args) {
		Ej ej = new Ej();
		int n1 = Integer.parseInt(JOptionPane.showInputDialog(
				"Ingrese 1 para ejecutar todos los ejercicios en orden" + "o 2 para elegir un ej especifico"));
		if (n1 == 1) {
			ej.ej1();
			ej.ej2();
			ej.ej3();
			ej.ej4();
			ej.ej5();
			ej.ej6();
			ej.ej7();
			ej.ej8();
			ej.ej9();
			ej.ej10();
			ej.ej11();
			ej.ej12();
		} else {
			n1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese del 1 al 12 para elegir los ejercicios"));
			switch (n1) {
			case 1:
				ej.ej1();
				break;
			case 2:
				ej.ej2();
				break;
			case 3:
				ej.ej3();
				break;
			case 4:
				ej.ej4();
				break;
			case 5:
				ej.ej5();
				break;
			case 6:
				ej.ej6();
				break;
			case 7:
				ej.ej7();
				break;
			case 8:
				ej.ej8();
				break;
			case 9:
				ej.ej9();
				break;
			case 10:
				ej.ej10();
				break;
			case 11:
				ej.ej11();
				break;
			case 12:
				ej.ej12();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Error al ingresar un ejercicio");
				break;
			}
		}
	}
}
