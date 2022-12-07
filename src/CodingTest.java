import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CodingTest {
    static int count =0;
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
//        Stream<StudentDto> studentDtoStream = StudentDto.studentDtoList(10).stream();
//        Map<StudentDto,Double> studentDtoDoubleMap = StudentDto.studentDtoList(10).stream()
//                .collect(Collectors.groupingBy(Function.identity(), HashMap::new,Collectors.averagingInt(studentDto ->{return studentDto.getEng()+studentDto.getKor()+studentDto.getMath(); })));
//        Map<Integer,Double> studentDtoDoubleMap2 = StudentDto.studentDtoList(10).stream()
//                .collect(Collectors.groupingBy(StudentDto::getAge, HashMap::new,Collectors.averagingInt(studentDto ->{return studentDto.getEng()+studentDto.getKor()+studentDto.getMath(); })));
//        System.out.println("나를 바라바"+StudentDto.studentDtoList(10).stream()
//                .collect(Collectors.groupingBy(StudentDto::getAge, HashMap::new,Collectors.toList())).toString());
//        TreeMap<Integer, StudentDto> stringStudentDtoTreeMap = new TreeMap<>();
//        System.out.println(studentDtoStream.collect(Collectors.toMap(StudentDto::getAge,Function.identity(),(studentDto, studentDto2) -> studentDto2)).toString());
//        System.out.println(StudentDto.studentDtoList(10).stream().collect(Collectors.toMap(StudentDto::getAge,Function.identity(),(studentDto, studentDto2) -> studentDto2,()->stringStudentDtoTreeMap)));
//        System.out.println(stringStudentDtoTreeMap.toString());
//        System.out.println(StudentDto.studentDtoList(10).stream().collect(Collectors.toMap(StudentDto::getAge,Function.identity(),(studentDto, studentDto2) -> studentDto2,TreeMap::new)).toString());
//        Map<Integer,List<String>> stringListMap = StudentDto.studentDtoList(10).stream().collect(Collectors.toMap(StudentDto::getAge,studentDto -> {
//            List<String> studentDtos = new ArrayList<>();
//            studentDtos.add(studentDto.toString());
//            return studentDtos;
//        },(strings, strings2) -> {
//            strings2.stream().forEach(s -> strings.add(s));
//            return strings;
//        },TreeMap::new));
//
//        System.out.println(stringListMap.toString());

//        System.out.println((StudentDto.studentDtoList(10).stream().collect(Collectors.groupingBy(studentDto -> studentDto.getName().charAt(0))).toString()));
//        System.out.println(StudentDto.studentDtoList(10).stream().collect(
//                Collectors.groupingBy(StudentDto::getHak,
//                        Collectors.groupingBy(StudentDto::getBan,
//                        collectingAndThen(maxBy(Comparator.comparingInt(StudentDto::getAge)),Optional::get)))).toString());

//        StudentDto.studentDtoList(10).stream().collect(Collectors.groupingBy(StudentDto::getHak,Collectors.collectingAndThen(groupingBy(StudentDto::getBan),integerListMap -> {
//            System.out.println(integerListMap.toString());
//            return null;
//        })));
//        System.out.println("strawberries".substring(2,5));
//        String[] array = new String[]{"a","b","c"};
//        List<String > list1 = Arrays.asList(array);
//        List<String > list2 =new ArrayList<>(Arrays.asList(array));
//        System.out.println(list1.equals(list2));
//        new Test().solution(new int[]{95,90,99,99,80,99},new int[]{1,1,1,1,1,1});
//        new Test().solution(new int[]{1, 5, 2, 6, 3, 7, 4},new int[][]{{2,5,3,},{4,4,1},{1,7,3}});
//        new Test().solution2(new int[]{13000,88000,10000},new int[]{30});
//        new Test().solution("abcxyqwetyxyabc");
        List<String> strings = new ArrayList<>();
//        Permutations.perm2(new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8")),strings,8,3);
        Set<Integer> set = new HashSet<>();
//        Hanoi.Hanoi(3,1,2,3);
//        System.out.println(Hanoi.count);
        // 2019 카카오 문제 1번
//        new Test().solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3,},{0,2,5,0,1,},{4,2,4,4,2},{3,5,1,3,1}},new int[]{1,5,3,5,1,2,1,4});
//        new Kakao2019().solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},new String[]{"fr*d*", "*rodo", "******", "******"});
//        DynamicProgramming_1.solution(5,12);
//        Test.solution(5,12);
//        new DynamicProgramming_2().solution2(new int[][]{{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}});
//        new DynamicProgramming_3().solution2(4,3,new int[][]{{-1,-1}});
//        new DynamicProgramming_3().test();

    }

}
