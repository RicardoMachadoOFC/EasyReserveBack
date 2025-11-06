package net.javaguides.springboot.dto;

public class RegisterRequest {
    private String email;
    private String senha;
    private String role; // usuario, funcionario, gerente

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
