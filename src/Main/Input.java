package Main;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author szueshol
 */
public class Input
{
    private String          txtPlaintext;
    private String          strKeyword;
    private List<String>    lisBigrams = new ArrayList();

    public void setTxtplaintext(String txtPlaintext) {
        this.txtPlaintext = txtPlaintext;
        this.lisBigrams.clear();
    }

    public void setStrkeyword(String strKeyword) {
        this.strKeyword = strKeyword;
    }

    public List<String> getLisbigrams() {
        return this.lisBigrams;
    }

    public String getStrkeyword() {
        return this.strKeyword;
    }

    public void doPreparevalues(int lngMode) {
        // Prepare keyword
        this.strKeyword = this.strKeyword.toUpperCase().replace("J", "I").replaceAll("\\W", "");

        String txtPlaintext = this.txtPlaintext;

        switch(lngMode) {
            case 0:
                // create bigrams
                txtPlaintext = txtPlaintext.toUpperCase().replace("J", "I").replaceAll("\\W", "").replaceAll("([A-Z])\\1", "$1X$1");

                if((txtPlaintext.length()%2) != 0) {
                    txtPlaintext += "X";
                }

                break;

            case 1:
                // we have bigrams just remove spaces
                txtPlaintext = txtPlaintext.toUpperCase().replaceAll("\\W", "");

                break;
        }

        for(int i = 0; i+1 < txtPlaintext.length(); i++) {
            this.lisBigrams.add(txtPlaintext.substring(i, i+2));
            i++;
        }
    }
}
