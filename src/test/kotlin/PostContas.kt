import io.restassured.http.ContentType
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PostContas : Base() {

    fun criarConta() {
        Given {
            spec(specBase())
            contentType(ContentType.JSON)
            body(
                "{\n" +
                        " \"nome\" : \"Conta Nova\"\n" +
                        "}"
            )
        } When {
            post("https://barrigarest.wcaquino.me/contas")
        } Then {
            log().all()
        }
    }

    fun criarConta2() {
        Given {
            spec(specBaseToken())
            contentType(ContentType.JSON)
            body(
                "{\n" +
                        " \"nome\" : \"Conta Teste Tres\"\n" +
                        "}"
            )
            log().all()
        } When {
            post("https://barrigarest.wcaquino.me/contas")
        } Then {
            log().all()
        }

    }

    @Test
    @DisplayName("Incluir conta com nome repetido")
    fun criarContaTest() {
        criarConta2()
    }

    @Test
    @DisplayName("Incluir conta com sucesso")
    fun criarContaTest2() {
        criarConta()
    }
}
