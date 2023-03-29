package com.xiaozhi;


import com.xiaozhi.entity.Blog;
import com.xiaozhi.service.BlogService;
import com.xiaozhi.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class MajorBlogApplicationTests {

	@Autowired
	LabelService labelService;
	@Autowired
	BlogService blogService;

//	@Test
//	void contextLoads() {
//		Label label = new Label();
//		label.setName("java");
//		label.setStyle(null);
//		label.setCreateTime(new Date());
//		label.setUpdateTime(new Date());
//		System.out.println(label);
//	}
//
//
//	@Test
//	public void Test4(){
//		Label label = new Label();
//		label.setName("java");
//		label.setStyle("left: 16px; top: 1px; z-index: 3; font-size: 18px; color: rgb(237, 204, 185); padding: 6px;");
//		labelService.save(label);
//	}
//
//	@Test
//	public void Test5(){
//		Blog byId = blogService.getById(206);
//		System.out.println(byId);
//	}
//
//	@Test
//	public void Test3(){
//		Blog blog = new Blog();
//		blog.setId(154L);
//		blog.setReleaseTime(new Date());
//		blog.setBlogDescribe("记录生活和学习");
//		blog.setLabel("java");
//		blog.setTitle("更新测试");
//		blogService.updateById(blog);
//	}
//

	public void Test2(){
		for (int i = 0; i < 20; i++) {
			Blog blog = new Blog();
			blog.setReleaseTime(new Date());
			blog.setBlogDescribe("记录生活和学习");
			blog.setLabel("java");
			blog.setTitle("我的第一篇博客");
			blog.setContent("# 反射\n" +
					"\n" +
					"## 什么是反射？\n" +
					"\n" +
					"反射它是java动态化的关键，它相当于是一面镜子，我们通过它可以得到类中的所有东西，比如私有的属性、构造器、方法，我们都可以通过反射得到它和给它赋值，这就是反射的作用。\n" +
					"\n" +
					"\n" +
					"\n" +
					"\n" +
					"\n" +
					"# 反射的实现机制\n" +
					"\n" +
					"## Class类和获取Class类的实例\n" +
					"\n" +
					"我们的java程序运行的步骤：首先我们需要编译我们的java文件，编程完成之后，经过类加载器加载，就到了我们的内存中，然后通过操作平台来执行我们的java程序，这个加载到内存中的过程就叫类的加载，加载到内存中的类也就是运行时类，我们的class对象就可以指向这个运行时类，通过这个运行时类的实例我们可以得到是由那个类加载出来额，从而得到这个类的所有信息\n" +
					"\n" +
					"```java\n" +
					"// 四种得到Class实例的方式\n" +
					"Class clazz = Class.forName(\"com.xiaozhi.java.Person\");\n" +
					"Class clazz2 = Person.class;\n" +
					"System.out.println(clazz == clazz2);        // true\n" +
					"Person person = new Person();\n" +
					"Class clazz3 = person.getClass();\n" +
					"System.out.println(clazz3 == clazz);        // true\n" +
					"ClassLoader classLoader = new Reflection().getClass().getClassLoader();\n" +
					"Class clazz4 = classLoader.loadClass(\"com.xiaozhi.java.Person\");\n" +
					"System.out.println(clazz == clazz4);\t\t// true\n" +
					"```\n" +
					"\n" +
					"\n" +
					"\n" +
					"## Class类方法的使用\n" +
					"\n" +
					"java类\n" +
					"\n" +
					"```java\n" +
					"@MyAnnotation\n" +
					"public class Person extends Persons{\n" +
					"\n" +
					"    public String name;\n" +
					"    public char sex;\n" +
					"    private int age;\n" +
					"\n" +
					"    @MyAnnotation(value = \"小智\")\n" +
					"    public void show(String name) throws Exception{\n" +
					"        System.out.println(name + \"哇哇哇\");\n" +
					"    }\n" +
					"    private void yell () {\n" +
					"        System.out.println(\"miemiemie\");\n" +
					"    }\n" +
					"\n" +
					"    public Person() {\n" +
					"    }\n" +
					"\n" +
					"    private Person(int age){\n" +
					"        this.age = age;\n" +
					"    }\n" +
					"    public Person(String name, char sex, int age) {\n" +
					"        this.name = name;\n" +
					"        this.sex = sex;\n" +
					"        this.age = age;\n" +
					"    }\n" +
					"\n" +
					"    public String getName() {\n" +
					"        return name;\n" +
					"    }\n" +
					"\n" +
					"    public void setName(String name) {\n" +
					"        this.name = name;\n" +
					"    }\n" +
					"\n" +
					"    public char getSex() {\n" +
					"        return sex;\n" +
					"    }\n" +
					"\n" +
					"    public void setSex(char sex) {\n" +
					"        this.sex = sex;\n" +
					"    }\n" +
					"\n" +
					"    public int getAge() {\n" +
					"        return age;\n" +
					"    }\n" +
					"\n" +
					"    public void setAge(int age) {\n" +
					"        this.age = age;\n" +
					"    }\n" +
					"\n" +
					"    @Override\n" +
					"    public String toString() {\n" +
					"        return \"Person{\" +\n" +
					"                \"name='\" + name + '\\'' +\n" +
					"                \", sex=\" + sex +\n" +
					"                \", age=\" + age +\n" +
					"                '}';\n" +
					"    }\n" +
					"}\n" +
					"```\n" +
					"\n" +
					"\n" +
					"\n" +
					"\n" +
					"\n" +
					"```java\n" +
					"public class Reflection {\n" +
					"\n" +
					"    public static void main(String[] args) throws Exception {\n" +
					"        // 四种得到Class实例的方式\n" +
					"        Class clazz = Class.forName(\"com.xiaozhi.java.Person\");\n" +
					"        // 通过反射创建对象 newInstance()\n" +
					"        Person person = (Person) clazz.newInstance();\n" +
					"        System.out.println(person);\n" +
					"        System.out.println(\"========================\");\n" +
					"\n" +
					"        // 通过反射获取构造器\n" +
					"        Constructor[] constructors = clazz.getConstructors();\n" +
					"        for (Constructor constructor : constructors) {\n" +
					"            System.out.println(constructor);\n" +
					"        }\n" +
					"        // 得到对应参数的构造器，只需要传入参数类型就可以了\n" +
					"        Constructor declaredConstructor = clazz.getDeclaredConstructor(int.class);\n" +
					"        System.out.println(declaredConstructor);\n" +
					"\n" +
					"        System.out.println(\"========================\");\n" +
					"        // 通过反射得到全部被public修饰的属性,包括父类的属性\n" +
					"        Field[] fields = clazz.getFields();\n" +
					"        for (Field field : fields) {\n" +
					"            System.out.println(field.getName());\n" +
					"        }\n" +
					"        System.out.println(\"==========================\");\n" +
					"        // 获取的本类中全部的属性（没有父类的）\n" +
					"        for (Field declaredField : clazz.getDeclaredFields()) {\n" +
					"            System.out.println(declaredField);\n" +
					"        }\n" +
					"\n" +
					"        System.out.println(\"==========================\");\n" +
					"        // 通过反射获得私有被public修饰的方法(包括父类的)\n" +
					"        Method[] methods = clazz.getMethods();\n" +
					"        for (Method method : methods) {\n" +
					"            System.out.println(method.getName());   // 输出方法名\n" +
					"            System.out.println(method);\n" +
					"        }\n" +
					"\n" +
					"        System.out.println(\"========================\");\n" +
					"        // 通过反射得到对应类中的所有方法，是全部的\n" +
					"        Field[] declaredFields = clazz.getDeclaredFields();\n" +
					"        for (Field declaredField : declaredFields) {\n" +
					"            System.out.println(declaredField);\n" +
					"        }\n" +
					"        System.out.println(\"======================\");\n" +
					"        // 属性赋值\n" +
					"        Person person1 = (Person) clazz.newInstance();\n" +
					"        Field age = clazz.getDeclaredField(\"age\");\n" +
					"        age.setAccessible(true);\n" +
					"        age.set(person1,1);\n" +
					"\n" +
					"        // 方法赋值\n" +
					"        Method show = clazz.getDeclaredMethod(\"show\", String.class);\n" +
					"        show.setAccessible(true);\n" +
					"        show.invoke(person1,\"小智\");\n" +
					"    }\n" +
					"}\n" +
					"```\n" +
					"\n" +
					"使用反射得到方法的东西\n" +
					"\n" +
					"```java\n" +
					"public class MethodTest {\n" +
					"\n" +
					"    public static void main(String[] args) throws ClassNotFoundException {\n" +
					"        Class clazz = Class.forName(\"com.xiaozhi.java.Person\");\n" +
					"        for (Method declaredMethod : clazz.getDeclaredMethods()) {\n" +
					"            // 注解\n" +
					"            System.out.println(\"=============注解===========\");\n" +
					"            for (Annotation annotation : declaredMethod.getAnnotations()) {\n" +
					"                System.out.println(annotation.annotationType().getSimpleName());\n" +
					"            }\n" +
					"            // 权限修饰符\n" +
					"            System.out.println(\"=============权限修饰符===========\");\n" +
					"            System.out.println(Modifier.toString(declaredMethod.getModifiers()));\n" +
					"            // 方法名\n" +
					"            System.out.println(\"=============方法名===========\");\n" +
					"            System.out.println(declaredMethod.getName());\n" +
					"            // 参数列表\n" +
					"            System.out.println(\"=============参数列表===========\");\n" +
					"            for (Parameter parameter : declaredMethod.getParameters()) {\n" +
					"                System.out.println(parameter);\n" +
					"            }\n" +
					"            // 返回值类型\n" +
					"            System.out.println(\"=============返回值类型===========\");\n" +
					"            System.out.println(declaredMethod.getReturnType().getName());\n" +
					"            // 异常类型\n" +
					"            System.out.println(\"=============异常类型===========\");\n" +
					"            for (Class exceptionType : declaredMethod.getExceptionTypes()) {\n" +
					"                System.out.println(exceptionType.getSimpleName());\n" +
					"            }\n" +
					"        }\n" +
					"    }\n" +
					"}\n" +
					"```\n" +
					"\n" +
					"```java\n" +
					"public class ReflectionTest {\n" +
					"\n" +
					"    public static void main(String[] args) throws Exception {\n" +
					"\n" +
					"        Class<?> clazz = Class.forName(\"com.xiaozhi.java.Person\");\n" +
					"        // 得到运行时类实现的接口\n" +
					"        Class[] interfaces = clazz.getInterfaces();\n" +
					"        for (Class anInterface : interfaces) {\n" +
					"            System.out.println(anInterface.getSimpleName());    // 得到对应接口的名字\n" +
					"            Type[] genericInterfaces = anInterface.getGenericInterfaces();  // 得到接口的泛型的类型\n" +
					"            for (Type genericInterface : genericInterfaces) {\n" +
					"                System.out.println(genericInterface.getTypeName());     // 打印泛型的类型名\n" +
					"            }\n" +
					"        }\n" +
					"        // 得到运行时类所在的包\n" +
					"        Package aPackage = clazz.getPackage();\n" +
					"        System.out.println(aPackage.getName());\n" +
					"\n" +
					"        // 得到运行时类的父类和父类的泛型\n" +
					"        Class superclass = clazz.getSuperclass();   // 得到父类\n" +
					"        Type type = superclass.getGenericSuperclass();  // 得到泛型的类型\n" +
					"        System.out.println(type.getTypeName());\n" +
					"    }\n" +
					"}\n" +
					"```\n" +
					"\n" +
					"\n" +
					"\n" +
					"\n" +
					"\n" +
					"## spring框架的初步原理\n" +
					"\n" +
					"通过bean注解的机制原理，通过反射得到有@bean注解的类，然后创建对象，这也就是IOC的底层原理的一部分\n" +
					"\n" +
					"```java\n" +
					"public class TestInstance {\n" +
					"\n" +
					"    public static void main(String[] args) throws Exception {\n" +
					"        for (int n = 0; n < 100; n++) {\n" +
					"            int i = new Random().nextInt(2);\n" +
					"            switch (i){\n" +
					"                case 0:\n" +
					"                    String classPath = \"com.xiaozhi.java.Person\";\n" +
					"                    System.out.println(getInstance(classPath));\n" +
					"                    break;\n" +
					"                case 1:\n" +
					"                    System.out.println(getInstance(\"java.util.Date\"));\n" +
					"                    break;\n" +
					"                case 2:\n" +
					"                    System.out.println(getInstance(\"java.sql.Date\"));\n" +
					"                    break;\n" +
					"            }\n" +
					"        }\n" +
					"    }\n" +
					"\n" +
					"    public static Object getInstance(String classPath) throws Exception {\n" +
					"        Class clazz = Class.forName(classPath);\n" +
					"        Object instance = clazz.newInstance();\n" +
					"        return instance;\n" +
					"    }\n" +
					"}\n" +
					"```\n" +
					"\n" +
					"\n" +
					"\n" +
					"\n" +
					"\n" +
					"# 代理模式\n" +
					"\n" +
					"## 静态代理\n" +
					"\n" +
					"```java\n" +
					"public class StaticProxy {\n" +
					"\n" +
					"    public static void main(String[] args) {\n" +
					"        Homeowners homeowners = new Homeowners();   // 房主（被代理类）\n" +
					"        intermediary intermediary = new intermediary(homeowners);   // 中介（代理类）\n" +
					"        intermediary.lease();   // 调用出租方法\n" +
					"    }\n" +
					"}\n" +
					"\n" +
					"class Homeowners implements House {\n" +
					"\n" +
					"    @Override\n" +
					"    public void lease() {\n" +
					"        System.out.println(\"出租房子\");\n" +
					"    }\n" +
					"}\n" +
					"\n" +
					"\n" +
					"// 中介,代理类\n" +
					"class intermediary implements House {\n" +
					"    Homeowners homeowners;\n" +
					"\n" +
					"    public intermediary(Homeowners homeowners) {\n" +
					"        this.homeowners = homeowners;\n" +
					"    }\n" +
					"\n" +
					"    public intermediary() {\n" +
					"    }\n" +
					"\n" +
					"    @Override\n" +
					"    public void lease() {\n" +
					"        homeowners.lease();\n" +
					"        System.out.println(\"中介做了其他事\");\n" +
					"    }\n" +
					"}\n" +
					"\n" +
					"\n" +
					"interface House {\n" +
					"    /**\n" +
					"     * 出租房子\n" +
					"     */\n" +
					"    public void lease();\n" +
					"}\n" +
					"```\n" +
					"\n" +
					"\n" +
					"\n" +
					"## 动态代理\n" +
					"\n" +
					"```java\n" +
					"public class DynamicProxy {\n" +
					"\n" +
					"    public static void main(String[] args) {\n" +
					"//        new DynamicProxy().huMan();\n" +
					"//        new DynamicProxy().house();\n" +
					"        HuMan proxyNewInstance = (HuMan) ProxyUtils.getProxyNewInstance(new SuperMan());\n" +
					"        proxyNewInstance.say();\n" +
					"    }\n" +
					"\n" +
					"    public void huMan(){\n" +
					"        HuMan instance = (HuMan) ProxyTest.getProxyInstance(new SuperMan());\n" +
					"        instance.say();\n" +
					"    }\n" +
					"    public void house(){\n" +
					"        House proxyInstance = (House) ProxyTest.getProxyInstance(new Homeowners());\n" +
					"        proxyInstance.lease();\n" +
					"    }\n" +
					"\n" +
					"}\n" +
					"\n" +
					"// 创建动态代理的类\n" +
					"class ProxyTest{\n" +
					"    public static Object getProxyInstance(Object obj){ // obj：被代理类的对象\n" +
					"        MyInvocationHandler handler = new MyInvocationHandler(obj);\n" +
					"        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);\n" +
					"    }\n" +
					"}\n" +
					"\n" +
					"class MyInvocationHandler implements InvocationHandler{\n" +
					"\n" +
					"    private Object obj;\n" +
					"\n" +
					"    public MyInvocationHandler(Object obj) {\n" +
					"        this.obj = obj;\n" +
					"    }\n" +
					"\n" +
					"    @Override\n" +
					"    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {\n" +
					"        Object returnValue = method.invoke(obj, args);\n" +
					"        return returnValue;\n" +
					"    }\n" +
					"}\n" +
					"\n" +
					"// 被代理类\n" +
					"class SuperMan implements HuMan{\n" +
					"\n" +
					"    @Override\n" +
					"    public void say() {\n" +
					"        System.out.println(\"我相信自己会飞\");\n" +
					"    }\n" +
					"}\n" +
					"\n" +
					"\n" +
					"interface HuMan{\n" +
					"    public void say();\n" +
					"}\n" +
					"```\n" +
					"\n" +
					"\n" +
					"\n" +
					"\n" +
					"\n" +
					"## 封装成工具类\n" +
					"\n" +
					"只需要传入一个被代理的对象，就可以动态的创建代理类，实现动态代理的实现\n" +
					"\n" +
					"```java\n" +
					"public class ProxyUtils {    public static Object getProxyNewInstance(Object obj){        InvocationHandler handler = new InvocationHandler() {            @Override            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {                Object invoke = method.invoke(obj, args);                return invoke;            }        };        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);    }}\n" +
					"```\n" +
					"\n" +
					"\n" +
					"\n" +
					"\n" +
					"\n");
			blogService.save(blog);
		}
	}
}
