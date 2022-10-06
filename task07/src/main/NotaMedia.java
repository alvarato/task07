package main;

import java.util.Hashtable;
import javax.swing.JOptionPane;

public class NotaMedia {

	public void app() {
		JOptionPane.showMessageDialog(null, "App Nota Media");
		boolean flag;
		Hashtable<String, Double> listAlumn = new Hashtable<>();
		int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de notas por alumno"));
		// bucle que solicita el nombre del alumno y las notas;
		// asigna el nombre y el promedio al alumno y pregunta si desea ingresar otro
		// alumno o continuar
		do {
			String name = (JOptionPane.showInputDialog("Ingrese el nombre del alumno"));
			double promedio = 0;
			for (int i = 0; i < n; i++) {
				promedio += Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota nº" + (i + 1)));
			}
			listAlumn.put(name, (promedio / n));
			int n2 = Integer.parseInt(
					JOptionPane.showInputDialog("Ingrese 1 para ingresar otro y alumno 2 para ver los promedios"));
			flag = (n2 == 1) ? true : false;
		} while (flag);
		JOptionPane.showMessageDialog(null, listAlumn.toString());
	}

}
