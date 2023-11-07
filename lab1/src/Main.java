import task1.IService;
import task1.ServiceAImpl;
import task1.ServiceBImpl;
import task2.Vector;
import task3.CheckedCustomException;
import task3.UncheckedCustomException;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1");
        {
            IService service = new ServiceAImpl();
            service.someServiceWork();
            service = new ServiceBImpl();
            service.someServiceWork();
        }

        System.out.println("Task 2");
        {
            Vector vector = new Vector(new Vector.Point(0, 0), new Vector.Point(3, 3));
            System.out.println(vector);
        }

        System.out.println("Task 3");
        {
            if (Math.random() * 1000 / 2 == 0)
                throw new UncheckedCustomException("Runtime-исключение, которое нет необходимости проверять");

            try {
                if (Math.random() * 1000 / 2 == 0)
                    throw new CheckedCustomException("Произошло что-то, что вызвало проверяемое исключение");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Task 4");
        {
            int x = -1;
            assert x >= 0 : "x < 0";
        }

        System.out.println("Task 5");
        {
            final Logger logger = Logger.getLogger(Main.class.getName());
            logger.info("INFO");
            logger.warning("WARNING");
        }
    }
}