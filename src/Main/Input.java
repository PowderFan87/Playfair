/**********************************************************************
 * Copyright (c) 2013 Holger Szuesz, <hszuesz@live.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to
 * deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 *********************************************************************/

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
