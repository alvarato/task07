package main;

import java.util.Hashtable;
import java.util.Set;

import javax.swing.JOptionPane;

public class Supermercado {
	
	public void app() {
		JOptionPane.showMessageDialog(null, "App Supermercado");
		Hashtable< String , String[]> listProductos = new Hashtable<>();
		boolean flag;
		//solicita por producto codigo-key nombre,precio y el IVA es alertorio entre 24 y 4;
		do {
			String key = controlId(listProductos);
			listProductos.put(key,nuevoProducto());
			int auxFlag = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 para ingresar otro producto y 2 para continuar"));
		flag = (auxFlag == 1)? true : false;
		}while(flag);
		JOptionPane.showMessageDialog(null, "Panel de ventas");
		Hashtable< String, Integer> venta = cargaVenta(listProductos);
		procesarCompra(listProductos,venta);
	}
	// genera un nuevo producto
	public String[] nuevoProducto() {
		String[] infoProducto = new String[4];
		int IVA = (int)(Math.random()*10+1);
		infoProducto[0] = (JOptionPane.showInputDialog("Ingrese el nombre del producto")); 
		infoProducto[1] = (JOptionPane.showInputDialog("Ingrese el precio del producto"));
		infoProducto[2] = (IVA > 5)? "24" : "4" ;
		infoProducto[3] = "10";
		return infoProducto;
	}
	//metodo que busca si los productos existen y genera una venta;
	public Hashtable< String, Integer> cargaVenta(Hashtable<String , String[]> listProductos){
		Hashtable< String, Integer> venta = new Hashtable<>();
		boolean flag = true;
		do {
			do {
				//verificamos si existe el nombre del producto e ingresamos la cantidad;
				String aux = (JOptionPane.showInputDialog("Ingrese el nombre del producto"));
				Set<String> setOfkeys = listProductos.keySet();
				for (String key : setOfkeys) {
					if(aux.equals(listProductos.get(key)[0])) {
						int cantidadP = Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese la cantidad del producto"));
						venta.put(key,cantidadP);
						flag = false;
						break;
					}
				}
				//si no se encotro el producto salta el mensaje y se vuelve a ejecutar el bucle;
				if(flag) {
					JOptionPane.showMessageDialog(null, "No se encontro el producto");
				}
			}while(flag);
			int auxFlag = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 para ingresar otro producto y 2 para continuar"));
			flag = (auxFlag == 1)? true : false;
		}while(flag);
		return venta;
	}
	
	//metodo que obtiene lista de productos y lista de compras;
	//finaliza dicha compra y la muestra por pantalla;
	public void procesarCompra(Hashtable<String , String[]> listProductos,Hashtable<String, Integer> venta) {
		String show = "";
		Double totalIva = 0.0;
		Double total = 0.0;
		Set<String> setOfkeys = venta.keySet();
		for (String key : setOfkeys) {
			int aux = Integer.parseInt(listProductos.get(key)[3]);
			int cantidad;
			if(venta.get(key) > aux) {
				cantidad = aux;
				JOptionPane.showMessageDialog(null, "La cantidad maxima de " + listProductos.get(key)[0] + " es: " + cantidad);
			}else {
				cantidad = venta.get(key);
			}
			listProductos.get(key)[3] = String.valueOf(aux-cantidad);
			show += " | producto: " + listProductos.get(key)[0] + " | cantidad: " + cantidad +
					" | precio/u: " + listProductos.get(key)[1] + " | total: " 
					+ ((Double.parseDouble(listProductos.get(key)[1])) * venta.get(key)) +
					" | IVA: " + listProductos.get(key)[2] + " %" + "\n";
			//calculamos el total de todo el iva en conjunto;
			totalIva += ((Integer.parseInt(listProductos.get(key)[2]) *
					Double.parseDouble(listProductos.get(key)[1]) * cantidad)/100);
			//lo mismo con el total de los productos;
			total += ((Double.parseDouble(listProductos.get(key)[1])) * cantidad);
		}
		double pago;
		do {
			pago = Double.parseDouble(JOptionPane.showInputDialog("El total a pagar es: " + (total + totalIva) + " Ingrese pago "));
		}while(pago >= total + totalIva);
		show += "\n Subtotal = " + total + "\n" + " + Iva = " + totalIva + "\n" 
				+  "Total = " + (total + totalIva) + "\n" + " - Pago = " + pago + " | Vuelto = " +( pago - (total + totalIva)) ;
		JOptionPane.showMessageDialog(null, show);
	}
	
	//controla si el id no esta repetido;
	public String controlId(Hashtable< String , String[]> listProductos) {
		String newKey = (JOptionPane.showInputDialog("Ingrese el codigo del producto"));
		if(listProductos.size() != 0) {
			
			Set<String> setOfkeys = listProductos.keySet();
			boolean flag = true;
			do {
			for (String key : setOfkeys) {
				if(newKey.equals(key)) {
					newKey = JOptionPane.showInputDialog("El codigo del producto no puede ser repedito ingrese otro");
					flag = true;
					break;
				
			}else {
				flag = false;
				}
			}
			}while(flag);
		}
		return newKey;
	}
	
}
