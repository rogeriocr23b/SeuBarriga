class SigninFactory {
    var signinPojo = SigninPojo()

    fun signinSuccess(): SigninPojo {
        signinPojo.email = "rogeriocr@email.com"
        signinPojo.senha = "123456@"
        return signinPojo

    }
}