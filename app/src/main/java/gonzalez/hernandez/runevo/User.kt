package gonzalez.hernandez.runevo

data class User(
    var usuario: String,
    var email: String,
    var contraseña: String,
    var perfiles: ArrayList<Perfil>?
)
