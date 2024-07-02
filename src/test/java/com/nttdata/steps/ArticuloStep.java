package com.nttdata.steps;

import com.nttdata.model.Articulo;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ArticuloStep {

    private static String URL = null;
    Response response;

    public void definirurl(String url){
        URL = url;
    };

    public void consultaArtuculos(){

        response =
        given()
                .contentType("application/json")
                .log()
                .all()
                .get(URL+"/posts")
               // .then()
                //.log()
                //.all()
                ;

    };

    public void imprimirArticulos() {
        //Convertimos el objeto JSON a un List
        List<Articulo> articulos = response.jsonPath().getList("", Articulo.class);
        System.out.println("Total: "+articulos.size());
        for(Articulo articulo:articulos){
            System.out.println("Titulo: "+ articulo.getId() + " - " +articulo.getTitle());
        }
    }


}
