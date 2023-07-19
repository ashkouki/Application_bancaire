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

    
    public void retrait(double montant) throws SoldeInsuffisantException {
        if (solde >= montant) {
            solde -= montant;
        } else {
            throw new SoldeInsuffisantException("Solde insuffisant pour effectuer le retrait.");
        }
    }

    public void transferer(CompteBancaire destination, double montant) throws SoldeInsuffisantException {
        if (solde >= montant) {
            retrait(montant);
            destination.depot(montant);
        } else {
            throw new SoldeInsuffisantException("Solde insuffisant pour effectuer le transfert.");
        }
    }
    


}
