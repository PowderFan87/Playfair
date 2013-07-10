package Main;

import java.util.Scanner;
import java.util.List;

/**
 *
 * @author szueshol
 */
public class Main {

    public static Scanner objIn = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Input   objInput    = new Input();
        boolean blnGoon     = true;

        do {
            switch(Main.showMenu()) {
                case 1:
                    System.out.println("[1] Encrypt text\n\n"
                            + "Please enter the text you whant to encrypt:");

                    objInput.setTxtplaintext(Main.objIn.nextLine());

                    System.out.println("\nPlease enter keyword:");

                    objInput.setStrkeyword(Main.objIn.nextLine());

                    objInput.doPreparevalues(0);

                    Table objTable = new Table(objInput.getStrkeyword());

                    System.out.println("Your playfair crypt square:\n" + objTable);

                    Encrypt objEncrypt = new Encrypt(objInput.getLisbigrams(), objTable.getListable());

                    List<String> lisCrypted = objEncrypt.doEncrypt();

                    System.out.println("Your crypted bigrams:");
                    for(String strBigram : lisCrypted) {
                        System.out.print(strBigram + " ");
                    }

                    Main.objIn.nextLine();

                    break;

                case 2:
                    System.out.println("[2] Decrypt text\n\n"
                            + "Please enter the text you whant to decrypt:");

                    objInput.setTxtplaintext(Main.objIn.nextLine());

                    System.out.println("\nPlease enter Keyword:");

                    objInput.setStrkeyword(Main.objIn.nextLine());

                    objInput.doPreparevalues(1);

                    Table objTable2 = new Table(objInput.getStrkeyword());

                    System.out.println("Your playfair crypt square:\n" + objTable2);

                    Decrypt objDecrypt = new Decrypt(objInput.getLisbigrams(), objTable2.getListable());

                    List<String> lisPlain = objDecrypt.doDecrypt();

                    System.out.println("Your decrypted bigrams:");
                    for(String strBigram : lisPlain) {
                        System.out.print(strBigram + " ");
                    }

                    Main.objIn.nextLine();

                    break;

                case 0:
                default:
                    System.out.println("Thank you and good bye...");

                    blnGoon = false;

                    break;
            }

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        } while(blnGoon);
    }

    private static int showMenu() {
        int lngAction;

        System.out.println("###   P L A Y F A I R   C I P H E R   ###\n"
                + "###\n"
                + "### [1] Encrypt text\n"
                + "### [2] Decrypt text\n"
                + "### \n"
                + "### [0] EXIT\n");

        lngAction = Main.objIn.nextInt();
        Main.objIn.nextLine();

        return lngAction;
    }
}
