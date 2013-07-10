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
public class Cryptcore
{
    protected   List<Character> lisTable;
    protected   List<String>    lisBigrams;

    private     List<List>      lisCol;
    private     List<List>      lisRow;

    public Cryptcore() {
        this.lisCol = new ArrayList();

        this.lisCol.add(new ArrayList());
        this.lisCol.add(new ArrayList());
        this.lisCol.add(new ArrayList());
        this.lisCol.add(new ArrayList());
        this.lisCol.add(new ArrayList());

        this.lisCol.get(0).add(0);
        this.lisCol.get(0).add(5);
        this.lisCol.get(0).add(10);
        this.lisCol.get(0).add(15);
        this.lisCol.get(0).add(20);

        this.lisCol.get(1).add(1);
        this.lisCol.get(1).add(6);
        this.lisCol.get(1).add(11);
        this.lisCol.get(1).add(16);
        this.lisCol.get(1).add(21);

        this.lisCol.get(2).add(2);
        this.lisCol.get(2).add(7);
        this.lisCol.get(2).add(12);
        this.lisCol.get(2).add(17);
        this.lisCol.get(2).add(22);

        this.lisCol.get(3).add(3);
        this.lisCol.get(3).add(8);
        this.lisCol.get(3).add(13);
        this.lisCol.get(3).add(18);
        this.lisCol.get(3).add(23);

        this.lisCol.get(4).add(4);
        this.lisCol.get(4).add(9);
        this.lisCol.get(4).add(14);
        this.lisCol.get(4).add(19);
        this.lisCol.get(4).add(24);

        this.lisRow = new ArrayList();

        this.lisRow.add(new ArrayList());
        this.lisRow.add(new ArrayList());
        this.lisRow.add(new ArrayList());
        this.lisRow.add(new ArrayList());
        this.lisRow.add(new ArrayList());

        this.lisRow.get(0).add(0);
        this.lisRow.get(0).add(1);
        this.lisRow.get(0).add(2);
        this.lisRow.get(0).add(3);
        this.lisRow.get(0).add(4);

        this.lisRow.get(1).add(5);
        this.lisRow.get(1).add(6);
        this.lisRow.get(1).add(7);
        this.lisRow.get(1).add(8);
        this.lisRow.get(1).add(9);

        this.lisRow.get(2).add(10);
        this.lisRow.get(2).add(11);
        this.lisRow.get(2).add(12);
        this.lisRow.get(2).add(13);
        this.lisRow.get(2).add(14);

        this.lisRow.get(3).add(15);
        this.lisRow.get(3).add(16);
        this.lisRow.get(3).add(17);
        this.lisRow.get(3).add(18);
        this.lisRow.get(3).add(19);

        this.lisRow.get(4).add(20);
        this.lisRow.get(4).add(21);
        this.lisRow.get(4).add(22);
        this.lisRow.get(4).add(23);
        this.lisRow.get(4).add(24);
    }

    protected int getColofvalue(int a) {
        int lngCol = 0;

        if(this.lisCol.get(0).contains(a)) {
            lngCol = 0;
        }else if(this.lisCol.get(1).contains(a)) {
            lngCol = 1;
        } else if(this.lisCol.get(2).contains(a)) {
            lngCol = 2;
        } else if(this.lisCol.get(3).contains(a)) {
            lngCol = 3;
        } else if(this.lisCol.get(4).contains(a)) {
            lngCol = 4;
        }

        return lngCol;
    }

    protected int getRowofvalue(int a) {
        int lngRow = 0;

        if(lisCol.get(0).contains(a)) {
            lngRow = 0;
        }else if(lisCol.get(1).contains(a)) {
            lngRow = 1;
        } else if(lisCol.get(2).contains(a)) {
            lngRow = 2;
        } else if(lisCol.get(3).contains(a)) {
            lngRow = 3;
        } else if(lisCol.get(4).contains(a)) {
            lngRow = 4;
        }

        return lngRow;
    }
}
