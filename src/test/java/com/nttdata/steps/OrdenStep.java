package com.nttdata.steps;

import com.google.gson.JsonObject;
import com.nttdata.model.Orden;
import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.given;

public class OrdenStep {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(OrdenStep.class);
    private String BASE_URL = "https://petstore.swagger.io/v2";
    private static String CREATE_ORDER = "https://petstore.swagger.io/v2/store/order";

    private String bodyPost;

    @Step("Insertar Orden")
    public void crearOrden(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        JsonObject body = new JsonObject();
        body.addProperty("id", id);
        body.addProperty("petId", petId);
        body.addProperty("quantity", quantity);
        body.addProperty("shipDate", shipDate);
        body.addProperty("status", status);
        body.addProperty("complete", complete);
        bodyPost = body.toString();

        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body(bodyPost)
                .log().all()
                .post(CREATE_ORDER)
                .then()
                .log().all()
        ;
    }
    public void validarContenidoIdPedIdOrden(int id, int petId, int quantity) {
        Assert.assertEquals(id, SerenityRest.lastResponse().body().jsonPath().getInt("id"));
        Assert.assertEquals(petId, SerenityRest.lastResponse().body().jsonPath().getInt("petId"));
        Assert.assertEquals(quantity, SerenityRest.lastResponse().body().jsonPath().getInt("quantity"));
    }
    public void validacionCodigoRespuesta(int codigo) {
        Assert.assertEquals(codigo, SerenityRest.lastResponse().statusCode());
    }

    public void consultaOrder(String id) {
        Orden orden =
                given()
                        .baseUri(BASE_URL)
                        .log()
                        .all()
                        .when()
                        .get("store/order/"+id)
                        //.then()
                        //.log().all()
                        .as(Orden.class)
                ;

        System.out.println("id: " + orden.getId());
        System.out.println("petId: " + orden.getPetId());
        System.out.println("quantity: " + orden.getQuantity());
        System.out.println("shipDate: " + orden.getShipDate());
        System.out.println("status: " + orden.getStatus());
        System.out.println("complete: " + orden.isComplete());


    }


}
