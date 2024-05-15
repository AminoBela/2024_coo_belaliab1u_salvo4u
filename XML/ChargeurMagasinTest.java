package XML;

import donnees.Magasin;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ChargeurMagasinTest {

    @Test

    void chargerDirectoryValide() {
        ChargeurMagasin chargeur = new ChargeurMagasin("../magasinCD_donnees/musicbrainzSimple/");
        try {
            Magasin magasin = chargeur.chargerMagasin();
            assertNotNull(magasin);
            assertEquals(12, magasin.getNombreCds());
        } catch (FileNotFoundException e) {
            fail("Le répertoire existe, il ne devrait pas y avoir d'exception");
        }
    }


    @Test
    void chargerDirectoryInvalide() {
        ChargeurMagasin chargeur = new ChargeurMagasin("../Directory/Invalide/");
        assertThrows(FileNotFoundException.class, chargeur::chargerMagasin);
    }
}