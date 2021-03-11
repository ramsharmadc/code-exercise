package dsa.util;

import java.util.*;

public class CommonUtils {

    private static final String FOLDER_SEPARATOR = "/";

    private static final char EXTENSION_SEPARATOR = '.';

    /**
     * Append the given String to the given String array, returning a new array consisting of the
     * input array contents plus the given String.
     *
     * @param array the array to append to (can be <code>null</code>)
     * @param str   the String to append
     * @return the new array (never <code>null</code>)
     */
    public static String[] addStringToArray(final String[] array, final String str) {

        // if (ObjectUtils.isEmpty(array)) {
        if (array.length == 0)
            return new String[]{str};

        final String[] newArr = new String[array.length + 1];
        System.arraycopy(array, 0, newArr, 0, array.length);
        newArr[array.length] = str;
        return newArr;

        /**
         * long[] v = new long[x.length]; TreeSet<Integer> s = new TreeSet<>();
         *
         * for(int i = 0; i < x.length; i++){ if(operations[i]=="push"){ s.add(x[i]);
         * if(s.size()==1){ v[i] = x[i]*x[i]; } else { v[i]=s.first() * s.last(); } } else
         * if(operations[i]=="pop"){ s.remove(x[i]); if(s.size()==1){ v[i] = x[i]*x[i]; } else {
         * v[i]=s.first() * s.last(); } } } return v;
         */
    }

    // ---------------------------------------------------------------------
    // General convenience methods for working with Strings
    // ---------------------------------------------------------------------

    /**
     * Apply the given relative path to the given path, assuming standard Java folder separation
     * (i.e. "/" separators).
     *
     * @param path         the path to start from (usually a full file path)
     * @param relativePath the relative path to apply (relative to the full file path above)
     * @return the full file path that results from applying the relative path
     */
    public static String applyRelativePath(final String path, final String relativePath) {

        final int separatorIndex = path.lastIndexOf(FOLDER_SEPARATOR);
        if (separatorIndex != -1) {
            String newPath = path.substring(0, separatorIndex);
            if (!relativePath.startsWith(FOLDER_SEPARATOR)) {
                newPath += FOLDER_SEPARATOR;
            }
            return newPath + relativePath;
        } else
            return relativePath;
    }

    public static String arrayAsString(final char[] arr) throws Exception {

        return arrayAsString(arr, null);

    }

    public static String arrayAsString(final char[] arr, final String delimiter) {

        final StringBuilder str = new StringBuilder();

        final int lastIndx = arr.length - 1;
        if (lastIndx == -1)
            return "[]";

        for (int i = 0; ; i++) {
            str.append(arr[i]);
            if (i == lastIndx)
                return str.toString();
            str.append(delimiter != null ? delimiter : ", ");
        }
    }

    /**
     * convert the array into string separated by default delimiter which is comma separator
     *
     * @param arr
     * @return
     * @throws Exception
     */
    public static String arrayAsString(final int[] arr) throws Exception {

        return arrayAsString(arr, null);
    }

    /**
     * convert the array into string separated by the delimiter
     *
     * @param arr
     * @param delimiter
     * @return
     * @throws Exception
     */
    public static String arrayAsString(final int[] arr, final String delimiter) throws Exception {
        StringBuilder str = new StringBuilder();
        int lastIndx = arr.length - 1;
        String delim = (delimiter != null && !isEmpty(delimiter)) ? delimiter : ",";
        if (lastIndx == -1)
            return "[]";
        str.append("[");
        for (int i = 0; ; i++) {
            str.append(arr[i]);
            if (i == lastIndx)
                return str.append("]").toString();
            str.append(delim);
        }
    }

    /**
     * Capitalize a <code>String</code>, changing the first letter to upper case as per
     * {@link Character#toUpperCase(char)}. No other letters are changed.
     *
     * @param str the String to capitalize, may be <code>null</code>
     * @return the capitalized String, <code>null</code> if null
     */
    public static String capitalize(final String str) {

        return changeFirstCharacterCase(str, true);
    }

    private static String changeFirstCharacterCase(final String str, final boolean capitalize) {

        if ((str == null) || (str.length() == 0))
            return str;
        final StringBuilder sb = new StringBuilder(str.length());

        if (capitalize) {
            sb.append(Character.toUpperCase(str.charAt(0)));
        } else {
            sb.append(Character.toLowerCase(str.charAt(0)));
        }

        sb.append(str.substring(1));
        return sb.toString();
    }

    public static void checkAnagram(final String str_one, final String str_two) {

        int flag = 1;
        /*
         * System.out.println("Enter first string, second string: "); String str =
         * scan_it.nextLine(); String []strArr = str.split(",");
         */

        /*
         * String str1 = strArr[0].trim(); String str2 = strArr[1].trim();
         */

        final String str1 = str_one;
        final String str2 = str_two;

        final HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char c;

        for (int i = 0; i < str1.length(); i++) {
            c = str1.charAt(i);
            if (map.get(c) != null) {
                map.put(c, map.get(c + 1));
            } else {
                map.put(str1.charAt(i), 1);
            }
        }

        /*
         * for(int j = 0; j < str2.length(); j++){ if(map.containsKey(str2.charAt(j)))
         * map.put(str2.charAt(j), map.get(str2.charAt(j))-1); else flag = 0; }
         */

        for (int j = 0; j < str2.length(); j++) {
            if (map.containsKey(str2.charAt(j))) {
                map.put(str2.charAt(j), map.get(str2.charAt(j)) + 1);
            } else {
                flag = 0;
            }
        }

        /*
         * for(Integer k : map.values()) if(k !=0 ) flag = 0;
         */

        for (final Integer k : map.values())
            if ((k % 2) != 0) {
                flag = 0;
            }

        if (flag == 1) {
            System.out.println("Anagram");
        } else {
            System.out.println("Nt Anagram.");
        }

    }

    public static boolean checkAndRemoveDuplicates(final String str) {

        final StringBuilder strbuild = new StringBuilder();
        int flag = 0;

        for (int i = 0; i < str.length(); i++) {
            final String tempStr = str.substring(i, i + 1);

            if (str.charAt(i) != ' ')
                if (strbuild.indexOf(tempStr) == -1) {
                    strbuild.append(tempStr);
                } else {
                    flag = 1;
                    continue;
                }
        }

        System.out.println("After removing duplicates :" + strbuild.toString());

        return flag == 1;
    }

    public static boolean checkRepeat(final String str) {

        final Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ')
                if (map.containsKey(str.charAt(i))) {
                    map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
                } else {
                    map.put(str.charAt(i), 1);
                }
        }

        for (final char c : map.keySet())
            if (map.get(c) > 1)
                return true;

        // 9899573109

        return false;
    }

    public static boolean checkRotation(final String str1, final String str2) {

        return (str1.length() == str2.length()) && (isSubstring(str1, (str2.concat(str2)))
                || isSubstring(str2, (str1.concat(str1))));

    }

    public static boolean checkUniqueChar(final String str) {

        for (final Character c : str.toCharArray()) {

            if (!c.equals(' ')) {
                final int firstIdx = str.indexOf(c);
                final int lastIdx = str.lastIndexOf(c);

                System.out.println(firstIdx + ", " + lastIdx);
                if (firstIdx != lastIdx)
                    return false;
            }
        }

        return true;
    }

    /**
     * Convenience method to convert a CSV string list to a set. Note that this will suppress
     * duplicates.
     *
     * @param str the input String
     * @return a Set of String entries in the list
     */
    public static Set<String> commaDelimitedListToSet(final String str) {

        final Set<String> set = new TreeSet<String>();
        final String[] tokens = commaDelimitedListToStringArray(str);
        for (final String token : tokens) {
            set.add(token);
        }
        return set;
    }

    /**
     * Convert a CSV list into an array of Strings.
     *
     * @param str the input String
     * @return an array of Strings, or the empty array in case of empty input
     */
    public static String[] commaDelimitedListToStringArray(final String str) {

        return delimitedListToStringArray(str, ",");
    }

    /**
     * Concatenate the given String arrays into one, with overlapping array elements included twice.
     * <p>
     * The order of elements in the original arrays is preserved.
     *
     * @param array1 the first array (can be <code>null</code>)
     * @param array2 the second array (can be <code>null</code>)
     * @return the new array (<code>null</code> if both given arrays were <code>null</code>)
     */
    public static String[] concatenateStringArrays(final String[] array1, final String[] array2) {

        // if (ObjectUtils.isEmpty(array1)) {
        if (array1.length == 0)
            return array2;
        // if (ObjectUtils.isEmpty(array2)) {
        if (array2.length == 0)
            return array1;
        final String[] newArr = new String[array1.length + array2.length];
        System.arraycopy(array1, 0, newArr, 0, array1.length);
        System.arraycopy(array2, 0, newArr, array1.length, array2.length);
        return newArr;
    }

    /**
     * Check whether the given CharSequence contains any whitespace characters.
     *
     * @param str the CharSequence to check (may be <code>null</code>)
     * @return <code>true</code> if the CharSequence is not empty and contains at least 1 whitespace
     * character
     * @see Character#isWhitespace
     */
    public static boolean containsWhitespace(final CharSequence str) {

        if (!hasLength(str))
            return false;
        final int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(str.charAt(i)))
                return true;
        }
        return false;
    }

    /**
     * Check whether the given String contains any whitespace characters.
     *
     * @param str the String to check (may be <code>null</code>)
     * @return <code>true</code> if the String is not empty and contains at least 1 whitespace
     * character
     * @see #containsWhitespace(CharSequence)
     */
    public static boolean containsWhitespace(final String str) {

        return containsWhitespace((CharSequence) str);
    }

    /**
     * Count the occurrences of the substring in string s.
     *
     * @param str string to search in. Return 0 if this is null.
     * @param sub string to search for. Return 0 if this is null.
     */
    public static int countOccurrencesOf(final String str, final String sub) {

        if ((str == null) || (sub == null) || (str.length() == 0) || (sub.length() == 0))
            return 0;
        int count = 0;
        int pos = 0;
        int idx;
        while ((idx = str.indexOf(sub, pos)) != -1) {
            ++count;
            pos = idx + sub.length();
        }
        return count;
    }

    /**
     * Delete all occurrences of the given substring.
     *
     * @param inString the original String
     * @param pattern  the pattern to delete all occurrences of
     * @return the resulting String
     */
    public static String delete(final String inString, final String pattern) {

        return replace(inString, pattern, "");
    }

    // ---------------------------------------------------------------------
    // Convenience methods for working with formatted Strings
    // ---------------------------------------------------------------------

    /**
     * Delete any character in a given String.
     *
     * @param inString      the original String
     * @param charsToDelete a set of characters to delete. E.g. "az\n" will delete 'a's, 'z's and
     *                      new lines.
     * @return the resulting String
     */
    public static String deleteAny(final String inString, final String charsToDelete) {

        if (!hasLength(inString) || !hasLength(charsToDelete))
            return inString;
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inString.length(); i++) {
            final char c = inString.charAt(i);
            if (charsToDelete.indexOf(c) == -1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Take a String which is a delimited list and convert it to a String array.
     * <p>
     * A single delimiter can consists of more than one character: It will still be considered as
     * single delimiter string, rather than as bunch of potential delimiter characters - in contrast
     * to <code>tokenizeToStringArray</code>.
     *
     * @param str       the input String
     * @param delimiter the delimiter between elements (this is a single delimiter, rather than a
     *                  bunch individual delimiter characters)
     * @return an array of the tokens in the list
     * @see #tokenizeToStringArray
     */
    public static String[] delimitedListToStringArray(final String str, final String delimiter) {

        return delimitedListToStringArray(str, delimiter, null);
    }

    /**
     * Take a String which is a delimited list and convert it to a String array.
     * <p>
     * A single delimiter can consists of more than one character: It will still be considered as
     * single delimiter string, rather than as bunch of potential delimiter characters - in contrast
     * to <code>tokenizeToStringArray</code>.
     *
     * @param str           the input String
     * @param delimiter     the delimiter between elements (this is a single delimiter, rather than a
     *                      bunch individual delimiter characters)
     * @param charsToDelete a set of characters to delete. Useful for deleting unwanted line breaks:
     *                      e.g. "\r\n\f" will delete all new lines and line feeds in a String.
     * @return an array of the tokens in the list
     * @see #tokenizeToStringArray
     */
    public static String[] delimitedListToStringArray(final String str, final String delimiter,
                                                      final String charsToDelete) {

        if (str == null)
            return new String[0];
        if (delimiter == null)
            return new String[]{str};
        final List<String> result = new ArrayList<String>();
        if ("".equals(delimiter)) {
            for (int i = 0; i < str.length(); i++) {
                result.add(deleteAny(str.substring(i, i + 1), charsToDelete));
            }
        } else {
            int pos = 0;
            int delPos;
            while ((delPos = str.indexOf(delimiter, pos)) != -1) {
                result.add(deleteAny(str.substring(pos, delPos), charsToDelete));
                pos = delPos + delimiter.length();
            }
            if ((str.length() > 0) && (pos <= str.length())) {
                // Add rest of String, but not in case of empty input.
                result.add(deleteAny(str.substring(pos), charsToDelete));
            }
        }
        return toStringArray(result);
    }

    /**
     * Test if the given String ends with the specified suffix, ignoring upper/lower case.
     *
     * @param str    the String to check
     * @param suffix the suffix to look for
     * @see String#endsWith
     */
    public static boolean endsWithIgnoreCase(final String str, final String suffix) {

        if ((str == null) || (suffix == null))
            return false;
        if (str.endsWith(suffix))
            return true;
        if (str.length() < suffix.length())
            return false;

        final String lcStr = str.substring(str.length() - suffix.length()).toLowerCase();
        final String lcSuffix = suffix.toLowerCase();
        return lcStr.equals(lcSuffix);
    }

    // returns the first non repeated Character in a string
    public static Character findFirstNonRepeated(final String input) {

        // create a new hash table:
        final Hashtable<Character, Integer> hashChar = new Hashtable<>();

        int j, strLength;
        Character chr;
        Integer intgr;

        strLength = input.length();

        for (j = 0; j < strLength; j++) {
            chr = new Character(input.charAt(j));
            intgr = hashChar.get(chr);
            if (intgr == null) {
                hashChar.put(chr, new Integer(1));
            } else {
                hashChar.put(chr, new Integer(intgr.intValue() + 1));
            }
        }

        /*
         * go through hashtable and search for the first nonrepeated char:
         */

        for (j = 0; j < input.length(); j++) {
            chr = new Character(input.charAt(j));
            if (hashChar.get(chr).intValue() == 1)
                return chr;
        }
        /*
         * this only returns if the loop above doesn't find a nonrepeated character.
         */
        return null;
    }

    /**
     * Extract the filename from the given path, e.g. "mypath/myfile.txt" -> "myfile.txt".
     *
     * @param path the file path (may be <code>null</code>)
     * @return the extracted filename, or <code>null</code> if none
     */
    public static String getFilename(final String path) {

        if (path == null)
            return null;
        final int separatorIndex = path.lastIndexOf(FOLDER_SEPARATOR);
        return (separatorIndex != -1 ? path.substring(separatorIndex + 1) : path);
    }

    /**
     * Extract the filename extension from the given path, e.g. "mypath/myfile.txt" -> "txt".
     *
     * @param path the file path (may be <code>null</code>)
     * @return the extracted filename extension, or <code>null</code> if none
     */
    public static String getFilenameExtension(final String path) {

        if (path == null)
            return null;
        final int extIndex = path.lastIndexOf(EXTENSION_SEPARATOR);
        if (extIndex == -1)
            return null;
        final int folderIndex = path.lastIndexOf(FOLDER_SEPARATOR);
        if (folderIndex > extIndex)
            return null;
        return path.substring(extIndex + 1);
    }

    public static String getFirstLetterUpperCase(final String str) {

        final StringBuilder build = new StringBuilder();

        build.append(str.toUpperCase().charAt(0));
        build.append(str.substring(1));

        return build.toString();
    }

    /**
     * Check that the given CharSequence is neither <code>null</code> nor of length 0. Note: Will
     * return <code>true</code> for a CharSequence that purely consists of whitespace.
     * <p>
     * <p>
     *
     * <pre>
     * StringUtils.hasLength(null) = false StringUtils.hasLength("") = false StringUtils.hasLength(" ") = true
     * StringUtils.hasLength("Hello") = true
     * </pre>
     *
     * @param str the CharSequence to check (may be <code>null</code>)
     * @return <code>true</code> if the CharSequence is not null and has length
     * @see #hasText(String)
     */
    public static boolean hasLength(final CharSequence str) {

        return ((str != null) && (str.length() > 0));
    }

    /**
     * Check that the given String is neither <code>null</code> nor of length 0. Note: Will return
     * <code>true</code> for a String that purely consists of whitespace.
     *
     * @param str the String to check (may be <code>null</code>)
     * @return <code>true</code> if the String is not null and has length
     * @see #hasLength(CharSequence)
     */
    public static boolean hasLength(final String str) {

        return hasLength((CharSequence) str);
    }

    /**
     * Check whether the given CharSequence has actual text. More specifically, returns
     * <code>true</code> if the string not <code>null</code>, its length is greater than 0, and it
     * contains at least one non-whitespace character.
     * <p>
     * <p>
     *
     * <pre>
     *  StringUtils.hasText(null) = false StringUtils.hasText("") = false
     * StringUtils.hasText(" ") = false StringUtils.hasText("12345") = true StringUtils.hasText(" 12345 ") =
     * true
     * </pre>
     *
     * @param str the CharSequence to check (may be <code>null</code>)
     * @return <code>true</code> if the CharSequence is not <code>null</code>, its length is greater
     * than 0, and it does not contain whitespace only
     * @see Character#isWhitespace
     */
    public static boolean hasText(final CharSequence str) {

        if (!hasLength(str))
            return false;
        final int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i)))
                return true;
        }
        return false;
    }

    /**
     * Check whether the given String has actual text. More specifically, returns <code>true</code>
     * if the string not <code>null</code>, its length is greater than 0, and it contains at least
     * one non-whitespace character.
     *
     * @param str the String to check (may be <code>null</code>)
     * @return <code>true</code> if the String is not <code>null</code>, its length is greater than
     * 0, and it does not contain whitespace only
     * @see #hasText(CharSequence)
     */
    public static boolean hasText(final String str) {

        return hasText((CharSequence) str);
    }

    public static boolean isEmpty(final String s) {

        return ((s != null) && !s.isEmpty()) ? false : false;
    }

    public static boolean isSubstring(final String str1, final String str2) {

        return str2.contains(str1);
    }

    // ---------------------------------------------------------------------
    // Convenience methods for working with String arrays
    // ---------------------------------------------------------------------

    /**
     * Merge the given String arrays into one, with overlapping array elements only included once.
     * <p>
     * The order of elements in the original arrays is preserved (with the exception of overlapping
     * elements, which are only included on their first occurrence).
     *
     * @param array1 the first array (can be <code>null</code>)
     * @param array2 the second array (can be <code>null</code>)
     * @return the new array (<code>null</code> if both given arrays were <code>null</code>)
     */
    public static String[] mergeStringArrays(final String[] array1, final String[] array2) {

        // new TreeSet().remove(0).first();

        // if (ObjectUtils.isEmpty(array1)) {
        if (array1.length == 0)
            return array2;

        // if (ObjectUtils.isEmpty(array2)) {
        if (array2.length == 0)
            return array1;
        final List<String> result = new ArrayList<String>();
        result.addAll(Arrays.asList(array1));
        for (final String str : array2) {
            if (!result.contains(str)) {
                result.add(str);
            }
        }
        return toStringArray(result);
    }

    /**
     * Parse the given <code>localeString</code> value into a {@link Locale}.
     * <p>
     * This is the inverse operation of {@link Locale#toString Locale's toString}.
     *
     * @param localeString the locale string, following <code>Locale's</code>
     *                     <code>toString()</code> format ("en", "en_UK", etc); also accepts spaces as
     *                     separators, as an alternative to underscores
     * @return a corresponding <code>Locale</code> instance
     */
    public static Locale parseLocaleString(final String localeString) {

        final String[] parts = tokenizeToStringArray(localeString, "_ ", false, false);
        final String language = (parts.length > 0 ? parts[0] : "");
        final String country = (parts.length > 1 ? parts[1] : "");
        validateLocalePart(language);
        validateLocalePart(country);
        String variant = "";
        if (parts.length >= 2) {
            // There is definitely a variant, and it is everything after the
            // country
            // code sans the separator between the country code and the variant.
            final int endIndexOfCountryCode = localeString.indexOf(country) + country.length();
            // Strip off any leading '_' and whitespace, what's left is the
            // variant.
            variant = trimLeadingWhitespace(localeString.substring(endIndexOfCountryCode));
            if (variant.startsWith("_")) {
                variant = trimLeadingCharacter(variant, '_');
            }
        }
        return (language.length() > 0 ? new Locale(language, country, variant) : null);
    }

    /**
     * Quote the given String with single quotes.
     *
     * @param str the input String (e.g. "myString")
     * @return the quoted String (e.g. "'myString'"), or
     * <code>null<code> if the input was <code>null</code>
     */
    public static String quote(final String str) {

        return (str != null ? "'" + str + "'" : null);
    }

    /**
     * Turn the given Object into a String with single quotes if it is a String; keeping the Object
     * as-is else.
     *
     * @param obj the input Object (e.g. "myString")
     * @return the quoted String (e.g. "'myString'"), or the input object as-is if not a String
     */
    public static Object quoteIfString(final Object obj) {

        return (obj instanceof String ? quote((String) obj) : obj);
    }

    /**
     * Remove duplicate Strings from the given array. Also sorts the array, as it uses a TreeSet.
     *
     * @param array the String array
     * @return an array without duplicates, in natural sort order
     */
    public static String[] removeDuplicateStrings(final String[] array) {

        // if (ObjectUtils.isEmpty(array)) {
        if (array.length == 0)
            return array;
        final Set<String> set = new TreeSet<String>();
        for (final String element : array) {
            set.add(element);
        }
        return toStringArray(set);
    }

    /**
     * Replace all occurences of a substring within a string with another string.
     *
     * @param inString   String to examine
     * @param oldPattern String to replace
     * @param newPattern String to insert
     * @return a String with the replacements
     */
    public static String replace(final String inString, final String oldPattern,
                                 final String newPattern) {

        if (!hasLength(inString) || !hasLength(oldPattern) || (newPattern == null))
            return inString;
        final StringBuilder sb = new StringBuilder();
        int pos = 0; // our position in the old string
        int index = inString.indexOf(oldPattern);
        // the index of an occurrence we've found, or -1
        final int patLen = oldPattern.length();
        while (index >= 0) {
            sb.append(inString, pos, index);
            sb.append(newPattern);
            pos = index + patLen;
            index = inString.indexOf(oldPattern, pos);
        }
        sb.append(inString.substring(pos));
        // remember to append any characters to the right of a match
        return sb.toString();
    }

    @SuppressWarnings("deprecation")
    public static String replaceSpaceWithChar(final String str) {

        final StringBuffer strBuf = new StringBuffer();

        for (final Character c : str.toCharArray()) {

            if (Character.isSpace(c)) {

                strBuf.append("%20");
            } else {
                strBuf.append(c);
            }
        }

        return strBuf.toString();
    }

    public static String reverse(final String str) {

        if (str.length() <= 1)
            return str;

        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static String reverseOrderString(final String str) {

        final char[] strAsArr = str.toCharArray();
        final StringBuilder newStr = new StringBuilder();

        for (int i = (strAsArr.length - 1); i >= 0; i--) {
            newStr.append(strAsArr[i]);
        }

        return newStr.toString();
    }

    public static String reverseWordsInString(final String str) {

        final String[] words = str.split(" ");
        final StringBuilder newStr = new StringBuilder();

        for (int i = (words.length - 1); i >= 0; i--) {
            newStr.append(words[i] + " ");
        }
        return newStr.toString();
    }

    public static String sort(final String str) {

        final StringBuilder _str = new StringBuilder();
        final char[] charArr = str.toCharArray();
        Arrays.sort(charArr);

        for (final Character ch : charArr) {
            _str.append(ch.toString());
        }

        return _str.toString();
    }

    /**
     * Turn given source String array into sorted array.
     *
     * @param array the source array
     * @return the sorted array (never <code>null</code>)
     */
    public static String[] sortStringArray(final String[] array) {

        // if (ObjectUtils.isEmpty(array)) {
        if (array.length == 0)
            return new String[0];
        Arrays.sort(array);
        return array;
    }

    /**
     * Split a String at the first occurrence of the delimiter. Does not include the delimiter in
     * the result.
     *
     * @param toSplit   the string to split
     * @param delimiter to split the string up with
     * @return a two element array with index 0 being before the delimiter, and index 1 being after
     * the delimiter (neither element includes the delimiter); or <code>null</code> if the
     * delimiter wasn't found in the given input String
     */
    public static String[] split(final String toSplit, final String delimiter) {

        if (!hasLength(toSplit) || !hasLength(delimiter))
            return null;
        final int offset = toSplit.indexOf(delimiter);
        if (offset < 0)
            return null;
        final String beforeDelimiter = toSplit.substring(0, offset);
        final String afterDelimiter = toSplit.substring(offset + delimiter.length());
        return new String[]{beforeDelimiter, afterDelimiter};
    }

    /**
     * Take an array Strings and split each element based on the given delimiter. A
     * <code>Properties</code> instance is then generated, with the left of the delimiter providing
     * the key, and the right of the delimiter providing the value.
     * <p>
     * Will trim both the key and value before adding them to the <code>Properties</code> instance.
     *
     * @param array     the array to process
     * @param delimiter to split each element using (typically the equals symbol)
     * @return a <code>Properties</code> instance representing the array contents, or
     * <code>null</code> if the array to process was null or empty
     */
    public static Properties splitArrayElementsIntoProperties(final String[] array,
                                                              final String delimiter) {

        return splitArrayElementsIntoProperties(array, delimiter, null);
    }

    /**
     * Take an array Strings and split each element based on the given delimiter. A
     * <code>Properties</code> instance is then generated, with the left of the delimiter providing
     * the key, and the right of the delimiter providing the value.
     * <p>
     * Will trim both the key and value before adding them to the <code>Properties</code> instance.
     *
     * @param array         the array to process
     * @param delimiter     to split each element using (typically the equals symbol)
     * @param charsToDelete one or more characters to remove from each element prior to attempting
     *                      the split operation (typically the quotation mark symbol), or <code>null</code> if no
     *                      removal should occur
     * @return a <code>Properties</code> instance representing the array contents, or
     * <code>null</code> if the array to process was <code>null</code> or empty
     */
    public static Properties splitArrayElementsIntoProperties(final String[] array,
                                                              final String delimiter, final String charsToDelete) {

        // if (ObjectUtils.isEmpty(array)) {
        if (array.length == 0)
            return null;
        final Properties result = new Properties();
        for (String element : array) {
            if (charsToDelete != null) {
                element = deleteAny(element, charsToDelete);
            }
            final String[] splittedElement = split(element, delimiter);
            if (splittedElement == null) {
                continue;
            }
            result.setProperty(splittedElement[0].trim(), splittedElement[1].trim());
        }
        return result;
    }

    /**
     * Test if the given String starts with the specified prefix, ignoring upper/lower case.
     *
     * @param str    the String to check
     * @param prefix the prefix to look for
     * @see String#startsWith
     */
    public static boolean startsWithIgnoreCase(final String str, final String prefix) {

        if ((str == null) || (prefix == null))
            return false;
        if (str.startsWith(prefix))
            return true;
        if (str.length() < prefix.length())
            return false;
        final String lcStr = str.substring(0, prefix.length()).toLowerCase();
        final String lcPrefix = prefix.toLowerCase();
        return lcStr.equals(lcPrefix);
    }

    /**
     * Strip the filename extension from the given path, e.g. "mypath/myfile.txt" ->
     * "mypath/myfile".
     *
     * @param path the file path (may be <code>null</code>)
     * @return the path with stripped filename extension, or <code>null</code> if none
     */
    public static String stripFilenameExtension(final String path) {

        if (path == null)
            return null;
        final int extIndex = path.lastIndexOf(EXTENSION_SEPARATOR);
        if (extIndex == -1)
            return path;
        final int folderIndex = path.lastIndexOf(FOLDER_SEPARATOR);
        if (folderIndex > extIndex)
            return path;
        return path.substring(0, extIndex);
    }

    /**
     * Test whether the given string matches the given substring at the given index.
     *
     * @param str       the original string (or StringBuilder)
     * @param index     the index in the original string to start matching against
     * @param substring the substring to match at the given index
     */
    public static boolean substringMatch(final CharSequence str, final int index,
                                         final CharSequence substring) {

        for (int j = 0; j < substring.length(); j++) {
            final int i = index + j;
            if ((i >= str.length()) || (str.charAt(i) != substring.charAt(j)))
                return false;
        }
        return true;
    }

    /**
     * Tokenize the given String into a String array via a StringTokenizer. Trims tokens and omits
     * empty tokens.
     * <p>
     * The given delimiters string is supposed to consist of any number of delimiter characters.
     * Each of those characters can be used to separate tokens. A delimiter is always a single
     * character; for multi-character delimiters, consider using
     * <code>delimitedListToStringArray</code>
     *
     * @param str        the String to tokenize
     * @param delimiters the delimiter characters, assembled as String (each of those characters is
     *                   individually considered as delimiter).
     * @return an array of the tokens
     * @see StringTokenizer
     * @see String#trim()
     * @see #delimitedListToStringArray
     */
    public static String[] tokenizeToStringArray(final String str, final String delimiters) {

        return tokenizeToStringArray(str, delimiters, true, true);
    }

    /**
     * Tokenize the given String into a String array via a StringTokenizer.
     * <p>
     * The given delimiters string is supposed to consist of any number of delimiter characters.
     * Each of those characters can be used to separate tokens. A delimiter is always a single
     * character; for multi-character delimiters, consider using
     * <code>delimitedListToStringArray</code>
     *
     * @param str               the String to tokenize
     * @param delimiters        the delimiter characters, assembled as String (each of those characters is
     *                          individually considered as delimiter)
     * @param trimTokens        trim the tokens via String's <code>trim</code>
     * @param ignoreEmptyTokens omit empty tokens from the result array (only applies to tokens that
     *                          are empty after trimming; StringTokenizer will not consider subsequent delimiters as
     *                          token in the first place).
     * @return an array of the tokens (<code>null</code> if the input String was <code>null</code>)
     * @see StringTokenizer
     * @see String#trim()
     * @see #delimitedListToStringArray
     */
    public static String[] tokenizeToStringArray(final String str, final String delimiters,
                                                 final boolean trimTokens, final boolean ignoreEmptyTokens) {

        if (str == null)
            return null;
        final StringTokenizer st = new StringTokenizer(str, delimiters);
        final List<String> tokens = new ArrayList<String>();
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (trimTokens) {
                token = token.trim();
            }
            if (!ignoreEmptyTokens || (token.length() > 0)) {
                tokens.add(token);
            }
        }
        return toStringArray(tokens);
    }

    /**
     * Determine the RFC 3066 compliant language tag, as used for the HTTP "Accept-Language" header.
     *
     * @param locale the Locale to transform to a language tag
     * @return the RFC 3066 compliant language tag as String
     */
    public static String toLanguageTag(final Locale locale) {

        return locale.getLanguage()
                + (hasText(locale.getCountry()) ? "-" + locale.getCountry() : "");
    }

    /**
     * Copy the given Collection into a String array. The Collection must contain String elements
     * only.
     *
     * @param collection the Collection to copy
     * @return the String array (<code>null</code> if the passed-in Collection was
     * <code>null</code>)
     */
    public static String[] toStringArray(final Collection<String> collection) {

        if (collection == null)
            return null;
        return collection.toArray(new String[collection.size()]);
    }

    /**
     * Copy the given Enumeration into a String array. The Enumeration must contain String elements
     * only.
     *
     * @param enumeration the Enumeration to copy
     * @return the String array (<code>null</code> if the passed-in Enumeration was
     * <code>null</code>)
     */
    public static String[] toStringArray(final Enumeration<String> enumeration) {

        if (enumeration == null)
            return null;
        final List<String> list = Collections.list(enumeration);
        return list.toArray(new String[list.size()]);
    }

    /**
     * Trim <i>all</i> whitespace from the given String: leading, trailing, and inbetween
     * characters.
     *
     * @param str the String to check
     * @return the trimmed String
     * @see Character#isWhitespace
     */
    public static String trimAllWhitespace(final String str) {

        if (!hasLength(str))
            return str;
        final StringBuilder sb = new StringBuilder(str);
        int index = 0;
        while (sb.length() > index) {
            if (Character.isWhitespace(sb.charAt(index))) {
                sb.deleteCharAt(index);
            } else {
                index++;
            }
        }
        return sb.toString();
    }

    /**
     * Trim the elements of the given String array, calling <code>String.trim()</code> on each of
     * them.
     *
     * @param array the original String array
     * @return the resulting array (of the same size) with trimmed elements
     */
    public static String[] trimArrayElements(final String[] array) {

        // if (ObjectUtils.isEmpty(array)) {
        if (array.length == 0)
            return new String[0];
        final String[] result = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            final String element = array[i];
            result[i] = (element != null ? element.trim() : null);
        }
        return result;
    }

    /**
     * Trim all occurences of the supplied leading character from the given String.
     *
     * @param str              the String to check
     * @param leadingCharacter the leading character to be trimmed
     * @return the trimmed String
     */
    public static String trimLeadingCharacter(final String str, final char leadingCharacter) {

        if (!hasLength(str))
            return str;
        final StringBuilder sb = new StringBuilder(str);
        while ((sb.length() > 0) && (sb.charAt(0) == leadingCharacter)) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    /**
     * Trim leading whitespace from the given String.
     *
     * @param str the String to check
     * @return the trimmed String
     * @see Character#isWhitespace
     */
    public static String trimLeadingWhitespace(final String str) {

        if (!hasLength(str))
            return str;
        final StringBuilder sb = new StringBuilder(str);
        while ((sb.length() > 0) && Character.isWhitespace(sb.charAt(0))) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    /**
     * Trim all occurences of the supplied trailing character from the given String.
     *
     * @param str               the String to check
     * @param trailingCharacter the trailing character to be trimmed
     * @return the trimmed String
     */
    public static String trimTrailingCharacter(final String str, final char trailingCharacter) {

        if (!hasLength(str))
            return str;
        final StringBuilder sb = new StringBuilder(str);
        while ((sb.length() > 0) && (sb.charAt(sb.length() - 1) == trailingCharacter)) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /**
     * Trim trailing whitespace from the given String.
     *
     * @param str the String to check
     * @return the trimmed String
     * @see Character#isWhitespace
     */
    public static String trimTrailingWhitespace(final String str) {

        if (!hasLength(str))
            return str;
        final StringBuilder sb = new StringBuilder(str);
        while ((sb.length() > 0) && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /**
     * Trim leading and trailing whitespace from the given String.
     *
     * @param str the String to check
     * @return the trimmed String
     * @see Character#isWhitespace
     */
    public static String trimWhitespace(final String str) {

        if (!hasLength(str))
            return str;
        final StringBuilder sb = new StringBuilder(str);
        while ((sb.length() > 0) && Character.isWhitespace(sb.charAt(0))) {
            sb.deleteCharAt(0);
        }
        while ((sb.length() > 0) && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /**
     * Uncapitalize a <code>String</code>, changing the first letter to lower case as per
     * {@link Character#toLowerCase(char)}. No other letters are changed.
     *
     * @param str the String to uncapitalize, may be <code>null</code>
     * @return the uncapitalized String, <code>null</code> if null
     */
    public static String uncapitalize(final String str) {

        return changeFirstCharacterCase(str, false);
    }

    /**
     * Unqualify a string qualified by a '.' dot character. For example, "this.name.is.qualified",
     * returns "qualified".
     *
     * @param qualifiedName the qualified name
     */
    public static String unqualify(final String qualifiedName) {

        return unqualify(qualifiedName, '.');
    }

    /**
     * Unqualify a string qualified by a separator character. For example, "this:name:is:qualified"
     * returns "qualified" if using a ':' separator.
     *
     * @param qualifiedName the qualified name
     * @param separator     the separator
     */
    public static String unqualify(final String qualifiedName, final char separator) {

        return qualifiedName.substring(qualifiedName.lastIndexOf(separator) + 1);
    }

    private static void validateLocalePart(final String localePart) {

        for (int i = 0; i < localePart.length(); i++) {
            final char ch = localePart.charAt(i);
            if ((ch != '_') && (ch != ' ') && !Character.isLetterOrDigit(ch))
                throw new IllegalArgumentException(
                        "Locale part \"" + localePart + "\" contains invalid characters");
        }
    }

    public static boolean isPallindrome(final String str) {

        final String original = str;
        StringBuffer reverse = new StringBuffer();
        // Scanner in = new Scanner(System.in);

        // System.out.println("Enter a string to check if it is a palindrome");
        // original = in.nextLine();

        final int length = original.length();

        for (int i = length - 1; i >= 0; i--) {
            reverse = reverse.append(original.charAt(i));
        }

        if (original.equals(reverse)) {
            System.out.println("String is a palindrome.");
            return true;
        } else {
            System.out.println("String is not a palindrome.");
            return false;
        }

    }

    public static void print_2D_matrix(char[][] m) {

        for (int i = 0; i < m.length; i++) {
            // for (int j = 0; i < m[i].length; j++) {
            System.out.println(arrayAsString(m[i], "  "));
            System.out.println();
            // }
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public String reverseCStyleString(final String CString) {

        final StringBuffer reversedString = new StringBuffer();

        for (int i = CString.length() - 1; i >= 0; i--) {

            if ((Character) CString.charAt(i) != null) {

                reversedString.append(CString.charAt(i));
            }
        }

        return reversedString.toString();
    }

    // prints the String equivalent of a given number
    public void stringEquivalent() {

        final String input = "123423425";

        int output = 0;

        for (int i = 0; i < input.length(); i++) {

            System.out.print(input.charAt(i) + " ");
            final int y = input.charAt(i) - '0';

            output = (output * 10) + y;

        }
        System.out.println("\nOutput : " + output);
    }
}
