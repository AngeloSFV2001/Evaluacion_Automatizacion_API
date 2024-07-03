package com.nttdata.glue;

import com.nttdata.steps.OrdenStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

public class OrdenStepDef {
    @Steps
    OrdenStep orden;

    @Given("la aplicacion este operativa")
    public void laAplicacionEsteOperativa() {
    }

    @And("inicializo request en post")
    public void inicializoRequestEnPost() {
    }

    @And("inserto los valores de ordenes con id: {string}, petId: {string}, quantity: {string},shipDate: {string}, status: {string}, complete: {string}")
    public void insertoLosValoresDeOrdenes(String id, String petId, String quantity, String shipDate, String status, String complete) {
        orden.crearOrden(parseInt(id),parseInt(petId),parseInt(quantity), shipDate,status,parseBoolean(complete));
    }

    @Then("valido que la respuesta es {int}")
    public void validoQueLaRespuestaEs(int codigo) {
        orden.validacionCodigoRespuesta(codigo);
    }

    @Then("valido el contenido id: {string}, petId: {string}, quantity: {string}")
    public void validoElContenidoIdPetIdQuantity(String id, String petId, String quantity) {
        orden.validarContenidoIdPedIdOrden(parseInt(id),parseInt(petId),parseInt(quantity));
    }

    @When("consulto la orden de ID: {string}")
    public void consultoLaOrdenDeID(String id) {
        orden.consultaOrder(id);
    }



}
