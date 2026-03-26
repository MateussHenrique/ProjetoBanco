package project.mateuzin.banco;

public class Conta {
    //Definindo os métodos
    public String titular;
    private String senha;
    private double saldo;

    //Construtor definindo os valores

    public Conta(String titular, String senha, double saldo) {
        this.titular = titular;
        this.senha = senha;
        this.saldo = saldo;
    }



}
