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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author szueshol
 */
public class Decrypt extends Cryptcore
{
    public Decrypt(List<String> lisBigrams, List<Character> lisTables) {
        super();

        this.lisTable   = lisTables;
        this.lisBigrams = lisBigrams;
    }

    public List<String> doDecrypt() {
        List<String> lisDecrypted = new ArrayList();

        for(String strBigram : this.lisBigrams) {
            lisDecrypted.add(this.doDecryptbigram(strBigram));
        }

        return lisDecrypted;
    }

    private String doDecryptbigram(String strBigram) {
        char[]  arrChars        = strBigram.toCharArray();
        int[]   arrPositions    = new int[2];
        int[]   arrNewpositions;

        arrPositions[0] = this.lisTable.indexOf(arrChars[0]);
        arrPositions[1] = this.lisTable.indexOf(arrChars[1]);

        arrNewpositions = this.getShiftids(arrPositions);

        strBigram = this.lisTable.get(arrNewpositions[0]).toString() + this.lisTable.get(arrNewpositions[1]).toString();

        return strBigram;
    }

    private int[] getShiftids(int[] arrIds) {
        int[]   arrNewids   = new int[2];
        int     lngDist     = arrIds[1] - arrIds[0];

        if(lngDist < 0) {
            lngDist *= -1;
        }

        int lngCol1 = this.getColofvalue(arrIds[0]);
        int lngCol2 = this.getColofvalue(arrIds[1]);
        int lngRow1 = this.getRowofvalue(arrIds[0]);
        int lngRow2 = this.getRowofvalue(arrIds[1]);

        if(lngDist <= 4 && lngRow1 == lngRow2) {
            //Same row
            if(arrIds[0] == 0 || arrIds[0] == 5 || arrIds[0] == 10 || arrIds[0] == 15 || arrIds[0] == 20) {
                arrNewids[0] = arrIds[0] + 4;
            } else {
                arrNewids[0] = arrIds[0] - 1;
            }

            if(arrIds[1] == 0 || arrIds[1] == 5 || arrIds[1] == 10 || arrIds[1] == 15 || arrIds[1] == 20) {
                arrNewids[1] = arrIds[1] + 4;
            } else {
                arrNewids[1] = arrIds[1] - 1;
            }
        } else if((lngDist%5) == 0 && lngCol1 == lngCol2) {
            //Same column
            if(arrIds[0] == 0 || arrIds[0] == 1 || arrIds[0] == 2 || arrIds[0] == 3 || arrIds[0] == 4) {
                arrNewids[0] = arrIds[0] + 20;
            } else {
                arrNewids[0] = arrIds[0] - 5;
            }

            if(arrIds[1] == 0 || arrIds[1] == 1 || arrIds[1] == 2 || arrIds[1] == 3 || arrIds[1] == 4) {
                arrNewids[1] = arrIds[1] + 20;
            } else {
                arrNewids[1] = arrIds[1] - 5;
            }
        } else {
            //Rectangel rotate
            if(lngCol1 > lngCol2) {
                arrNewids[0] = arrIds[0] - (lngCol1 - lngCol2);
                arrNewids[1] = arrIds[1] + (lngCol1 - lngCol2);
            } else {
                arrNewids[0] = arrIds[0] + (lngCol2 - lngCol1);
                arrNewids[1] = arrIds[1] - (lngCol2 - lngCol1);
            }
        }

        return arrNewids;
    }
}
