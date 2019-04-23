package util;

public class SpaceAppender {

    public String appendBefore(String str, int spaceCount) {
        StringBuilder sb = new StringBuilder();
        while(spaceCount > 0) {
            sb.append(" ");
            spaceCount--;
        }
        return sb.append(str).toString();
    }
}
