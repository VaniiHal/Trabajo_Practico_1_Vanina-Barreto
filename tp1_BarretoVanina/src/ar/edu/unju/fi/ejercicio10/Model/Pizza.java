package ar.edu.unju.fi.ejercicio10.Model;

public class Pizza {
	private int diametro;
	private double precio;
	private double area;
	private boolean ingredientesEspeciales;
	
	public final int ESPECIAL20 = 500;
	public final int ESPECIAL30 = 750;
	public final int ESPECIAL40 = 1000;
	
	public Pizza() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return "Diametro = " + diametro + "\nIngredientes Especiales = "
				+ ingredientesEspeciales +"\nPrecio = $" + precio + "\nArea de la pizza = " + area;
	}

	public double getDiametro() {
		return diametro;
	}

	public void setDiametro(int diametro) {
		this.diametro = diametro;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public boolean isIngredientesEspeciales() {
		return ingredientesEspeciales;
	}

	public void setIngredientesEspeciales(boolean ingredientesEspeciales) {
		this.ingredientesEspeciales = ingredientesEspeciales;
	}
	
	public void calcularPrecio() {
		switch(diametro) {
		case 20:
			precio=4500;
			if(ingredientesEspeciales==true) {
				precio+=ESPECIAL20;
			}
			break;
		case 30:
			precio=4800;
			if(ingredientesEspeciales==true) {
				precio+=ESPECIAL30;
			}
			break;
		case 40:
			precio=5500;
			if(ingredientesEspeciales==true) {
				precio+=ESPECIAL40;
			}
			break;
		}
	}
	
	public void calcularArea() {
		double radio= diametro/2;
		area= Math.PI * Math.pow(radio, 2);
	}
}
