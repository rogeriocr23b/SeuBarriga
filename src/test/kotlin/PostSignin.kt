import io.restassured.http.ContentType
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.response.Response
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.junit5.JUnit5Asserter.assertNotNull
import org.junit.jupiter.api.Assertions.*

class PostSignin {

    fun signin(signinPojo: SigninPojo): Response {
        return Given {
            contentType(ContentType.JSON)
            body(signinPojo)
            log().all()

        } When {
            post("https://barrigarest.wcaquino.me/signin")
        } Then {
            log().all()
        } Extract {
            response()
        }

    }

    val signinFactory = SigninFactory()

    @Test
    @DisplayName("acessar cadastro")
    fun signinsuccess() {

    }
}

//class PostLogin {
//    fun login(loginPojo: LoginPojo) {
//        Given {
//            contentType(ContentType.JSON)
//            body(loginPojo)
//            log().all()
//        } When {
//            post("https://reqres.in/api/login")
//        } Then {
//            log().all()
//        }
//
//    }
//
//    val loginFactory = LoginFactory()
//
//    @Test
//    fun loginSucccess() {
//        login(loginFactory.loginSuccess())
//    }