import io.restassured.builder.RequestSpecBuilder
import io.restassured.http.ContentType
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.specification.RequestSpecification
import org.junit.jupiter.api.Test

open class Base {

    fun specBase() : RequestSpecification{
        return RequestSpecBuilder()
            .setBaseUri("https://barrigarest.wcaquino.me")
            .setBasePath("signin")
            .build()
    }

    fun specBaseToken() : RequestSpecification {
        val token = getToken()
        return RequestSpecBuilder()
            .addRequestSpecification(specBase())
            .addHeader("Authorization","JWT $token")
            .build()
    }


    fun getToken() : String {

        var signinJson: HashMap<String,String> = HashMap()
        signinJson.put("email","rogerioteste@email.com")
        signinJson.put("senha","123456!")

        return Given {
            spec(specBase())
            contentType(ContentType.JSON)
            body(signinJson)

        } When {
            post("https://barrigarest.wcaquino.me/signin")
        } Then {
            log().all()

        } Extract {
            response().jsonPath().getString("token")
        }


    }

@Test
fun getTokenTest() {
    getToken()
}
}

