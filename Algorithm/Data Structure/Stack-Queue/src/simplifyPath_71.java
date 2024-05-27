import java.util.*;
/**
 * @Author:PanYa
 * @Date 2024/5/27-上午11:11
 * @Description:
 */
public class simplifyPath_71 {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] components = path.split("/");

        for (String component : components) {
            if (component.equals("") || component.equals(".")) {
                continue;
            }
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(component);
            }
        }

        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : stack) {
            simplifiedPath.insert(0, "/" + dir);
        }

        return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
    }
}
