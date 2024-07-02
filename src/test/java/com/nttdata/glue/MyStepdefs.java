package com.nttdata.glue;

import io.cucumber.java.en.When;

public class MyStepdefs {

    @When("hare un post con los datos de usuario: {string}, nombres: {string}, apellidos: {string}")
    public void hareUnPostConLosDatosDeUsuarioNombresApellidos(String arg0, String arg1, String apellidos) {
        System.out.println("ejecuta codigo java");
        System.out.println("Usuario: " +  arg0);
        System.out.println("Nombre: " +  arg1);
        System.out.println("Apellidos: " +  apellidos);
    }


}
