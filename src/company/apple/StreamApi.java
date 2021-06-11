package company.apple;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=759182&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D4%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 *
 * https://www.baeldung.com/java-8-streams
 */
public class StreamApi {
    Stream<String> streamEmpty = Stream.empty();

    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamofCollection = collection.stream();
    }

}
