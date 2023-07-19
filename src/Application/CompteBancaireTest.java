package Application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompteBancaireTest {

	private CompteBancaire compte;

    @BeforeEach
    public void setUp() {
        compte = new CompteBancaire("123456789", 1000);
    }
    
    @Test
    public void testGetSolde() {
        double solde = compte.getSolde();
        Assertions.assertEquals(1000, solde);
    }

    @Test
    public void testDepot() {
        compte.depot(500);
        double solde = compte.getSolde();
        Assertions.assertEquals(1500, solde);
    }

    @Test
    public void testRetraitAvecSoldeSuffisant() throws SoldeInsuffisantException {
        compte.retrait(500);
        double solde = compte.getSolde();
        Assertions.assertEquals(500, solde);
    }

    @Test
    public void testRetraitAvecSoldeInsuffisant() {
        Assertions.assertThrows(SoldeInsuffisantException.class, () -> compte.retrait(1500));
    }

    @Test
    public void testTransfererAvecSoldeSuffisant() throws SoldeInsuffisantException {
        CompteBancaire destination = new CompteBancaire("987654321", 0);
        compte.transferer(destination, 500);
        
        double soldeCompte = compte.getSolde();
        double soldeDestination = destination.getSolde();
        
        Assertions.assertEquals(500, soldeCompte);
        Assertions.assertEquals(500, soldeDestination);
    }

    @Test
    public void testTransfererAvecSoldeInsuffisant() {
        CompteBancaire destination = new CompteBancaire("987654321", 0);
        Assertions.assertThrows(SoldeInsuffisantException.class, () -> compte.transferer(destination, 1500));
    }
}
