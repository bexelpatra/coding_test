import com.sun.org.apache.bcel.internal.generic.ARETURN;
import com.test.practice.StudentDto;
import com.test.practice.ThreadSafe;
import com.test.practice.e_exhaustive_search.ExhaustiveSearch_3;
import com.test.practice.f_dfs_bfs.DFSBFS_1;
import com.test.practice.f_dfs_bfs.DFSBFS_2;
import com.test.practice.f_dfs_bfs.DFSBFS_3;
import sun.security.pkcs11.wrapper.Functions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CodingTest {
    public static void main(String[] args) {
//        new ExhaustiveSearch_3().solution(24,24);
//        new DFSBFS_2().solution(3,new int[][]{{1,1,0},{1,1,0},{0,0,1}});

//        new DFSBFS_3().solution("111","222",new String[]{"122","212","221","222"});

//        DFSBFS_2.class.getClasses();
//        System.out.println(DFSBFS_2.class.getName());
//        String name = DFSBFS_2.class.getName().replace("_2","_3");
//        System.out.println(DFSBFS_2.class.getTypeName());
//        DFSBFS_2.class.getClassLoader();
//        Class aClass = null;
//        try {
//            aClass = ClassLoader.getSystemClassLoader().loadClass(name);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println(aClass.getName());
        Stream<StudentDto> studentDtoStream = StudentDto.studentDtoList(10).stream();
//        Map<StudentDto,Double> studentDtoDoubleMap = StudentDto.studentDtoList(10).stream()
//                .collect(Collectors.groupingBy(Function.identity(), HashMap::new,Collectors.averagingInt(studentDto ->{return studentDto.getEng()+studentDto.getKor()+studentDto.getMath(); })));
//        Map<Integer,Double> studentDtoDoubleMap2 = StudentDto.studentDtoList(10).stream()
//                .collect(Collectors.groupingBy(StudentDto::getAge, HashMap::new,Collectors.averagingInt(studentDto ->{return studentDto.getEng()+studentDto.getKor()+studentDto.getMath(); })));
//        Map<Integer,Double> studentDtoDoubleMap3 = StudentDto.studentDtoList(10).stream()
//                .collect(Collectors.groupingBy(StudentDto::getAge, HashMap::new,Collectors.averagingInt(studentDto ->{return studentDto.getEng()+studentDto.getKor()+studentDto.getMath(); })));
        TreeMap<Integer, StudentDto> stringStudentDtoTreeMap = new TreeMap<>();
        System.out.println(studentDtoStream.collect(Collectors.toMap(StudentDto::getAge,Function.identity(),(studentDto, studentDto2) -> studentDto2)).toString());
        System.out.println(StudentDto.studentDtoList(10).stream().collect(Collectors.toMap(StudentDto::getAge,Function.identity(),(studentDto, studentDto2) -> studentDto2,()->stringStudentDtoTreeMap)));
        System.out.println(stringStudentDtoTreeMap.toString());
        System.out.println(StudentDto.studentDtoList(10).stream().collect(Collectors.toMap(StudentDto::getAge,Function.identity(),(studentDto, studentDto2) -> studentDto2,TreeMap::new)).toString());
        Map<Integer,List<String>> stringListMap = StudentDto.studentDtoList(10).stream().collect(Collectors.toMap(StudentDto::getAge,studentDto -> {
            List<String> studentDtos = new ArrayList<>();
            studentDtos.add(studentDto.toString());
            return studentDtos;
        },(strings, strings2) -> {
            strings2.stream().forEach(s -> strings.add(s));
            return strings;
        },TreeMap::new));


        System.out.println(stringListMap.toString());
        System.out.println((StudentDto.studentDtoList(10).stream().collect(Collectors.groupingBy(studentDto -> studentDto.getName().charAt(0))).toString()));



    }
}
