import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Tool {
    public static final String REGEX_SMALL_ALPHA_NUM = "[a-z0-9]";
    public static final String REGEX_LARGE_ALPHA = "[A-Z]";
    public static final String[] SYMBOLS = {"`","~","!","@","#","$","%","^","&","*","(",")","_","+","-","=","[","]","{","}",";","'",":","\"","\\","|",",",".","<",">","/","?"," "};

    public Tool() {
        p("DELAY 3000");
        moveDesktopDirectory();

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

            if (name.substring(name.length() - 4).equals("java") ||
                name.substring(name.length() - 3).equals("txt")) {
                createFile(name);
                load(name);
            }
        }

        compile();
        run();
    }

    private void moveDesktopDirectory() {
        p("KEY [Shift]++");
        p("KEY [Semicolon]");
        p("KEY [Shift]--");
        p("KEY L");
        p("KEY C");
        p("KEY D");
        p("KEY [Space]");
        p("KEY D");
        p("KEY E");
        p("KEY S");
        p("KEY K");
        p("KEY T");
        p("KEY O");
        p("KEY P");
        p("KEY [RET]");
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

    private void run() {
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

        p("KEY [Shift]++");
        p("KEY L");
        p("KEY [Shift]--");
        p("KEY A");
        p("KEY U");
        p("KEY N");
        p("KEY C");
        p("KEY H");
        p("KEY E");
        p("KEY R");
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
            boolean upperFlg = false;

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
                        if (upperFlg) {
                            p("KEY [Shift]--");
                            upperFlg = false;
                        }
                        if (c.equals("2")) {
                            p("KEY @");
                        } else if (c.equals("6")) {
                            p("KEY ^");
                        } else {
                            p("KEY " + c.toUpperCase());
                        }
                    } else if (Pattern.matches(REGEX_LARGE_ALPHA, c)) {
                        if (!upperFlg) {
                            p("KEY [Shift]++");
                            upperFlg = true;
                        }
                        p("KEY " + c.toUpperCase());
                    } else if (Arrays.asList(SYMBOLS).contains(c)) {
                        switch (c) {
                        case "`":
                            if (upperFlg) {
                                p("KEY [Shift]--");
                                upperFlg = false;
                            }
                            p("KEY [OEM-192]");
                            break;

                        case "~":
                            if (!upperFlg) {
                                p("KEY [Shift]++");
                                upperFlg = true;
                            }
                            p("KEY [OEM-192]");
                            break;

                        case "!":
                            if (!upperFlg) {
                                p("KEY [Shift]++");
                                upperFlg = true;
                            }
                            p("KEY 1");
                            break;

                        case "@":
                            if (!upperFlg) {
                                p("KEY [Shift]++");
                                upperFlg = true;
                            }
                            p("KEY @");
                            break;

                        case "#":
                            if (!upperFlg) {
                                p("KEY [Shift]++");
                                upperFlg = true;
                            }
                            p("KEY 3");
                            break;

                        case "$":
                            if (!upperFlg) {
                                p("KEY [Shift]++");
                                upperFlg = true;
                            }
                            p("KEY 4");
                            break;

                        case "%":
                            if (!upperFlg) {
                                p("KEY [Shift]++");
                                upperFlg = true;
                            }
                            p("KEY 5");
                            break;

                        case "^":
                            if (!upperFlg) {
                                p("KEY [Shift]++");
                                upperFlg = true;
                            }
                            p("KEY ^");
                            break;

                        case "&":
                            if (!upperFlg) {
                                p("KEY [Shift]++");
                                upperFlg = true;
                            }
                            p("KEY 7");
                            break;

                        case "*":
                            if (!upperFlg) {
                                p("KEY [Shift]++");
                                upperFlg = true;
                            }
                            p("KEY 8");
                            break;

                        case "(":
                            if (!upperFlg) {
                                p("KEY [Shift]++");
                                upperFlg = true;
                            }
                            p("KEY 9");
                            break;

                        case ")":
                            if (!upperFlg) {
                                p("KEY [Shift]++");
                                upperFlg = true;
                            }
                            p("KEY 0");
                            break;

                        case "_":
                            if (!upperFlg) {
                                p("KEY [Shift]++");
                                upperFlg = true;
                            }
                            p("KEY _");
                            break;

                        case "+":
                            if (!upperFlg) {
                                p("KEY [Shift]++");
                                upperFlg = true;
                            }
                            p("KEY [OEM-187]");
                            break;

                        case "-":
                            if (upperFlg) {
                                p("KEY [Shift]--");
                                upperFlg = false;
                            }
                            p("KEY _");
                            break;

                        case "=":
                            if (upperFlg) {
                                p("KEY [Shift]--");
                                upperFlg = false;
                            }
                            p("KEY [OEM-187]");
                            break;

                        case "[":
                            if (upperFlg) {
                                p("KEY [Shift]--");
                                upperFlg = false;
                            }
                            p("KEY [");
                            break;

                        case "]":
                            if (upperFlg) {
                                p("KEY [Shift]--");
                                upperFlg = false;
                            }
                            p("KEY ]");
                            break;

                        case "{":
                            if (!upperFlg) {
                                p("KEY [Shift]++");
                                upperFlg = true;
                            }
                            p("KEY [");
                            break;

                        case "}":
                            if (!upperFlg) {
                                p("KEY [Shift]++");
                                upperFlg = true;
                            }
                            p("KEY ]");
                            break;

                        case ";":
                            if (upperFlg) {
                                p("KEY [Shift]--");
                                upperFlg = false;
                            }
                            p("KEY [Semicolon]");
                            break;

                        case "'":
                            if (upperFlg) {
                                p("KEY [Shift]--");
                                upperFlg = false;
                            }
                            p("KEY [OEM-222]");
                            break;

                        case ":":
                            if (!upperFlg) {
                                p("KEY [Shift]++");
                                upperFlg = true;
                            }
                            p("KEY [Semicolon]");
                            break;

                        case "\"":
                            if (!upperFlg) {
                                p("KEY [Shift]++");
                                upperFlg = true;
                            }
                            p("KEY [OEM-222]");
                            break;

                        case "\\":
                            if (upperFlg) {
                                p("KEY [Shift]--");
                                upperFlg = false;
                            }
                            p("KEY \\");
                            break;

                        case "|":
                            if (!upperFlg) {
                                p("KEY [Shift]++");
                                upperFlg = true;
                            }
                            p("KEY \\");
                            break;

                        case ",":
                            if (upperFlg) {
                                p("KEY [Shift]--");
                                upperFlg = false;
                            }
                            p("KEY ,");
                            break;

                        case ".":
                            if (upperFlg) {
                                p("KEY [Shift]--");
                                upperFlg = false;
                            }
                            p("KEY .");
                            break;

                        case "<":
                            if (!upperFlg) {
                                p("KEY [Shift]++");
                                upperFlg = true;
                            }
                            p("KEY ,");
                            break;

                        case ">":
                            if (!upperFlg) {
                                p("KEY [Shift]++");
                                upperFlg = true;
                            }
                            p("KEY .");
                            break;

                        case "/":
                            if (upperFlg) {
                                p("KEY [Shift]--");
                                upperFlg = false;
                            }
                            p("KEY /");
                            break;

                        case "?":
                            if (!upperFlg) {
                                p("KEY [Shift]++");
                                upperFlg = true;
                            }
                            p("KEY /");
                            break;

                        case " ":
                            if (upperFlg) {
                                p("KEY [Shift]--");
                                upperFlg = false;
                            }
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

        p("KEY [Shift]--");
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
