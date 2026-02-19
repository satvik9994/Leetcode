import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int lineLength = words[i].length();
            int j = i + 1;
            
            // Step 1: Find words for the current line
            while (j < words.length && lineLength + 1 + words[j].length() <= maxWidth) {
                lineLength += 1 + words[j].length();
                j++;
            }

            StringBuilder sb = new StringBuilder();
            int numWords = j - i;
            int numGaps = numWords - 1;

            // Step 2 & 3: Format the line
            // Case: Last line or only one word in the line (Left Justified)
            if (j == words.length || numWords == 1) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) sb.append(" ");
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                // Case: Fully Justified
                int totalSpaces = maxWidth - (lineLength - numGaps);
                int spacesPerGap = totalSpaces / numGaps;
                int extraSpaces = totalSpaces % numGaps;

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        int spacesToAdd = spacesPerGap + (k - i < extraSpaces ? 1 : 0);
                        for (int s = 0; s < spacesToAdd; s++) {
                            sb.append(" ");
                        }
                    }
                }
            }

            result.add(sb.toString());
            i = j; // Move to the next set of words
        }

        return result;
    }
}