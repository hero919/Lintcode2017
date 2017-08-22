import java.util.ArrayList;
import java.util.List;

public class TextJustification02 {
    public static List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }

        int index = 0;
        while (index < words.length) {
            String beginWord = words[index];
            int length = beginWord.length();
            int endIndex = index + 1;
            while (endIndex < words.length) {
                if (words[endIndex].length() + length + 1 > L) {
                    break;
                }
                length = length + 1 + words[endIndex].length();
                endIndex = endIndex + 1;
            }

            String list = "";
            list += words[index];

            int difference = endIndex - index - 1;
            if (endIndex == words.length || difference == 0) {
                for (int i = index + 1; i < endIndex; i++) {
                    list += " ";
                    list += words[i];
                }
                for (int i = list.length(); i < L; i++) {
                    list += " ";
                }
            } else {
                int space = L - length;
                int eachSpace = space / difference;
                int extra = space % difference;
                for (int i = index + 1; i < endIndex; i++) {
                    {
                        for (int j = 0; j < eachSpace; j++) {
                            list += " ";
                        }

                        if (extra != 0) {
                            list += " ";
                            extra--;
                        }
                        list += " ";
                        list += words[i];
                    }
                }

            }
            result.add(list);
            index = endIndex;
        }
        return result;
    }



    public static void main(String[] args) {
        String[] words = new String[] {
                "This", "is", "an", "example", "of", "text", "justification."
        };
        System.out.println(fullJustify(words, 16));
        System.out.println("Test");
    }
}
