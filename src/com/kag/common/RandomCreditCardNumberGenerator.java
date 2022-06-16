package com.kag.common;

import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 * See the license below. Obviously, this is not a Javascript credit card number
 * generator. However, The following class is a port of a Javascript credit card
 * number generator.
 *
 * @author KHighness
 * @since 2020/4/30
 */
public class RandomCreditCardNumberGenerator {

    private static final String[] VISA_PREFIX_LIST = new String[] { "4539", "4556", "4916", "4532", "4929", "40240071", "4485", "4716", "4" };

    public static final String[] MASTERCARD_PREFIX_LIST = new String[] { "51", "52", "53", "54", "55" };

    public static final String[] DISCOVER_PREFIX_LIST = new String[] { "6011" };

    public static final String[] DINERS_PREFIX_LIST = new String[] { "300", "301", "302", "303", "36", "38" };

    public static final String[] JCB_PREFIX_LIST = new String[] { "35" };

    public static final String[] VOYAGER_PREFIX_LIST = new String[] { "8699" };

    public static String strRev (String str) {
        if (str == null)
            return "";
        String revstr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            revstr += str.charAt(i);
        }

        return revstr;
    }

    /*
     * 'prefix' is the start of the CC number as a string, any number of digits.
     * 'length' is the length of the CC number to generate. Typically 13 or 16
     */
    static String completed_number(String prefix, int length) {

        String ccnumber = prefix;

        // generate digits
        while (ccnumber.length() < (length - 1)) {
            ccnumber += new Double(Math.floor(Math.random() * 10)).intValue();
        }

        // reverse number and convert to int
        String reversedCardNumberString = strRev(ccnumber);

        List<Integer> reversedCardNumberList = new Vector<Integer>();
        for (int i = 0; i < reversedCardNumberString.length(); i++) {
            reversedCardNumberList.add(new Integer(String
                    .valueOf(reversedCardNumberString.charAt(i))));
        }

        // calculate sum
        int sum = 0;
        int pos = 0;

        Integer[] reversedCardNumber = reversedCardNumberList
                .toArray(new Integer[reversedCardNumberList.size()]);
        while (pos < length - 1) {

            int odd = reversedCardNumber[pos] * 2;
            if (odd > 9) {
                odd -= 9;
            }

            sum += odd;

            if (pos != (length - 2)) {
                sum += reversedCardNumber[pos + 1];
            }
            pos += 2;
        }

        // calculate check digit

        int checkdigit = new Double(
                ((Math.floor(sum / 10) + 1) * 10 - sum) % 10).intValue();
        ccnumber += checkdigit;

        return ccnumber;

    }

    public static String[] credit_card_number(String[] prefixList, int length, int howMany) {
        Stack<String> result = new Stack<String>();
        for (int i = 0; i < howMany; i++) {
            int randomArrayIndex = (int) Math.floor(Math.random()
                    * prefixList.length);
            String cardNumber = prefixList[randomArrayIndex];
            result.push(completed_number(cardNumber, length));
        }
        return result.toArray(new String[result.size()]);
    }

    public static String[] generateMasterCardNumbers(int howMany) {
        return credit_card_number(MASTERCARD_PREFIX_LIST, 16, howMany);
    }

    public static String getRandomCardNumber() {
        return credit_card_number(MASTERCARD_PREFIX_LIST, 16, 1)[0];
    }

    public static boolean isValidCreditCardNumber(String creditCardNumber) {
        boolean isValid = false;
        try {
            String reversedNumber = new StringBuffer(creditCardNumber).reverse().toString();
            int mod10Count = 0;
            for (int i = 0; i < reversedNumber.length(); i++) {
                int augend = Integer.parseInt(String.valueOf(reversedNumber
                        .charAt(i)));
                if (((i + 1) % 2) == 0) {
                    String productString = String.valueOf(augend * 2);
                    augend = 0;
                    for (int j = 0; j < productString.length(); j++) {
                        augend += Integer.parseInt(String.valueOf(productString.charAt(j)));
                    }
                }
                mod10Count += augend;
            }
            if ((mod10Count % 10) == 0) {
                isValid = true;
            }
        } catch (NumberFormatException e) {
            ExceptionUtil.printException(e);
        }
        return isValid;
    }
}
