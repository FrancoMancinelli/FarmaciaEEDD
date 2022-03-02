package mainapp;

import models.Medicamento;
import models.Farmaceutico;
import utils.Almacen;
import views.LoginView;

public class mainapp {

	public static void main(String[] args) {
		
		//Creo un usuario único de la farmacia y lo añado al array de usuarios
		Farmaceutico u = new Farmaceutico(0, "0000");
		Almacen.usuarios.add(u);
		
		//Creo los medicamentos con los que cuenta la farmacia y los añado al array de medicamentos
		Medicamento m1 = new Medicamento(0, "Ibuprofeno", "Pildoras", 32, 4.65);
		Almacen.medicamentos.add(m1);
		Medicamento m2 = new Medicamento(1, "Paracetamol", "Pastillas", 27, 2.10);
		Almacen.medicamentos.add(m2);
		Medicamento m3 = new Medicamento(2, "Dextrometorfano", "Jarabe", 20,  8.90);
		Almacen.medicamentos.add(m3);
		
		//Creo una LoginView
		new LoginView();
	}
}
