import com.sun.deploy.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/*
 * @description:
 * @author: zwq
 * @date: 2019/3/26 15:32
 */
public class Test {
    public static void main(String[] args) {
        Set<String> departNameSet = new HashSet<String>();
        System.out.println(StringUtils.join(departNameSet, ",") instanceof String);
    }
}
