public class Usuario {
    private String login;
    private String senhaHash;
    private String perfil; // "admin" ou "usuario"

    public Usuario(String login, String senhaHash, String perfil) {
        this.login = login;
        this.senhaHash = senhaHash;
        this.perfil = perfil;
    }

    public String getLogin() {
        return login;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public String getPerfil() {
        return perfil;
    }
}
