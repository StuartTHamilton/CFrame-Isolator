public class Main {
    static String rawOutput = new String(
            //   v  ENTER RAW OUTPUT HERE
                "");
    static final int size = 321;
    static String[] cframes = new String[size-1];

    public static void main(String[] args) {
        store(size-1);
        printScript(.01, false);
    }

    public static int giveFirstIndex(String find){
        int length = find.length();
        for(int s = 0; s < 250; s++){
            if(rawOutput.substring(s, s + length).equals(find)){
                return s;
            }
        }
        return 0;
    }

    public static void redact(){
        int newStartPos = giveFirstIndex("Get") + 12;
        int length = rawOutput.length();
        rawOutput = rawOutput.substring(newStartPos, length);
    }

    public static void store(int count){
        for(int c = 0; c < count; c++){
            int endPos = giveFirstIndex("Client") - 5;
            int startPos = 16;
            cframes[c] = rawOutput.substring(startPos, endPos);
            redact();
        }
    }

    public static void print(){
        for(int p = 0; p < cframes.length; p++){
            System.out.println(cframes[p]);
        }
    }

    public static void printScript(double interval, boolean lineNums){
        for(int p = 0; p < cframes.length; p++){
            if(lineNums)
                System.out.print(p + ": ");
            System.out.println("workspace.CurrentCamera.CFrame = CFrame.new(" + cframes[p] + ");");
            System.out.println("wait(" + interval + ");");
        }
    }
}
