package com.neyser;

import java.io.*;
import java.util.Scanner;

public class Transaccion {
    static Scanner sc1 = new Scanner(System.in);

    public void menu() throws IOException {

        System.out.println("_____________________________");
        System.out.println("|      MENU PRINCIPAL       |");
        System.out.println("|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|");
        System.out.println(
                "| 1. Ver Escritores\t\t\t|\n" +
                        "| 2. Registrar escritor\t\t|\n" +
                        "| 0. Cerrar Programa\t\t|");
        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

        String opcion = sc1.nextLine();

        switch (opcion)
        {
            case "1":
                verEscritores();
                menu();
                break;
            case "2":
                System.out.println("Escribir el nombre del escritor:");
                registrarEscritor();
                menu();
                break;
            case "0":
                sc1.close();
                System.exit(0);
            default:
                System.out.println("Debe seleccionar una opción válida");
                menu();

        }
    }

    private void registrarEscritor() throws IOException {
        System.out.println("Nombre:");
        String nombre = sc1.nextLine();
        System.out.println("Fecha de nacimiento:");
        String fechaNacimiento = sc1.nextLine();
        System.out.println("Nacionalidad:");
        String nacionalidad = sc1.nextLine();

        Escritor escritor1 = new Escritor();
        escritor1.setNombre(nombre);
        escritor1.setFechaNacimineto(fechaNacimiento);
        escritor1.setNacionalidad(nacionalidad);

        // Escribir en fichero
        File file1 = new File("Escritores/lista.txt");
        FileWriter fileWriter1 = new FileWriter(file1, true);
        BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);

        bufferedWriter1.write(escritor1.getNombre()+"|");
        bufferedWriter1.write(escritor1.getFechaNacimineto()+"|");
        bufferedWriter1.write(escritor1.getNacionalidad().toString()+"\n");

        bufferedWriter1.close();
        System.out.println("Se ha escrito en el fichero");

        menu();




    }

    private void verEscritores() {
        File file1 = new File("Escritores/lista.txt");

        String resultado = "";

        try
        {
            FileReader fileReader1 = new FileReader(file1);
            BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
            String strCurrentLine;

            while ((strCurrentLine=bufferedReader1.readLine()) != null)
            {
                String[] parts = strCurrentLine.split("\\|");

                if (Integer.parseInt(parts[2])!=0)
                {
                    resultado+=parts[0];
                    resultado+="\t\t";
                    resultado+=parts[1];
                    resultado+="\t";
                    resultado+=parts[2];
                }

            }

            if (fileReader1 != null)
            {
                fileReader1.close();
            }

        } catch (FileNotFoundException e1)
        {
            e1.printStackTrace();
        } catch (IOException e2)
        {
            e2.printStackTrace();
        }


        //System.out.println("TEST - "+resultado);

        //return resultado;
    }

}
