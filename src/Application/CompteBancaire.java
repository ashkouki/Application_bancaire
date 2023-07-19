package Application;

public class CompteBancaire {
	
	private String numeroCompte;
    private double solde;

    public CompteBancaire(String numeroCompte, double solde) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
    }

    public double getSolde() {
        return solde;
    }

    public void depot(double montant) {
        solde += montant;
    }

	public static void main(String[] args) {
	

	}

}
