package main;

import java.util.Hashtable;
import java.util.Set;

import javax.swing.JOptionPane;

public class Articulos {
	Supermercado superMercado = new Supermercado();

	public void app() {
		JOptionPane.showMessageDialog(null, "App Articulos");
		Hashtable<String, String[]> listProductos = cargarDatos();
		boolean flag = true;
		// bucle que se ejecuta para que la aplicacion funcione hasta que el
		// usuario decida cerrarla;
		do {
			String aux = JOptionPane.showInputDialog(
					"Ingrese 1 para crear un producto," + " 2 para ver la lista de productos, 3 para agregar stock");
			if (aux.equals("1")) {
				String key = superMercado.controlId(listProductos);
				listProductos.put(key, superMercado.nuevoProducto());
			} else if (aux.equals("2")) {
				mostrar(listProductos);
			} else {
				addStock(listProductos);
			}
			int auxFlag = Integer
					.parseInt(JOptionPane.showInputDialog("Ingrese 1 para volver al menu y 2 para finalizar"));
			flag = (auxFlag == 1) ? true : false;
		} while (flag);
	}

	public void addStock(Hashtable<String, String[]> listProductos) {
		Set<String> setOfkeys = listProductos.keySet();
		String name = JOptionPane.showInputDialog("Ingrese el nombre del producto");
		boolean flag = true;
		// busca si existe el producto, si existe te permite aumentar la cantidad
		do {
			for (String key : setOfkeys) {
				if (name.equals(listProductos.get(key)[0])) {
					listProductos.get(key)[3] = String
							.valueOf(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad"))
									+ Integer.parseInt(listProductos.get(key)[3]));
					flag = false;
					break;
				}
			}
			name = (flag) ? JOptionPane.showInputDialog("El nombre del producto no fue encontrado ingrese otro") : "";
		} while (flag);
	}

	public void mostrar(Hashtable<String, String[]> listProductos) {
		Set<String> setOfkeys = listProductos.keySet();
		String show = "";
		for (String key : setOfkeys) {
			show += " | codigo: " + key + " | producto: " + listProductos.get(key)[0] + " | precio/u: "
					+ listProductos.get(key)[1] + " | stock: " + listProductos.get(key)[3] + " | IVA: "
					+ listProductos.get(key)[2] + "% \n";
		}
		JOptionPane.showMessageDialog(null, show);
	}

	// lista de objetos predefinido;
	public Hashtable<String, String[]> cargarDatos() {
		Hashtable<String, String[]> listProductos = new Hashtable<>();
		String l1[] = { "agua", "2", "21", "6" };
		String l2[] = { "cocacola", "3", "21", "5" };
		String l3[] = { "mate", "3.5", "21", "1" };
		String l4[] = { "papas", "1", "4", "6" };
		String l5[] = { "cebolla", "1.5", "4", "4" };
		String l6[] = { "papel", "3", "24", "3" };
		String l7[] = { "yogur", "1.6", "24", "8" };
		String l8[] = { "leche", "0.5", "4", "9" };
		String l9[] = { "tapabocas", "2", "24", "3" };
		String l10[] = { "lejia", "4", "24", "5" };
		listProductos.put("1", l1);
		listProductos.put("2", l2);
		listProductos.put("3", l3);
		listProductos.put("4", l4);
		listProductos.put("5", l5);
		listProductos.put("6", l6);
		listProductos.put("7", l7);
		listProductos.put("8", l8);
		listProductos.put("9", l9);
		listProductos.put("10", l10);
		return listProductos;
	}
}
