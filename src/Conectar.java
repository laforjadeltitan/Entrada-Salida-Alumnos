import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conectar {

	public void leer() {
		try {
			FileReader archivo = new FileReader("C:\\notas.txt");
			FileWriter writer = new FileWriter("promedio.txt");
			BufferedReader buffer = new BufferedReader(archivo);
			String texto;
			String [] textoSeparado = null;
			Historial h = null;
			
			while ((texto = buffer.readLine())!=null) {
				textoSeparado = texto.split(" ");
				
				String dni = textoSeparado[0];
				String nombre = textoSeparado[1];
				String apellido = textoSeparado[2];
				int nota1 = Integer.valueOf(textoSeparado[3]);
				int nota2 = Integer.valueOf(textoSeparado[4]);
				int nota3 = Integer.valueOf(textoSeparado[5]);
				
				h = new Historial(dni, nombre, apellido, nota1, nota2, nota3);
				
				if(((h.getNota1()+h.getNota2()+h.getNota3())/3)>14) {
					System.out.println(h);
					writer.write(h.getDni() + " ");
					writer.write(h.getNombre() + " ");
					writer.write(h.getApellido());
					writer.write("\n");
				}
			}
			
			System.out.println("Se ha creado el archivo promedio.txt con los alumnos cuya nota media es mayor de 14");
			
			writer.close();
			archivo.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
