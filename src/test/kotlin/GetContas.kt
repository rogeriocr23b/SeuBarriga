import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.response.Response
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.junit5.JUnit5Asserter.assertEquals
import kotlin.test.junit5.JUnit5Asserter.assertNotNull


class GetContas : Base() {
    fun getConta(): Response {
        return Given {
            spec(specBaseToken())
        } When {
            get("https://barrigarest.wcaquino.me/contas")
        } Then {
            log().all()
        } Extract {
            response()
        }

    }

    @Test
    @DisplayName("acessar conta sem cadastro")
    fun acessaCadastroSemConta() {
        val response = getConta()
        assertAll("acessa cadastro cem conta",
            { kotlin.test.assertEquals(200, response.statusCode) },
            { kotlin.test.assertEquals(0, response.jsonPath().getInt("size()")) })

    }
}
