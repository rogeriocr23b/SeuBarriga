import io.restassured.http.ContentType
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.response.Response
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.junit5.JUnit5Asserter.assertEquals

class PutContas : Base() {
    fun alterarConta(id: String) : Response {
        return Given {
            spec(specBaseToken())
            contentType(ContentType.JSON)
            body(
                "{\n" +
                        " \"nome\" : \"Conta Teste Tres\"\n" +
                        "}"
            )
            pathParam("id", id)

        } When {
            put("https://barrigarest.wcaquino.me/contas/{id}")
        } Then {
            log().all()
        } Extract {
            response()
        }


    }


    @Test
    @DisplayName ("alterar conta com sucesso")
    fun alterarContaTeste() {
        val response = alterarConta("1366167")


        }
    }











