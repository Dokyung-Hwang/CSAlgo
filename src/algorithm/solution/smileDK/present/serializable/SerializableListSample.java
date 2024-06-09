package algorithm.solution.smileDK.present.serializable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializableListSample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 직렬화할 고객 객체
        Customer dk = new Customer(1, "도경", "123123", 20);
        Customer dh = new Customer(2, "도형", "4556456", 20);
        Customer yj = new Customer(3, "예준", "789789", 20);

        // 외부 파일명
        String fileName = "Customer.ser";

        // 리스트 생성
        List<Customer> customerList = new ArrayList<>();
        customerList.add(dk);
        customerList.add(dh);
        customerList.add(yj);

        // 리스트 자체를 직렬화 하기
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(customerList);

        oos.close();

        // 역직렬화 하여 리스트 객체에 넣기
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Customer> deserializedCustomerList = (List<Customer>) ois.readObject();

        ois.close();

        System.out.println(deserializedCustomerList);
    }
}
