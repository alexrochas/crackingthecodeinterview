import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.Ignore;
import org.junit.Test;

public class ArraysQuestions {

  @Test
  public void isUniqueQuestion() {
    String unique = "aaaaaaa";
    String notUnique = "abcdefg";

    Function<String, Boolean> isUnique = (String s) -> s.matches(s.charAt(0) + "*");

    assertTrue(isUnique.apply(unique));
    assertFalse(isUnique.apply(notUnique));
  }

  @Test
  public void URLifyQuestion() {
    BiFunction<String, Integer, String> urlify = (String s, Integer size) -> s.trim().replaceAll("\\s+","%20");

    assertEquals(urlify.apply("Mr John Smith    ", 13), "Mr%20John%20Smith");
  }

  @Test
  public void oneWayQuestion() {
    BiFunction<String, String, Boolean> oneWay = (String s1, String s2) -> {
      return Stream.of(
        java.util.Arrays.stream(s1.split("")).filter(s -> !s2.contains(s)).count(),
        java.util.Arrays.stream(s2.split("")).filter(s -> !s1.contains(s)).count()
      ).anyMatch(changes -> changes == 1);
    };

    assertTrue(oneWay.apply("pale", "ple"));
    assertTrue(oneWay.apply("pales", "pale"));
    assertTrue(oneWay.apply("pale", "bale"));
    assertFalse(oneWay.apply("pale", "bake"));
  }

  @Test
  @Ignore
  public void rotateMatrixQuestion() {

  }

  @Test
  public void stringRotationQuestion() {
    BiFunction<String, String, Boolean> isSubstring = (s1, s2) -> {
      if (s1.length() != s2.length()) return false;
      for (int i = 0; i < s1.length(); i++) {
        for (int j = 0; j < s1.length(); j++) {
          if (s1.charAt(j + i) != s2.charAt(j)) break;
          return true;
        }
      }

      return false;
    };

    assertTrue(isSubstring.apply("waterbottle", "erbottlewat"));
  }
}
