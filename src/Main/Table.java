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
public class Table
{
    private static  String          strCharlist = "ABCDEFGHIKLMNOPQRSTUVWXYZ";

    private         List<Character> lisTable    = new ArrayList<>();

    public Table(String strKeyword) {
        for(int i = 0; i < strKeyword.length(); i++) {
            if(!this.lisTable.contains(strKeyword.charAt(i))) {
                this.lisTable.add(strKeyword.charAt(i));
            }
        }

        for(int i = 0; i < Table.strCharlist.length(); i++) {
            if(!this.lisTable.contains(Table.strCharlist.charAt(i))) {
                this.lisTable.add(Table.strCharlist.charAt(i));
            }
        }
    }

    public List<Character> getListable() {
        return this.lisTable;
    }

    public String toString() {
        String output = "";

        for(int i = 0; i < this.lisTable.size(); i++) {
            output += this.lisTable.get(i);

            if((i+1)%5 == 0) {
                output += "\n";
            } else {
                output += " ";
            }
        }

        return output;
    }
}
