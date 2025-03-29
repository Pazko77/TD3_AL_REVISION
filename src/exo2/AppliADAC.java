package exo2;

import exo2.cours.Cours;
import exo2.cours.Inscription;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JFBrette
 *
 */
public class AppliADAC {

	public static void main(String[] args) {

		List<Cours> listCours = new ArrayList<Cours>();

		Cours cours0 = new Cours (1,"AppRefJavaLeCafe",30);
		Cours cours1 = new Cours (2,"AppRefCLaLettre",30);
		Cours cours2 = new Cours (3,"AppRefPythonLeSerpent",30);
		Cours cours3 = new Cours (4,"AppRefJavaLajava",30);
		Cours cours4 = new Cours (5,"AppRefQualiteNonRelationnelleAudela",30);

		listCours.add(cours0);
		listCours.add(cours1);
		listCours.add(cours2);
		listCours.add(cours3);
		listCours.add(cours4);


		
	}

	
}
