package main;

import java.util.Hashtable;

import javax.swing.JOptionPane;

public class tarea4 {
	Articulos articulos = new Articulos();
	Supermercado superMercado = new Supermercado();

	public void app() {
		JOptionPane.showMessageDialog(null, "App final");
		Hashtable<String, String[]> listProductos = articulos.cargarDatos();
		boolean flag;
		do {
			int n1 = Integer.parseInt(JOptionPane.showInputDialog(
					"Ingrese el número para realizar la función que desee \n " + "(1) crear un producto \n"
							+ "(2) realizar venta \n" + "(3) agregar stock \n" + "(4) ver los productos \n"));
			switch (n1) {
			case 1:
				String key = superMercado.controlId(listProductos);
				listProductos.put(key, superMercado.nuevoProducto());
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Panel de ventas");
				Hashtable<String, Integer> venta = superMercado.cargaVenta(listProductos);
				superMercado.procesarCompra(listProductos, venta);
				break;
			case 3:
				articulos.addStock(listProductos);
				break;
			case 4:
				articulos.mostrar(listProductos);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Error al ingresar una función");
				break;
			}
			int auxFlag = Integer
					.parseInt(JOptionPane.showInputDialog("Ingrese 1 para volver al menu y 2 para continuar"));
			flag = (auxFlag == 1) ? true : false;
		} while (flag);
	}
}
