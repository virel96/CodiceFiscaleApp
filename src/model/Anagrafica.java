package model;
import java.util.Date;
/**
 * Classe modello per dati anagrafici
 * @author Sandro
 */
public class Anagrafica {
    private String cognome, nome, sesso;
    private Date dataNascita;
    private String statoNascita, codComuneNascita, desComuneNascita;
    private Date convertToDate(String s) {
        Date dt;
        java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
        try {
            dt = df.parse(s);
        } catch (Exception ex) {
            dt = new Date();
        }
        return dt;
    }
    public Anagrafica ( String cognome, String nome, String sesso,
            String dataNascita, String statoNascita, String desComuneNascita ) {
        this.cognome = cognome;
        this.nome = nome;
        this.sesso = sesso;
        this.dataNascita = this.convertToDate(dataNascita);
        this.statoNascita = statoNascita;
        this.desComuneNascita = desComuneNascita;
        Codifica c = new Codifica("codici_comuni.csv", 1, 0);
        this.codComuneNascita = c.decode(desComuneNascita);
    }
    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public Date   getDataNascita() { return dataNascita; }
    public String getStatoNascita() { return statoNascita; }
    public String getCodComuneNascita() { return codComuneNascita; }
    public String getDesComuneNascita() { return desComuneNascita; }
    public boolean isMaschio() { return (sesso.compareToIgnoreCase("m")==0); }
    public boolean isFemmina() { return (sesso.compareToIgnoreCase("f")==0); }
}