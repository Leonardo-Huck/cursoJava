package entiti;

public class ContaBancaria {
    private String numero;
    private String nomeTitular;
    private double saldo;

    public ContaBancaria(String numero, String nomeTitular, double saldo) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public void sacar(double valor){
        if(this.saldo < valor) {
            System.out.println("Saldo insuficiente");
            return;
        }
        this.saldo -= valor + 5;
    }

    public String toString() {
        return "Account " +
                getNumero() +
                ", Holder: " +
                getNomeTitular() +
                ", Balance: " +
                getSaldo();
    }
}
