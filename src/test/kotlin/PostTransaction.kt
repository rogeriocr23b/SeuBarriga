import io.restassured.http.ContentType
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.response.Response
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PostTransaction : Base() {
    fun postTransaction() {
        Given {
            spec(specBaseToken())
            contentType(ContentType.JSON)
            body(
                "{\n" +
                        " \"conta_id\" : \"1366167\",\n" +
                        " \"descricao\" : \"Movimentando Teste 2\",\n" +
                        " \"envolvido\" : \"solo\",\n" +
                        " \"tipo\" : \"REC\",\n" +
                        " \"data_transacao\" : \"04/09/2022\",\n" +
                        " \"data_pagamento\" : \"04/09/2022\", \n" +
                        " \"valor\" : 10.00,\n" +
                        " \"status\" : true\n" +
                        "}"
            )
        } When {
            post("https://barrigarest.wcaquino.me/transacoes")

        } Then {
            log().all()
        } Extract {
            response()
        }
    }

    fun postTransaction2() {
        Given {
            spec(specBaseToken())
            contentType(ContentType.JSON)
            body("{}")
        } When {
            post("https://barrigarest.wcaquino.me/transacoes")

        } Then {
            log().all()
        } Extract {
            response()
        }
    }


        @Test
        @DisplayName("Inserir transação com sucesso")
        fun postTransactionTest() {
            postTransaction()
        }

        @Test
        @DisplayName("Validação de campos obrigatórios")
        fun postTransactionTest2() {
            postTransaction2()
        }
    }
