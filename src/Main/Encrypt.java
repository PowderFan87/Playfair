package Main;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author szueshol
 */
public class Encrypt extends Cryptcore
{
    public Encrypt(List<String> lisBigrams, List<Character> lisTables) {
        super();

        this.lisTable   = lisTables;
        this.lisBigrams = lisBigrams;
    }

    public List<String> doEncrypt() {
        List<String> lisEncrypted = new ArrayList();

        for(String strBigram : this.lisBigrams) {
            lisEncrypted.add(this.doEncryptbigram(strBigram));
        }

        return lisEncrypted;
    }

    private String doEncryptbigram(String strBigram) {
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
            if(arrIds[0] == 4 || arrIds[0] == 9 || arrIds[0] == 14 || arrIds[0] == 19 || arrIds[0] == 24) {
                arrNewids[0] = arrIds[0] - 4;
            } else {
                arrNewids[0] = arrIds[0] + 1;
            }

            if(arrIds[1] == 4 || arrIds[1] == 9 || arrIds[1] == 14 || arrIds[1] == 19 || arrIds[1] == 24) {
                arrNewids[1] = arrIds[1] - 4;
            } else {
                arrNewids[1] = arrIds[1] + 1;
            }
        } else if((lngDist%5) == 0 && lngCol1 == lngCol2) {
            //Same column
            if(arrIds[0] == 20 || arrIds[0] == 21 || arrIds[0] == 22 || arrIds[0] == 23 || arrIds[0] == 24) {
                arrNewids[0] = arrIds[0] - 20;
            } else {
                arrNewids[0] = arrIds[0] + 5;
            }

            if(arrIds[1] == 20 || arrIds[1] == 21 || arrIds[1] == 22 || arrIds[1] == 23 || arrIds[1] == 24) {
                arrNewids[1] = arrIds[1] - 20;
            } else {
                arrNewids[1] = arrIds[1] + 5;
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
