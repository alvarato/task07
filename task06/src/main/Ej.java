package main;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Ej {
	public double ej1() {
		JOptionPane.showMessageDialog(null, "Ejercicio 1");
		int n1 = Integer
				.parseInt(JOptionPane.showInputDialog("Ingrese un número para elegir el elemento a calcular el area"
						+ " 1 = circulo || 2 = cuadrado || 3 = triangulo"));
		Double respuesta;
		if (n1 == 1) {
			Double radio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el radio"));
			respuesta = (Math.pow(radio, 2) * Math.PI);
			JOptionPane.showMessageDialog(null, "area del circulo: " + respuesta);
		} else if (n1 == 2) {
			Double lado1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese un lado"));
			respuesta = (lado1 * lado1);
			JOptionPane.showMessageDialog(null, "area del cuadrado: " + respuesta);
		} else {
			Double base = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la base"));
			Double altura = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la altura"));
			respuesta = (base * altura) / 2;
			JOptionPane.showMessageDialog(null, "area del triangulo: " + respuesta);
		}
		return respuesta;
	}

	public int ej2() {
		JOptionPane.showMessageDialog(null, "Ejercicio 2");
		int cantidad = Integer.parseInt(
				JOptionPane.showInputDialog("Ingrese la cantidad " + "de números alertorios que desea que se generen"));
		int max = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el máximo"));
		int min = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mínimo"));
		int r = 0;
		String total = "";
		for (int i = 0; i < cantidad; i++) {
			r = (int) ((Math.random() * (max - min)) + min);
			total += " - " + r;
		}
		JOptionPane.showMessageDialog(null, "Lo números aletorios salidos son: " + total);
		return r;
	}

	// metodo que recibe un max y un min para obtener un número random;
	public int random(int max, int min) {
		return (int) Math.random() * (max - min + 1) + min;
	}

	public boolean ej3() {
		JOptionPane.showMessageDialog(null, "Ejercicio 3");
		int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número"));
		if (n == 0 || n == 1 || n == 2) {
			JOptionPane.showMessageDialog(null, "El no número es primo: " + false);
			return false;
		}
		for (int i = 2; i < n / 2; i++) {
			if (n % i == 0) {
				JOptionPane.showMessageDialog(null, "El no número es primo: " + false);
				return false;
			}

		}
		JOptionPane.showMessageDialog(null, "El número es primo: " + true);
		return true;

	}

	public int ej4() {
		JOptionPane.showMessageDialog(null, "Ejercicio 4");
		int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número"));
		int total = n;
		String data = " 5 x ";
		for (int i = 1; i < n; i++) {
			total *= (n - i);
			data += (i != (n - 1)) ? (n - i) + " x " : (n - i);
		}
		JOptionPane.showMessageDialog(null, data + " = " + total);
		return total;
	}

	public String ej5() {
		JOptionPane.showMessageDialog(null, "Ejercicio 5");
		int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número decimal"));
		JOptionPane.showMessageDialog(null, binario(n));
		return binario(n);
	}

	// metodo que recibe como parametro un entero y retorna un binario en string;
	public String binario(int n) {
		String binario = Integer.toBinaryString(n);
		return binario;
	}

	public int ej6() {
		JOptionPane.showMessageDialog(null, "Ejercicio 6");
		int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número decimal positivo"));
		do {
			if (n > 0) {
				break;
			}
			n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número decimal positivo"));
		} while (true);
		String s = String.valueOf(n);
		String aux = "";
		int n2 = 0;
		while (true) {
			aux += s.charAt(n2);
			n2++;
			if (s.equals(aux)) {
				JOptionPane.showMessageDialog(null, n2);
				return n2;
			}
		}
	}

	public void ej7() {
		JOptionPane.showMessageDialog(null, "Ejercicio 7");
		String s = (JOptionPane.showInputDialog("Ingrese la cantidad en euros"));
		divisas(s);
	}

	// metodo que recibe un string con numeros en euros
	// y muestra los el equivalente en divisas
	public void divisas(String s) {
		double LIBRA = 0.86;
		double DOLAR = 1.28611;
		double YENES = 129.852;
		double n = Double.parseDouble(s);
		JOptionPane.showMessageDialog(null,
				"Euro: " + n + " | Libra: " + (LIBRA * n) + " | Dolar: " + (DOLAR * n) + " | Yenes: " + (YENES * n));
	}

	public void ej8() {
		JOptionPane.showMessageDialog(null, "Ejercicio 8");
		double a[] = rellenarArray();
		mostrarArray(a);
	}

	// metodo que ingresa los de datos del array;
	public double[] rellenarArray() {
		double a[] = new double[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el dato en la posición" + i));
		}
		return a;

	}

	// metodo que muestra los valores y su posicion en el array;
	public void mostrarArray(double a[]) {
		String s = "";
		for (int i = 0; i < a.length; i++) {
			s += "p: " + i + " | v: " + a[i];
		}
		JOptionPane.showMessageDialog(null, s);
	}

	public void ej9() {
		JOptionPane.showMessageDialog(null, "Ejercicio 9");
		int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del array"));
		int a[] = rellenarArrayAletorio(n);
		mostrarArraySuma(a);
	}

	// metodo que rellena un array con numeros alertorios;
	public int[] rellenarArrayAletorio(int n) {
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) Math.floor(Math.random() * 9);
		}
		return a;
	}

	// metodo que muestra los valores, su posicion en el array y la suma de los
	// mismos;
	public void mostrarArraySuma(int a[]) {
		String s = "";
		int total = 0;
		for (int i = 0; i < a.length; i++) {
			s += " | p: " + i + " - v: " + a[i];
			total += a[i];
		}
		JOptionPane.showMessageDialog(null, s + " | total: " + total);
	}

	public void ej10() {
		JOptionPane.showMessageDialog(null, "Ejercicio 10");
		int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del array"));
		int a[] = new int[n];
		int max = 0;
		String s = "";
		for (int i = 0; i < a.length;) {
			int aux = numeroradom();
			if (esPrimo(aux)) {
				a[i] = aux;
				max = (aux > max) ? aux : max;
				s += "p: " + i + " - v: " + a[i];
				i++;

			}
		}
		JOptionPane.showMessageDialog(null, s + " | Maximo: " + max);

	}

	// retorna un entero random entre 0 y 999
	public int numeroradom() {
		return (int) Math.floor(Math.random() * 1000);
	}

	// devuelve true si el numero es primo
	public boolean esPrimo(int n) {
		if (n == 0 || n == 1 || n == 2) {
			return false;
		}
		for (int i = 2; i < n / 2; i++) {
			if (n % i == 0) {
				return false;
			}

		}
		return true;
	}

	public int[] ej11() {
		JOptionPane.showMessageDialog(null, "Ejercicio 11");
		int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del array"));
		int[] a1 = new int[n];
		for (int i = 0; i < a1.length; i++) {
			a1[i] = numeroradom();
		}
		int[] a2 = Arrays.copyOfRange(a1, 0, n);
		JOptionPane.showMessageDialog(null, "array 1: " + mostrarArray(a1) + " \n array 2: " + mostrarArray(a2));
		for (int i = 0; i < a1.length; i++) {
			a2[i] = numeroradom();
		}
		JOptionPane.showMessageDialog(null, "array 1: " + mostrarArray(a1) + " \n array 2: " + mostrarArray(a2));
		return multiplicarArrays(a1, a2);
	}

	public int[] multiplicarArrays(int[] a1, int[] a2) {
		int[] a3 = new int[a1.length];
		for (int i = 0; i < a3.length; i++) {
			a3[i] = a2[i] * a1[i];
		}
		JOptionPane.showMessageDialog(null, "array 1: " + mostrarArray(a1) + " \n array 2: " + mostrarArray(a2)
				+ " \n array suma: " + mostrarArray(a3));
		return a3;
	}

	public String mostrarArray(int[] a) {
		String aux = "";
		for (int i = 0; i < a.length; i++) {
			aux += a[i] + " - ";
		}
		return aux;
	}

	public void ej12() {
		JOptionPane.showMessageDialog(null, "Ejercicio 12");
		int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del array"));
		int a[] = new int[n];
		String aux = "";
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) Math.floor(Math.random() * 300);
		}
		String n2 = (JOptionPane.showInputDialog("Ingrese el ultimo número"));
		String s = n2 + " :";
		for (int i = 0; i < a.length; i++) {
			// obtener los decimales;
			int auxi = String.valueOf(a[i]).toCharArray().length;
			// transformo el decimal con index i en string
			String auxs = String.valueOf(a[i]);
			// obtengo el ultimo elemento del número
			String auxs2 = String.valueOf(auxs.charAt(auxi - 1));
			// operador ternario que si el ultimo numero del entero coicide
			// con el numero asignado lo agrega a[i] s;
			s += (n2.equals(auxs2)) ? " | " + a[i] : "";
			aux += " - " + a[i];
		}
		s = (!(s.equals(""))) ? s : "EL número ingresado no coincide con ningún número en la lista";
		JOptionPane.showMessageDialog(null, "número alertorios: " + aux);
		JOptionPane.showMessageDialog(null, s);
	}
}
