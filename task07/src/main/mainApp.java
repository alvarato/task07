package main;

public class mainApp {
	public static void main(String[] args) {
		NotaMedia notaMedia = new NotaMedia();
		Supermercado superMercado = new Supermercado();
		Articulos articulo = new Articulos();
		tarea4 t = new tarea4();
		notaMedia.app();
		superMercado.app();
		articulo.app();
		t.app();
	}
}
