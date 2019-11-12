package com.qzing.ddd.classic.demo.core.kit;

import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/**
 * @author yangyanze
 */
public class StrKit {
    private StrKit() {

    }

    public static String remove(String str, String remove) {
        return StringUtils.remove(str, remove);
    }

    public static String remove(String str, char remove) {
        return StringUtils.remove(str, remove);
    }

    public static boolean equals(CharSequence cs1, CharSequence cs2) {
        return StringUtils.equals(cs1, cs2);
    }

    public static int indexOf(CharSequence seq, int search) {
        return StringUtils.indexOf(seq, search);
    }

    public static int indexOf(CharSequence seq, CharSequence search, int startPos) {
        return StringUtils.indexOf(seq, search, startPos);
    }

    public static int indexOf(CharSequence seq, CharSequence search) {
        return StringUtils.indexOf(seq, search);
    }

    public static int indexOf(CharSequence seq, int search, int startPos) {
        return StringUtils.indexOf(seq, search, startPos);
    }

    public static String valueOf(char[] cs) {
        return StringUtils.valueOf(cs);
    }

    public static int compare(String arg0, String arg1) {
        return StringUtils.compare(arg0, arg1);
    }

    public static int compare(String arg0, String arg1, boolean arg2) {
        return StringUtils.compare(arg0, arg1, arg2);
    }

    public static boolean contains(CharSequence arg0, int arg1) {
        return StringUtils.contains(arg0, arg1);
    }

    public static boolean contains(CharSequence arg0, CharSequence arg1) {
        return StringUtils.contains(arg0, arg1);
    }

    public static boolean endsWith(CharSequence arg0, CharSequence arg1) {
        return StringUtils.endsWith(arg0, arg1);
    }

    public static boolean equalsIgnoreCase(CharSequence arg0, CharSequence arg1) {
        return StringUtils.equalsIgnoreCase(arg0, arg1);
    }

    public static boolean isEmpty(CharSequence arg0) {
        return StringUtils.isEmpty(arg0);
    }

    public static String join(List<String> arg0, char arg1, int arg2, int arg3) {
        return StringUtils.join(arg0, arg1, arg2, arg3);
    }

    public static String join(double[] arg0, char arg1, int arg2, int arg3) {
        return StringUtils.join(arg0, arg1, arg2, arg3);
    }

    public static String join(Iterator<String> arg0, String arg1) {
        return StringUtils.join(arg0, arg1);
    }

    public static String join(List arg0, String arg1, int arg2, int arg3) {
        return StringUtils.join(arg0, arg1, arg2, arg3);
    }

    public static String join(Object[] arg0, String arg1) {
        return StringUtils.join(arg0, arg1);
    }

    public static String join(Object[] arg0, String arg1, int arg2, int arg3) {
        return StringUtils.join(arg0, arg1, arg2, arg3);
    }

    public static String join(Iterable arg0, char arg1) {
        return StringUtils.join(arg0, arg1);
    }

    public static String join(Iterable arg0, String arg1) {
        return StringUtils.join(arg0, arg1);
    }

    public static String join(float[] arg0, char arg1, int arg2, int arg3) {
        return StringUtils.join(arg0, arg1, arg2, arg3);
    }

    public static String join(Iterator arg0, char arg1) {
        return StringUtils.join(arg0, arg1);
    }

    public static String join(short[] arg0, char arg1) {
        return StringUtils.join(arg0, arg1);
    }

    public static String join(byte[] arg0, char arg1) {
        return StringUtils.join(arg0, arg1);
    }

    public static String join(char[] arg0, char arg1) {
        return StringUtils.join(arg0, arg1);
    }

    public static String join(float[] arg0, char arg1) {
        return StringUtils.join(arg0, arg1);
    }

    public static String join(Object[] arg0) {
        return StringUtils.join(arg0);
    }

    public static String join(Object[] arg0, char arg1) {
        return StringUtils.join(arg0, arg1);
    }

    public static String join(long[] arg0, char arg1) {
        return StringUtils.join(arg0, arg1);
    }

    public static String join(int[] arg0, char arg1) {
        return StringUtils.join(arg0, arg1);
    }

    public static String join(int[] arg0, char arg1, int arg2, int arg3) {
        return StringUtils.join(arg0, arg1, arg2, arg3);
    }

    public static String join(byte[] arg0, char arg1, int arg2, int arg3) {
        return StringUtils.join(arg0, arg1, arg2, arg3);
    }

    public static String join(short[] arg0, char arg1, int arg2, int arg3) {
        return StringUtils.join(arg0, arg1, arg2, arg3);
    }

    public static String join(char[] arg0, char arg1, int arg2, int arg3) {
        return StringUtils.join(arg0, arg1, arg2, arg3);
    }

    public static String join(long[] arg0, char arg1, int arg2, int arg3) {
        return StringUtils.join(arg0, arg1, arg2, arg3);
    }

    public static String join(Object[] arg0, char arg1, int arg2, int arg3) {
        return StringUtils.join(arg0, arg1, arg2, arg3);
    }

    public static String join(double[] arg0, char arg1) {
        return StringUtils.join(arg0, arg1);
    }

    public static int lastIndexOf(CharSequence arg0, int arg1) {
        return StringUtils.lastIndexOf(arg0, arg1);
    }

    public static int lastIndexOf(CharSequence arg0, CharSequence arg1, int arg2) {
        return StringUtils.lastIndexOf(arg0, arg1, arg2);
    }

    public static int lastIndexOf(CharSequence arg0, int arg1, int arg2) {
        return StringUtils.lastIndexOf(arg0, arg1, arg2);
    }

    public static int lastIndexOf(CharSequence arg0, CharSequence arg1) {
        return StringUtils.lastIndexOf(arg0, arg1);
    }

    public static int length(CharSequence arg0) {
        return StringUtils.length(arg0);
    }

    public static String replace(String arg0, String arg1, String arg2) {
        return StringUtils.replace(arg0, arg1, arg2);
    }

    public static String replace(String arg0, String arg1, String arg2, int arg3) {
        return StringUtils.replace(arg0, arg1, arg2, arg3);
    }

    public static String[] split(String arg0, char arg1) {
        return StringUtils.split(arg0, arg1);
    }

    public static String[] split(String arg0, String arg1, int arg2) {
        return StringUtils.split(arg0, arg1, arg2);
    }

    public static String[] split(String arg0, String arg1) {
        return StringUtils.split(arg0, arg1);
    }

    public static String[] split(String arg0) {
        return StringUtils.split(arg0);
    }

    public static boolean startsWith(CharSequence arg0, CharSequence arg1) {
        return StringUtils.startsWith(arg0, arg1);
    }

    public static String substring(String arg0, int arg1, int arg2) {
        return StringUtils.substring(arg0, arg1, arg2);
    }

    public static String substring(String arg0, int arg1) {
        return StringUtils.substring(arg0, arg1);
    }

    public static String trim(String arg0) {
        return StringUtils.trim(arg0);
    }

    public static String wrap(String arg0, char arg1) {
        return StringUtils.wrap(arg0, arg1);
    }

    public static String wrap(String arg0, String arg1) {
        return StringUtils.wrap(arg0, arg1);
    }

    public static String unwrap(String arg0, String arg1) {
        return StringUtils.unwrap(arg0, arg1);
    }

    public static String unwrap(String arg0, char arg1) {
        return StringUtils.unwrap(arg0, arg1);
    }

    public static String reverse(String arg0) {
        return StringUtils.reverse(arg0);
    }

    public static String truncate(String arg0, int arg1, int arg2) {
        return StringUtils.truncate(arg0, arg1, arg2);
    }

    public static String truncate(String arg0, int arg1) {
        return StringUtils.truncate(arg0, arg1);
    }

    public static boolean isWhitespace(CharSequence arg0) {
        return StringUtils.isWhitespace(arg0);
    }

    public static String rotate(String arg0, int arg1) {
        return StringUtils.rotate(arg0, arg1);
    }

    public static String left(String arg0, int arg1) {
        return StringUtils.left(arg0, arg1);
    }

    public static String right(String arg0, int arg1) {
        return StringUtils.right(arg0, arg1);
    }

    public static boolean isAlpha(CharSequence arg0) {
        return StringUtils.isAlpha(arg0);
    }

    public static boolean isNumeric(CharSequence arg0) {
        return StringUtils.isNumeric(arg0);
    }

    public static int compareIgnoreCase(String arg0, String arg1, boolean arg2) {
        return StringUtils.compareIgnoreCase(arg0, arg1, arg2);
    }

    public static int compareIgnoreCase(String arg0, String arg1) {
        return StringUtils.compareIgnoreCase(arg0, arg1);
    }

    public static String[] substringsBetween(String arg0, String arg1, String arg2) {
        return StringUtils.substringsBetween(arg0, arg1, arg2);
    }

    public static int lastOrdinalIndexOf(CharSequence arg0, CharSequence arg1, int arg2) {
        return StringUtils.lastOrdinalIndexOf(arg0, arg1, arg2);
    }

    public static String removeEndIgnoreCase(String arg0, String arg1) {
        return StringUtils.removeEndIgnoreCase(arg0, arg1);
    }

    public static String replaceOnceIgnoreCase(String arg0, String arg1, String arg2) {
        return StringUtils.replaceOnceIgnoreCase(arg0, arg1, arg2);
    }

    public static String replaceIgnoreCase(String arg0, String arg1, String arg2) {
        return StringUtils.replaceIgnoreCase(arg0, arg1, arg2);
    }

    public static String replaceIgnoreCase(String arg0, String arg1, String arg2, int arg3) {
        return StringUtils.replaceIgnoreCase(arg0, arg1, arg2, arg3);
    }

    public static String replaceEachRepeatedly(String arg0, String[] arg1, String[] arg2) {
        return StringUtils.replaceEachRepeatedly(arg0, arg1, arg2);
    }

    public static String[] splitPreserveAllTokens(String arg0, String arg1) {
        return StringUtils.splitPreserveAllTokens(arg0, arg1);
    }

    public static String[] splitPreserveAllTokens(String arg0, char arg1) {
        return StringUtils.splitPreserveAllTokens(arg0, arg1);
    }

    public static String[] splitPreserveAllTokens(String arg0, String arg1, int arg2) {
        return StringUtils.splitPreserveAllTokens(arg0, arg1, arg2);
    }

    public static String[] splitPreserveAllTokens(String arg0) {
        return StringUtils.splitPreserveAllTokens(arg0);
    }

    public static String substringAfterLast(String arg0, String arg1) {
        return StringUtils.substringAfterLast(arg0, arg1);
    }

    public static String removeStartIgnoreCase(String arg0, String arg1) {
        return StringUtils.removeStartIgnoreCase(arg0, arg1);
    }

    public static String substringBeforeLast(String arg0, String arg1) {
        return StringUtils.substringBeforeLast(arg0, arg1);
    }

    public static boolean containsIgnoreCase(CharSequence arg0, CharSequence arg1) {
        return StringUtils.containsIgnoreCase(arg0, arg1);
    }

    public static int indexOfIgnoreCase(CharSequence arg0, CharSequence arg1) {
        return StringUtils.indexOfIgnoreCase(arg0, arg1);
    }

    public static int indexOfIgnoreCase(CharSequence arg0, CharSequence arg1, int arg2) {
        return StringUtils.indexOfIgnoreCase(arg0, arg1, arg2);
    }

    public static int lastIndexOfIgnoreCase(CharSequence arg0, CharSequence arg1) {
        return StringUtils.lastIndexOfIgnoreCase(arg0, arg1);
    }

    public static int lastIndexOfIgnoreCase(CharSequence arg0, CharSequence arg1, int arg2) {
        return StringUtils.lastIndexOfIgnoreCase(arg0, arg1, arg2);
    }

    public static String[] splitByCharacterTypeCamelCase(String arg0) {
        return StringUtils.splitByCharacterTypeCamelCase(arg0);
    }

    public static boolean equalsAnyIgnoreCase(CharSequence arg0, CharSequence[] arg1) {
        return StringUtils.equalsAnyIgnoreCase(arg0, arg1);
    }

    public static boolean containsWhitespace(CharSequence arg0) {
        return StringUtils.containsWhitespace(arg0);
    }

    public static String[] splitByWholeSeparator(String arg0, String arg1, int arg2) {
        return StringUtils.splitByWholeSeparator(arg0, arg1, arg2);
    }

    public static String[] splitByWholeSeparator(String arg0, String arg1) {
        return StringUtils.splitByWholeSeparator(arg0, arg1);
    }

    public static String[] splitByCharacterType(String arg0) {
        return StringUtils.splitByCharacterType(arg0);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String arg0, String arg1) {
        return StringUtils.splitByWholeSeparatorPreserveAllTokens(arg0, arg1);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String arg0, String arg1, int arg2) {
        return StringUtils.splitByWholeSeparatorPreserveAllTokens(arg0, arg1, arg2);
    }

    public static String swapCase(String arg0) {
        return StringUtils.swapCase(arg0);
    }

    public static String reverseDelimited(String arg0, char arg1) {
        return StringUtils.reverseDelimited(arg0, arg1);
    }

    public static String abbreviate(String arg0, int arg1) {
        return StringUtils.abbreviate(arg0, arg1);
    }

    public static String abbreviate(String arg0, int arg1, int arg2) {
        return StringUtils.abbreviate(arg0, arg1, arg2);
    }

    public static String abbreviate(String arg0, String arg1, int arg2, int arg3) {
        return StringUtils.abbreviate(arg0, arg1, arg2, arg3);
    }

    public static String abbreviate(String arg0, String arg1, int arg2) {
        return StringUtils.abbreviate(arg0, arg1, arg2);
    }

    public static String difference(String arg0, String arg1) {
        return StringUtils.difference(arg0, arg1);
    }

    public static boolean isAsciiPrintable(CharSequence arg0) {
        return StringUtils.isAsciiPrintable(arg0);
    }

    public static String getDigits(String arg0) {
        return StringUtils.getDigits(arg0);
    }

    public static CharSequence defaultIfBlank(CharSequence arg0, CharSequence arg1) {
        return StringUtils.defaultIfBlank(arg0, arg1);
    }

    public static boolean isAlphaSpace(CharSequence arg0) {
        return StringUtils.isAlphaSpace(arg0);
    }

    public static boolean isMixedCase(CharSequence arg0) {
        return StringUtils.isMixedCase(arg0);
    }

    public static boolean isNumericSpace(CharSequence arg0) {
        return StringUtils.isNumericSpace(arg0);
    }

    public static CharSequence defaultIfEmpty(CharSequence arg0, CharSequence arg1) {
        return StringUtils.defaultIfEmpty(arg0, arg1);
    }

    public static String abbreviateMiddle(String arg0, String arg1, int arg2) {
        return StringUtils.abbreviateMiddle(arg0, arg1, arg2);
    }

    public static CharSequence firstNonBlank(CharSequence[] arg0) {
        return StringUtils.firstNonBlank(arg0);
    }

    public static boolean isAllUpperCase(CharSequence arg0) {
        return StringUtils.isAllUpperCase(arg0);
    }

    public static CharSequence firstNonEmpty(CharSequence[] arg0) {
        return StringUtils.firstNonEmpty(arg0);
    }

    public static String defaultString(String arg0, String arg1) {
        return StringUtils.defaultString(arg0, arg1);
    }

    public static String defaultString(String arg0) {
        return StringUtils.defaultString(arg0);
    }

    public static boolean isAlphanumeric(CharSequence arg0) {
        return StringUtils.isAlphanumeric(arg0);
    }

    public static String getCommonPrefix(String[] arg0) {
        return StringUtils.getCommonPrefix(arg0);
    }

    public static String uncapitalize(String arg0) {
        return StringUtils.uncapitalize(arg0);
    }

    public static boolean isAllLowerCase(CharSequence arg0) {
        return StringUtils.isAllLowerCase(arg0);
    }

    public static int countMatches(CharSequence arg0, char arg1) {
        return StringUtils.countMatches(arg0, arg1);
    }

    public static int countMatches(CharSequence arg0, CharSequence arg1) {
        return StringUtils.countMatches(arg0, arg1);
    }

    public static String wrapIfMissing(String arg0, char arg1) {
        return StringUtils.wrapIfMissing(arg0, arg1);
    }

    public static String wrapIfMissing(String arg0, String arg1) {
        return StringUtils.wrapIfMissing(arg0, arg1);
    }

    public static boolean endsWithAny(CharSequence arg0, CharSequence[] arg1) {
        return StringUtils.endsWithAny(arg0, arg1);
    }

    public static String toEncodedString(byte[] arg0, Charset arg1) {
        return StringUtils.toEncodedString(arg0, arg1);
    }

    public static String appendIfMissing(String arg0, CharSequence arg1, CharSequence[] arg2) {
        return StringUtils.appendIfMissing(arg0, arg1, arg2);
    }

    public static boolean startsWithAny(CharSequence arg0, CharSequence[] arg1) {
        return StringUtils.startsWithAny(arg0, arg1);
    }

    public static String prependIfMissing(String arg0, CharSequence arg1, CharSequence[] arg2) {
        return StringUtils.prependIfMissing(arg0, arg1, arg2);
    }

    public static int[] toCodePoints(CharSequence arg0) {
        return StringUtils.toCodePoints(arg0);
    }

    public static String normalizeSpace(String arg0) {
        return StringUtils.normalizeSpace(arg0);
    }

    public static int indexOfDifference(CharSequence arg0, CharSequence arg1) {
        return StringUtils.indexOfDifference(arg0, arg1);
    }

    public static int indexOfDifference(CharSequence[] arg0) {
        return StringUtils.indexOfDifference(arg0);
    }

    public static boolean startsWithIgnoreCase(CharSequence arg0, CharSequence arg1) {
        return StringUtils.startsWithIgnoreCase(arg0, arg1);
    }

    public static String prependIfMissingIgnoreCase(String arg0, CharSequence arg1, CharSequence[] arg2) {
        return StringUtils.prependIfMissingIgnoreCase(arg0, arg1, arg2);
    }

    public static int getLevenshteinDistance(CharSequence arg0, CharSequence arg1) {
        return StringUtils.getLevenshteinDistance(arg0, arg1);
    }

    public static int getLevenshteinDistance(CharSequence arg0, CharSequence arg1, int arg2) {
        return StringUtils.getLevenshteinDistance(arg0, arg1, arg2);
    }

    public static boolean endsWithIgnoreCase(CharSequence arg0, CharSequence arg1) {
        return StringUtils.endsWithIgnoreCase(arg0, arg1);
    }

    public static String appendIfMissingIgnoreCase(String arg0, CharSequence arg1, CharSequence[] arg2) {
        return StringUtils.appendIfMissingIgnoreCase(arg0, arg1, arg2);
    }

    public static boolean isAlphanumericSpace(CharSequence arg0) {
        return StringUtils.isAlphanumericSpace(arg0);
    }

    public static boolean allEmpty(CharSequence[] arg0) {
        return StringUtils.isAllEmpty(arg0);
    }

    public static boolean isBlank(CharSequence arg0) {
        return StringUtils.isBlank(arg0);
    }

    public static boolean notEmpty(CharSequence arg0) {
        return StringUtils.isNotEmpty(arg0);
    }

    public static boolean noneEmpty(CharSequence[] arg0) {
        return StringUtils.isNoneEmpty(arg0);
    }

    public static boolean notBlank(CharSequence arg0) {
        return StringUtils.isNotBlank(arg0);
    }

    public static boolean anyBlank(CharSequence[] arg0) {
        return StringUtils.isAnyBlank(arg0);
    }

    public static boolean anyEmpty(CharSequence[] arg0) {
        return StringUtils.isAnyEmpty(arg0);
    }

    public static boolean noneBlank(CharSequence[] arg0) {
        return StringUtils.isNoneBlank(arg0);
    }

    public static boolean allBlank(CharSequence[] arg0) {
        return StringUtils.isAllBlank(arg0);
    }

    public static String trimToNull(String arg0) {
        return StringUtils.trimToNull(arg0);
    }

    public static String trimToEmpty(String arg0) {
        return StringUtils.trimToEmpty(arg0);
    }

    public static String strip(String arg0, String arg1) {
        return StringUtils.strip(arg0, arg1);
    }

    public static String strip(String arg0) {
        return StringUtils.strip(arg0);
    }

    public static String stripToNull(String arg0) {
        return StringUtils.stripToNull(arg0);
    }

    public static String stripToEmpty(String arg0) {
        return StringUtils.stripToEmpty(arg0);
    }

    public static String mid(String arg0, int arg1, int arg2) {
        return StringUtils.mid(arg0, arg1, arg2);
    }

    public static int indexOfAny(CharSequence arg0, char[] arg1) {
        return StringUtils.indexOfAny(arg0, arg1);
    }

    public static int indexOfAny(CharSequence arg0, CharSequence[] arg1) {
        return StringUtils.indexOfAny(arg0, arg1);
    }

    public static int indexOfAny(CharSequence arg0, String arg1) {
        return StringUtils.indexOfAny(arg0, arg1);
    }

    public static boolean containsNone(CharSequence arg0, char[] arg1) {
        return StringUtils.containsNone(arg0, arg1);
    }

    public static boolean containsNone(CharSequence arg0, String arg1) {
        return StringUtils.containsNone(arg0, arg1);
    }

    public static String stripStart(String arg0, String arg1) {
        return StringUtils.stripStart(arg0, arg1);
    }

    public static int lastIndexOfAny(CharSequence arg0, CharSequence[] arg1) {
        return StringUtils.lastIndexOfAny(arg0, arg1);
    }

    public static String stripAccents(String arg0) {
        return StringUtils.stripAccents(arg0);
    }

    public static boolean equalsAny(CharSequence arg0, CharSequence[] arg1) {
        return StringUtils.equalsAny(arg0, arg1);
    }

    public static boolean containsAny(CharSequence arg0, char[] arg1) {
        return StringUtils.containsAny(arg0, arg1);
    }

    public static boolean containsAny(CharSequence arg0, CharSequence[] arg1) {
        return StringUtils.containsAny(arg0, arg1);
    }

    public static boolean containsAny(CharSequence arg0, CharSequence arg1) {
        return StringUtils.containsAny(arg0, arg1);
    }

    public static int ordinalIndexOf(CharSequence arg0, CharSequence arg1, int arg2) {
        return StringUtils.ordinalIndexOf(arg0, arg1, arg2);
    }

    public static boolean containsOnly(CharSequence arg0, String arg1) {
        return StringUtils.containsOnly(arg0, arg1);
    }

    public static boolean containsOnly(CharSequence arg0, char[] arg1) {
        return StringUtils.containsOnly(arg0, arg1);
    }

    public static String substringBefore(String arg0, String arg1) {
        return StringUtils.substringBefore(arg0, arg1);
    }

    public static String[] stripAll(String[] arg0) {
        return StringUtils.stripAll(arg0);
    }

    public static String[] stripAll(String[] arg0, String arg1) {
        return StringUtils.stripAll(arg0, arg1);
    }

    public static String substringAfter(String arg0, String arg1) {
        return StringUtils.substringAfter(arg0, arg1);
    }

    public static String substringBetween(String arg0, String arg1) {
        return StringUtils.substringBetween(arg0, arg1);
    }

    public static String substringBetween(String arg0, String arg1, String arg2) {
        return StringUtils.substringBetween(arg0, arg1, arg2);
    }

    public static String stripEnd(String arg0, String arg1) {
        return StringUtils.stripEnd(arg0, arg1);
    }

    public static int indexOfAnyBut(CharSequence arg0, CharSequence arg1) {
        return StringUtils.indexOfAnyBut(arg0, arg1);
    }

    public static int indexOfAnyBut(CharSequence arg0, char[] arg1) {
        return StringUtils.indexOfAnyBut(arg0, arg1);
    }

    public static String removeIgnoreCase(String arg0, String arg1) {
        return StringUtils.removeIgnoreCase(arg0, arg1);
    }

    public static String leftPad(String arg0, int arg1) {
        return StringUtils.leftPad(arg0, arg1);
    }

    public static String leftPad(String arg0, int arg1, char arg2) {
        return StringUtils.leftPad(arg0, arg1, arg2);
    }

    public static String leftPad(String arg0, int arg1, String arg2) {
        return StringUtils.leftPad(arg0, arg1, arg2);
    }

    public static String center(String arg0, int arg1, String arg2) {
        return StringUtils.center(arg0, arg1, arg2);
    }

    public static String center(String arg0, int arg1) {
        return StringUtils.center(arg0, arg1);
    }

    public static String center(String arg0, int arg1, char arg2) {
        return StringUtils.center(arg0, arg1, arg2);
    }

    public static String lowerCase(String arg0) {
        return StringUtils.lowerCase(arg0);
    }

    public static String lowerCase(String arg0, Locale arg1) {
        return StringUtils.lowerCase(arg0, arg1);
    }

    public static String upperCase(String arg0) {
        return StringUtils.upperCase(arg0);
    }

    public static String upperCase(String arg0, Locale arg1) {
        return StringUtils.upperCase(arg0, arg1);
    }

    public static String removePattern(String arg0, String arg1) {
        return StringUtils.removePattern(arg0, arg1);
    }

    public static String joinWith(String arg0, Object[] arg1) {
        return StringUtils.joinWith(arg0, arg1);
    }

    public static String capitalize(String arg0) {
        return StringUtils.capitalize(arg0);
    }

    public static String replaceOnce(String arg0, String arg1, String arg2) {
        return StringUtils.replaceOnce(arg0, arg1, arg2);
    }

    public static String removeStart(String arg0, String arg1) {
        return StringUtils.removeStart(arg0, arg1);
    }

    public static String removeEnd(String arg0, String arg1) {
        return StringUtils.removeEnd(arg0, arg1);
    }

    public static String repeat(String arg0, int arg1) {
        return StringUtils.repeat(arg0, arg1);
    }

    public static String repeat(String arg0, String arg1, int arg2) {
        return StringUtils.repeat(arg0, arg1, arg2);
    }

    public static String repeat(char arg0, int arg1) {
        return StringUtils.repeat(arg0, arg1);
    }

    public static String overlay(String arg0, String arg1, int arg2, int arg3) {
        return StringUtils.overlay(arg0, arg1, arg2, arg3);
    }

    public static String deleteWhitespace(String arg0) {
        return StringUtils.deleteWhitespace(arg0);
    }

    public static String chomp(String arg0) {
        return StringUtils.chomp(arg0);
    }

    public static String replaceEach(String arg0, String[] arg1, String[] arg2) {
        return StringUtils.replaceEach(arg0, arg1, arg2);
    }

    public static String replaceChars(String arg0, String arg1, String arg2) {
        return StringUtils.replaceChars(arg0, arg1, arg2);
    }

    public static String replaceChars(String arg0, char arg1, char arg2) {
        return StringUtils.replaceChars(arg0, arg1, arg2);
    }

    public static String chop(String arg0) {
        return StringUtils.chop(arg0);
    }

    public static String rightPad(String arg0, int arg1, char arg2) {
        return StringUtils.rightPad(arg0, arg1, arg2);
    }

    public static String rightPad(String arg0, int arg1) {
        return StringUtils.rightPad(arg0, arg1);
    }

    public static String rightPad(String arg0, int arg1, String arg2) {
        return StringUtils.rightPad(arg0, arg1, arg2);
    }


    public static void main(String[] args) {
        Class<StringUtils> stringUtilsClass = StringUtils.class;


        Method[] ms = stringUtilsClass.getMethods();
        for (Method m : ms) {
            Annotation[] mda = m.getDeclaredAnnotations();
            boolean rt = false;
            for (Annotation annotation : mda) {
                if (annotation.annotationType() == Deprecated.class) {
                    rt = true;
                    break;
                }
            }
            if (rt) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            int mf = m.getModifiers();
            boolean dft = m.isDefault();
            printModifiersIfNonzero(sb, mf, dft);
            if (!sb.toString().contains(" static ")) {
                continue;
            }
            sb.append(m.getReturnType().getSimpleName()).append(" ");
            sb.append(m.getName()).append("(");
            boolean first = true;
            for (Parameter p : m.getParameters()) {
                if (first) {
                    first = false;
                } else {
                    sb.append(",");
                }
                sb.append(p.getType().getSimpleName()).append(" ").append(p.getName());
            }
            sb.append("){\n");
            sb.append("return StringUtils.").append(m.getName()).append("(");
            first = true;
            for (Parameter p : m.getParameters()) {
                if (first) {
                    first = false;
                } else {
                    sb.append(",");
                }
                sb.append(p.getName());
            }
            sb.append(");");
            sb.append("\n}");

            System.out.println(sb);
        }
    }

    static final int ACCESS_MODIFIERS =
            Modifier.PUBLIC | Modifier.PROTECTED | Modifier.PRIVATE;

    static void printModifiersIfNonzero(StringBuilder sb, int mf, boolean isDefault) {
        int mod = mf & Modifier.methodModifiers();

        if (mod != 0 && !isDefault) {
            sb.append(Modifier.toString(mod)).append(' ');
        } else {
            int access_mod = mod & ACCESS_MODIFIERS;
            if (access_mod != 0) {
                sb.append(Modifier.toString(access_mod)).append(' ');
            }
            if (isDefault) {
                sb.append("default ");
            }
            mod = (mod & ~ACCESS_MODIFIERS);
            if (mod != 0) {
                sb.append(Modifier.toString(mod)).append(' ');
            }
        }
    }

}
