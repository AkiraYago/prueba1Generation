package com.generation.evaluacion_java;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.generation.evaluacion_java.models.Alumno;
import com.generation.evaluacion_java.models.Curso;
import com.generation.evaluacion_java.models.Profesor;

@SpringBootApplication
public class EvaluacionJavaApplication {
	/*
	 * -----MATERIAS: 8
	 * Lenguaje
	 * Matematica
	 * Ciencias
	 * Ed. Fisica
	 * Musica
	 * Artes visuales
	 * Historia
	 * Ingles
	 * -----PROFESORES: 8
	 * -----CURSOS: 1° a 8° Basico
	 * -----ALUMNOS: Entre 30 y 45
	 */
	public static void mensajeError(String texto){
		System.out.println("[ERROR DE INGRESO] - " + texto);
	}
	public static void invocarMaterias(){
		System.out.println("\n[Lenguaje y Comunicación]");
		System.out.println("[Matemáticas]");
		System.out.println("[Ciencias Naturales]");
		System.out.println("[Educación Física]");
		System.out.println("[Música]");
		System.out.println("[Artes Visuales]");
		System.out.println("[Historia, Geografía y Ciencias Sociales]");
		System.out.println("[Inglés]");
	}

	public static void invocarCursos(){
		System.out.println("\n[1] - 1° Basico");
		System.out.println("[2] - 2° Basico");
		System.out.println("[3] - 3° Basico");
		System.out.println("[4] - 4° Basico");
		System.out.println("[5] - 5° Basico");
		System.out.println("[6] - 6° Basico");
		System.out.println("[7] - 7° Basico");
		System.out.println("[8] - 8° Basico\n");
	}

	//===============================================================================================================================//
	//--------------------------------------------------------------------------------------------------MENU PROFESOR----------------//
    public static Profesor registroProfesor(Scanner input){
        System.out.println("\n--------------------REGISTRO PROFESOR--------------------\n");
		System.out.println("\nIngrese su nombre: ");
		String nombreProfesor = input.nextLine();
		System.out.println("\nIngrese su RUT: ");
		Integer rutProfesor = input.nextInt(); input.nextLine();
		System.out.println("\nIngrese su sexo: ");
		char sexoProfesor = input.nextLine().charAt(0);
		invocarMaterias();
		System.out.println("\nIngrese la materia que imparte: ");
		String materiaProfesor = input.nextLine();
		System.out.println("\nCree su contraseña: ");
		String contraseñaProfesor = input.nextLine();
		Profesor nuevoProfesor = new Profesor(nombreProfesor, sexoProfesor, contraseñaProfesor, rutProfesor, materiaProfesor);
        return nuevoProfesor;
    }
	public static void opcion1(Scanner input, Profesor nuevoProfesor, ArrayList<Alumno> listaAlumnos){
		//Asignar alumnos a un curso y mostrarlos
		System.out.println("\n--------------------[OPCION 1] - INGRESAR ALUMNOS--------------------\n");
		invocarCursos();
		System.out.println("\nIngrese el curso que tiene a cargo: ");
			//Mostrar lista de cursos
		int numeroCurso = input.nextInt();
		String cursoProfesor = numeroCurso + "° Basico";
			//Ingrese la cantidad de alumnos que tiene entre 30 y 40
		System.out.println("\nIngrese cantidad de alumnos de su curso: ");
		int cantidadAlumnos = input.nextInt();

		input.nextLine();
			//Ingrese a sus alumnos
		
		for (int i = 0; i < cantidadAlumnos; i++) {
			System.out.println("\n---------------INGRESE LOS DATOS DEL ALUMNO N°" + (i + 1) + "---------------\n");
			Alumno nuevoAlumno = new Alumno();
			System.out.println("\nIngrese el nombre del alumno: ");
			String nombreAlumno = input.nextLine();
			System.out.println("\nIngrese el sexo del alumno: ");
			char sexoAlumno = input.nextLine().charAt(0);
			System.out.println("\nIngrese el RUT del alumno: ");
			Integer rutAlumno = input.nextInt(); input.nextLine();

			nuevoAlumno.setNombre(nombreAlumno);
			nuevoAlumno.setRut(rutAlumno);
			nuevoAlumno.setSexo(sexoAlumno);
			listaAlumnos.add(nuevoAlumno);
		}
		Curso nuevoCurso = new Curso(cursoProfesor, nuevoProfesor, listaAlumnos);
		System.out.println(nuevoCurso.toString());
	}
	public static void opcion2(Scanner input, ArrayList<Alumno> listaAlumnos){
		//ingrese el numero de lista del estudiante para agregar notas
		int opcionSeguir;
		do {
			System.out.println("\n--------------------[OPCION 2] - INGRESAR NOTAS--------------------\n");
			for (int i = 0; i < listaAlumnos.size(); i++) {
				System.out.println("[" + (i + 1) + "] - " + listaAlumnos.get(i).getNombre());
			}
			System.out.println("Ingrese el N° del alumno al cual le agregará notas: ");
			int alumnoSeleccionado = input.nextInt(); input.nextLine();
			System.out.println("Ingrese el N° de notas que desea poner: ");
			int cantidadNotas = input.nextInt(); input.nextLine();
			for (int i = 0; i < cantidadNotas; i++) {
				System.out.println("Ingrese la nota N°" + (i + 1));
				Double nota = input.nextDouble(); input.nextLine();
				listaAlumnos.get(alumnoSeleccionado - 1).getListaNotas().add(nota);
			}
			Double sumaNotas = 0.0;
			for (int i = 0; i < listaAlumnos.get(alumnoSeleccionado - 1).getListaNotas().size(); i++) {
				sumaNotas += listaAlumnos.get(alumnoSeleccionado - 1).getListaNotas().get(i);
			}
			listaAlumnos.get(alumnoSeleccionado - 1).setPromedio(sumaNotas / cantidadNotas);
			do {
				System.out.println("\n--------------------------");
				System.out.println("\n¿Desea ingresar mas notas?\n");
				System.out.println("[1] - Si          [2] - No\n");
				System.out.println("--------------------------\n");
				opcionSeguir = input.nextInt(); input.nextLine();
				if (opcionSeguir < 1 || opcionSeguir > 2) {
					mensajeError("Debe ingresar [1] o [2]");
				}
			} while (opcionSeguir < 1 || opcionSeguir > 2);
		} while (opcionSeguir == 1);
		System.out.println(listaAlumnos);
	}
	
	public static void opcion3(Scanner input, ArrayList<Alumno> listaAlumnos){
		System.out.println("\n--------------------[OPCION 3] - PEOR, MEJOR PROMEDIO Y PROMEDIO GENERAL--------------------\n");
		Double peorPromedio = listaAlumnos.get(0).getPromedio();
		Double mejorPromedio = listaAlumnos.get(0).getPromedio();
		Double sumaPromedios = 0.0;
		for (int i = 0; i < listaAlumnos.size(); i++) {
			if (peorPromedio > listaAlumnos.get(i).getPromedio()) {
				peorPromedio = listaAlumnos.get(i).getPromedio();
			}
			if (mejorPromedio < listaAlumnos.get(i).getPromedio()) {
				mejorPromedio = listaAlumnos.get(i).getPromedio();
			}
			sumaPromedios += listaAlumnos.get(i).getPromedio();
		}
		Double promedioGeneral = sumaPromedios / listaAlumnos.size();
		System.out.println("El peor promedio es " + peorPromedio);
		System.out.println("El mejor promedio es " + mejorPromedio);
		System.out.println("El promedio general del curso es " + promedioGeneral);
	}
	public static void menuOpciones(Scanner input, Profesor nuevoProfesor, ArrayList<Alumno> listaAlumnos){
		//--------------------------------------------------MOSTRAR MENU OPCIONES
		int opcionIngresada;
		boolean opcion1Ejecutada = false;
		do {
			System.out.println("\n--------------------MENU OPCIONES--------------------\n");
			System.out.println("[Opcion 1] - Ingresar alumnos ");
			System.out.println("[Opcion 2] - Ingresar notas ");
			System.out.println("[Opcion 3] - Mostrar el mejor y peor promedio y el promedio general");
			System.out.println("[Opcion 4] - Volver");
			System.out.println("\n-----------------------------------------------------\n");
			System.out.println("Ingrese una de las opciones: ");
			opcionIngresada = input.nextInt();
			if (opcionIngresada == 1) {
				//ejecutar opcion 1
				opcion1(input, nuevoProfesor, listaAlumnos);
				opcion1Ejecutada = true;
				opcionIngresada = 0;
			} else if (opcionIngresada == 2) {
				if (opcion1Ejecutada) {
					//ejecutar opcion 2
					opcion2(input, listaAlumnos);
				} else {
					System.out.println("Debe ejecutar la opción 1 para acceder a esta opción");
				}
				opcionIngresada = 0;
			} else if (opcionIngresada == 3) {
				if (opcion1Ejecutada) {
					//ejecutar opcion 3
					opcion3(input, listaAlumnos);
				} else {
					System.out.println("Debe ejecutar la opción 1 para acceder a esta opción");
				}
				opcionIngresada = 0;
			} else if (opcionIngresada == 4) {
				//volver
			} else {
				//Mostrar mensaje de error y  repetir
				mensajeError("Debe ingresar [1],[2],[3] o [4]");
			}
		} while (opcionIngresada < 1 || opcionIngresada > 4);
		
	}
    public static void menuProfesor(ArrayList<Alumno> listaAlumnos){
        Scanner input = new Scanner(System.in);
        Profesor nuevoProfesor = registroProfesor(input);
        menuOpciones(input, nuevoProfesor, listaAlumnos);
    }
	//-------------------------------------------------------------------------------------------------------------------------------//
	//===============================================================================================================================//
	public static void menuAlumno(Scanner input, ArrayList<Alumno> listaAlumnos){
		System.out.println("\n--------------------MENU ALUMNO--------------------\n");
		System.out.println("\nIngresa tu rut: ");
		Integer rutIngresado = input.nextInt(); input.nextLine();
		boolean usuarioRegistrado = false;
		if (listaAlumnos.size() == 0) {
			System.out.println("\n--------------------------------------------------------------\n");
			System.out.println("                No hay ningun usuario registrado");
			System.out.println("    Posible Razón: Su profesor jefe no lo ingresado al sistema");
			System.out.println("\n--------------------------------------------------------------\n");
		} else {
			for (int i = 0; i < listaAlumnos.size(); i++) {
				if (rutIngresado != listaAlumnos.get(i).getRut()) {
					usuarioRegistrado = false;
				} else {
					usuarioRegistrado = true;
					System.out.println("\nEstablezca una contraseña: ");
					String contraseñaIngresada = input.nextLine();
					listaAlumnos.get(i).setContraseña(contraseñaIngresada);
					System.out.println(listaAlumnos.get(i).toString());
					i = listaAlumnos.size() + 2;
				}
			}
			if (usuarioRegistrado == false) {
				System.out.println("\n--------------------------------------------------------------\n");
				System.out.println("          Su usuario no se encuentra registrado");
				System.out.println("  Posible Razón: Su profesor jefe no lo ingresado al sistema");
				System.out.println("\n--------------------------------------------------------------\n");
			}
		}
	}
	public static void main(String[] args) {
		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
		Scanner input = new Scanner(System.in);
		int opcionIngresada;
		do {
			System.out.println("\n--------------------MENU PRINCIPAL--------------------\n");
			System.out.println("[Opcion 1] - Profesor");
			System.out.println("[Opcion 2] - Alumno");
			System.out.println("[Opcion 3] - Salir");
			System.out.println("\n------------------------------------------------------\n");
			System.out.println("Ingrese la opcion de su tipo de usuario: ");
			opcionIngresada = input.nextInt();
			if (opcionIngresada == 1) {
				//Mostrar menu profe
				menuProfesor(listaAlumnos);
				opcionIngresada = 0;
			} else if (opcionIngresada == 2) {
				//Mostrar menu alumno
				menuAlumno(input, listaAlumnos);
				opcionIngresada = 0;
			} else if (opcionIngresada == 3) {
				//Salir (break)
				int confirmarSalir;
				do {
					System.out.println("\n--------------------------");
					System.out.println("\n      ¿Desea Salir?\n");
					System.out.println("   [1] - Si      [2] - No\n");
					System.out.println("--------------------------\n");
					confirmarSalir = input.nextInt(); input.nextLine();
					if (confirmarSalir == 1) {
						System.out.println("Hasta luego!");
						break;
					} else if (confirmarSalir == 2){
						opcionIngresada = 0;
					} else {
						//mensaje error
						mensajeError("Debe ingresar [1] o [2]");
					}
				} while (confirmarSalir < 1 || confirmarSalir > 2);
			} else {
				//Mostrar mensaje de error y  repetir
				mensajeError("Debe ingresar [1],[2] o [3]");
			}
		} while (opcionIngresada < 1 || opcionIngresada > 3);
		
	}

}
