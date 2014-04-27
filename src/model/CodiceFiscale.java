
package model;
import java.util.Calendar;

/**
 * Calcola il codice fiscale dell'anagrafica passata al costruttore
 * @author Sandro
 */
public class CodiceFiscale {
    
    private String codicefiscale;

    public CodiceFiscale(Anagrafica ana) {
        int i, n, tot;
        char c;
        String s, cod = "";
        
        // CALCOLO DEL COGNOME
        // elimina eventuali spazi e lo pone in maiuscolo
        s = ana.getCognome().toUpperCase().replaceAll("\\s", "");
        // se il cognome ha meno di tre lettere va completato con delle X
        if ( s.length() < 3 ) {
            cod += s;
            while (cod.length()<3) cod += "X";
        } else {
            // prendo 3 consonanti dal cognome
            for ( i=0; i<s.length() && cod.length()<3; i++ ) {
                c = s.charAt(i);
                if ( "AEIOU".indexOf(c)>=0 ) continue;
                cod += c;
            }
            // se non le trovo completo con le vocali (che ci sono sicuro)
            for ( i=0; i<s.length() && cod.length()<3; i++ ) {
                c = s.charAt(i);
                if ( "AEIOU".indexOf(c)<0 ) continue;
                cod += c;
            }
        }
        
        // CALCOLO DEL NOME
        s = ana.getNome().toUpperCase().replaceAll("\\s", "");
        // se il nome ha meno di tre lettere va completato con delle X
        if ( s.length() < 3 ) {
            cod += s;
            while (cod.length()<6) cod += "X";
        } else {
            // conto le consonanti
            for ( i=0, n=0; i<s.length(); i++ ) {
                c = s.charAt(i);
                if ( "AEIOU".indexOf(c)<0 ) n++;
            }
            tot = n;
            // ora ne porto massimo 3 nel codice
            for ( i=0, n=0; i<s.length() && cod.length()<6; i++ ) {
                c = s.charAt(i);
                if ( "AEIOU".indexOf(c)>=0 ) continue;
                n++;
                // salto la seconda se sono almeno 4
                if (n==2 && tot>=4) continue;
                cod += c;
            }
            // se non bastano completo con le vocali
            for ( i=0; i<s.length() && cod.length()<6; i++ ) {
                c = s.charAt(i);
                if ( "AEIOU".indexOf(c)<0 ) continue;
                cod += c;
            }
        }
        
        // CALCOLO DELLE POSIZIONI 7,8,9,10,11 (YY M DD-S)
        Calendar cal = Calendar.getInstance();
        cal.setTime(ana.getDataNascita());
        int anno = cal.get(Calendar.YEAR);
        int mese = cal.get(Calendar.MONTH);
        int giorno = cal.get(Calendar.DAY_OF_MONTH);
        if( anno%100 < 10 ) cod += "0";
        cod += Integer.toString(anno%100);
        String codiceMese = "ABCDEHLMPRST";
        cod += codiceMese.charAt(mese);
        if ( ana.isMaschio() ) {
            if ( giorno < 10 ) cod += "0";
            cod += Integer.toString( giorno );
        } else {
            cod += Integer.toString( giorno + 40 );
        }
       
        // CALCOLO DEL CODICE ISTAT, posizioni 12,13,14,15
        String istat;
        String statoNascita = ana.getStatoNascita().toUpperCase().trim();
        if ( statoNascita.equalsIgnoreCase("Italy") || statoNascita.equalsIgnoreCase("Italia") ) {
            istat = ana.getCodComuneNascita();
        } else {
            Codifica stati = new Codifica("codici_stati.csv", 1, 0);
            istat = stati.decode(statoNascita);
        }
        cod += istat;

        // CALCOLO DEL CARATTERE DI CONTROLLO
        int valoreInteroCarattereControllo=0;
        // scorro tutti i caratteri pari
        for ( i=1; i<=13; i+=2 ) {
            switch ( cod.charAt(i) ) {
                case '0': {valoreInteroCarattereControllo+=0;break;}//se il carattere é 0 somma il valore 0
                case '1': {valoreInteroCarattereControllo+=1;break;}//se il carattere é 1 somma il valore 1
                case '2': {valoreInteroCarattereControllo+=2;break;}//se il carattere é 2 somma il valore 2
                case '3': {valoreInteroCarattereControllo+=3;break;}//se il carattere é 3 somma il valore 3
                case '4': {valoreInteroCarattereControllo+=4;break;}//se il carattere é 4 somma il valore 4
                case '5': {valoreInteroCarattereControllo+=5;break;}//se il carattere é 5 somma il valore 5
                case '6': {valoreInteroCarattereControllo+=6;break;}//se il carattere é 6 somma il valore 6
                case '7': {valoreInteroCarattereControllo+=7;break;}//se il carattere é 7 somma il valore 7
                case '8': {valoreInteroCarattereControllo+=8;break;}//se il carattere é 8 somma il valore 8
                case '9': {valoreInteroCarattereControllo+=9;break;}//se il carattere é 9 somma il valore 9
                case 'A': {valoreInteroCarattereControllo+=0;break;}//se il carattere é A somma il valore 0
                case 'B': {valoreInteroCarattereControllo+=1;break;}//se il carattere é B somma il valore 1
                case 'C': {valoreInteroCarattereControllo+=2;break;}//se il carattere é C somma il valore 2
                case 'D': {valoreInteroCarattereControllo+=3;break;}//se il carattere é D somma il valore 3
                case 'E': {valoreInteroCarattereControllo+=4;break;}//se il carattere é E somma il valore 4
                case 'F': {valoreInteroCarattereControllo+=5;break;}//se il carattere é F somma il valore 5
                case 'G': {valoreInteroCarattereControllo+=6;break;}//se il carattere é G somma il valore 6
                case 'H': {valoreInteroCarattereControllo+=7;break;}//se il carattere é H somma il valore 7
                case 'I': {valoreInteroCarattereControllo+=8;break;}//se il carattere é I somma il valore 8
                case 'J': {valoreInteroCarattereControllo+=9;break;}//se il carattere é J somma il valore 9
                case 'K': {valoreInteroCarattereControllo+=10;break;}//se il carattere é K somma il valore 10
                case 'L': {valoreInteroCarattereControllo+=11;break;}//se il carattere é L somma il valore 11
                case 'M': {valoreInteroCarattereControllo+=12;break;}//se il carattere é M somma il valore 12
                case 'N': {valoreInteroCarattereControllo+=13;break;}//se il carattere é N somma il valore 13
                case 'O': {valoreInteroCarattereControllo+=14;break;}//se il carattere é O somma il valore 14
                case 'P': {valoreInteroCarattereControllo+=15;break;}//se il carattere é P somma il valore 15
                case 'Q': {valoreInteroCarattereControllo+=16;break;}//se il carattere é Q somma il valore 16
                case 'R': {valoreInteroCarattereControllo+=17;break;}//se il carattere é R somma il valore 17
                case 'S': {valoreInteroCarattereControllo+=18;break;}//se il carattere é S somma il valore 18
                case 'T': {valoreInteroCarattereControllo+=19;break;}//se il carattere é T somma il valore 19
                case 'U': {valoreInteroCarattereControllo+=20;break;}//se il carattere é U somma il valore 20
                case 'V': {valoreInteroCarattereControllo+=21;break;}//se il carattere é V somma il valore 21
                case 'W': {valoreInteroCarattereControllo+=22;break;}//se il carattere é W somma il valore 22
                case 'X': {valoreInteroCarattereControllo+=23;break;}//se il carattere é X somma il valore 23
                case 'Y': {valoreInteroCarattereControllo+=24;break;}//se il carattere é Y somma il valore 24
                case 'Z': {valoreInteroCarattereControllo+=25;break;}//se il carattere é Z somma il valore 25
            }
        }
        //scorro tutti i caratteri dispari
        for ( i=0; i<=14; i+=2 ) {
            switch (cod.charAt(i)) {
                case '0': {valoreInteroCarattereControllo+=1;break;}// se il carattere è 0 somma il valore 1
                case '1': {valoreInteroCarattereControllo+=0;break;}// se il carattere è 1 somma il valore 0
                case '2': {valoreInteroCarattereControllo+=5;break;}// se il carattere è 2 somma il valore 5
                case '3': {valoreInteroCarattereControllo+=7;break;}// se il carattere è 3 somma il valore 7
                case '4': {valoreInteroCarattereControllo+=9;break;}// se il carattere è 4 somma il valore 9
                case '5': {valoreInteroCarattereControllo+=13;break;}// se il carattere è 5 somma il valore 13
                case '6': {valoreInteroCarattereControllo+=15;break;}// se il carattere è 6 somma il valore 15
                case '7': {valoreInteroCarattereControllo+=17;break;}// se il carattere è 7 somma il valore 17
                case '8': {valoreInteroCarattereControllo+=19;break;}// se il carattere è 8 somma il valore 19
                case '9': {valoreInteroCarattereControllo+=21;break;}// se il carattere è 9 somma il valore 21
                case 'A': {valoreInteroCarattereControllo+=1;break;}// se il carattere è A somma il valore 1
                case 'B': {valoreInteroCarattereControllo+=0;break;}// se il carattere è B somma il valore 0
                case 'C': {valoreInteroCarattereControllo+=5;break;}// se il carattere è C somma il valore 5
                case 'D': {valoreInteroCarattereControllo+=7;break;}// se il carattere è D somma il valore 7
                case 'E': {valoreInteroCarattereControllo+=9;break;}// se il carattere è E somma il valore 9
                case 'F': {valoreInteroCarattereControllo+=13;break;}// se il carattere è F somma il valore 13
                case 'G': {valoreInteroCarattereControllo+=15;break;}// se il carattere è G somma il valore 15
                case 'H': {valoreInteroCarattereControllo+=17;break;}// se il carattere è H somma il valore 17
                case 'I': {valoreInteroCarattereControllo+=19;break;}// se il carattere è I somma il valore 19
                case 'J': {valoreInteroCarattereControllo+=21;break;}// se il carattere è J somma il valore 21
                case 'K': {valoreInteroCarattereControllo+=2;break;}// se il carattere è K somma il valore 2
                case 'L': {valoreInteroCarattereControllo+=4;break;}// se il carattere è L somma il valore 4
                case 'M': {valoreInteroCarattereControllo+=18;break;}// se il carattere è M somma il valore 18
                case 'N': {valoreInteroCarattereControllo+=20;break;}// se il carattere è N somma il valore 20
                case 'O': {valoreInteroCarattereControllo+=11;break;}// se il carattere è O somma il valore 11
                case 'P': {valoreInteroCarattereControllo+=3;break;}// se il carattere è P somma il valore 3
                case 'Q': {valoreInteroCarattereControllo+=6;break;}// se il carattere è Q somma il valore 6
                case 'R': {valoreInteroCarattereControllo+=8;break;}// se il carattere è R somma il valore 8
                case 'S': {valoreInteroCarattereControllo+=12;break;}// se il carattere è S somma il valore 12
                case 'T': {valoreInteroCarattereControllo+=14;break;}// se il carattere è T somma il valore 14
                case 'U': {valoreInteroCarattereControllo+=16;break;}// se il carattere è U somma il valore 16
                case 'V': {valoreInteroCarattereControllo+=10;break;}// se il carattere è V somma il valore 10
                case 'W': {valoreInteroCarattereControllo+=22;break;}// se il carattere è W somma il valore 22
                case 'X': {valoreInteroCarattereControllo+=25;break;}// se il carattere è X somma il valore 25
                case 'Y': {valoreInteroCarattereControllo+=24;break;}// se il carattere è Y somma il valore 24
                case 'Z': {valoreInteroCarattereControllo+=23;break;}// se il carattere è Z somma il valore 23
            }
        }
        String carattereControllo="";
        switch (valoreInteroCarattereControllo%26) {//il resto dellla divisione per 26
            case 1:{carattereControllo="B";break;}// se il resto della divisione per 26 è 1 allora il carattere di controllo è B
            case 0:{carattereControllo="A";break;}// se il resto della divisione per 26 è 0 allora il carattere di controllo è A
            case 2:{carattereControllo="C";break;}// se il resto della divisione per 26 è 2 allora il carattere di controllo è C
            case 3:{carattereControllo="D";break;}// se il resto della divisione per 26 è 3 allora il carattere di controllo è D
            case 4:{carattereControllo="E";break;}// se il resto della divisione per 26 è 4 allora il carattere di controllo è E
            case 5:{carattereControllo="F";break;}// se il resto della divisione per 26 è 5 allora il carattere di controllo è F
            case 6:{carattereControllo="G";break;}// se il resto della divisione per 26 è 6 allora il carattere di controllo è G
            case 7:{carattereControllo="H";break;}// se il resto della divisione per 26 è 7 allora il carattere di controllo è H
            case 8:{carattereControllo="I";break;}// se il resto della divisione per 26 è 8 allora il carattere di controllo è I
            case 9:{carattereControllo="J";break;}// se il resto della divisione per 26 è 9 allora il carattere di controllo è J
            case 10:{carattereControllo="K";break;}// se il resto della divisione per 26 è 10 allora il carattere di controllo è K
            case 11:{carattereControllo="L";break;}// se il resto della divisione per 26 è 11 allora il carattere di controllo è L
            case 12:{carattereControllo="M";break;}// se il resto della divisione per 26 è 12 allora il carattere di controllo è M
            case 13:{carattereControllo="N";break;}// se il resto della divisione per 26 è 13 allora il carattere di controllo è N
            case 14:{carattereControllo="O";break;}// se il resto della divisione per 26 è 14 allora il carattere di controllo è O
            case 15:{carattereControllo="P";break;}// se il resto della divisione per 26 è 15 allora il carattere di controllo è P
            case 16:{carattereControllo="Q";break;}// se il resto della divisione per 26 è 16 allora il carattere di controllo è Q
            case 17:{carattereControllo="R";break;}// se il resto della divisione per 26 è 17 allora il carattere di controllo è R
            case 18:{carattereControllo="S";break;}// se il resto della divisione per 26 è 18 allora il carattere di controllo è S
            case 19:{carattereControllo="T";break;}// se il resto della divisione per 26 è 19 allora il carattere di controllo è T
            case 20:{carattereControllo="U";break;}// se il resto della divisione per 26 è 20 allora il carattere di controllo è U
            case 21:{carattereControllo="V";break;}// se il resto della divisione per 26 è 21 allora il carattere di controllo è V
            case 22:{carattereControllo="W";break;}// se il resto della divisione per 26 è 22 allora il carattere di controllo è W
            case 23:{carattereControllo="X";break;}// se il resto della divisione per 26 è 23 allora il carattere di controllo è X
            case 24:{carattereControllo="Y";break;}// se il resto della divisione per 26 è 24 allora il carattere di controllo è Y
            case 25:{carattereControllo="Z";break;}// se il resto della divisione per 26 è 25 allora il carattere di controllo è Z
        }
        cod += carattereControllo;
        this.codicefiscale=cod;
    }
    
    public String getCodice() {
        return codicefiscale;
    }

    @Override
    public String toString() {
        return codicefiscale;
    }
    
}
