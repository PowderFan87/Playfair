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
