import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].isEmpty()) return "";
        
        final var psCnt = new AtomicInteger(strs[0].split("").length);
        return Stream.generate(() -> strs[0].substring(0, psCnt.getAndDecrement()))
                .filter(s -> Arrays.stream(strs).skip(1).allMatch(f -> f.startsWith(s)))
                .findAny()
                .orElse("");
    }
}
