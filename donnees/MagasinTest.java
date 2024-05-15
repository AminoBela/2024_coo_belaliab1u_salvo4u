package donnees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MagasinTest {

    @Test
    void testTrierAlbum() {
        Magasin magasin = new Magasin();
        CD cd1 = new CD("artiste1", "CD1");
        CD cd2 = new CD("artiste2", "CD2");
        CD cd3 = new CD("artiste3", "CD3");
        magasin.ajouteCd(cd2);
        magasin.ajouteCd(cd1);
        magasin.ajouteCd(cd3);
        magasin.trierAlbum();
        assertEquals(cd1, magasin.getCd(0));
        assertEquals(cd3, magasin.getCd(magasin.getNombreCds() - 1));
    }

    @Test
    void testTrierArtiste() {
        Magasin magasin = new Magasin();
        CD cd1 = new CD("artiste1", "CD1");
        CD cd2 = new CD("artiste2", "CD2");
        CD cd3 = new CD("artiste3", "CD3");
        magasin.ajouteCd(cd2);
        magasin.ajouteCd(cd1);
        magasin.ajouteCd(cd3);
        magasin.trierAriste();
        assertEquals(cd1, magasin.getCd(0));
        assertEquals(cd3, magasin.getCd(magasin.getNombreCds() - 1));
    }
}
