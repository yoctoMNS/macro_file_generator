import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Main {
    public Main() {
        new Tool();
    }

    public static void main(String[] args) {
        new Main();
    }
}

class Tool {
    public static final String REGEX_SMALL_ALPHA_NUM = "[a-z0-9]";
    public static final String REGEX_LARGE_ALPHA = "[A-Z]";
    public static final String[] SYMBOLS = {"`","~","!","@","#","$","%","^","&","*","(",")","_","+","-","=","[","]","{","}",";","'",":","\"","\\","|",",",".","<",">","/","?"," "};

    public Tool() {
        p("DELAY 3000");

        ArrayList<String> directoreis = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(new File(Tool.class.getResource("directory.txt").toURI())))) {
            String line = "";

            while ((line = br.readLine()) != null) {
                directoreis.add(line);
            }
        } catch (Exception e) {
        }

        for (int i = 0; i < directoreis.size(); ++i) {
            String name = directoreis.get(i);

            if (name.substring(name.length() - 4).equals("java")) {
                createFile(name);
                load(name);
            }
        }

        compile();
        run(directoreis.get(0));
    }

    private void compile() {
        p("KEY [Shift]++");
        p("KEY [Semicolon]");
        p("KEY [Shift]--");
        p("KEY [Shift]++");
        p("KEY 1");
        p("KEY [Shift]--");
        p("KEY J");
        p("KEY A");
        p("KEY V");
        p("KEY A");
        p("KEY C");
        p("KEY [Space]");
        p("KEY [Shift]++");
        p("KEY 8");
        p("KEY [Shift]--");
        p("KEY .");
        p("KEY J");
        p("KEY A");
        p("KEY V");
        p("KEY A");
        p("KEY [RET]");
        p("DELAY 3000");
        p("KEY [RET]");
    }

    private void run(String runningFile) {
        p("KEY [Shift]++");
        p("KEY [Semicolon]");
        p("KEY [Shift]--");
        p("KEY [Shift]++");
        p("KEY 1");
        p("KEY [Shift]--");
        p("KEY J");
        p("KEY A");
        p("KEY V");
        p("KEY A");
        p("KEY [Space]");

        String className = runningFile.substring(0, runningFile.length() - 5);

        for (int j = 0; j < className.length(); ++j) {
            char c = className.charAt(j);

            if (Character.isUpperCase(c)) {
                p("KEY [Shift]++");
                p("KEY " + String.valueOf(c).toUpperCase());
                p("KEY [Shift]--");
            } else {
                p("KEY " + String.valueOf(c).toUpperCase());
            }
        }

        p("KEY [RET]");
    }

    private void createFile(String name) {
        p("KEY [Semicolon]");
        p("KEY E");
        p("KEY [Space]");

        for (int j = 0; j < name.length(); ++j) {
            char c = name.charAt(j);

            if (Character.isUpperCase(c)) {
                p("KEY [Shift]++");
                p("KEY " + String.valueOf(c).toUpperCase());
                p("KEY [Shift]--");
            } else {
                p("KEY " + String.valueOf(c).toUpperCase());
            }
        }

        p("KEY [RET]");
    }

    private void load(String path) {
        p("KEY I");

        try (BufferedReader br = new BufferedReader(new FileReader(new File(Tool.class.getResource(path).toURI())))) {
            String line = "";

            while ((line = br.readLine()) != null) {
                char[] arr = line.toCharArray();
                boolean isAriveCharacter = false;

                for (int i = 0; i < arr.length; ++i) {
                    String c = String.valueOf(arr[i]);

                    if (c.equals(" ") && !isAriveCharacter) {
                        continue;
                    } else {
                        isAriveCharacter = true;
                    }

                    if (Pattern.matches(REGEX_SMALL_ALPHA_NUM, c)) {
                        if (c.equals("2")) {
                            p("KEY @");
                        } else if (c.equals("6")) {
                            p("KEY ^");
                        } else {
                            p("KEY " + c);
                        }
                    } else if (Pattern.matches(REGEX_LARGE_ALPHA, c)) {
                        p("KEY [Shift]++");
                        p("KEY " + c.toLowerCase());
                        p("KEY [Shift]--");
                    } else if (Arrays.asList(SYMBOLS).contains(c)) {
                        switch (c) {
                        case "`":
                            p("KEY [OEM-192]");
                            break;

                        case "~":
                            p("KEY [Shift]++");
                            p("KEY [OEM-192]");
                            p("KEY [Shift]--");
                            break;

                        case "!":
                            p("KEY [Shift]++");
                            p("KEY 1");
                            p("KEY [Shift]--");
                            break;

                        case "@":
                            p("KEY [Shift]++");
                            p("KEY @");
                            p("KEY [Shift]--");
                            break;

                        case "#":
                            p("KEY [Shift]++");
                            p("KEY 3");
                            p("KEY [Shift]--");
                            break;

                        case "$":
                            p("KEY [Shift]++");
                            p("KEY 4");
                            p("KEY [Shift]--");
                            break;

                        case "%":
                            p("KEY [Shift]++");
                            p("KEY 5");
                            p("KEY [Shift]--");
                            break;

                        case "^":
                            p("KEY [Shift]++");
                            p("KEY ^");
                            p("KEY [Shift]--");
                            break;

                        case "&":
                            p("KEY [Shift]++");
                            p("KEY 7");
                            p("KEY [Shift]--");
                            break;

                        case "*":
                            p("KEY [Shift]++");
                            p("KEY 8");
                            p("KEY [Shift]--");
                            break;

                        case "(":
                            p("KEY [Shift]++");
                            p("KEY 9");
                            p("KEY [Shift]--");
                            break;

                        case ")":
                            p("KEY [Shift]++");
                            p("KEY 0");
                            p("KEY [Shift]--");
                            break;

                        case "_":
                            p("KEY [Shift]++");
                            p("KEY _");
                            p("KEY [Shift]--");
                            break;

                        case "+":
                            p("KEY [Shift]++");
                            p("KEY [OEM-187]");
                            p("KEY [Shift]--");
                            break;

                        case "-":
                            p("KEY _");
                            break;

                        case "=":
                            p("KEY [OEM-187]");
                            break;

                        case "[":
                            p("KEY [");
                            break;

                        case "]":
                            p("KEY ]");
                            break;

                        case "{":
                            p("KEY [Shift]++");
                            p("KEY [");
                            p("KEY [Shift]--");
                            break;

                        case "}":
                            p("KEY [Shift]++");
                            p("KEY ]");
                            p("KEY [Shift]--");
                            break;

                        case ";":
                            p("KEY [Semicolon]");
                            break;

                        case "'":
                            p("KEY [OEM-222]");
                            break;

                        case ":":
                            p("KEY [Shift]++");
                            p("KEY [Semicolon]");
                            p("KEY [Shift]--");
                            break;

                        case "\"":
                            p("KEY [Shift]++");
                            p("KEY [OEM-222]");
                            p("KEY [Shift]--");
                            break;

                        case "\\":
                            p("KEY \\");
                            break;

                        case "|":
                            p("KEY [Shift]++");
                            p("KEY \\");
                            p("KEY [Shift]--");
                            break;

                        case ",":
                            p("KEY ,");
                            break;

                        case ".":
                            p("KEY .");
                            break;

                        case "<":
                            p("KEY [Shift]++");
                            p("KEY ,");
                            p("KEY [Shift]--");
                            break;

                        case ">":
                            p("KEY [Shift]++");
                            p("KEY .");
                            p("KEY [Shift]--");
                            break;

                        case "/":
                            p("KEY /");
                            break;

                        case "?":
                            p("KEY [Shift]++");
                            p("KEY /");
                            p("KEY [Shift]--");
                            break;

                        case " ":
                            p("KEY [Space]");
                            break;
                        }
                    }
                }

                p("KEY [RET]");

                isAriveCharacter = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        p("KEY [Ctrl]++");
        p("KEY [");
        p("KEY [Ctrl]--");
        p("KEY [Semicolon]");
        p("KEY W");
        p("KEY [RET]");
    }

    private void p(String o) {
        System.out.println(o);
    }
}
