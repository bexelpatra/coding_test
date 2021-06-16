import com.test.practice.e_exhaustive_search.ExhaustiveSearch_3;
import com.test.practice.f_dfs_bfs.DFSBFS_1;
import com.test.practice.f_dfs_bfs.DFSBFS_2;
import com.test.practice.f_dfs_bfs.DFSBFS_3;

import java.util.ArrayList;
import java.util.List;

public class CodingTest {
    public static void main(String[] args) {
//        new ExhaustiveSearch_3().solution(24,24);
//        new DFSBFS_2().solution(3,new int[][]{{1,1,0},{1,1,0},{0,0,1}});

//        new DFSBFS_3().solution("111","222",new String[]{"122","212","221","222"});

        DFSBFS_2.class.getClasses();
        System.out.println(DFSBFS_2.class.getName());
        String name = DFSBFS_2.class.getName().replace("_2","_3");
        System.out.println(DFSBFS_2.class.getTypeName());
        DFSBFS_2.class.getClassLoader();
        Class aClass = null;
        try {
            aClass = ClassLoader.getSystemClassLoader().loadClass(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(aClass.getName());
    }
}
