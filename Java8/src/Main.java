import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

    }
    public static void testOptional(){
        //        Student student=new Student();
//        student.name="Ricardo";
//        if(student!=null){
//            System.out.println(student.name);
//        }
//        Optional<Student> optional=Optional.of(student);
//        if(optional.isPresent()){
//            System.out.println(optional.get().name);
        //}
//        //pre java 8
//        List<String> list=null;
//        List<String> opt=list !=null?list: new ArrayList<>();
//        // java 8
//        List<String> listopt=getList2().orElse(new ArrayList<>());
//        List<String> listopt3= getList2().orElseGet(()->new ArrayList<>());

        Optional<String> optionalOf= Optional.of("The way to Nioh: Invoice");
        Optional<String> optionalEmpty= Optional.empty();

        System.out.println(optionalOf.map(String::toUpperCase));

        System.out.print(optionalEmpty.map(String::toUpperCase));

        Optional<Optional<String>> multiOptinal=Optional.of(Optional.of("Yumi x Nguyen Minh"));
        multiOptinal.flatMap(gender->gender.map(String::toUpperCase));

    }
    public static void testIterable(){
        Rin<String> peRin=new Rin<>();
        peRin.add("Ngoc Tuyen");
        peRin.add("Nguyen Nam");
        peRin.add("Chifuyu");
        peRin.add("1999");
//        for(String nir: peRin){
//            System.out.println(nir);
//        }

        peRin.forEach(s-> System.out.println(s));
    }
    public static void testComsumer(){
        Consumer<Integer> iaiquickdraw=e-> System.out.println(e*2);
        Consumer<Integer> tigersprint=e-> System.out.println(e*e);
        Consumer<Integer> isOdd=e-> System.out.println(e%2==1);
        iaiquickdraw.accept(5);
        tigersprint.accept(5);
        isOdd.accept(5);

        Consumer<Integer> tempest= iaiquickdraw.andThen(tigersprint);
        tempest.accept(5);
    }
    public static void testForEachConsumer(){
        List<Programing> list = new ArrayList<>();
        list.add(new Programing("Java", 5));
        list.add(new Programing("PHP", 2));
        list.add(new Programing("C#", 1));

        Consumer<Programing> consumer = (p) -> System.out.println(
                "Name: " + p.language + " - Experience: " + p.experience);
        //list.forEach(consumer);
        //list.forEach(Programing::print);
        list.forEach( (p) -> System.out.println(
                "Name: " + p.language + " - Experience: " + p.experience));
    }
    public static void linhtinh(){
        //List<String> Yumi=Arrays.asList("Cam","tay","em","cho","le","nay");
        String[] nguyenMinh= {"Cam","tay","em","cho","le","nay"};
        //IntStream.of(1,2,6,3,7).forEach(System.out::print);

        //Stream<String> conversion= Arrays.stream(nguyenMinh);
        Stream<String> conversion=Stream.of(nguyenMinh); // return Arrays.stream(values)
        //Trả về một luồng có thứ tự tuần tự có các phần tử duoc sap xep theo các giá trị được chỉ định
        //Returns a sequential ordered stream whose elements are the specified values

        //conversion.forEach(s-> System.out.print(s+" "));
        System.out.println();
        //Stream.iterate(1,count->count+1).skip(7).filter(n->n%3==0).limit(6).forEach(s-> System.out.print(s+" "));
        conversion.sorted((s1,s2)->s1.length()-s2.length()).collect(Collectors.toList());
        int []numbers = {1, 8, 3, 4, 5, 7, 9, 6};
    }
    public static Optional<List<String>> getList2(){
        return Optional.ofNullable(null);
    }
    public static void testPredicate(){
        Predicate<String> predicate= s->{return s.equals("Yumi");};
        System.out.println(predicate.test("Yumi"));
        System.out.println(predicate.test("Nguyen Minh"));

        System.out.println(predicate.or(s->s.length()==4).test("Minh"));
    }
    public static String getDefaultlanguage(){
        return "Java";
    }
    public static void testSupplier(){
        Supplier<String> stringSupplier= Main::getDefaultlanguage;
        System.out.println(stringSupplier.get());
        IntSupplier intSupplier= () ->5;//get
    }
    public static void FunctionInterface(){
        //        Function<Character,Integer> numbercvt=c->c-'a';
//        System.out.println(numbercvt.apply('e'));//apply
//        Function<User,Member> mapuser=u->new Member(u.name,u.email);
//        User rin= new User("Rin","Ngoctuyen.nguyenthi@gmail.com","123");
//        Member perin=mapuser.apply(rin);
//        System.out.println(perin.toString());

        Function<Integer,Integer> times2=n->n*2;
        Function<Integer,Integer> square= n->n*n;

        Function<Integer,Integer> andThen=times2.andThen(square);
        System.out.println("Using and then :" +andThen.apply(5));

        Function<Integer,Integer> compose=times2.compose(square);
        System.out.println("Using compose :"+compose.apply(5));

        BiFunction<Integer,Integer,Integer> bifunc1=(s1,s2)->s1+s2;
        BiFunction<Integer,Integer,Integer> andthenbi=bifunc1.andThen(square);
        System.out.println(andthenbi.apply(3,7));
    }
    public static void testCollectors(){
        String[] list= {"Cam","tay","em","cho","le","ne"};
        Stream<String> stream= Arrays.stream(list);
//        List<String> result=stream.collect(Collectors.collectingAndThen(Collectors.toList(),x->x.subList(0,3)));
//        for(String chip:result){
//            System.out.println(chip +" ");
//        }
        //System.out.println(stream.collect(Collectors.joining(" ","Chi Yumi ",",<3")));
        Long num=stream.collect(Collectors.counting());
        System.out.println(num);
    }

}