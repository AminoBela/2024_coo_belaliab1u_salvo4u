package donnees;

import java.util.ArrayList;

/**
 * La classe Magasin represente un magasin qui vend des CDs.</p>
 * 
 * cette classe est caracterisee par un ensemble de CDs correspondant aux CDS
 * vendus dans ce magasin.
 * 
 */
public class Magasin {

	/**
	 * la liste des CDs disponibles en magasin
	 */
	private ArrayList<CD> listeCds;

	/**
	 * construit un magasin par defaut qui ne contient pas de CD
	 */
	public Magasin() {
		listeCds = new ArrayList<CD>();
	}

	/**
	 * ajoute un cd au magasin
	 * 
	 * @param cdAAjouter
	 *            le cd a ajouter
	 */
	public void ajouteCd(CD cdAAjouter) {
		listeCds.add(cdAAjouter);
	}

	@Override
	/**
	 * affiche le contenu du magasin
	 */
	public String toString() {
		String chaineResultat = "";
		//parcours des Cds
		for (int i = 0; i < listeCds.size(); i++) {
			chaineResultat += listeCds.get(i);
		}
		chaineResultat += "nb Cds: " + listeCds.size();
		return (chaineResultat);

	}

	/**
	 * @return le nombre de Cds du magasin
	 */
	public int getNombreCds() {
		return listeCds.size();
	}
	
	/**
	 * permet d'acceder à un CD
	 * 
	 * @return le cd a l'indice i ou null si indice est non valide
	 */
	public CD getCd(int i)
	{
		CD res=null;
		if ((i>=0)&&(i<this.listeCds.size()))
			res=this.listeCds.get(i);
		return(res);
	}

	/**
	 * trie les CDs du magasin par album
	 */

	public void trierAlbum(){
		ArrayList<CD> cd_trie = new ArrayList<>();
		while(!this.listeCds.isEmpty()){
			CD min = this.listeCds.get(0);
			int ind =0;
			int ind_val =0;
			for(CD v : this.listeCds){
				if(min.getCD().compareTo(v.getCD())<0){
					min = v;
					ind_val = ind;
				}
				ind++;
			}
			cd_trie.add(min);
			this.listeCds.remove(ind_val);
		}
		this.listeCds = cd_trie;
	}

	/**
	 * trie les CDs du magasin par artiste
	 */

	public void trierAriste() {
		ArrayList<CD> listeCdsTries = new ArrayList<CD>();
		while (!listeCds.isEmpty()) {
			int indiceMin = 0;
			for (int i = 1; i < listeCds.size(); i++) {
				if (listeCds.get(i).getArtiste().compareTo(listeCds.get(indiceMin).getArtiste()) < 0) {
					indiceMin = i;
				}
			}
			listeCdsTries.add(listeCds.get(indiceMin));
			listeCds.remove(indiceMin);
		}
		listeCds = listeCdsTries;
	}


}
