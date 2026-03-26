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

    //Get para pegar o saldo
    public double getSaldo(){
        return this.saldo;
    }

    //Método de Saldo, adiciona dinheiro na conta
    public double setSaldo(double valor){
        this.saldo = this.saldo+valor;
        return this.saldo;
    }

    //Método para sacar, tenta sacar o dinheiro
    public double sacarSaldo (double valor){
        //Se for verdade o valor ele saca, caso contrário ele não faz nada
        if(this.saldo >= valor){
            this.saldo = this.saldo - valor;
            return this.saldo;
        }
        return valor;
    }
}
