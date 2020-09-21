//Вариант 3. В исходном файле содержится произвольное количество чисел типа int. В результирующий файл переписать числа, которые делятся на 3.

import java.io.*;
import java.util.Scanner;

public class Variant {
    public static void main(String[] args) throws IOException {
        DataOutputStream wr = null;
        DataInputStream rd = null;
        try {
            File f1 = new File( "numbers.txt");
            if (f1.exists()) f1.delete();
            f1.createNewFile();

            Scanner sc = new Scanner(System.in);
            wr = new DataOutputStream(new FileOutputStream(f1.getAbsolutePath()));

            System.out.println("Введите количество символов");
            int count = sc.nextInt();

            System.out.println("Введите числа типа int: ");
            for (int i=0; i<count; i++) wr.writeInt(sc.nextInt());

            File f2 = new File("results.txt");
            if (f2.exists()) f2.delete();
            f2.createNewFile();

            rd = new DataInputStream(new FileInputStream(f1.getAbsolutePath()));
            wr = new DataOutputStream(new FileOutputStream(f2.getAbsolutePath()));

            int numDivideThree ;
            try {
                while (true) {
                    numDivideThree = rd.readInt();
                    if(numDivideThree%3==0) {
                        wr.writeInt(numDivideThree);
                        System.out.println("Number divide " + numDivideThree);
                    }
                }
            } catch (IOException e) {
                System.out.println("End of file");
            }
            finally {
                wr.flush();
                wr.close();
                rd.close();
            }
            try {
                DataInputStream rd2 = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
