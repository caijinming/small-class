import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        /*Book book = new Book();
        book.setAuthor("路遥");
        book.setBookName("平凡的世界");
        book.printBookInfo();*/

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        Book book = applicationContext.getBean("book", Book.class);
        book.printBookInfo();
    }
}
