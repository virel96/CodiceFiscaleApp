
package view;

/**
 *
 * @author Sandro
 */
public class TuiInterface {

    public void esempio() {
        model.Anagrafica ana = new model.Anagrafica ( "Sandro", "Gallo", "m",
                "28/12/1961", "Italy", "Catanzaro" );
        model.CodiceFiscale cf = new model.CodiceFiscale(ana);
        System.out.println( cf.getCodice() );
    }
    
}
